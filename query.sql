--CREATE DATABASE OOP;
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

CREATE TABLE score (
	level int not null,
	value int not null,
	created_at datetime not null
		DEFAULT CURRENT_TIMESTAMP
	primary key(level, created_at)
);



INSERT INTO topic VALUES
(1, 1, 58, 'Try to sleep', 'Norma went to bed. It was eleven o’clock...'),
(1, 2, 58, 'Red, White and Blue', 'Tracy looked at the flag. The flag is red, white, and blue...'),
(1, 3, 58, 'A Thin Man', 'Richard is a light eater. He doesn’t eat much...'),

(2, 4, 81, 'Thank you mom', 'I love my mom. She took care of me when I was very young...'),
--(2, 5, 60, 'Cold Weather', 'Thomas was not hot. He was not warm either...'),
(2, 5, 10, 'Cold Weather', 'Thomas was not hot. He was not warm either...'),
(2, 6, 59, 'New Shoes', 'Lisa loves to go shopping. Tomorrow she is going shopping...'),

(3, 7, 63, 'Benjamin Franklin', 'Benjamin Franklin was one of the most famous people in American history...'),
(3, 8, 66, 'Hawaii', 'Of the fifty states in the United States...'),
(3, 9, 81, 'William Shakespeare', 'There have been many great writers in the history of English literature...')

INSERT INTO track VALUES
(1, 1, 'track1_1', 'Norma went to bed. It was eleven o''clock. She turned out the light.', 'Norma'),
(1, 2, 'track1_2', 'She lay in bed. It was dark. It was quiet. She couldn''t sleep. She closed her eyes. She tried to sleep, but she couldn''t.', ''),
(1, 3, 'track1_3', 'She turned the light back on. She opened her book. Norma started to read her book. It was a good book. She read one page. Then she read another page.', 'Norma'),
(1, 4, 'track1_4', 'After a while, she felt sleepy. She closed the book. She turned out the light. She closed her eyes. She went straight to sleep.', ''),

(2, 1, 'track2_1', 'Tracy looked at the flag. The flag is red, white, and blue. It has 50 white stars.', 'Tracy'),
(2, 2, 'track2_2', 'The white stars are on a blue square. The flag has six white stripes. It has seven red stripes. All the stripes are horizontal.', ''),
(2, 3, 'track2_3', 'They are not vertical. The stripes do not go up and down. They go from left to right.', ''),
(2, 4, 'track2_4', 'Tracy loves her flag. It is the flag of her country. It is a pretty flag. No other flag has 50 stars. No other flag has 13 stripes.', 'Tracy'),

(3, 1, 'track3_1', 'Richard is a light eater. He doesn''t eat much. He isn''t a heavy eater. He eats a light breakfast, a light lunch, and a light dinner.', 'Richard'),
(3, 2, 'track3_2', 'Richard is not fat. He is thin. He will always be thin, because he is a light eater.', 'Richard'),
(3, 3, 'track3_3', 'He eats a bowl of cereal for breakfast. He eats a bowl of cereal with milk. He eats a sandwich for lunch. Sometimes it''s a fish sandwich. He likes fish.', ''),
(3, 4, 'track3_4', 'He eats rice and vegetables for dinner. All he eats for dinner is rice and vegetables. He will never get fat.', ''),

(4, 1, 'track4_1', 'I love my mom. She took care of me when I was very young. She took care of me when I was sick.', ''),
(4, 2, 'track4_2', 'She taught me how to read. She taught me how to get dressed. She taught me how to button my shirt. She taught me how to tie my shoes.', ''),
(4, 3, 'track4_3', 'She taught me how to brush my teeth. She taught me to be kind to others. She taught me to tell the truth.',''),
(4, 4, 'track4_4', 'She taught me to be polite. She took me to school on my first day of school. She held my hand.', ''),
(4, 5, 'track4_5', 'She helped me with my homework. She was nice to all my friends. She always cheered me up. Next year I will graduate from high school.',''),
(4, 6, 'track4_6', 'I will go to college. I will do well in college. I will do well after college. My mom has taught me well.',''),


