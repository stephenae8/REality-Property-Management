BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (role, fName, lName, email, password_hash) VALUES
('tenant', 'John', 'Doe', 'john.doe@example.com', 'hashedpassword123'),
('landlord', 'Jane', 'Smith', 'jane.smith@example.com', 'hashedpassword456'),
('admin', 'Alice', 'Johnson', 'alice.johnson@example.com', 'hashedpassword789'),
('tenant', 'Michael', 'Brown', 'michael.brown@example.com', 'hashedpassword101'),
('landlord', 'Emily', 'Davis', 'emily.davis@example.com', 'hashedpassword102');

INSERT INTO property (address, city, state, zipcode, vacancy, price, bedrooms, bathrooms, img_url) VALUES
('123 Maple St', 'Springfield', 'IL', 62701, true, 1200.00, 3, 2.0, 'http://example.com/img1.jpg'),
('456 Oak St', 'Metropolis', 'NY', 10001, false, 2200.00, 4, 3.0, 'http://example.com/img2.jpg'),
('789 Pine St', 'Gotham', 'NJ', 07001, true, 1500.00, 2, 1.5, 'http://example.com/img3.jpg'),
('321 Birch St', 'Star City', 'CA', 90001, true, 1800.00, 3, 2.5, 'http://example.com/img4.jpg'),
('654 Cedar St', 'Smallville', 'TX', 75001, false, 2000.00, 4, 3.0, 'http://example.com/img5.jpg');

INSERT INTO amenities (prop_id, dishwasher, a_c, laundry, pets) VALUES
(1, true, true, true, false),
(2, true, true, true, true),
(3, false, true, false, true),
(4, true, false, true, false),
(5, true, true, true, true);

INSERT INTO property_application (user_id, prop_id, status, app_date) VALUES
(1, 1, 'pending', '2024-08-01'),
(2, 3, 'approved', '2024-08-02'),
(4, 2, 'rejected', '2024-08-03'),
(5, 4, 'pending', '2024-08-04'),
(3, 5, 'approved', '2024-08-05');

INSERT INTO service_request (user_id, prop_id, status, req_date) VALUES
(1, 1, 'completed', '2024-08-01'),
(2, 3, 'pending', '2024-08-02'),
(4, 2, 'in-progress', '2024-08-03'),
(5, 4, 'completed', '2024-08-04'),
(3, 5, 'pending', '2024-08-05');

INSERT INTO email (user_to, user_from, subject, body, email_date) VALUES
(2, 1, 'Application Update', 'Your application has been approved.', '2024-08-02'),
(3, 2, 'Service Request', 'Your service request is pending.', '2024-08-03'),
(4, 3, 'Property Inquiry', 'We have received your inquiry about the property.', '2024-08-04'),
(5, 4, 'Application Status', 'Your application is currently being reviewed.', '2024-08-05'),
(1, 5, 'Service Request Update', 'Your service request has been completed.', '2024-08-06');

COMMIT TRANSACTION;
