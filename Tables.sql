CREATE TABLE tbl_users(user_id INT NOT NULL AUTO_INCREMENT,first_name VARCHAR(64) NOT NULL,last_name VARCHAR(64) NOT NULL,email_address VARCHAR(256) NOT NULL,
phone_number VARCHAR(32) NOT NULL,email_verification_status BIT(1),password VARCHAR(1024) NOT NULL,PRIMARY KEY(user_id)) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE tbl_locations(
	location_id INT NOT NULL AUTO_INCREMENT,
	user_id INT NOT NULL,
	longitude DOUBLE NOT NULL,
	lattitude DOUBLE NOT NULL,
	PRIMARY KEY(location_id),
	FOREIGN KEY(user_id) REFERENCES tbl_users(user_id) ON DELETE CASCADE) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
	
CREATE TABLE tbl_properties(
	property_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	user_id INT NOT NULL,
	property_reference_number INT,
	street_number INT NOT NULL,
	street_name VARCHAR(32) NOt NULL,
	city_name VARCHAR(32) NOT NULL,
	province_name VARCHAR(32) NOT NULL,
	postal_code VARCHAR(8) NOT NULL,
	longitude DOUBLE NOT NULL,
	lattitude DOUBLE NOT NULL,
	FOREIGN KEY(user_id) REFERENCES tbl_users(user_id) ON DELETE CASCADE) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE tbl_favorites(
	fav_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	user_id INT,
	property_id INT,
	note VARCHAR(256),
    FOREIGN KEY(user_id) REFERENCES tbl_users(user_id) ON DELETE CASCADE,
    FOREIGN KEY(property_id) REFERENCES tbl_properties(property_id) ON DELETE CASCADE) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE tbl_property_images(
	image_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	property_id INT NOT NULL,
	image_data BLOB(1048576) NOT NULL,
	FOREIGN KEY(property_id) REFERENCES tbl_properties(property_id) ON DELETE CASCADE) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

