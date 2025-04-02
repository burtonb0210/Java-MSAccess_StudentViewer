USE dbStudentMajors;

IF OBJECT_ID('TStudents')	IS NOT NULL DROP TABLE TStudents
IF OBJECT_ID('TMajors') IS NOT NULL DROP TABLE TMajors


CREATE TABLE TStudents
(
	 intStudentID			INTEGER			NOT NULL
	,strFirstName			VARCHAR(50)		NOT NULL
	,strLastName			VARCHAR(50)		NOT NULL
	,strAddress				VARCHAR(50)		NOT NULL
	,strCity				VARCHAR(50)		NOT NULL
	,strState				VARCHAR(50)		NOT NULL
	,strZip					VARCHAR(50)		NOT NULL
	,strPhoneNumber			VARCHAR(50)		NOT NULL
	,strEmail				VARCHAR(50)		NOT NULL
	,CONSTRAINT TStudents_PK PRIMARY KEY ( intStudentID )
)


INSERT INTO TStudents (intStudentID, strFirstName, strLastName, strAddress, strCity, strState, strZip, strPhoneNumber, strEmail ) 
VALUES
	 (1, 'John', 'Doe', '123 Main St', 'Springfield', 'OH', '45503', '555-1234', 'john.doe@email.com')
	,(2, 'Sarah', 'Johnson', '456 Elm St', 'Dayton', 'OH', '45410', '555-5678', 'sarah.johnson@email.com')
	,(3, 'Mike', 'Brown', '789 Oak St', 'Columbus', 'OH', '43215', '555-9101', 'mike.brown@email.com')
	,(4, 'Emily', 'Davis', '321 Pine St', 'Cincinnati', 'OH', '45202', '555-1122', 'emily.davis@email.com')
	,(5, 'Jake', 'Wilson', '654 Maple St', 'Cleveland', 'OH', '44114', '555-3344', 'jake.wilson@email.com')

CREATE TABLE TMajors
(
	intMajorID					INTEGER				NOT NULL
	,strMajor					varchar(255)	NOT NULL
	,strDescription  			varchar(255)	NOT NULL
	,CONSTRAINT TMajors_PK PRIMARY KEY (intMajorID)
)
			   
INSERT INTO TMajors (intMajorID, strMajor, strDescription) VALUES
	 (1, 'PSY', 'Psychology')
	,(2, 'MECH', 'Mechanical Engineering')
	,(3, 'NURS', 'Nursing')
	,(4, 'BSMG', 'Business Management')
	,(5, 'CS', 'Computer Science')

select * from TStudents

select * from TMajors