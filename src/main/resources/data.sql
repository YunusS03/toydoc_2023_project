
-- wachtwoorden zijn voor de dummys altijd  "test"  dummy1 dummy2 dummy3
INSERT INTO app_user (dtype, first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality)
VALUES ('doctor', 'John', 'Doe', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'dummy1', '123 Main St', 30, 'New York', 'USA', 'john.doe@gmail.com', '555-123-4567', '10001', 'IT Specialist');

INSERT INTO app_user (dtype, first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code)
VALUES ('client', 'Jane', 'Smith', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 4, 'dummy2', '456 Elm St', 25, 'Los Angeles', 'USA', 'jane.smith@gmail.com', '555-987-6543', '90001');

INSERT INTO app_user (dtype, first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code)
VALUES ('client', 'Bob', 'Johnson', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 4, 'dummy3', '789 Oak St', 40, 'Chicago', 'USA', 'bob.johnson@gmail.com', '555-555-5555', '60601');

-- !!merk op!! dtype verwijst naar de classen client en doctor of app_user en we hebben ook een role enum wat niet meer klopt ik laat het voor nu zo aangezien dit nu vlekkenloos werkt.