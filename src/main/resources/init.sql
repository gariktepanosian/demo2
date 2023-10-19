-- Trainee table
CREATE TABLE Trainee (
                         trainee_id INT PRIMARY KEY AUTO_INCREMENT,
                         first_name VARCHAR(50) NOT NULL,
                         last_name VARCHAR(50) NOT NULL,
                         email VARCHAR(100) UNIQUE NOT NULL,
                         phone_number VARCHAR(15),
                         date_of_birth DATE,
                         registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Trainer table
CREATE TABLE Trainer (
                         trainer_id INT PRIMARY KEY AUTO_INCREMENT,
                         first_name VARCHAR(50) NOT NULL,
                         last_name VARCHAR(50) NOT NULL,
                         email VARCHAR(100) UNIQUE NOT NULL,
                         phone_number VARCHAR(15),
                         specialty VARCHAR(100),
                         hire_date DATE,
                         registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- TrainingSession table
CREATE TABLE TrainingSession (
                                 session_id INT PRIMARY KEY AUTO_INCREMENT,
                                 session_name VARCHAR(100),
                                 date_time DATETIME NOT NULL,
                                 trainer_id INT,
                                 trainee_id INT,
                                 FOREIGN KEY (trainer_id) REFERENCES Trainer(trainer_id),
                                 FOREIGN KEY (trainee_id) REFERENCES Trainee(trainee_id)
);
