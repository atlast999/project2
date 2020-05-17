CREATE DATABASE OOP;
CREATE TABLE topic (
	level int NOT NULL,
    topicId int NOT NULL,
	length int NOT NULL,
	name varchar(255) NOT NULL,
    description varchar(255),
	CONSTRAINT primaryKey PRIMARY KEY(topicId, level)
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
(1, 1, 127, 'Topic1', 'So how is your weekend Alexa? Well I wanted to go to the club with my friends,,,')

INSERT INTO track VALUES
(1, 1, 'track1_1', 'So how is your weekend Alexa?', 'Alexa?'),
(1, 2, 'track1_2', 'Well I wanted to go to the club with my friends', '')
