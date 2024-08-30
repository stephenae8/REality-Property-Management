BEGIN TRANSACTION;

DROP TABLE IF EXISTS messages, service_request, payments, leases, applications, images, amenities, properties, users CASCADE;

CREATE TABLE users (
	user_id SERIAL NOT NULL,
	username varchar(50),
	role varchar(50),
	fName varchar(25),
	lName varchar(25),
	email varchar(50) UNIQUE,
	phone_number varchar(25),
	password_hash varchar(200) NOT NULL,
	
	CONSTRAINT PK_user PRIMARY KEY (user_id)
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

-- Function to create lease when application is approved
CREATE OR REPLACE FUNCTION create_lease_on_approval()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.app_status = 'approved' AND OLD.app_status = 'pending' THEN
        INSERT INTO leases (user_id, prop_id, start_date, end_date, rent, lease_status, term_length)
        SELECT
            NEW.user_id,
            NEW.prop_id,
            NEW.move_in_date,
            NEW.move_in_date + INTERVAL '1 year', -- Assuming 1-year lease
            (SELECT rent FROM properties WHERE prop_id = NEW.prop_id),
            'active',
            12
        ;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger to create lease when application is approved
CREATE TRIGGER create_lease_on_approval_trigger
AFTER UPDATE ON applications
FOR EACH ROW
WHEN (NEW.app_status = 'approved' AND OLD.app_status = 'pending')
EXECUTE FUNCTION create_lease_on_approval();

-- Function to update property vacancy when a lease is created
CREATE OR REPLACE FUNCTION update_property_vacancy_on_lease()
RETURNS TRIGGER AS $$
BEGIN
    -- Update the property's vacancy to false when a new lease is created
    UPDATE properties
    SET vacancy = false
    WHERE prop_id = NEW.prop_id;

    RAISE NOTICE 'Updated vacancy for property % to false', NEW.prop_id;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger to update property vacancy when a lease is created
CREATE TRIGGER update_property_vacancy_on_lease_trigger
AFTER INSERT ON leases
FOR EACH ROW
EXECUTE FUNCTION update_property_vacancy_on_lease();

COMMIT TRANSACTION;
