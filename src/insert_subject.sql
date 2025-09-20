INSERT INTO Subject (id, name, credit, prof_name, prerequisite) VALUES
(05500001, 'Mathematics I', 3, 'Dr. Allen', NULL),
(05500002, 'Physics I', 3, 'Dr. Baker', NULL),
(05500003, 'Chemistry I', 3, 'Dr. Clark', NULL),
(05500004, 'Mathematics II', 3, 'Dr. Allen', 05500001),
(05500005, 'Physics II', 3, 'Dr. Baker', 05500002),
(05500006, 'Chemistry II', 3, 'Dr. Clark', 05500003),
(05500007, 'Computer Science I', 3, 'Dr. Davis', NULL),
(05500008, 'Computer Science II', 3, 'Dr. Davis', 05500007),
(05500009, 'Biology I', 3, 'Dr. Evans', NULL),
(05500010, 'Biology II', 3, 'Dr. Evans', 05500009);
