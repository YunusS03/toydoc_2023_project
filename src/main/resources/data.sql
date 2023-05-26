-- Inserts for app_user
INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,short_description)
VALUES ('John', 'Doe', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'dummy1', '123 Main St', 30, 'New York', 'USA', 'john.doe@example.com', '555-123-4567', '10001', NULL, 'I am John.I am studying computer science');
--Insert Doctors
INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality, image_url,job)
VALUES ('Jane', 'Smith', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'dummy2', '456 Second St', 40, 'Antwerpen', 'Belgium', 'jane.smith@example.com', '555-987-6543', '90001', 'Cars' ,'https://thumbs.dreamstime.com/b/happy-young-male-doctor-man-smile-handsome-14181289.jpg','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('John', 'Doe', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'jdoe', '123 Main St', 30, 'Brussels', 'Belgium', 'john.doe@example.com', '555-123-4567', '1000', 'Cuddly toys','https://img.freepik.com/free-photo/portrait-smiling-handsome-male-doctor-man_171337-5055.jpg','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Alice', 'Lee', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'alee', '789 Third Ave', 45, 'Amsterdam', 'Nederland', 'alice.lee@example.com', '555-234-5678', '1012', 'Cars', 'https://www.shape.com/thmb/q-mU0BCcgv9JhCkETuSILva8yfg=/1500x0/filters:no_upscale():max_bytes(200000):strip_icc()/black-female-doctor-6d6a6c2ec3ae48ceaeeae61f78b7038e.jpg','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Michael', 'Chen', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'mchen', '456 Fourth St', 35, 'Antwerp', 'Belgium', 'michael.chen@example.com', '555-345-6789', '2000', 'Wooden toy','https://img.freepik.com/free-photo/smiling-doctor-with-strethoscope-isolated-grey_651396-974.jpg','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Sarah', 'Wong', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'swong', '567 Fifth Ave', 50, 'Rotterdam', 'Nederland', 'sarah.wong@example.com', '555-456-7890', '3012', 'Cuddly toys','https://img.freepik.com/free-photo/content-young-female-doctor-posing-camera_1262-18213.jpg','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('David', 'Kim', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'dkim', '234 First St', 28, 'Brussels', 'Belgium', 'david.kim@example.com', '555-567-8901', '1000', 'Action Figures', 'https://media.istockphoto.com/id/1346124900/photo/confident-successful-mature-doctor-at-hospital.jpg?b=1&s=170667a&w=0&k=20&c=vUq0J-LgD4FPEV1Ua_0NeQBcJ2xb8EjGe5fdcR1K2x0=','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Daniel', 'Nguyen', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'dnguyen', '678 Sixth St', 42, 'Amsterdam', 'Nederland', 'daniel.nguyen@example.com', '555-678-9012', '1012', 'Wooden Toy','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvYZGAy-gS7jCxv9lhYs7ciMD94Z4nfo_6HEeILCh62IrGUOmBTNa5UXxpZZ8d1WZCmBo&usqp=CAU','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Jennifer', 'Liu', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'jliu', '789 Seventh Ave', 33, 'Brussels', 'Belgium', 'jennifer.liu@example.com', '555-789-0123', '1000', 'Cars','https://images.theconversation.com/files/304957/original/file-20191203-66986-im7o5.jpg?ixlib=rb-1.1.0&q=45&auto=format&w=926&fit=clip','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Kevin', 'Park', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'kpark', '123 Second St', 25, 'Antwerp', 'Belgium', 'kevin.park@example.com', '555-890-1234', '2000', 'Action Figures','https://t4.ftcdn.net/jpg/00/58/33/17/360_F_58331714_RO7gYyfIE19CcD9MzJZxwEqqeetvtyhA.jpg','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Stephanie', 'Tran', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'stran', '456 Eighth St', 37, 'Rotterdam', 'Nederland', 'stephanie.tran@example.com', '555-901-2345', '3012', 'Cuddly toys','https://img.freepik.com/free-photo/woman-doctor-wearing-lab-coat-with-stethoscope-isolated_1303-29791.jpg','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code, speciality,image_url,job)
VALUES ('Christopher', 'Gupta', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 2, 'cgupta', '234 Ninth St', 48, 'Brussels', 'Belgium', 'christopher.gupta@example.com', '555-234-5678', '100','Board games','https://us.123rf.com/450wm/opolja/opolja1904/opolja190400678/121991996-cheerful-mature-doctor-posing-and-smiling-at-camera-healthcare-and-medicine.jpg?ver=6','Doctor');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code)
VALUES ('Yunus', 'Sahin', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 3, 'yusa', '234 Ninth St', 48, 'Brussels', 'Belgium', 'r0930908@student.thomasmore.be', '555-234-5678', '100');