(5, 1, 'track5_1', 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', ''),
(5, 2, 'track5_2', 'bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb', ''),
(5, 3, 'track5_3', 'cccccccccccccccccccccccccccccccccccc',''),
(5, 4, 'track5_4', 'dddddddddddddddddddddddddddddddddddd', ''),
(5, 5, 'track5_5', 'eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee',''),

/*
(5, 1, 'track5_1', 'Thomas was not hot. He was not warm either. He was cold. The weather was not hot. The weather was not warm', ''),
(5, 2, 'track5_2', 'The weather was cold. Thomas did not like to be cold, he look for his jacket, he found his jacket, he put on', ''),
(5, 3, 'track5_3', 'But he was still cold. He looked at the windows. Were all the windows closed? Yes, they were.',''),
(5, 4, 'track5_4', 'They were all closed. None of the windows were open. He looked at the door. The door wasn’t open.', ''),
(5, 5, 'track5_5', 'It was closed. He was still cold. He looked for a warmer jacket.',''),
*/

(6, 1, 'track6_1', 'Lisa loves to go shopping. Tomorrow she is going shopping. She needs a new pair of shoes. She wants to buy a pair of red shoes.', ''),
(6, 2, 'track6_2', 'She thinks red shoes are pretty. She will buy a pair of shoes at the mall. Lisa usually shops at the mall.', ''),
(6, 3, 'track6_3', 'The mall is only a mile from her house. She just walks to the mall. It only takes her 20 minutes.',''),
(6, 4, 'track6_4', 'Tomorrow she will go to four different shoe stores. Tomorrow is Saturday. The mall always has sales on Saturday.', ''),
(6, 5, 'track6_5', 'If the sale price is good, Lisa might buy two pairs of shoes.',''),

(7, 1, 'track7_1', 'Benjamin Franklin was one of the most famous people in American history.', ''),
(7, 2, 'track7_2', 'He was never a President of the United States, but he made great achievements in many areas of life, including business, literature, science, and politics.', ''),
(7, 3, 'track7_3', 'Benjamin Franklin was born in the city of Boston, during the year 1706. In his early years, Franklin was very poor. As a young man, he worked for his older brother, who was a printer.', ''),
(7, 4, 'track7_4', 'However, the two brothers soon argued with each other. Benjamin decided to leave, and he moved to the city of Philadelphia. He worked very hard and soon became a successful printer.', ''),
(7, 5, 'track7_5', 'He published his own newspapers, and he also published books called almanacs, which contained many wise sayings.', ''),
(7, 6, 'track7_6', 'Many of the wise sayings in Franklin''s almanacs are still repeated today.', ''),

(8, 1, 'track8_1', 'Of the fifty states in the United States, forty-nine are located on the mainland of North America.', ''),
(8, 2, 'track8_2', 'The other state is Hawaii, which consists of several islands in the middle of the Pacific Ocean. Hawaii is known as an especially beautiful and interesting place.', ''),
(8, 3, 'track8_3', 'The Hawaiian islands were formed by volcanic eruptions that pushed molten rock, called Lava above the surface of the ocean.', ''),
(8, 4, 'track8_4', 'Some of the islands no longer have any volcanic activity, but there are still active volcanoes on two Hawaiian islands, Oahu and the big island which is known simply as Hawaii.', ''),
(8, 5, 'track8_5', 'One of these volcanoes, Mauna Loa, still erupts sometimes, with spectacular explosions of lava. Another volcano, called Mauna Kea, is now dormant.', ''),
(8, 6, 'track8_6', 'These volcanoes are both very tall and reach over 4000 metres above sea level. The air above Mauna Kea is so clear and thin that scientists use the mountain as a base for observing the stars.', ''),

(9, 1, 'track9_1', 'There have been many great writers in the history of English literature, but there is no doubt about which writer was the greatest. Many people consider William Shakespeare to have been the best writer who ever lived.', ''),
(9, 2, 'track9_2', 'William Shakespeare was born in the town of Stratford, England, in the year 1564. When he was a young man, Shakespeare moved to the city of London, where he began writing plays. ', ''),
(9, 3, 'track9_3', 'His plays were soon very successful, and were enjoyed both by the common people of London and also by the rich and famous. In addition to his plays, Shakespeare wrote many short poems and a few longer poems. ', ''),
(9, 4, 'track9_4', 'Like his plays, these poems are still famous today. Shakespeare''s most famous plays include Romeo and Juliet, Macbeth, Hamlet, King Lear, Othello, and Julius Caesar. ', ''),
(9, 5, 'track9_5', 'Usually, Shakespeare did not invent the stories that he told in his plays. Instead, he wrote his plays using stories that already existed.', ''),
(9, 6, 'track9_6', 'However, Shakespeare''s plays told these stories in a more interesting way than ever before. Some of the stories were tragedies, some were comedies, and some described historical events.', '')





