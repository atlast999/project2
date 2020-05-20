CREATE DATABASE OOP;
CREATE TABLE topic (
	level int NOT NULL,
   	topicId int NOT NULL,
	length int NOT NULL,
	name varchar(255) NOT NULL,
   	description varchar(255),
	CONSTRAINT primaryKey PRIMARY KEY(topicId)
);
CREATE TABLE track (
	topicId int NOT NULL,
	trackId int NOT NULL,
	fileName varchar(255),
	script varchar(255),
	freeWord varchar(255),
	CONSTRAINT primaryKey2 PRIMARY KEY(trackId, topicId)
);

INSERT INTO topic VALUES
(2, 4, 81, 'Thank you mom', 'I love my mom. She took care of me when I was very young...'),
(2, 5, 60, 'Cold Weather', 'Thomas was not hot. He was not warm either...'),
(2, 6, 59, 'New Shoes', 'Lisa loves to go shopping. Tomorrow she is going shopping...')

INSERT INTO track VALUES
(4, 1, 'track4_1', 'I love my mom. She took care of me when I was very young. She took care of me when I was sick.', ''),
(4, 2, 'track4_2', 'She taught me how to read. She taught me how to get dressed. She taught me how to button my shirt. She taught me how to tie my shoes.', ''),
(4, 3, 'track4_3', 'She taught me how to brush my teeth. She taught me to be kind to others. She taught me to tell the truth.',''),
(4, 4, 'track4_4', 'She taught me to be polite. She took me to school on my first day of school. She held my hand.', ''),
(4, 5, 'track4_5', 'She helped me with my homework. She was nice to all my friends. She always cheered me up. Next year I will graduate from high school.',''),
(4, 6, 'track4_6', 'I will go to college. I will do well in college. I will do well after college. My mom has taught me well.',''),

(5, 1, 'track5_1', 'Thomas was not hot. He was not warm either. He was cold. The weather was not hot. The weather was not warm', ''),
(5, 2, 'track5_2', 'Thomas was not hot. He was not warm either. He was cold. The weather was not hot. The weather was not warm ', ''),
(5, 3, 'track5_3', 'But he was still cold. He looked at the windows. Were all the windows closed? Yes, they were.',''),
(5, 4, 'track5_4', 'They were all closed. None of the windows were open. He looked at the door. The door wasn’t open.', ''),
(5, 5, 'track5_5', 'It was closed. He was still cold. He looked for a warmer jacket.',''),

(6, 1, 'track6_1', 'Lisa loves to go shopping. Tomorrow she is going shopping. She needs a new pair of shoes. She wants to buy a pair of red shoes.', ''),
(6, 2, 'track6_2', 'She thinks red shoes are pretty. She will buy a pair of shoes at the mall. Lisa usually shops at the mall.', ''),
(6, 3, 'track6_3', 'The mall is only a mile from her house. She just walks to the mall. It only takes her 20 minutes.',''),
(6, 4, 'track6_4', 'Tomorrow she will go to four different shoe stores. Tomorrow is Saturday. The mall always has sales on Saturday.', ''),
(6, 5, 'track6_5', 'If the sale price is good, Lisa might buy two pairs of shoes.','')