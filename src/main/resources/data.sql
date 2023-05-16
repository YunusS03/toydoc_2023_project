-- Inserts for app_user
INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality)
VALUES ('John', 'Doe', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'dummy1', '123 Main St', 30, 'New York', 'USA', 'john.doe@example.com', '555-123-4567', '10001', NULL);
--Insert Doctors
INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality, profile_image)
VALUES ('Jane', 'Smith', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'dummy2', '456 Second St', 40, 'Antwerpen', 'Belgium', 'jane.smith@example.com', '555-987-6543', '90001', 'Cars' ,'https://thumbs.dreamstime.com/b/happy-young-male-doctor-man-smile-handsome-14181289.jpg');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('John', 'Doe', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'jdoe', '123 Main St', 30, 'Brussels', 'Belgium', 'john.doe@example.com', '555-123-4567', '1000', 'Cuddly toys','https://img.freepik.com/free-photo/portrait-smiling-handsome-male-doctor-man_171337-5055.jpg');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Alice', 'Lee', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'alee', '789 Third Ave', 45, 'Amsterdam', 'Nederland', 'alice.lee@example.com', '555-234-5678', '1012', 'Cars', 'https://www.shape.com/thmb/q-mU0BCcgv9JhCkETuSILva8yfg=/1500x0/filters:no_upscale():max_bytes(200000):strip_icc()/black-female-doctor-6d6a6c2ec3ae48ceaeeae61f78b7038e.jpg');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Michael', 'Chen', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'mchen', '456 Fourth St', 35, 'Antwerp', 'Belgium', 'michael.chen@example.com', '555-345-6789', '2000', 'Wooden toy','https://img.freepik.com/free-photo/smiling-doctor-with-strethoscope-isolated-grey_651396-974.jpg');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Sarah', 'Wong', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'swong', '567 Fifth Ave', 50, 'Rotterdam', 'Nederland', 'sarah.wong@example.com', '555-456-7890', '3012', 'Cuddly toys','https://img.freepik.com/free-photo/content-young-female-doctor-posing-camera_1262-18213.jpg');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('David', 'Kim', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'dkim', '234 First St', 28, 'Brussels', 'Belgium', 'david.kim@example.com', '555-567-8901', '1000', 'Action Figures', 'https://media.istockphoto.com/id/1346124900/photo/confident-successful-mature-doctor-at-hospital.jpg?b=1&s=170667a&w=0&k=20&c=vUq0J-LgD4FPEV1Ua_0NeQBcJ2xb8EjGe5fdcR1K2x0=');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Daniel', 'Nguyen', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'dnguyen', '678 Sixth St', 42, 'Amsterdam', 'Nederland', 'daniel.nguyen@example.com', '555-678-9012', '1012', 'Wooden toy','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvYZGAy-gS7jCxv9lhYs7ciMD94Z4nfo_6HEeILCh62IrGUOmBTNa5UXxpZZ8d1WZCmBo&usqp=CAU');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Jennifer', 'Liu', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'jliu', '789 Seventh Ave', 33, 'Brussels', 'Belgium', 'jennifer.liu@example.com', '555-789-0123', '1000', 'Cars','https://images.theconversation.com/files/304957/original/file-20191203-66986-im7o5.jpg?ixlib=rb-1.1.0&q=45&auto=format&w=926&fit=clip');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Kevin', 'Park', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'kpark', '123 Second St', 25, 'Antwerp', 'Belgium', 'kevin.park@example.com', '555-890-1234', '2000', 'Action Figures','https://t4.ftcdn.net/jpg/00/58/33/17/360_F_58331714_RO7gYyfIE19CcD9MzJZxwEqqeetvtyhA.jpg');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Stephanie', 'Tran', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'stran', '456 Eighth St', 37, 'Rotterdam', 'Nederland', 'stephanie.tran@example.com', '555-901-2345', '3012', 'Cuddly toys','https://img.freepik.com/free-photo/woman-doctor-wearing-lab-coat-with-stethoscope-isolated_1303-29791.jpg');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,profile_image)
VALUES ('Christopher', 'Gupta', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'cgupta', '234 Ninth St', 48, 'Brussels', 'Belgium', 'christopher.gupta@example.com', '555-234-5678', '100','Board games','https://us.123rf.com/450wm/opolja/opolja1904/opolja190400678/121991996-cheerful-mature-doctor-posing-and-smiling-at-camera-healthcare-and-medicine.jpg?ver=6');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code)
VALUES ('Yunus', 'Sahin', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'yusa', '234 Ninth St', 48, 'Brussels', 'Belgium', 'r0930908@student.thomasmore.be', '555-234-5678', '100');


