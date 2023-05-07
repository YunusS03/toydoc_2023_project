-- Inserts for app_user
INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality)
VALUES ('John', 'Doe', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'dummy1', '123 Main St', 30, 'New York', 'USA', 'john.doe@email.com', '555-123-4567', '10001', NULL);
--Insert Doctors
INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality, profile_image)
VALUES ('Jane', 'Smith', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'dummy2', '456 Second St', 40, 'Antwerpen', 'Belgium', 'jane.smith@email.com', '555-987-6543', '90001', 'Cars' ,'https://thumbs.dreamstime.com/b/happy-young-male-doctor-man-smile-handsome-14181289.jpg');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('John', 'Doe', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'jdoe', '123 Main St', 30, 'Brussels', 'Belgium', 'john.doe@email.com', '555-123-4567', '1000', 'Cuddly toys','https://img.freepik.com/free-photo/portrait-smiling-handsome-male-doctor-man_171337-5055.jpg');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Alice', 'Lee', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'alee', '789 Third Ave', 45, 'Amsterdam', 'Nederland', 'alice.lee@email.com', '555-234-5678', '1012', 'Cars', 'https://www.shape.com/thmb/q-mU0BCcgv9JhCkETuSILva8yfg=/1500x0/filters:no_upscale():max_bytes(200000):strip_icc()/black-female-doctor-6d6a6c2ec3ae48ceaeeae61f78b7038e.jpg');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Michael', 'Chen', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'mchen', '456 Fourth St', 35, 'Antwerp', 'Belgium', 'michael.chen@email.com', '555-345-6789', '2000', 'Wooden toy ','https://img.freepik.com/free-photo/smiling-doctor-with-strethoscope-isolated-grey_651396-974.jpg');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Sarah', 'Wong', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'swong', '567 Fifth Ave', 50, 'Rotterdam', 'Nederland', 'sarah.wong@email.com', '555-456-7890', '3012', 'Cuddly toys','https://img.freepik.com/free-photo/content-young-female-doctor-posing-camera_1262-18213.jpg');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('David', 'Kim', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'dkim', '234 First St', 28, 'Brussels', 'Belgium', 'david.kim@email.com', '555-567-8901', '1000', 'Action Figures', 'https://media.istockphoto.com/id/1346124900/photo/confident-successful-mature-doctor-at-hospital.jpg?b=1&s=170667a&w=0&k=20&c=vUq0J-LgD4FPEV1Ua_0NeQBcJ2xb8EjGe5fdcR1K2x0=');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Daniel', 'Nguyen', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'dnguyen', '678 Sixth St', 42, 'Amsterdam', 'Nederland', 'daniel.nguyen@email.com', '555-678-9012', '1012', 'Wooden toy ','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvYZGAy-gS7jCxv9lhYs7ciMD94Z4nfo_6HEeILCh62IrGUOmBTNa5UXxpZZ8d1WZCmBo&usqp=CAU');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Jennifer', 'Liu', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'jliu', '789 Seventh Ave', 33, 'Brussels', 'Belgium', 'jennifer.liu@email.com', '555-789-0123', '1000', 'Cars','https://images.theconversation.com/files/304957/original/file-20191203-66986-im7o5.jpg?ixlib=rb-1.1.0&q=45&auto=format&w=926&fit=clip');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Kevin', 'Park', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'kpark', '123 Second St', 25, 'Antwerp', 'Belgium', 'kevin.park@email.com', '555-890-1234', '2000', 'Action Figures','https://t4.ftcdn.net/jpg/00/58/33/17/360_F_58331714_RO7gYyfIE19CcD9MzJZxwEqqeetvtyhA.jpg');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Stephanie', 'Tran', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'stran', '456 Eighth St', 37, 'Rotterdam', 'Nederland', 'stephanie.tran@email.com', '555-901-2345', '3012', 'Cuddly toys','https://img.freepik.com/free-photo/woman-doctor-wearing-lab-coat-with-stethoscope-isolated_1303-29791.jpg');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Christopher', 'Gupta', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'cgupta', '234 Ninth St', 48, 'Brussels', 'Belgium', 'christopher.gupta@email.com', '555-234-5678', '100','Board games','https://us.123rf.com/450wm/opolja/opolja1904/opolja190400678/121991996-cheerful-mature-doctor-posing-and-smiling-at-camera-healthcare-and-medicine.jpg?ver=6');

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

