CREATE TABLE Department(
    id INTEGER PRIMARY KEY,
    name TEXT
);

CREATE TABLE SubjectStructures(
    id INTEGER PRIMARY KEY,
    name TEXT,
    term INTEGER,
    dept_id INTEGER,
    FOREIGN KEY(dept_id) REFERENCES Department(id)
);

CREATE TABLE Students(
    id INTEGER PRIMARY KEY,
    prefix TEXT,
    surname TEXT,
    date_of_birth INTEGER,
    current_school TEXT,
    email TEXT,
    registered_struct INTEGER,
    FOREIGN KEY(registered_struct) REFERENCES SubjectStructures(id)
);

CREATE TABLE Subject(
    id INTEGER PRIMARY KEY,
    name TEXT,
    credit INTEGER,
    prof_name TEXT,
    prerequisite INTEGER,
    FOREIGN KEY(prerequisite) REFERENCES Subject(id)
);

CREATE TABLE Registered_Subject(
    student_id INTEGER,
    subject_id INTEGER,
    grade TEXT,
    FOREIGN KEY(student_id) REFERENCES Students(id),
    FOREIGN KEY(subject_id) REFERENCES Subject(id)
);

CREATE TABLE StructureRequirement(
    struct_id INTEGER,
    subject_id INTEGER,
    FOREIGN KEY(struct_id) REFERENCES SubjectStructures(id),
    FOREIGN KEY(subject_id) REFERENCES Subject(id)
);
