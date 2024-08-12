BEGIN TRANSACTION;


INSERT INTO users (user_id, username,password_hash,role) VALUES (9900, 'user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (user_id, username,password_hash,role) VALUES (9901, 'admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

-- Users
INSERT INTO users (user_id, username, role, fName, lName, email, phone_number, password_hash) VALUES
(9001, 'johndoe', 'ROLE_TENANT', 'John', 'Doe', 'john.doe@example.com', '123-456-7890', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9002, 'ad2s2', 'ROLE_MANAGER', 'REality', 'Manager', 'A2DS2@REality.com', '123-456-7891', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9003, 'bobjohnson', 'ROLE_OWNER', 'Bob', 'Johnson', 'bob.johnson@example.com', '123-456-7892', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9004, 'alicebrown', 'ROLE_TENANT', 'Alice', 'Brown', 'alice.brown@example.com', '123-456-7893', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9005, 'chrisdavis', 'ROLE_TENANT', 'Chris', 'Davis', 'chris.davis@example.com', '123-456-7894', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9006, 'evemiller', 'ROLE_OWNER', 'Eve', 'Miller', 'eve.miller@example.com', '123-456-7895', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9007, 'frankwilson', 'ROLE_TENANT', 'Frank', 'Wilson', 'frank.wilson@example.com', '123-456-7896', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9008, 'gracemoore', 'ROLE_TENANT', 'Grace', 'Moore', 'grace.moore@example.com', '123-456-7897', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9009, 'henrytaylor', 'ROLE_OWNER', 'Henry', 'Taylor', 'henry.taylor@example.com', '123-456-7898', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9010, 'ivyanderson', 'ROLE_TENANT', 'Ivy', 'Anderson', 'ivy.anderson@example.com', '123-456-7899', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9011, 'oliviayoung', 'ROLE_TENANT', 'Olivia', 'Young', 'olivia.young@example.com', '123-456-7890', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9012, 'lucasking', 'ROLE_TENANT', 'Lucas', 'King', 'lucas.king@example.com', '123-456-7891', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9013, 'miacarter', 'ROLE_TENANT', 'Mia', 'Carter', 'mia.carter@example.com', '123-456-7892', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9014, 'noahdmas', 'ROLE_TENANT', 'Noah', 'Adams', 'noah.adams@example.com', '123-456-7893', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9015, 'emmabrown', 'ROLE_TENANT', 'Emma', 'Brown', 'emma.brown@example.com', '123-456-7894', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9016, 'jacobmiller', 'ROLE_TENANT', 'Jacob', 'Miller', 'jacob.miller@example.com', '123-456-7895', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9017, 'ethandavis', 'ROLE_TENANT', 'Ethan', 'Davis', 'ethan.davis@example.com', '123-456-7896', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9018, 'sophiajohnson', 'ROLE_TENANT', 'Sophia', 'Johnson', 'sophia.johnson@example.com', '123-456-7897', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9019, 'avawilson', 'ROLE_TENANT', 'Ava', 'Wilson', 'ava.wilson@example.com', '123-456-7898', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC'),
(9020, 'williamanderson', 'ROLE_TENANT', 'William', 'Anderson', 'william.anderson@example.com', '123-456-7899', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC')
;



-- Properties
INSERT INTO properties (prop_id, owner_id, address, city, state, zip, vacancy, pending, rent, bedrooms, bathrooms) VALUES
(9001, 9003, '123 Wabash Ave', 'Chicago', 'IL', 60601, false, false, 1200.00, 3, 2.0),
(9002, 9006, '456 Market St', 'Indianapolis', 'IN', 46201, false, false, 1500.00, 4, 3.0),
(9003, 9009, '789 Grand Blvd', 'Detroit', 'MI', 48201, false, false, 900.00, 2, 1.5),
(9004, 9003, '101 Walnut St', 'Columbus', 'OH', 43201, false, false, 1100.00, 3, 2.0),
(9005, 9006, '202 Cedar Dr', 'Milwaukee', 'WI', 53201, false, false, 1300.00, 3, 2.5),
(9006, 9009, '303 Elmwood Ln', 'St. Louis', 'MO', 63101, false, false, 1000.00, 2, 1.0),
(9007, 9003, '404 Pine St', 'Minneapolis', 'MN', 55401, false, false, 1400.00, 4, 3.0),
(9008, 9006, '505 Maplewood Ct', 'Kansas City', 'MO', 64101, false, false, 950.00, 2, 1.5),
(9009, 9006, '606 Oakwood Rd', 'Cleveland', 'OH', 44101, false, false, 1250.00, 3, 2.0),
(9010, 9009, '707 Birch Ln', 'Cincinnati', 'OH', 45201, false, false, 1150.00, 3, 2.0),
(9011, 9003, '808 Chestnut St', 'Madison', 'WI', 53701, true, false, 1350.00, 3, 2.5),
(9012, 9006, '909 Willow Ave', 'Des Moines', 'IA', 50301, true, true, 1050.00, 2, 1.0),
(9013, 9009, '1010 Cherry Pl', 'Toledo', 'OH', 43601, true, true, 1450.00, 4, 3.5),
(9014, 9003, '1111 Maple St', 'Omaha', 'NE', 68101, true, false, 950.00, 2, 1.5),
(9015, 9006, '1212 Oak St', 'Sioux Falls', 'SD', 57101, true, true, 1250.00, 3, 2.0),
(9016, 9009, '1313 Pine St', 'Fargo', 'ND', 58102, true, false, 1150.00, 3, 2.0),
(9017, 9003, '1414 Birch St', 'Lincoln', 'NE', 68501, true, false, 1550.00, 4, 3.0),
(9018, 9006, '1515 Cedar St', 'Green Bay', 'WI', 54301, true, false, 1000.00, 2, 1.0),
(9019, 9009, '1616 Elm St', 'Lansing', 'MI', 48901, true, true, 1350.00, 3, 2.5),
(9020, 9003, '1717 Fir St', 'Fort Wayne', 'IN', 46801, true, true, 1200.00, 3, 2.0);
;


-- Amenities
INSERT INTO amenities (prop_id, dishwasher, central_air, laundry, pets_allowed) VALUES
(9001, true, true, true, false),
(9002, true, false, true, true),
(9003, false, true, false, false),
(9004, true, true, true, true),
(9005, false, false, true, false),
(9006, true, true, false, true),
(9007, false, true, true, false),
(9008, true, true, true, true),
(9009, true, false, true, false),
(9010, false, true, false, true),
(9011, true, false, true, false),
(9012, false, true, false, true),
(9013, true, true, true, false),
(9014, false, false, true, true),
(9015, true, true, false, false),
(9016, false, false, true, true),
(9017, true, true, true, false),
(9018, false, true, false, true),
(9019, true, false, true, false),
(9020, false, true, false, true)
;

-- Images
INSERT INTO images (img_id, prop_id, img_url) VALUES
(9001, 9001, 'https://photos.zillowstatic.com/fp/7300956bf9c2e2b7d6e9265274dfe90d-cc_ft_576.jpeg'),
(9002, 9001, 'https://photos.zillowstatic.com/fp/094cad6f3fd4b93d0b88b104e83d0835-cc_ft_960.jpeg'),
(9003, 9001, 'https://photos.zillowstatic.com/fp/22552d87c7bf1f3432951d46224bd9bd-cc_ft_576.jpeg'),
(9004, 9001, 'https://photos.zillowstatic.com/fp/5d01fe1bc0a4d47688ab4fa5feb6e299-cc_ft_576.jpeg'),
(9005, 9001, 'https://photos.zillowstatic.com/fp/5b074ede2cadae73a60b130217a7c030-cc_ft_960.jpeg'),
(9006, 9002, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/4000215152.jpeg?d=l'),
(9007, 9002, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/4000215152.jpeg?d=l'),
(9008, 9002, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/4000215152.jpeg?d=l'),
(9009, 9002, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/4000215152.jpeg?d=l'),
(9010, 9002, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/4000215152.jpeg?d=l'),
(9011, 9003, 'https://photos.zillowstatic.com/fp/c943c48e82899923c224207a4ed70279-cc_ft_960.jpeg'),
(9012, 9003, 'https://photos.zillowstatic.com/fp/ae94438ba3ca9b57f2a0e8c2846b5f35-cc_ft_576.jpeg'),
(9013, 9003, 'https://photos.zillowstatic.com/fp/e9fceb484fbda67f579fd1967da1ed32-cc_ft_576.jpeg'),
(9014, 9003, 'https://photos.zillowstatic.com/fp/e8448063ac3e327424e98e1a174fa742-cc_ft_960.jpeg'),
(9015, 9003, 'https://photos.zillowstatic.com/fp/57de2d66b4a184dcba312207cbbfbac5-cc_ft_576.jpeg'),
(9016, 9004, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/44466929.jpeg?d=l'),
(9017, 9004, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1714803251.jpeg?d=l'),
(9018, 9004, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/2256398421.jpeg?d=l'),
(9019, 9004, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1189049495.jpeg?d=l'),
(9020, 9004, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/4000215152.jpeg?d=l'),
(9021, 9005, 'https://photos.zillowstatic.com/fp/c943c48e82899923c224207a4ed70279-cc_ft_960.jpeg'),
(9022, 9005, 'https://photos.zillowstatic.com/fp/ae94438ba3ca9b57f2a0e8c2846b5f35-cc_ft_576.jpeg'),
(9023, 9005, 'https://photos.zillowstatic.com/fp/e9fceb484fbda67f579fd1967da1ed32-cc_ft_576.jpeg'),
(9024, 9005, 'https://photos.zillowstatic.com/fp/e8448063ac3e327424e98e1a174fa742-cc_ft_960.jpeg'),
(9025, 9005, 'https://photos.zillowstatic.com/fp/57de2d66b4a184dcba312207cbbfbac5-cc_ft_576.jpeg'),
(9026, 9006, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/44466929.jpeg?d=l'),
(9027, 9006, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1714803251.jpeg?d=l'),
(9028, 9006, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/2256398421.jpeg?d=l'),
(9029, 9006, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1189049495.jpeg?d=l'),
(9030, 9006, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/4000215152.jpeg?d=l'),
(9031, 9007, 'https://photos.zillowstatic.com/fp/c943c48e82899923c224207a4ed70279-cc_ft_960.jpeg'),
(9032, 9007, 'https://photos.zillowstatic.com/fp/ae94438ba3ca9b57f2a0e8c2846b5f35-cc_ft_576.jpeg'),
(9033, 9007, 'https://photos.zillowstatic.com/fp/e9fceb484fbda67f579fd1967da1ed32-cc_ft_576.jpeg'),
(9034, 9007, 'https://photos.zillowstatic.com/fp/e8448063ac3e327424e98e1a174fa742-cc_ft_960.jpeg'),
(9035, 9007, 'https://photos.zillowstatic.com/fp/57de2d66b4a184dcba312207cbbfbac5-cc_ft_576.jpeg'),
(9036, 9008, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/44466929.jpeg?d=l'),
(9037, 9008, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1714803251.jpeg?d=l'),
(9038, 9008, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/2256398421.jpeg?d=l'),
(9039, 9008, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1189049495.jpeg?d=l'),
(9040, 9008, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/4000215152.jpeg?d=l'),
(9041, 9009, 'https://photos.zillowstatic.com/fp/c943c48e82899923c224207a4ed70279-cc_ft_960.jpeg'),
(9042, 9009, 'https://photos.zillowstatic.com/fp/ae94438ba3ca9b57f2a0e8c2846b5f35-cc_ft_576.jpeg'),
(9043, 9009, 'https://photos.zillowstatic.com/fp/e9fceb484fbda67f579fd1967da1ed32-cc_ft_576.jpeg'),
(9044, 9009, 'https://photos.zillowstatic.com/fp/e8448063ac3e327424e98e1a174fa742-cc_ft_960.jpeg'),
(9045, 9009, 'https://photos.zillowstatic.com/fp/57de2d66b4a184dcba312207cbbfbac5-cc_ft_576.jpeg'),
(9046, 9010, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/44466929.jpeg?d=l'),
(9047, 9010, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1714803251.jpeg?d=l'),
(9048, 9010, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/2256398421.jpeg?d=l'),
(9049, 9010, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1189049495.jpeg?d=l'),
(9050, 9010, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/4000215152.jpeg?d=l'),
(9051, 9011, 'https://photos.zillowstatic.com/fp/c943c48e82899923c224207a4ed70279-cc_ft_960.jpeg'),
(9052, 9011, 'https://photos.zillowstatic.com/fp/ae94438ba3ca9b57f2a0e8c2846b5f35-cc_ft_576.jpeg'),
(9053, 9011, 'https://photos.zillowstatic.com/fp/e9fceb484fbda67f579fd1967da1ed32-cc_ft_576.jpeg'),
(9054, 9011, 'https://photos.zillowstatic.com/fp/e8448063ac3e327424e98e1a174fa742-cc_ft_960.jpeg'),
(9055, 9011, 'https://photos.zillowstatic.com/fp/57de2d66b4a184dcba312207cbbfbac5-cc_ft_576.jpeg'),
(9056, 9012, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/44466929.jpeg?d=l'),
(9057, 9012, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1714803251.jpeg?d=l'),
(9058, 9012, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/2256398421.jpeg?d=l'),
(9059, 9012, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1189049495.jpeg?d=l'),
(9060, 9012, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/4000215152.jpeg?d=l'),
(9061, 9013, 'https://photos.zillowstatic.com/fp/c943c48e82899923c224207a4ed70279-cc_ft_960.jpeg'),
(9062, 9013, 'https://photos.zillowstatic.com/fp/ae94438ba3ca9b57f2a0e8c2846b5f35-cc_ft_576.jpeg'),
(9063, 9013, 'https://photos.zillowstatic.com/fp/e9fceb484fbda67f579fd1967da1ed32-cc_ft_576.jpeg'),
(9064, 9013, 'https://photos.zillowstatic.com/fp/e8448063ac3e327424e98e1a174fa742-cc_ft_960.jpeg'),
(9065, 9013, 'https://photos.zillowstatic.com/fp/57de2d66b4a184dcba312207cbbfbac5-cc_ft_576.jpeg'),
(9066, 9014, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/44466929.jpeg?d=l'),
(9067, 9014, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1714803251.jpeg?d=l'),
(9068, 9014, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/2256398421.jpeg?d=l'),
(9069, 9014, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1189049495.jpeg?d=l'),
(9070, 9014, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/4000215152.jpeg?d=l'),
(9071, 9015, 'https://photos.zillowstatic.com/fp/c943c48e82899923c224207a4ed70279-cc_ft_960.jpeg'),
(9072, 9015, 'https://photos.zillowstatic.com/fp/ae94438ba3ca9b57f2a0e8c2846b5f35-cc_ft_576.jpeg'),
(9073, 9015, 'https://photos.zillowstatic.com/fp/e9fceb484fbda67f579fd1967da1ed32-cc_ft_576.jpeg'),
(9074, 9015, 'https://photos.zillowstatic.com/fp/e8448063ac3e327424e98e1a174fa742-cc_ft_960.jpeg'),
(9075, 9015, 'https://photos.zillowstatic.com/fp/57de2d66b4a184dcba312207cbbfbac5-cc_ft_576.jpeg'),
(9076, 9016, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/44466929.jpeg?d=l'),
(9077, 9016, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1714803251.jpeg?d=l'),
(9078, 9016, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/2256398421.jpeg?d=l'),
(9079, 9016, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1189049495.jpeg?d=l'),
(9080, 9016, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/4000215152.jpeg?d=l'),
(9081, 9017, 'https://photos.zillowstatic.com/fp/c943c48e82899923c224207a4ed70279-cc_ft_960.jpeg'),
(9082, 9017, 'https://photos.zillowstatic.com/fp/ae94438ba3ca9b57f2a0e8c2846b5f35-cc_ft_576.jpeg'),
(9083, 9017, 'https://photos.zillowstatic.com/fp/e9fceb484fbda67f579fd1967da1ed32-cc_ft_576.jpeg'),
(9084, 9017, 'https://photos.zillowstatic.com/fp/e8448063ac3e327424e98e1a174fa742-cc_ft_960.jpeg'),
(9085, 9017, 'https://photos.zillowstatic.com/fp/57de2d66b4a184dcba312207cbbfbac5-cc_ft_576.jpeg'),
(9086, 9018, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/44466929.jpeg?d=l'),
(9087, 9018, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1714803251.jpeg?d=l'),
(9088, 9018, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/2256398421.jpeg?d=l'),
(9089, 9018, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1189049495.jpeg?d=l'),
(9090, 9018, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/4000215152.jpeg?d=l'),
(9091, 9019, 'https://photos.zillowstatic.com/fp/c943c48e82899923c224207a4ed70279-cc_ft_960.jpeg'),
(9092, 9019, 'https://photos.zillowstatic.com/fp/ae94438ba3ca9b57f2a0e8c2846b5f35-cc_ft_576.jpeg'),
(9093, 9019, 'https://photos.zillowstatic.com/fp/e9fceb484fbda67f579fd1967da1ed32-cc_ft_576.jpeg'),
(9094, 9019, 'https://photos.zillowstatic.com/fp/e8448063ac3e327424e98e1a174fa742-cc_ft_960.jpeg'),
(9095, 9019, 'https://photos.zillowstatic.com/fp/57de2d66b4a184dcba312207cbbfbac5-cc_ft_576.jpeg'),
(9096, 9020, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/44466929.jpeg?d=l'),
(9097, 9020, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1714803251.jpeg?d=l'),
(9098, 9020, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/2256398421.jpeg?d=l'),
(9099, 9020, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/1189049495.jpeg?d=l'),
(9100, 9020, 'https://photos.prod.cirrussystem.net/712/9abd0ebb51c37a5b80fc5e9a94391bed/4000215152.jpeg?d=l')

;


-- Applications
INSERT INTO applications (app_id, user_id, prop_id, move_in_date, app_status, app_date) VALUES
(9001, 9001, 9001, '2024-01-15', 'approved', '2024-01-02 10:00:00'),
(9002, 9015, 9002, '2024-02-01', 'withdrawn', '2024-01-14 12:30:00'),
(9003, 9004, 9002, '2024-02-01', 'approved', '2024-01-15 14:30:00'),
(9004, 9005, 9003, '2024-03-01', 'approved', '2024-02-10 09:15:00'),
(9005, 9017, 9004, '2024-04-01', 'denied', '2024-03-14 16:00:00'),
(9006, 9007, 9004, '2024-04-01', 'approved', '2024-03-15 16:45:00'),
(9007, 9008, 9005, '2024-05-01', 'approved', '2024-04-10 11:20:00'),
(9008, 9010, 9006, '2024-06-01', 'approved', '2024-05-15 13:00:00'),
(9009, 9011, 9007, '2024-07-01', 'approved', '2024-06-10 15:30:00'),
(9010, 9012, 9008, '2024-07-15', 'approved', '2024-06-25 10:45:00'),
(9011, 9016, 9008, '2024-07-15', 'denied', '2024-06-25 10:45:00'),
(9012, 9013, 9009, '2024-08-01', 'approved', '2024-07-10 14:15:00'),
(9013, 9014, 9010, '2024-08-15', 'approved', '2024-07-25 09:30:00'),
(9014, 9018, 9013, '2024-09-01', 'pending', '2024-08-01 11:30:00'),
(9015, 9019, 9012, '2024-09-15', 'pending', '2024-08-01 14:45:00'),
(9016, 9020, 9019, '2024-09-01', 'pending', '2024-08-02 09:00:00'),
(9017, 9019, 9015, '2024-09-15', 'pending', '2024-08-02 14:45:00'),
(9018, 9020, 9020, '2024-10-01', 'pending', '2024-08-01 11:00:00'),
(9019, 9020, 9020, '2024-10-01', 'pending', '2024-08-03 09:00:00')
;

-- Leases
INSERT INTO leases (lease_id, user_id, prop_id, start_date, end_date, rent, lease_status, term_length) VALUES
(9001, 9001, 9001, '2024-01-15', '2025-01-14', 1200.00, 'active', 12),
(9002, 9004, 9002, '2024-02-01', '2025-07-31', 1500.00, 'active', 18),
(9003, 9005, 9003, '2024-03-01', '2025-02-28', 900.00, 'active', 12),
(9004, 9007, 9004, '2024-04-01', '2026-03-31', 1100.00, 'active', 24),
(9005, 9008, 9005, '2024-05-01', '2025-04-30', 1300.00, 'active', 12),
(9006, 9010, 9006, '2024-06-01', '2025-11-30', 1000.00, 'active', 18),
(9007, 9011, 9007, '2024-07-01', '2024-12-31', 1400.00, 'active', 6),
(9008, 9012, 9008, '2024-07-15', '2026-07-14', 950.00, 'active', 24),
(9009, 9013, 9009, '2024-08-01', '2025-07-31', 1250.00, 'active', 12),
(9010, 9014, 9010, '2024-08-15', '2026-02-14', 1150.00, 'active', 18)
;

-- Payments
INSERT INTO payments (user_id, prop_id, lease_id, pay_period, pay_date, amount, late) VALUES
(9001, 9001, 9001, '2024-02-01', '2024-02-01 09:15:00', 1200.00, false),
(9001, 9001, 9001, '2024-03-01', '2024-03-01 10:30:00', 1200.00, false),
(9001, 9001, 9001, '2024-04-01', '2024-04-03 14:45:00', 1200.00, true),
(9001, 9001, 9001, '2024-05-01', '2024-05-01 11:00:00', 1200.00, false),
(9001, 9001, 9001, '2024-06-01', '2024-06-01 09:30:00', 1200.00, false),
(9001, 9001, 9001, '2024-07-01', '2024-07-02 16:15:00', 1200.00, true),
(9001, 9001, 9001, '2024-08-01', '2024-08-01 10:45:00', 1200.00, false),
(9004, 9002, 9002, '2024-02-01', '2024-02-01 08:45:00', 1500.00, false),
(9004, 9002, 9002, '2024-03-01', '2024-03-01 09:30:00', 1500.00, false),
(9004, 9002, 9002, '2024-04-01', '2024-04-01 10:15:00', 1500.00, false),
(9004, 9002, 9002, '2024-05-01', '2024-05-03 15:30:00', 1500.00, true),
(9004, 9002, 9002, '2024-06-01', '2024-06-01 11:45:00', 1500.00, false),
(9004, 9002, 9002, '2024-07-01', '2024-07-01 09:00:00', 1500.00, false),
(9004, 9002, 9002, '2024-08-01', '2024-08-01 10:30:00', 1500.00, false),
(9005, 9003, 9003,'2024-03-01', '2024-03-01 10:00:00', 900.00, false),
(9005, 9003, 9003,'2024-04-01', '2024-04-02 14:30:00', 900.00, true),
(9005, 9003, 9003,'2024-05-01', '2024-05-01 09:45:00', 900.00, false),
(9005, 9003, 9003,'2024-06-01', '2024-06-01 11:15:00', 900.00, false),
(9005, 9003, 9003,'2024-07-01', '2024-07-01 10:30:00', 900.00, false),
(9005, 9003, 9003,'2024-08-01', '2024-08-01 09:15:00', 900.00, false),
(9007, 9004, 9004, '2024-04-01', '2024-04-01 09:30:00', 1100.00, false),
(9007, 9004, 9004, '2024-05-01', '2024-05-01 10:45:00', 1100.00, false),
(9007, 9004, 9004, '2024-06-01', '2024-06-03 15:00:00', 1100.00, true),
(9007, 9004, 9004, '2024-07-01', '2024-07-01 11:30:00', 1100.00, false),
(9007, 9004, 9004, '2024-08-01', '2024-08-01 10:15:00', 1100.00, false),
(9008, 9005, 9005, '2024-05-01', '2024-05-01 10:00:00', 1300.00, false),
(9008, 9005, 9005, '2024-06-01', '2024-06-01 09:45:00', 1300.00, false),
(9008, 9005, 9005, '2024-07-01', '2024-07-03 14:30:00', 1300.00, true),
(9008, 9005, 9005, '2024-08-01', '2024-08-01 11:15:00', 1300.00, false),
(9010, 9006, 9006, '2024-06-01', '2024-06-01 09:15:00', 1000.00, false),
(9010, 9006, 9006, '2024-07-01', '2024-07-01 10:30:00', 1000.00, false),
(9010, 9006, 9006, '2024-08-01', '2024-08-02 15:45:00', 1000.00, true),
(9011, 9007, 9007, '2024-07-01', '2024-07-01 10:00:00', 1400.00, false),
(9011, 9007, 9007, '2024-08-01', '2024-08-01 09:30:00', 1400.00, false),
(9012, 9008, 9008,'2024-08-01', '2024-08-01 11:00:00', 950.00, false),
(9013, 9009, 9009, '2024-08-01', '2024-08-01 10:15:00', 1250.00, false)
;

-- Service Requests
INSERT INTO service_request (user_id, prop_id, req_status, req_date, last_updated, req_body, issue_type) VALUES
(9001, 9001, 'complete', '2024-03-15 10:30:00', '2024-03-16 10:30:00', 'Dishwasher not draining properly', 'dishwasher'),
(9005, 9003, 'complete', '2024-05-20 14:45:00', '2024-05-21 09:15:00', 'Central air not cooling effectively', 'central_air'),
(9008, 9005, 'complete', '2024-06-10 11:00:00', '2024-06-12 16:30:00', 'Washing machine leaking', 'laundry'),
(9011, 9007, 'complete', '2024-07-05 09:30:00', '2024-07-06 09:30:00', 'Bathroom sink clogged', 'bathroom'),
(9013, 9009, 'in_progress', '2024-08-03 13:15:00', '2024-08-04 10:00:00', 'Strange noise coming from the ceiling fan', 'other'),
(9004, 9002, 'pending', '2024-07-25 14:20:00', '2024-07-25 14:20:00', 'Dishwasher making loud grinding noise during wash cycle', 'dishwasher'),
(9007, 9004, 'in_progress', '2024-08-02 09:45:00', '2024-08-03 11:30:00', 'Air conditioning not turning on', 'central_air'),
(9010, 9006, 'pending', '2024-08-05 16:10:00', '2024-08-05 16:10:00', 'Shower head leaking and low water pressure', 'bathroom')
;

-- Messages
INSERT INTO messages (contact_type, user_to, user_from, subject, msg_body, msg_date) VALUES
-- Welcome messages for each lease
('email', 9001, 9002, 'Welcome to Your New Home!', 'Welcome to your new home! We''re excited to have you as our tenant. Here''s some important information about your rental property...', '2024-01-15 09:00:00'),
('email', 9004, 9002, 'Welcome to Your New Home!', 'Welcome to your new home! We''re excited to have you as our tenant. Here''s some important information about your rental property...', '2024-02-01 09:00:00'),
('email', 9005, 9002, 'Welcome to Your New Home!', 'Welcome to your new home! We''re excited to have you as our tenant. Here''s some important information about your rental property...', '2024-03-01 09:00:00'),
('email', 9007, 9002, 'Welcome to Your New Home!', 'Welcome to your new home! We''re excited to have you as our tenant. Here''s some important information about your rental property...', '2024-04-01 09:00:00'),
('email', 9008, 9002, 'Welcome to Your New Home!', 'Welcome to your new home! We''re excited to have you as our tenant. Here''s some important information about your rental property...', '2024-05-01 09:00:00'),
('email', 9010, 9002, 'Welcome to Your New Home!', 'Welcome to your new home! We''re excited to have you as our tenant. Here''s some important information about your rental property...', '2024-06-01 09:00:00'),
('email', 9011, 9002, 'Welcome to Your New Home!', 'Welcome to your new home! We''re excited to have you as our tenant. Here''s some important information about your rental property...', '2024-07-01 09:00:00'),
('email', 9012, 9002, 'Welcome to Your New Home!', 'Welcome to your new home! We''re excited to have you as our tenant. Here''s some important information about your rental property...', '2024-07-15 09:00:00'),
('email', 9013, 9002, 'Welcome to Your New Home!', 'Welcome to your new home! We''re excited to have you as our tenant. Here''s some important information about your rental property...', '2024-08-01 09:00:00'),
('email', 9014, 9002, 'Welcome to Your New Home!', 'Welcome to your new home! We''re excited to have you as our tenant. Here''s some important information about your rental property...', '2024-08-15 09:00:00'),

-- Newsletter messages (for some tenants)
('email', 9001, 9002, 'Community Newsletter - March 2024', 'Here''s your community newsletter for March 2024. Learn about upcoming events and important updates...', '2024-03-01 10:00:00'),
('email', 9005, 9002, 'Community Newsletter - June 2024', 'Here''s your community newsletter for June 2024. Learn about upcoming events and important updates...', '2024-06-01 10:00:00'),
('email', 9008, 9002, 'Community Newsletter - August 2024', 'Here''s your community newsletter for August 2024. Learn about upcoming events and important updates...', '2024-08-01 10:00:00'),

-- Service request messages
('email', 9001, 9002, 'Service Request Received - Dishwasher', 'We have received your service request regarding the dishwasher not draining properly. Our maintenance team will address this issue soon.', '2024-03-15 10:35:00'),
('email', 9001, 9002, 'Service Request Completed - Dishwasher', 'Your service request for the dishwasher has been completed. Please let us know if you need any further assistance.', '2024-03-16 10:35:00'),
('email', 9005, 9002, 'Service Request Received - Central Air', 'We have received your service request regarding the central air not cooling effectively. Our maintenance team will address this issue soon.', '2024-05-20 14:50:00'),
('email', 9005, 9002, 'Service Request Completed - Central Air', 'Your service request for the central air has been completed. Please let us know if you need any further assistance.', '2024-05-21 09:20:00'),
('email', 9008, 9002, 'Service Request Received - Washing Machine', 'We have received your service request regarding the leaking washing machine. Our maintenance team will address this issue soon.', '2024-06-10 11:05:00'),
('email', 9008, 9002, 'Service Request Completed - Washing Machine', 'Your service request for the washing machine has been completed. Please let us know if you need any further assistance.', '2024-06-12 16:35:00'),
('email', 9011, 9002, 'Service Request Received - Bathroom Sink', 'We have received your service request regarding the clogged bathroom sink. Our maintenance team will address this issue soon.', '2024-07-05 09:35:00'),
('email', 9011, 9002, 'Service Request Completed - Bathroom Sink', 'Your service request for the bathroom sink has been completed. Please let us know if you need any further assistance.', '2024-07-06 09:35:00'),
('email', 9013, 9002, 'Service Request Received - Ceiling Fan', 'We have received your service request regarding the strange noise from the ceiling fan. Our maintenance team will address this issue soon.', '2024-08-03 13:20:00'),
('email', 9013, 9002, 'Service Request Update - Ceiling Fan', 'Our maintenance team is currently working on your ceiling fan issue. We''ll update you once the work is completed.', '2024-08-04 10:05:00'),
('email', 9004, 9002, 'Service Request Received - Dishwasher', 'We have received your service request regarding the dishwasher making a loud grinding noise. Our maintenance team will address this issue soon.', '2024-07-25 14:25:00'),
('email', 9007, 9002, 'Service Request Received - Air Conditioning', 'We have received your service request regarding the air conditioning not turning on. Our maintenance team will address this issue soon.', '2024-08-02 09:50:00'),
('email', 9007, 9002, 'Service Request Update - Air Conditioning', 'Our maintenance team is currently working on your air conditioning issue. We''ll update you once the work is completed.', '2024-08-03 11:35:00'),
('email', 9010, 9002, 'Service Request Received - Shower', 'We have received your service request regarding the leaking shower head and low water pressure. Our maintenance team will address this issue soon.', '2024-08-05 16:15:00');

COMMIT TRANSACTION;
