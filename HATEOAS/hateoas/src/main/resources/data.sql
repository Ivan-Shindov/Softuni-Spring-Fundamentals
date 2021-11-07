INSERT INTO students (ID,NAME,AGE)
VALUES
(1,'Pesho',21),
(2,'Maya',42);


INSERT INTO courses (ID,NAME,ENABLED,PRICE)
VALUES
    (1,'Spring basic',0,100),
    (2,'Sprind Advanced',1,110);

INSERT INTO orders(ID,COURSE_ID,STUDENT_ID)
VALUES
(1,1,1),
(2,2,1),
(3,2,2);