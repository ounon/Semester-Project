CREATE DATABASE Compiler;

CREATE TABLE  `student` (
	`student_id` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(255) NOT NULL,
	`last_name` VARCHAR(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,UNIQUE KEY `email` (`email`),
    UNIQUE KEY `email` (`email`),
    PRIMARY KEY (`student_id`)
);

CREATE TABLE `student_course` (
	`student_id` SMALLINT UNSIGNED NOT NULL,
    `course_id` SMALLINT UNSIGNED NOT NULL,
	PRIMARY KEY (`student_id`,`course_id`),
	FOREIGN KEY (`student_id`) REFERENCES `student`(`student_id`) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (`course_id`) REFERENCES `course`(`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE  `assistant` (
    `assistant_id` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(255) NOT NULL,
	`last_name` VARCHAR(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,UNIQUE KEY `email` (`email`),
    UNIQUE KEY `email` (`email`),
    PRIMARY KEY (`assistant_id`)
);

CREATE TABLE `assistant_course` (
	`assistant_id` SMALLINT UNSIGNED NOT NULL,
    `course_id` SMALLINT UNSIGNED NOT NULL,
	PRIMARY KEY (`assistant_id`,`course_id`),
	FOREIGN KEY (`assistant_id`) REFERENCES `assistant`(`assistant_id`) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (`course_id`) REFERENCES `course`(`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE  `professor` (
    `professor_id` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(255) NOT NULL,
	`last_name` VARCHAR(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,UNIQUE KEY `email` (`email`),
    UNIQUE KEY `email` (`email`),
    PRIMARY KEY (`professor_id`)
);

CREATE TABLE `professor_course` (
	`professor_id` SMALLINT UNSIGNED NOT NULL,
    `course_id` SMALLINT UNSIGNED NOT NULL,
	PRIMARY KEY (`professor_id`,`course_id`),
	FOREIGN KEY (`professor_id`) REFERENCES `professor`(`professor_id`) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (`course_id`) REFERENCES `course`(`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `course` (
	`course_id` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255),
	`description` VARCHAR(255),
	PRIMARY KEY (`course_id`)
);

CREATE TABLE `question` (
	`question_id` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(255),
	`category` VARCHAR(255),
    `question_file_path` VARCHAR(255),
	`question_path` VARCHAR(255),
	PRIMARY KEY (`question_id`)
);
CREATE TABLE `course_question` (
	`course_id` SMALLINT UNSIGNED NOT NULL,
    `question_id` SMALLINT UNSIGNED NOT NULL,
	PRIMARY KEY (`course_id`,`question_id`),
	FOREIGN KEY (`course_id`) REFERENCES `course`(`course_id`) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (`question_id`) REFERENCES `question`(`question_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `submission` (
	`student_id` SMALLINT UNSIGNED NOT NULL,
    `question_id` SMALLINT UNSIGNED NOT NULL,
    `score` SMALLINT,
    `student_solution_path` VARCHAR(255),
	PRIMARY KEY (`student_id`,`question_id`),
	FOREIGN KEY (`student_id`) REFERENCES `student`(`student_id`) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (`question_id`) REFERENCES `question`(`question_id`) ON DELETE CASCADE ON UPDATE CASCADE
);




