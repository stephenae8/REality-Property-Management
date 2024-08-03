BEGIN TRANSACTION;

DROP TABLE IF EXISTS email, service_request, property_application, amenities, property, users;

CREATE TABLE users (
	user_id SERIAL NOT NULL,
	role varchar(50) NOT NULL,
	fName varchar(25) NOT NULL,
	lName varchar(25) NOT NULL,
	email varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE property (
	prop_id serial not null, 
	address varchar (100) not null, 
	city varchar (50) not null, 
	state varchar (50) not null, 
	zipcode int not null, 
	vacancy boolean not null, 
	price numeric not null, 
	bedrooms int not null, 
	bathrooms numeric(2) not null,
	img_url varchar (250) not null,
	
	Constraint PK_prop_id primary key (prop_id)
	

);

create table amenities (
	amenities_id serial not null,
	prop_id int not null,
	dishwasher boolean not null, 
	a_c boolean not null, 
	laundry boolean not null, 
	pets boolean not null, 
	
	Constraint PK_amenities_id primary key (amenities_id),
	Constraint FK_prop_id foreign key (prop_id) references property (prop_id)


);

create table property_application(
	prop_app_id serial not null, 
	user_id int not null, 
	prop_id int not null, 
	status varchar (10) not null, 
	app_date date not null, 
	
	constraint PK_prop_app_id primary key (prop_app_id),
	constraint FK_user_id foreign key (user_id) references users (user_id),
	constraint FK_prop_id foreign key (prop_id) references property (prop_id)
	
);

create table service_request(
	req_id serial not null,
	user_id int not null,
	prop_id int not null,
	status varchar (10) not null,
	req_date date not null,
	
	constraint PK_req_id primary key (req_id),
	constraint FK_user_id foreign key (user_id) references users (user_id),
	constraint FK_prop_id foreign key (prop_id) references property (prop_id)

);

create table email (
	email_id serial not null,
	user_to int not null,
	user_from int not null,
	subject varchar(50) not null,
	body varchar (500) not null,
	email_date date not null,
	
	constraint PK_email_id primary key (email_id),
	constraint FK_user_to foreign key (user_to) references users (user_id),
	constraint FK_user_from foreign key (user_from) references users (user_id)

);

COMMIT TRANSACTION;
