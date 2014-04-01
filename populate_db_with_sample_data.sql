SELECT * FROM obj_users;
SELECT * FROM obj_properties;

INSERT INTO obj_users (first_name, last_name, email_address, phone_number, email_verification_status, password)
VALUES ('Saman', 'Sohrab', 'ssohrab@gmail.com', '999-999-9999', 1, 'blahencodedpassword');
commit;

INSERT INTO obj_properties (user_id, property_reference_number, street_number, street_name, city_name, province_name, postal_code, longitude, lattitude)
VALUES (1, 1000, 437, 'Hazel Street', 'Waterloo', 'ON', 'N2L3P7', 2343.34, 5555.98);
commit;