-- Inserts for toy
-- INSERT INTO toy (name, type, appointment_id, client_id)
-- VALUES ('Teddy Bear', 'Stuffed Animal', NULL, 1);

-- INSERT INTO toy (name, type, appointment_id, client_id)
-- VALUES ('Lego Set', 'Building Blocks', NULL, 1);


INSERT INTO appointment (confirmed,creation_time, date, time, client_id, doctor_id)
VALUES
    (false,'2023-05-07', '2023-05-08', '08:00:00', 1, 2),
    (false,'2023-05-08', '2023-05-09', '08:00:00', 1, 2),
    (false,'2023-05-9', '2023-05-10', '09:00:00', 13, 5),
    (false,'2023-05-8', '2023-05-11', '10:00:00', 2, 2),
    (false,'2023-05-11', '2023-05-12', '11:00:00', 13, 2),
    (false,'2023-05-12', '2023-05-13', '12:00:00', 4, 2),
    (false,'2023-05-14', '2023-05-14', '13:00:00', 5, 2),
    (false,'2023-05-15', '2023-05-15', '14:00:00', 13, 5),
    (false,'2023-05-16', '2023-05-16', '15:00:00', 7, 5),
    (false,'2023-05-17', '2023-05-17', '16:00:00', 8, 2),
    (false,'2023-05-18', '2023-05-18', '17:00:00', 1, 2),
    (false,'2023-05-19', '2023-05-19', '08:00:00', 13, 2),
    (false,'2023-05-20', '2023-05-20', '09:00:00', 13, 5),
    (false,'2023-05-21', '2023-05-21', '10:00:00', 3, 2),
    (false,'2023-05-22', '2023-05-22', '11:00:00', 4, 5),
    (false,'2023-05-23', '2023-05-23', '12:00:00', 5, 2),
    (false,'2023-05-24', '2023-05-24', '13:00:00', 13, 5),
    (false,'2023-05-25', '2023-05-25', '14:00:00', 7, 2);

INSERT INTO appointment (confirmed ,creation_time,secret_key , date, time, client_id, doctor_id)
VALUES(false, '2023-05-07', 'testkey','2023-04-29', '13:00:00', 3, 2);

INSERT INTO post(id, body, date, title)
VALUES(10,'Dolls have been a part of human culture for hundreds of years. While early dolls were made of materials such as wood, clay or wax,
                        porcelain became a popular material to use in doll construction in the 19th century. The Chinese and the French began making china heads for dolls in the 1840s.
                        In 1880, the French popularized the "bebe,” which was one of the first dolls made to represent a child. Though beautiful, porcelain dolls are fragile and need to be repaired from time to time.',
       '2023-05-25','The Life of a Doll');
INSERT INTO post(id, body, date, title)
VALUES(11,'Dolls have been a part of human culture for hundreds of years. While early dolls were made of materials such as wood, clay or wax,
                        porcelain became a popular material to use in doll construction in the 19th century. The Chinese and the French began making china heads for dolls in the 1840s.
                        In 1880, the French popularized the "bebe,” which was one of the first dolls made to represent a child. Though beautiful, porcelain dolls are fragile and need to be repaired from time to time.',
       '2023-05-26','We just fixed this');
INSERT INTO post(id, body, date, title)
VALUES(12,'Many people don’t like to throw toys away. Children (and parents) are often attached to specific dolls or cuddly toys, ' ||
          'a battery-operated train or a remote-controlled car. Fortunately, in many cases, toys can be repaired very well. Bring your broken things to a Repair Café ' ||
          'and find out for yourself! We successfully repair electric and electronic toys in 70 per cent of cases, according to our RepairMonitor, ' ||
          'an online system where repairers keep track of what they fix. For non-electric toys, the number is as high as 76 per cent. So, it’s a shame to throw broken toys away.',
       '2023-05-26','Don’t just throw away broken toys');

