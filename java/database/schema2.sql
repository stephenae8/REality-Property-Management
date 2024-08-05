BEGIN TRANSACTION;

DROP TABLE IF EXISTS messages, service_request, payments, leases, applications, images, amenities, properties, users CASCADE;

CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	role VARCHAR(25) CHECK (role IN ('tenant', 'manager', 'owner','final_capstone_appuser', 'final_capstone_owner', 'ROLE_USER')) NOT NULL DEFAULT 'tenant',
	fName VARCHAR(25) ,
	lName VARCHAR(25) ,
	username VARCHAR(25),
	email VARCHAR(50) ,
	phone_number VARCHAR(20),
	password_hash VARCHAR(200) NOT NULL
);

CREATE TABLE properties (
	prop_id SERIAL PRIMARY KEY,
	owner_id INT NOT NULL REFERENCES users(user_id),
	address VARCHAR(100) NOT NULL, 
	city VARCHAR(50) NOT NULL, 
	state VARCHAR(50) NOT NULL, 
	zip VARCHAR(10) NOT NULL, 
	vacancy BOOLEAN NOT NULL DEFAULT false, 
 	pending BOOLEAN NOT NULL DEFAULT false,
	rent NUMERIC(10,2) NOT NULL,
	bedrooms INT NOT NULL, 
	bathrooms NUMERIC(2,1) NOT NULL
);

CREATE TABLE amenities (
	amenities_id SERIAL PRIMARY KEY,
	prop_id INT NOT NULL REFERENCES properties(prop_id),
	dishwasher BOOLEAN NOT NULL, 
	central_air BOOLEAN NOT NULL, 
	laundry BOOLEAN NOT NULL, 
	pets_allowed BOOLEAN NOT NULL
);

CREATE TABLE images (
	img_id SERIAL PRIMARY KEY,
	prop_id INT NOT NULL REFERENCES properties(prop_id),
	img_url VARCHAR(255) NOT NULL
);

CREATE TABLE applications (
	app_id SERIAL PRIMARY KEY, 
	user_id INT NOT NULL REFERENCES users(user_id), 
	prop_id INT NOT NULL REFERENCES properties(prop_id), 
	move_in_date DATE NOT NULL,
	app_status VARCHAR(10) CHECK (app_status IN ('pending', 'approved', 'denied', 'withdrawn'))NOT NULL DEFAULT 'pending',
 	app_date TIMESTAMP NOT NULL
);

CREATE TABLE leases (
	lease_id SERIAL PRIMARY KEY,
	user_id INT NOT NULL REFERENCES users(user_id),
	prop_id INT NOT NULL REFERENCES properties(prop_id),
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	rent NUMERIC(10,2) NOT NULL,
	lease_status VARCHAR(15) CHECK (lease_status IN ('active', 'expired', 'terminated')) NOT NULL DEFAULT 'active',
	term_length INT NOT NULL
);

CREATE TABLE payments (
	pay_id SERIAL PRIMARY KEY,
	user_id INT NOT NULL REFERENCES users(user_id),
	prop_id INT NOT NULL REFERENCES properties(prop_id),
	lease_id INT NOT NULL REFERENCES leases(lease_id),
	pay_period DATE NOT NULL,
	pay_date TIMESTAMP NOT NULL,
	amount NUMERIC(10,2) NOT NULL,
	late BOOLEAN NOT NULL
);

CREATE TABLE service_request (
	req_id SERIAL PRIMARY KEY,
	user_id INT NOT NULL REFERENCES users(user_id),
	prop_id INT NOT NULL REFERENCES properties(prop_id),
	req_status VARCHAR(15) CHECK (req_status IN ('pending', 'in_progress', 'complete', 'canceled')) NOT NULL DEFAULT 'pending',
	req_date TIMESTAMP NOT NULL,
	last_updated TIMESTAMP,
	req_body VARCHAR(500) NOT NULL,
	issue_type VARCHAR(15) CHECK (issue_type IN ('dishwasher', 'central_air', 'laundry', 'bathroom', 'other')) NOT NULL DEFAULT 'other'
);

CREATE TABLE messages (
	msg_id SERIAL PRIMARY KEY,
	contact_type VARCHAR(5) CHECK (contact_type IN ('email', 'text')) NOT NULL DEFAULT 'email',
	user_to INT NOT NULL REFERENCES users (user_id),
	user_from INT NOT NULL REFERENCES users (user_id),
	subject VARCHAR(50) NOT NULL,
	msg_body VARCHAR(500) NOT NULL,
	msg_date TIMESTAMP NOT NULL
);

-- Function to set payment_period
CREATE OR REPLACE FUNCTION set_payment_period() 
RETURNS TRIGGER AS $$
BEGIN
    NEW.pay_period := DATE_TRUNC('month', NEW.pay_date);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger to update payment_period before insert on payments table
CREATE TRIGGER set_payment_period_trigger
BEFORE INSERT ON payments
FOR EACH ROW
EXECUTE FUNCTION set_payment_period();

COMMIT TRANSACTION;
-- ROLLBACK TRANSACTION;