INSERT INTO app_user (first_name, last_name, password, role, username, address, age, city, country, email, phone, postal_code)
VALUES ('Ahmet', 'Uygun', '$2a$12$NzQP7G0NTWFwaUjRZgf09.IHgc5gRq17BzGZREa9/n1DUI9v.fTNG', 0, 'ahmet', 'Smedenstraat', 32, 'Antwerp', 'Belgium', 'r0937207@student.thomasmore.be', '555-234-5678', '100');


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
       '2023-05-16','The Life of a Doll');
INSERT INTO post(id, body, date, title)
VALUES(11,' Introduction:
As a doctor who specializes in fixing board games, I''ve seen my fair share of broken games. One game that I was recently asked to fix was "Goose Board". For those who may not know, "Goose Board" is a classic board game that has been around for centuries. However, over time, the game has lost some of its charm and has become outdated. That''s where I came in. In this blog post, I''m going to talk about how I fixed "Goose Board" and brought it back to life.
Background:Before I dive into how I fixed "Goose Board", let me give you some background on the game. "Goose Board" is a race game where players move their pieces along a track by rolling dice. Along the way, there are spaces with special instructions, such as "Goose" which allows the player to move again or "Inn" which requires the player to miss a turn. The first player to reach the final space wins.
Challenges:The biggest challenge with "Goose Board" was that it lacked excitement. Players simply rolled dice and moved along the track without any real strategy. In addition, the game had a lot of "dead" spaces where nothing happened, which made the game drag on. My goal was to add some excitement to the game and make it more engaging for players.
Solution:To solve the issues with "Goose Board", I added some new elements to the game. First, I added some new spaces with unique instructions. For example, I added a space called "Shortcut" which allowed players to skip ahead a few spaces. I also added a space called "Trap" which required players to go back a few spaces. These new spaces added some unpredictability to the game and gave players some tough decisions to make.
Another change I made was to the movement of the pieces. Instead of simply moving along the track, players could now move their pieces in any direction they wanted. This added a strategic element to the game and made it more challenging.
Finally, I added some new game pieces to "Goose Board". Instead of the traditional game pieces, I added some unique pieces such as a car, a spaceship, and a dragon. These new pieces added some visual interest to the game and made it more appealing to players.
Conclusion:In the end, my changes to "Goose Board" were a success. Players now had to think strategically about their moves and the game had some unpredictable moments that kept players engaged. The new game pieces also added some visual interest to the game and made it more appealing. If you''re a fan of "Goose Board", I encourage you to try out the new and improved version of the game. ' ||
          'It''s sure to bring some excitement back to this classic game.',
       '2023-05-06','We just fixed this');
INSERT INTO post(id, body, date, title)
VALUES(12,'Many people don’t like to throw toys away. Children (and parents) are often attached to specific dolls or cuddly toys, ' ||
          'a battery-operated train or a remote-controlled car. Fortunately, in many cases, toys can be repaired very well. Bring your broken things to a Repair Café ' ||
          'and find out for yourself! We successfully repair electric and electronic toys in 70 per cent of cases, according to our RepairMonitor, ' ||
          'an online system where repairers keep track of what they fix. For non-electric toys, the number is as high as 76 per cent. So, it’s a shame to throw broken toys away.',
       '2023-04-28','Don’t just throw away broken toys');

