-- Inserts for app_user
INSERT INTO app_user (first_name, last_name, password, role, username, address, birth_date, city, country, email, phone, postal_code, speciality,short_description,job)
VALUES ('John', 'Doe', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'dummy1', '123 Main St', '1975-06-25', 'New York', 'USA', 'john.doe@example.com', '555-123-4567', '10001', NULL, 'I am John.I am studying computer science','Student');
--Insert Doctors
INSERT INTO app_user (first_name, last_name, password, role, username, address, birth_date, city, country, email, phone, postal_code, speciality, image_url,job)
VALUES ('Jane', 'Smith', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'dummy2', '456 Second St', '1977-06-25', 'Antwerpen', 'Belgium', 'jane.smith@example.com', '555-987-6543', '90001', 'Cars' ,'https://thumbs.dreamstime.com/b/happy-young-male-doctor-man-smile-handsome-14181289.jpg','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, birth_date, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('John', 'Doe', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'jdoe', '123 Main St', '1978-06-25', 'Brussels', 'Belgium', 'john.doe@example.com', '555-123-4567', '1000', 'Cuddly toys','https://img.freepik.com/free-photo/portrait-smiling-handsome-male-doctor-man_171337-5055.jpg','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, birth_date, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Alice', 'Lee', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'alee', '789 Third Ave', '1980-06-25', 'Amsterdam', 'Nederland', 'alice.lee@example.com', '555-234-5678', '1012', 'Cars', 'https://www.shape.com/thmb/q-mU0BCcgv9JhCkETuSILva8yfg=/1500x0/filters:no_upscale():max_bytes(200000):strip_icc()/black-female-doctor-6d6a6c2ec3ae48ceaeeae61f78b7038e.jpg','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, birth_date, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Michael', 'Chen', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'mchen', '456 Fourth St', '1983-06-25', 'Antwerp', 'Belgium', 'michael.chen@example.com', '555-345-6789', '2000', 'Wooden toy','https://img.freepik.com/free-photo/smiling-doctor-with-strethoscope-isolated-grey_651396-974.jpg','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, birth_date, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Sarah', 'Wong', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'swong', '567 Fifth Ave', '1968-06-25', 'Rotterdam', 'Nederland', 'sarah.wong@example.com', '555-456-7890', '3012', 'Cuddly toys','https://img.freepik.com/free-photo/content-young-female-doctor-posing-camera_1262-18213.jpg','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, birth_date, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('David', 'Kim', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'dkim', '234 First St', '1980-06-25', 'Brussels', 'Belgium', 'david.kim@example.com', '555-567-8901', '1000', 'Action Figures', 'https://media.istockphoto.com/id/1346124900/photo/confident-successful-mature-doctor-at-hospital.jpg?b=1&s=170667a&w=0&k=20&c=vUq0J-LgD4FPEV1Ua_0NeQBcJ2xb8EjGe5fdcR1K2x0=','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, birth_date, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Daniel', 'Nguyen', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'dnguyen', '678 Sixth St', '1976-06-25', 'Amsterdam', 'Nederland', 'daniel.nguyen@example.com', '555-678-9012', '1012', 'Wooden Toy','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvYZGAy-gS7jCxv9lhYs7ciMD94Z4nfo_6HEeILCh62IrGUOmBTNa5UXxpZZ8d1WZCmBo&usqp=CAU','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, birth_date, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Jennifer', 'Liu', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'jliu', '789 Seventh Ave', '1979-06-25', 'Brussels', 'Belgium', 'jennifer.liu@example.com', '555-789-0123', '1000', 'Cars','https://images.theconversation.com/files/304957/original/file-20191203-66986-im7o5.jpg?ixlib=rb-1.1.0&q=45&auto=format&w=926&fit=clip','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, birth_date, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Kevin', 'Park', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'kpark', '123 Second St', '1981-06-25', 'Antwerp', 'Belgium', 'kevin.park@example.com', '555-890-1234', '2000', 'Action Figures','https://t4.ftcdn.net/jpg/00/58/33/17/360_F_58331714_RO7gYyfIE19CcD9MzJZxwEqqeetvtyhA.jpg','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, birth_date, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Stephanie', 'Tran', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'stran', '456 Eighth St', '1972-06-25', 'Rotterdam', 'Nederland', 'stephanie.tran@example.com', '555-901-2345', '3012', 'Cuddly toys','https://img.freepik.com/free-photo/woman-doctor-wearing-lab-coat-with-stethoscope-isolated_1303-29791.jpg','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, birth_date, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Christopher', 'Gupta', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'cgupta', '234 Ninth St', '1984-06-25', 'Brussels', 'Belgium', 'christopher.gupta@example.com', '555-234-5678', '100','Board games','https://us.123rf.com/450wm/opolja/opolja1904/opolja190400678/121991996-cheerful-mature-doctor-posing-and-smiling-at-camera-healthcare-and-medicine.jpg?ver=6','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, birth_date, city, country, email, phone, postal_code,job)
VALUES ('Yunus', 'Sahin', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 0, 'yusa', '234 Ninth St', '1983-06-25', 'Brussels', 'Belgium', 'r0930908@student.thomasmore.be', '555-234-5678', '100','Student');

INSERT INTO app_user (first_name, last_name, password, role, username, address, birth_date, city, country, email, phone, postal_code,job)
VALUES ('Ahmet', 'Uygun', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 0, 'ahmet', 'Smedenstraat', '1987-06-25', 'Antwerp', 'Belgium', 'r0937207@student.thomasmore.be', '555-234-5678', '100','Developer');


--NEW DATA
INSERT INTO app_user (first_name, last_name, password, role, username, address, birth_date, city, country, email, phone, postal_code, job)
VALUES
    ('Emma', 'Johnson', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'emma.johnson', '123 Main St', '1995-05-12', 'New York', 'USA', 'emma.johnson@example.com', '555-111-1111', '10001', 'Student'),
    ('Sophia', 'Smith', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'sophia.smith', '456 Second St', '1997-07-18', 'Los Angeles', 'USA', 'sophia.smith@example.com', '555-222-2222', '20001', 'Student'),
    ('Oliver', 'Davis', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'oliver.davis', '789 Third Ave', '1993-03-25', 'Chicago', 'USA', 'oliver.davis@example.com', '555-333-3333', '30001', 'Student'),
    ('Ava', 'Wilson', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'ava.wilson', '234 Fourth St', '1994-09-08', 'Houston', 'USA', 'ava.wilson@example.com', '555-444-4444', '40001', 'Student'),
    ('Liam', 'Martinez', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'liam.martinez', '567 Fifth Ave', '1996-11-02', 'Philadelphia', 'USA', 'liam.martinez@example.com', '555-555-5555', '50001', 'Student'),
    ('Isabella', 'Anderson', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'isabella.anderson', '890 Sixth St', '1992-01-14', 'Phoenix', 'USA', 'isabella.anderson@example.com', '555-666-6666', '60001', 'Student'),
    ('Noah', 'Thomas', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'noah.thomas', '123 Seventh Ave', '1998-04-21', 'San Antonio', 'USA', 'noah.thomas@example.com', '555-777-7777', '70001', 'Student'),
    ('Mia', 'Jackson', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'mia.jackson', '456 Eighth St', '1991-06-30', 'San Diego', 'USA', 'mia.jackson@example.com', '555-888-8888', '80001', 'Student'),
    ('Lucas', 'White', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'lucas.white', '789 Ninth Ave', '1999-08-16', 'Dallas', 'USA', 'lucas.white@example.com', '555-999-9999', '90001', 'Student'),
    ('Charlotte', 'Taylor', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'charlotte.taylor', '234 Tenth St', '1997-12-05', 'Austin', 'USA', 'charlotte.taylor@example.com', '555-000-0000', '10001', 'Student');



INSERT INTO appointment (confirmed, creation_time, date, time, client_id, doctor_id)
VALUES
    (false, NULL, '2023-05-30', '08:00:00', 13, 2),
    (false, NULL, '2023-05-30', '09:00:00', 14, 3),
    (false, NULL, '2023-05-30', '10:00:00', 15, 4),
    (false, NULL, '2023-05-30', '11:00:00', 16, 5),
    (false, NULL, '2023-05-30', '12:00:00', 17, 6),
    (false, NULL, '2023-05-31', '13:00:00', 18, 7),
    (false, NULL, '2023-05-31', '14:00:00', 19, 8),
    (false, NULL, '2023-05-31', '15:00:00', 20, 9),
    (false, NULL, '2023-05-31', '16:00:00', 21, 10),
    (false, NULL, '2023-06-01', '08:00:00', 22, 11),
    (false, NULL, '2023-06-01', '09:00:00', 23, 12),
    (false, NULL, '2023-06-01', '10:00:00', 24, 2),
    (false, NULL, '2023-06-01', '11:00:00', 13, 3),
    (false, NULL, '2023-06-02', '12:00:00', 14, 4),
    (false, NULL, '2023-06-02', '13:00:00', 15, 5),
    (false, NULL, '2023-06-02', '14:00:00', 16, 6),
    (false, NULL, '2023-06-02', '15:00:00', 17, 7),
    (false, NULL, '2023-06-03', '16:00:00', 18, 8),
    (false, NULL, '2023-06-03', '08:00:00', 19, 9),
    (false, NULL, '2023-06-03', '09:00:00', 20, 10),
    (false, NULL, '2023-06-03', '10:00:00', 21, 11),
    (false, NULL, '2023-06-04', '11:00:00', 22, 12),
    (false, NULL, '2023-06-04', '12:00:00', 23, 2),
    (false, NULL, '2023-06-04', '13:00:00', 24, 3),
    (false, NULL, '2023-06-04', '14:00:00', 13, 4),
    (false, NULL, '2023-06-05', '15:00:00', 14, 5),
    (false, NULL, '2023-06-05', '16:00:00', 15, 6),
    (false, NULL, '2023-06-05', '08:00:00', 16, 7),
    (false, NULL, '2023-06-05', '09:00:00', 17, 8),
    (false, NULL, '2023-06-06', '10:00:00', 18, 9),
    (false, NULL, '2023-06-06', '11:00:00', 19, 10),
    (true, NULL, '2023-05-30', '08:00:00', 13, 2),
  (false, NULL, '2023-05-30', '09:00:00', 14, 3),
  (true, NULL, '2023-05-30', '10:00:00', 15, 4),
  (true, NULL, '2023-05-30', '11:00:00', 16, 5),
  (false, NULL, '2023-05-30', '12:00:00', 17, 6),
  (false, NULL, '2023-05-31', '13:00:00', 18, 7),
  (true, NULL, '2023-05-31', '14:00:00', 19, 8),
  (true, NULL, '2023-05-31', '15:00:00', 20, 9),
  (true, NULL, '2023-05-31', '16:00:00', 21, 10),
  (false, NULL, '2023-06-01', '08:00:00', 22, 11),
  (true, NULL, '2023-06-01', '09:00:00', 23, 12),
  (false, NULL, '2023-06-01', '10:00:00', 24, 2),
  (true, NULL, '2023-06-01', '11:00:00', 13, 3),
  (true, NULL, '2023-06-02', '12:00:00', 14, 4),
  (true, NULL, '2023-06-02', '13:00:00', 15, 5),
  (false, NULL, '2023-06-02', '14:00:00', 16, 6),
  (true, NULL, '2023-06-02', '15:00:00', 17, 7),
  (false, NULL, '2023-06-03', '16:00:00', 18, 8),
  (true, NULL, '2023-06-03', '08:00:00', 19, 9),
  (true, NULL, '2023-06-03', '09:00:00', 20, 10),
  (false, NULL, '2023-06-03', '10:00:00', 21, 11),
  (true, NULL, '2023-06-04', '11:00:00', 22, 12),
  (false, NULL, '2023-06-04', '12:00:00', 23, 2),
  (false, NULL, '2023-06-04', '13:00:00', 24, 3),
  (true, NULL, '2023-06-04', '14:00:00', 13, 4),
  (true, NULL, '2023-06-05', '15:00:00', 14, 5),
  (true, NULL, '2023-06-05', '16:00:00', 15, 6),
  (false, NULL, '2023-06-05', '08:00:00', 16, 7),
  (true, NULL, '2023-06-05', '09:00:00', 17, 8),
  (false, NULL, '2023-06-06', '10:00:00', 18, 9),
  (false, NULL, '2023-06-06', '11:00:00', 19, 10),
    (true, NULL, '2023-06-06', '12:00:00', 20, 11),
    (false, NULL, '2023-06-07', '13:00:00', 21, 12),
    (true, NULL, '2023-06-07', '14:00:00', 22, 2),
    (true, NULL, '2023-06-08', '15:00:00', 23, 3),
    (false, NULL, '2023-06-08', '16:00:00', 24, 4),
    (true, NULL, '2023-06-09', '08:00:00', 13, 5),
    (false, NULL, '2023-06-09', '09:00:00', 14, 6),
    (true, NULL, '2023-06-10', '10:00:00', 15, 7),
    (false, NULL, '2023-06-10', '11:00:00', 16, 8),
    (true, NULL, '2023-06-11', '12:00:00', 17, 9),
    (true, NULL, '2023-06-11', '13:00:00', 18, 10),
    (false, NULL, '2023-06-12', '14:00:00', 19, 11),
    (true, NULL, '2023-06-12', '15:00:00', 20, 12),
    (false, NULL, '2023-06-13', '08:00:00', 21, 2),
    (true, NULL, '2023-06-13', '09:00:00', 22, 3),
    (true, NULL, '2023-06-14', '10:00:00', 23, 4),
    (true, NULL, '2023-06-14', '11:00:00', 24, 5),
    (false, NULL, '2023-06-15', '12:00:00', 13, 6),
    (false, NULL, '2023-06-15', '13:00:00', 14, 7),
    (true, NULL, '2023-06-16', '14:00:00', 15, 8);



INSERT INTO appointment (confirmed ,creation_time,secret_key , date, time, client_id, doctor_id)
VALUES(false, '2023-05-07', 'testkey','2023-04-29', '13:00:00', 3, 2);


-- Post SQL --
INSERT INTO post(id, date, title, intro, body, before_url, after_url, specialty, user_id, like_count)
VALUES(11, '2023-04-28', 'From Broken to Road-Ready', 'Children''s electric little cars have become a symbol of adventure and independence for young ones. These pint-sized vehicles offer a taste of the open road, allowing children to explore their surroundings with a sense of joy and excitement. However, just like any other cherished toy, these electric cars can encounter issues and fall into disrepair over time. But fear not, for there are skilled artisans known as toy doctors who specialize in reviving these miniature rides. In this blog post, we embark on a journey to restore a broken children''s electric little car and witness its triumphant return to the road',
       'Discovering the Dilemma:The tale begins with the discovery of a once-beloved children''s electric little car, neglected and in need of repair. Whether it has been left unused for an extended period, suffered damage during playtime, or encountered technical malfunctions, the time has come to seek the assistance of a toy doctor. Rather than bidding farewell to the cherished car, you choose to breathe new life into it and offer your child the joy of driving once again.
        Diagnosing the Issues: Upon consulting a toy doctor, the broken children''s electric little car undergoes a thorough diagnosis. The toy doctor carefully inspects every detail, identifying the root causes of malfunction. Whether it''s a faulty battery, a worn-out motor, or electrical issues, the toy doctor utilizes their expertise to pinpoint the necessary repairs and replacements required to restore the car''s functionality.
        The Restoration Process:Armed with the knowledge of the car''s ailments, the toy doctor sets to work, utilizing their technical skills to bring the children''s electric little car back to life. The battery may be replaced, ensuring optimal power supply for hours of uninterrupted driving pleasure. The motor is carefully examined, repaired, or replaced if necessary, ensuring smooth acceleration and maneuverability. Electrical components are meticulously checked and fixed, ensuring safety and reliability. The toy doctor''s expertise and attention to detail play a crucial role in restoring the car to its former glory.
        Ensuring Safety: Quality Check and Testing: Once the repairs and replacements are complete, the toy doctor conducts a comprehensive quality check to ensure the children''s electric little car meets the highest safety standards. Each component is tested for proper functionality, including brakes, lights, and steering. Only after passing the rigorous inspection is the car deemed road-ready and safe for children to enjoy.
        The Triumphant Return:With repairs and safety checks completed, the children''s electric little car is ready for its triumphant return. The once-broken vehicle gleams with a fresh coat of paint, its wheels spin with renewed vigor, and its lights illuminate the path ahead. The joy and excitement on your child''s face mirror the satisfaction felt by the toy doctor, who successfully restored this cherished mode of transportation. The electric little car is prepared to whisk your child away on countless adventures once again, fostering their sense of independence and imaginative play.',
       'https://i.pinimg.com/600x315/82/67/2c/82672c239cb4af0ceacfbd698cf241ac.jpg',
       'https://www.thesun.co.uk/wp-content/uploads/2020/04/NINTCHDBPICT000580161845.jpg',
       'Cars', 2, 2);

INSERT INTO post(id, date, title, intro, body, before_url, after_url, specialty, user_id, like_count)
VALUES(12, '2023-04-13', 'How I Fixed "Goose Board"', 'As a doctor who specializes in fixing board games, I''ve seen my fair share of broken games. One game that I was recently asked to fix was "Goose Board". For those who may not know, "Goose Board" is a classic board game that has been around for centuries. However, over time, the game has lost some of its charm and has become outdated. That''s where I came in. In this blog post, I''m going to talk about how I fixed "Goose Board" and brought it back to life',
       'Background: Before I dive into how I fixed "Goose Board", let me give you some background on the game. "Goose Board" is a race game where players move their pieces along a track by rolling dice. Along the way, there are spaces with special instructions, such as "Goose" which allows the player to move again or "Inn" which requires the player to miss a turn. The first player to reach the final space wins.
        Challenges: The biggest challenge with "Goose Board" was that it lacked excitement. Players simply rolled dice and moved along the track without any real strategy. In addition, the game had a lot of "dead" spaces where nothing happened, which made the game drag on. My goal was to add some excitement to the game and make it more engaging for players.
        Solution: To solve the issues with "Goose Board", I added some new elements to the game. First, I added some new spaces with unique instructions. For example, I added a space called "Shortcut" which allowed players to skip ahead a few spaces. I also added a space called "Trap" which required players to go back a few spaces. These new spaces added some unpredictability to the game and gave players some tough decisions to make.
        Another change I made was to the movement of the pieces. Instead of simply moving along the track, players could now move their pieces in any direction they wanted. This added a strategic element to the game and made it more challenging.
        Finally, I added some new game pieces to "Goose Board". Instead of the traditional game pieces, I added some unique pieces such as a car, a spaceship, and a dragon. These new pieces added some visual interest to the game and made it more appealing to players.',
       'https://www.mastersofgames.com/images/board/game-of-goose-juego-de-la-oca-lg.jpg',
       'https://speluitslagen.nl/images/ganzenbord.jpg',
       'Board games', 2, 3);

INSERT INTO post(id, date, title, intro, body, before_url, after_url, specialty, user_id, like_count)
VALUES(13, '2023-04-02', 'Repairing a Broken Plush Unicorn', 'In the realm of toys, few creatures are as enchanting and beloved as the plush unicorn. With its soft, whimsical charm, it has the power to ignite a child''s imagination and bring joy to people of all ages. But what happens when your treasured plush unicorn suffers a tear or loses its sparkle? Fear not, for there are skilled artisans known as toy doctors who specialize in restoring the magic of broken toys. In this blog post, we delve into the heartwarming journey of repairing a broken plush unicorn and witness the revival of its enchantment',
       'Discovering the Damage:The tale begins with the unfortunate discovery of a tear in your cherished plush unicorn. Perhaps it was an accident during playtime or the result of years of faithful companionship. Nevertheless, the once vibrant and huggable creature now lies in need of repair. This is where the expertise of a toy doctor comes into play.
        The Consultation:Upon seeking the services of a toy doctor, you embark on a journey to restore your plush unicorn''s magic. During the consultation, the toy doctor carefully examines the extent of the damage, taking note of any loose threads, missing stuffing, or worn-out features. They provide you with a detailed assessment of the necessary repairs and discuss the available options to ensure the unicorn''s restoration is tailored to your preferences.
        The Magical Restoration Process:With the consultation complete, the toy doctor commences the delicate restoration process. Every stitch is woven with precision and care, breathing new life into the unicorn''s torn fabric. Any missing stuffing is replenished, restoring its shape and ensuring a soft, huggable companion once again. The toy doctor''s skilled hands work like magic, reattaching lost limbs and mending the once-frayed seams. This careful artistry and attention to detail bring back the unicorn''s original splendor.Witness the Magic: Live Repair Experience:As an additional touch of enchantment, some toy doctors offer the option to witness the repair process live. By scheduling a date and time, ' ||
       'you can observe the transformation unfold before your eyes. This unique opportunity allows you to witness the skill and dedication of the toy doctor, forging a deeper connection with your beloved plush unicorn as it is restored to its former glory. It also provides an educational experience, as you can ask questions and gain insights into the techniques used to repair and revive toys.',
       'https://i.redd.it/s6mtgm9tlpc51.jpg',
       'https://i.pinimg.com/564x/5a/0a/ba/5a0aba10188d18be12e5ca9814efc28b.jpg',
       'Cuddly toys', 5, 0);

INSERT INTO post(id, date, title, intro, body, before_url, after_url, specialty, user_id, like_count)
VALUES(14, '2023-03-24', 'Racing to Revival', 'Every child''s imagination has been ignited by the thrill of a toy race car speeding across the floor, simulating the exhilaration of a real-life race. But what happens when that beloved toy race car meets an unfortunate accident and falls into disrepair? Fear not, for there are skilled artisans known as toy doctors who specialize in the restoration of broken toys. In this blog post, we dive into the exciting journey of repairing a broken toy race car and witness its triumphant return to the racetrack',
        'Discovery of Damage:The adventure begins when you come across your once-favorite toy race car, now broken and collecting dust. It might have suffered a crash during an epic race or been a casualty of enthusiastic playtime. Regardless of the cause, the time has come to seek the expert care of a toy doctor, who can breathe new life into your cherished race car.
         Initial Assessment:Upon consulting a toy doctor, your broken race car undergoes a thorough examination. The toy doctor carefully inspects every detail, assessing the extent of the damage. Whether it''s a missing wheel, a broken chassis, or a damaged motor, the toy doctor takes note of the repairs needed to get your race car back on track. They discuss the available options, including replacement parts and potential upgrades, to ensure the restoration aligns with your desires.
         The Precision Repair Process:With the assessment complete, the toy doctor sets to work, meticulously repairing the race car with precision and expertise. Each broken component is handled with care, ensuring that the race car''s original functionality is restored. From replacing broken parts to fixing wiring and fine-tuning the motor, the toy doctor''s skillful hands work like magic, breathing new life into the once-defunct race car. The repair process becomes an intricate dance of technical know-how and passion for restoring the joy of play.
         Witness the Transformation: Live Repair Experience: For a truly immersive experience, some toy doctors offer the option to witness the repair process live. By scheduling a date and time, you can observe the race car''s revival firsthand. This unique opportunity allows you to witness the skill and dedication of the toy doctor, gaining insight into the meticulous steps involved in restoring a broken toy. It also fosters a deeper connection with your race car as you witness its transformation, fueling your excitement to see it once again conquer the imaginary racetracks of your imagination.',
        'https://thumbs.dreamstime.com/z/broken-toy-car-pieces-98628041.jpg',
        'https://thumbs.dreamstime.com/z/yellow-sport-car-isolated-over-white-background-38690470.jpg',
        'Cars', 6, 9);

INSERT INTO post(id, date, title, intro, body, before_url, after_url, specialty, user_id, like_count)
VALUES (15, '2023-03-05', 'Beauty Resurrected', 'Barbie dolls have long been iconic symbols of beauty, fashion, and imagination. Many of us have cherished memories of playing with these beloved dolls, creating imaginative stories and exploring different worlds. But what happens when time takes its toll on these cherished companions, leaving them rusted and forgotten? Fear not, for there are skilled artisans known as toy doctors who specialize in the restoration of beloved toys.',
        'Discovering the Neglect:The story begins when you stumble upon a once-cherished Barbie figurine tucked away in a forgotten corner. Time and neglect have left their mark, resulting in rusted joints, faded paint, and a general sense of disrepair. Instead of casting it aside, you decide to seek the expertise of a toy doctor, hoping to restore the doll''s original beauty and revive the memories associated with it.
         The Evaluation:Upon consulting a toy doctor, the rusted Barbie figurine is meticulously examined, taking note of every detail and the extent of the damage. The toy doctor determines the best course of action, considering the appropriate methods to remove rust, repair any broken parts, and restore the doll''s aesthetic appeal. They discuss the available options and restoration techniques to ensure the doll''s revival aligns with your vision.
         The Restoration Process:With the evaluation complete, the toy doctor sets to work, delicately and painstakingly restoring the rusted Barbie figurine to its former glory. Every rusty joint is meticulously cleaned and treated, removing the tarnish of time. The doll''s faded paint is meticulously touched up, bringing back its vibrant colors and intricate details. Broken limbs or damaged accessories are carefully repaired or replaced, ensuring the doll''s full functionality is restored. The toy doctor''s skillful hands, combined with their knowledge of doll restoration, work wonders, transforming the Barbie figurine into a breathtaking vision once again.
         Witnessing the Transformation: Live Restoration Experience:For an extraordinary experience, some toy doctors offer the opportunity to witness the restoration process live. By scheduling a date and time, you can be present as the rusted Barbie figurine undergoes its miraculous transformation. This unique opportunity allows you to witness the artistry and passion of the toy doctor firsthand, gaining a deeper appreciation for the meticulous steps involved in restoring a beloved doll. It becomes a shared journey, as you witness the doll''s renaissance and the memories it holds come flooding back.',
        'https://i.ebayimg.com/images/g/uCUAAOSwhYlhqtJ1/s-l1600.jpg',
        'https://content.syndigo.com/asset/5355305d-d912-44b3-9ae3-d3021852889f/480.jpeg',
        'Action Figures', 10, 2);


--
INSERT INTO contact_message (name, email, subject, message,is_read)
VALUES ('John Doe', 'johndoe@example.com', 'Inquiry about Product', 'Hi, I have some questions regarding your product. Can you provide me with more information?',false);

INSERT INTO contact_message (name, email, subject, message,is_read)
VALUES ('Jane Smith', 'janesmith@example.com', 'Feedback', 'Hello, I wanted to provide some feedback regarding your services. Is there a way I can reach out to someone for further discussion?',false);

INSERT INTO contact_message (name, email, subject, message,is_read)
VALUES ('Michael Johnson', 'michaeljohnson@example.com', 'Technical Support', 'Hi, I''m experiencing some issues with your software. Can you please assist me in resolving this matter?',true);

INSERT INTO contact_message (name, email, subject, message,is_read)
VALUES ('Sarah Thompson', 'sarahthompson@example.com', 'Collaboration Opportunity', 'Greetings! I represent a company interested in exploring potential collaboration opportunities with your organization. Can we discuss this further?',true);

INSERT INTO contact_message (name, email, subject, message,is_read)
VALUES ('Robert Lee', 'robertlee@example.com', 'Job Application', 'Dear Hiring Manager, I am interested in applying for a software engineer position at your company. Could you please provide me with the necessary details?',false);

INSERT INTO contact_message (name, email, subject, message,is_read)
VALUES ('Emily Davis', 'emilydavis@example.com', 'Partnership Inquiry', 'Hi there, I am reaching out to inquire about potential partnership opportunities. Is there a dedicated person I can connect with to discuss this further?',false);

