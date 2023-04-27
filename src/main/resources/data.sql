-- Inserts for app_user
INSERT INTO app_user (dtype, first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality)
VALUES ('client', 'John', 'Doe', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 1, 'dummy1', '123 Main St', 30, 'New York', 'USA', 'john.doe@email.com', '555-123-4567', '10001', NULL);

INSERT INTO app_user (dtype, first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality)
VALUES ('doctor', 'Jane', 'Smith', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'dummy2', '456 Second St', 40, 'Los Angeles', 'USA', 'jane.smith@email.com', '555-987-6543', '90001', 'Pediatrics');

-- Inserts for toy
INSERT INTO toy (name, type, appointment_id, client_id)
VALUES ('Teddy Bear', 'Stuffed Animal', NULL, 1);

INSERT INTO toy (name, type, appointment_id, client_id)
VALUES ('Lego Set', 'Building Blocks', NULL, 1);

-- Inserts for appointment
INSERT INTO appointment (date, time, client_id, doctor_id, toy_id)
VALUES ('2023-05-01', '09:00:00', 1, 2, 1);

INSERT INTO appointment (date, time, client_id, doctor_id, toy_id)
VALUES ('2023-05-02', '14:00:00', 1, 2, 2);