INSERT INTO appointment (date, time, client_id, doctor_id, toy_id)
VALUES
    ('2023-04-28', '10:00:00', 1, 2, 1),
    ('2023-04-29', '11:00:00', 1, 2, 1),
    ('2023-04-30', '12:00:00', 1, 2, 1),
    ('2023-05-01', '13:00:00', 1, 2, 1),
    ('2023-05-02', '14:00:00', 1, 2, 1),
    ('2023-05-03', '15:00:00', 1, 2, 1),
    ('2023-05-04', '16:00:00', 1, 2, 1),
    ('2023-05-05', '17:00:00', 1, 2, 1),
    ('2023-05-06', '18:00:00', 1, 2, 1),
    ('2023-05-07', '19:00:00', 1, 2, 1),
    ('2023-05-08', '20:00:00', 1, 2, 1),
    ('2023-05-09', '21:00:00', 1, 2, 1),
    ('2023-05-10', '22:00:00', 1, 2, 1),
    ('2023-05-11', '23:00:00', 1, 2, 1),
    ('2023-05-12', '00:00:00', 1, 2, 1),
    ('2023-05-13', '01:00:00', 1, 2, 1),
    ('2023-05-14', '02:00:00', 1, 2, 1),
    ('2023-05-15', '03:00:00', 1, 2, 1),
    ('2023-05-16', '04:00:00', 1, 2, 1),
    ('2023-05-17', '05:00:00', 1, 2, 1),
    ('2023-05-18', '06:00:00', 1, 2, 1),
    ('2023-05-19', '07:00:00', 1, 2, 1),
    ('2023-05-20', '08:00:00', 1, 2, 1),
    ('2023-05-21', '09:00:00', 1, 2, 1),
    ('2023-05-22', '10:00:00', 1, 2, 1),
    ('2023-05-23', '11:00:00', 1, 2, 1),
    ('2023-05-24', '12:00:00', 1, 2, 1),
    ('2023-05-25', '13:00:00', 1, 2, 1),
    ('2023-04-28', '10:00:00', 1, 2, 1),
    ('2023-04-28', '11:00:00', 1, 2, 1),
    ('2023-04-28', '12:00:00', 1, 2, 1),
    ('2023-04-28', '13:00:00', 1, 2, 1),
    ('2023-04-28', '14:00:00', 1, 2, 1),
    ('2023-04-28', '15:00:00', 1, 2, 1),
    ('2023-04-28', '16:00:00', 1, 2, 1),
    ('2023-04-28', '17:00:00', 1, 2, 1),
    ('2023-04-28', '18:00:00', 1, 2, 1),
    ('2023-04-28', '19:00:00', 1, 2, 1),
    ('2023-04-28', '20:00:00', 1, 2, 1),
    ('2023-04-28', '21:00:00', 1, 2, 1),
    ('2023-04-28', '22:00:00', 1, 2, 1),
    ('2023-04-28', '23:00:00', 1, 2, 1),
    ('2023-04-29', '00:00:00', 1, 2, 1),
    ('2023-04-29', '01:00:00', 1, 2, 1),
    ('2023-04-29', '02:00:00', 1, 2, 1),
    ('2023-04-29', '03:00:00', 1, 2, 1),
    ('2023-04-29', '04:00:00', 1, 2, 1),
    ('2023-04-29', '05:00:00', 1, 2, 1),
    ('2023-04-29', '06:00:00', 1, 2, 1),
    ('2023-04-29', '07:00:00', 1, 2, 1),
    ('2023-04-29', '08:00:00', 1, 2, 1),
    ('2023-04-29', '09:00:00', 1, 2, 1),
    ('2023-04-29', '10:00:00', 1, 2, 1),
    ('2023-04-29', '11:00:00', 1, 2, 1),
    ('2023-04-29', '12:00:00', 1, 2, 1),
    ('2023-04-29', '13:00:00', 1, 2, 1);

