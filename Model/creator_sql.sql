CREATE DATABASE IF NOT EXISTS "test";

USE "test";

CREATE TABLE IF NOT EXISTS "users" ( 
    user_id BIGSERIAL PRIMARY KEY,
    user_identification_number VARCHAR(11) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    user_surname VARCHAR(255) NOT NULL,
    user_email VARCHAR(255) NOT NULL,
    user_password VARCHAR(256) NOT NULL,
    user_verification_code VARCHAR(64),
    user_is_verified BOOLEAN DEFAULT FALSE,
    user_uuid VARCHAR(36) DEFAULT (gen_random_uuid()) UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);  

CREATE INDEX IF NOT EXISTS user_uuid_index ON "users" (user_uuid);
CREATE INDEX IF NOT EXISTS user_identification_number_index ON "users" (user_identification_number);
CREATE INDEX IF NOT EXISTS user_is_verified_index ON "users" (user_is_verified);

CREATE TABLE IF NOT EXISTS "laborants" ( 
    laborant_id BIGSERIAL PRIMARY KEY,
    laborant_hospital_id VARCHAR(7) NOT NULL UNIQUE,
    laborant_identification_number VARCHAR(11) NOT NULL,
    laborant_name VARCHAR(255) NOT NULL,
    laborant_surname VARCHAR(255) NOT NULL,
    laborant_email VARCHAR(255) NOT NULL,
    laborant_password VARCHAR(256) NOT NULL,
    laborant_verification_code VARCHAR(64),
    laborant_is_verified BOOLEAN DEFAULT FALSE,
    laborant_is_active_work BOOLEAN DEFAULT FALSE,
    laborant_uuid VARCHAR(36) DEFAULT (gen_random_uuid()) UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);  

CREATE INDEX IF NOT EXISTS laborant_uuid_index ON "laborants" (laborant_uuid);
CREATE INDEX IF NOT EXISTS laborant_identification_number_index ON "laborants" (laborant_identification_number);
CREATE INDEX IF NOT EXISTS laborant_is_verified_index ON "laborants" (laborant_is_verified);

CREATE TABLE IF NOT EXISTS "admins" ( 
    admin_id BIGSERIAL PRIMARY KEY,
    admin_hospital_id VARCHAR(7) UNIQUE,
    admin_identification_number VARCHAR(11) NOT NULL UNIQUE,
    admin_name VARCHAR(255) NOT NULL,
    admin_surname VARCHAR(255) NOT NULL,
    admin_email VARCHAR(255) NOT NULL,
    admin_password VARCHAR(256) NOT NULL,
    admin_verification_code VARCHAR(64),
    admin_is_verified BOOLEAN DEFAULT FALSE,
    admin_uuid VARCHAR(36) DEFAULT (gen_random_uuid()) UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);  

CREATE INDEX IF NOT EXISTS admin_uuid_index ON "admins" (admin_uuid);
CREATE INDEX IF NOT EXISTS admin_identification_number_index ON "admins" (admin_identification_number);
CREATE INDEX IF NOT EXISTS admin_is_verified_index ON "admins" (admin_is_verified);

CREATE TABLE IF NOT EXISTS "photos" (
    photo_id BIGSERIAL PRIMARY KEY,
    photo_uuid VARCHAR(36) DEFAULT (gen_random_uuid()) UNIQUE,
    photo_is_visible BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX IF NOT EXISTS photo_uuid_index ON "photos" (photo_uuid);

CREATE TABLE IF NOT EXISTS "reports" (
    report_id BIGSERIAL PRIMARY KEY,
    report_number VARCHAR(100) NOT NULL,
    report_patient_name VARCHAR(255) NOT NULL,
    report_patient_surname VARCHAR(255) NOT NULL,
    report_patient_identification_number VARCHAR(11) NOT NULL,
    report_patient_birth_day VARCHAR(2) NOT NULL,
    report_patient_birth_month VARCHAR(2) NOT NULL,
    report_patient_birth_year VARCHAR(4) NOT NULL,
    report_patient_uuid VARCHAR(36),
    report_laborant_uuid VARCHAR(36) NOT NULL,
    report_diagnose_title VARCHAR(255) NOT NULL,
    report_diagnose_content TEXT NOT NULL,
    report_photo_url TEXT NOT NULL,
    report_is_visible BOOLEAN DEFAULT TRUE,
    report_uuid VARCHAR(36) DEFAULT (gen_random_uuid()) UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    -- CONSTRAINT fk_report_patient FOREIGN KEY (report_patient_uuid) REFERENCES "users" (user_uuid),
    CONSTRAINT fk_report_laborant FOREIGN KEY (report_laborant_uuid) REFERENCES "laborants" (laborant_uuid)
);

CREATE INDEX IF NOT EXISTS report_uuid_index ON "reports" (report_uuid);
CREATE INDEX IF NOT EXISTS report_number_index ON "reports" (report_number);
CREATE INDEX IF NOT EXISTS report_patient_uuid_index ON "reports" (report_patient_uuid);
CREATE INDEX IF NOT EXISTS report_laborant_uuid_index ON "reports" (report_laborant_uuid);




-- users table
INSERT INTO users (user_identification_number, user_name, user_surname, user_email, user_password, user_verification_code, user_is_verified, user_uuid, created_at, updated_at)
    SELECT 
        '12345678901', 'John', 'Doe', 'john.doe@example.com', 'password123', 'verification123', TRUE, '123e4567-e89b-12d3-a456-426614174010', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '98765432109', 'Jane', 'Smith', 'jane.smith@example.com', 'password456', 'verification456', TRUE, '123e4567-e89b-12d3-a456-426614174011', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '12345678902', 'Michael', 'Johnson', 'michael.johnson@example.com', 'password789', 'verification789', TRUE, '123e4567-e89b-12d3-a456-426614174012', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '98765432108', 'Emily', 'Brown', 'emily.brown@example.com', 'passwordabc', 'verificationabc', TRUE, '123e4567-e89b-12d3-a456-426614174013', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '12345678903', 'William', 'Miller', 'william.miller@example.com', 'passworddef', 'verificationdef', TRUE, '123e4567-e89b-12d3-a456-426614174014', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '98765432107', 'Sophia', 'Wilson', 'sophia.wilson@example.com', 'passwordghi', 'verificationghi', TRUE, '123e4567-e89b-12d3-a456-426614174015', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '12345678904', 'David', 'Martinez', 'david.martinez@example.com', 'passwordjkl', 'verificationjkl', TRUE, '123e4567-e89b-12d3-a456-426614174016', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '98765432106', 'Emma', 'Garcia', 'emma.garcia@example.com', 'passwordmno', 'verificationmno', TRUE, '123e4567-e89b-12d3-a456-426614174017', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '12345678905', 'Daniel', 'Hernandez', 'daniel.hernandez@example.com', 'passwordpqr', 'verificationpqr', TRUE, '123e4567-e89b-12d3-a456-426614174018', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '98765432105', 'Olivia', 'Lopez', 'olivia.lopez@example.com', 'passwordstu', 'verificationstu', TRUE, '123e4567-e89b-12d3-a456-426614174019', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP;


-- laborants table
INSERT INTO laborants (laborant_hospital_id, laborant_identification_number, laborant_name, laborant_surname, laborant_email, laborant_password, laborant_verification_code, laborant_is_verified, laborant_is_active_work, laborant_uuid, created_at, updated_at)
    SELECT 
        'H22345', '11111111111', 'Michael', 'Johnson', 'michael.johnson@example.com', 'password789', 'verification789', TRUE, TRUE, '123e4567-e89b-12d3-a456-426614174130', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H64321', '22222222222', 'Emily', 'Brown', 'emily.brown@example.com', 'passwordabc', 'verificationabc', TRUE, TRUE, '123e4567-e89b-12d3-a456-426614174131', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H22346', '33333333333', 'David', 'Martinez', 'david.martinez@example.com', 'passwordxyz', 'verificationxyz', TRUE, TRUE, '123e4567-e89b-12d3-a456-426614174132', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H64320', '44444444444', 'Emma', 'Garcia', 'emma.garcia@example.com', 'passworddef', 'verificationdef', TRUE, TRUE, '123e4567-e89b-12d3-a456-426614174133', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H22347', '55555555555', 'Daniel', 'Hernandez', 'daniel.hernandez@example.com', 'passwordghi', 'verificationghi', TRUE, TRUE, '123e4567-e89b-12d3-a456-426614174134', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H64319', '66666666666', 'Olivia', 'Lopez', 'olivia.lopez@example.com', 'passwordjkl', 'verificationjkl', TRUE, TRUE, '123e4567-e89b-12d3-a456-426614174135', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H22348', '77777777777', 'Sophia', 'Wilson', 'sophia.wilson@example.com', 'passwordmnop', 'verificationmnop', TRUE, TRUE, '123e4567-e89b-12d3-a456-426614174136', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H64318', '88888888888', 'William', 'Miller', 'william.miller@example.com', 'passwordpqr', 'verificationpqr', TRUE, TRUE, '123e4567-e89b-12d3-a456-426614174137', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H22349', '99999999999', 'Sophia', 'Wilson', 'sophia.wilson@example.com', 'passwordstu', 'verificationstu', TRUE, TRUE, '123e4567-e89b-12d3-a456-426614174138', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H64317', '10101010101', 'David', 'Martinez', 'david.martinez@example.com', 'password123', 'verification123', TRUE, TRUE, '123e4567-e89b-12d3-a456-426614174139', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP;


-- admins table
INSERT INTO admins (admin_hospital_id, admin_identification_number, admin_name, admin_surname, admin_email, admin_password, admin_verification_code, admin_is_verified, admin_uuid, created_at, updated_at)
    SELECT 
        'H12345', '11111111112', 'Michael', 'Johnson', 'michael.johnson@example.com', 'password789', 'verification789', TRUE, '123e4567-e89b-12d3-a456-426614174200', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H54321', '22222222223', 'Emily', 'Brown', 'emily.brown@example.com', 'passwordabc', 'verificationabc', TRUE, '123e4567-e89b-12d3-a456-426614174201', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H12346', '33333333334', 'David', 'Martinez', 'david.martinez@example.com', 'passwordxyz', 'verificationxyz', TRUE, '123e4567-e89b-12d3-a456-426614174202', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H54320', '44444444445', 'Emma', 'Garcia', 'emma.garcia@example.com', 'passworddef', 'verificationdef', TRUE, '123e4567-e89b-12d3-a456-426614174203', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H12347', '55555555556', 'Daniel', 'Hernandez', 'daniel.hernandez@example.com', 'passwordghi', 'verificationghi', TRUE, '123e4567-e89b-12d3-a456-426614174204', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H54319', '66666666667', 'Olivia', 'Lopez', 'olivia.lopez@example.com', 'passwordjkl', 'verificationjkl', TRUE, '123e4567-e89b-12d3-a456-426614174205', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H12348', '77777777778', 'Sophia', 'Wilson', 'sophia.wilson@example.com', 'passwordmno', 'verificationmno', TRUE, '123e4567-e89b-12d3-a456-426614174206', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H54318', '88888888889', 'William', 'Miller', 'william.miller@example.com', 'passwordpqr', 'verificationpqr', TRUE, '123e4567-e89b-12d3-a456-426614174207', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H12349', '99999999990', 'Sophia', 'Wilson', 'sophia.wilson@example.com', 'passwordstu', 'verificationstu', TRUE, '123e4567-e89b-12d3-a456-426614174208', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'H54317', '10101010102', 'David', 'Martinez', 'david.martinez@example.com', 'password123', 'verification123', TRUE, '123e4567-e89b-12d3-a456-426614174209', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP;


-- photos table
INSERT INTO photos (photo_uuid, photo_is_visible, created_at, updated_at)
    SELECT 
        '123e4567-e89b-12d3-a456-426614174300', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '123e4567-e89b-12d3-a456-426614174301', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '123e4567-e89b-12d3-a456-426614174302', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '123e4567-e89b-12d3-a456-426614174303', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '123e4567-e89b-12d3-a456-426614174304', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '123e4567-e89b-12d3-a456-426614174305', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '123e4567-e89b-12d3-a456-426614174306', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '123e4567-e89b-12d3-a456-426614174307', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '123e4567-e89b-12d3-a456-426614174308', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        '123e4567-e89b-12d3-a456-426614174309', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP;


-- reports table
INSERT INTO reports (report_number, report_patient_name, report_patient_surname, report_patient_identification_number, report_patient_birth_day, report_patient_birth_month, report_patient_birth_year, report_patient_uuid, report_laborant_uuid, report_diagnose_title, report_diagnose_content, report_photo_url, report_is_visible, report_uuid, created_at, updated_at)
    SELECT 
        'R001', 'John', 'Doe', '12345678901', '10', '01', '2000', '123e4567-e89b-12d3-a456-426614174010', '123e4567-e89b-12d3-a456-426614174130', 'Diagnose 1', 'Content 1', 'https://example.com/photo1.jpg', TRUE, '123e4567-e89b-12d3-a456-426614174400', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'R002', 'Jane', 'Smith', '98765432109', '11', '01', '2000', '123e4567-e89b-12d3-a456-426614174011', '123e4567-e89b-12d3-a456-426614174131', 'Diagnose 2', 'Content 2', 'https://example.com/photo2.jpg', TRUE, '123e4567-e89b-12d3-a456-426614174401', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'R003', 'Michael', 'Johnson', '12345678902', '11', '01', '2000', '123e4567-e89b-12d3-a456-426614174012', '123e4567-e89b-12d3-a456-426614174132', 'Diagnose 3', 'Content 3', 'https://example.com/photo3.jpg', TRUE, '123e4567-e89b-12d3-a456-426614174402', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'R004', 'Emily', 'Brown', '98765432108', '13', '11', '2000', '123e4567-e89b-12d3-a456-426614174013', '123e4567-e89b-12d3-a456-426614174133', 'Diagnose 4', 'Content 4', 'https://example.com/photo4.jpg', TRUE, '123e4567-e89b-12d3-a456-426614174403', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'R005', 'William', 'Miller', '12345678903', '11', '11', '2000', '123e4567-e89b-12d3-a456-426614174014', '123e4567-e89b-12d3-a456-426614174134', 'Diagnose 5', 'Content 5', 'https://example.com/photo5.jpg', TRUE, '123e4567-e89b-12d3-a456-426614174404', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'R006', 'Sophia', 'Wilson', '98765432107', '10', '11', '2000', '123e4567-e89b-12d3-a456-426614174015', '123e4567-e89b-12d3-a456-426614174135', 'Diagnose 6', 'Content 6', 'https://example.com/photo6.jpg', TRUE, '123e4567-e89b-12d3-a456-426614174405', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'R007', 'David', 'Martinez', '12345678904', '10', '05', '2000', '123e4567-e89b-12d3-a456-426614174016', '123e4567-e89b-12d3-a456-426614174136', 'Diagnose 7', 'Content 7', 'https://example.com/photo7.jpg', TRUE, '123e4567-e89b-12d3-a456-426614174406', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'R008', 'Emma', 'Garcia', '98765432106', '10', '05', '2000', '123e4567-e89b-12d3-a456-426614174017', '123e4567-e89b-12d3-a456-426614174137', 'Diagnose 8', 'Content 8', 'https://example.com/photo8.jpg', TRUE, '123e4567-e89b-12d3-a456-426614174407', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'R009', 'Daniel', 'Hernandez', '12345678905', '10', '07', '2000', '123e4567-e89b-12d3-a456-426614174018', '123e4567-e89b-12d3-a456-426614174138', 'Diagnose 9', 'Content 9', 'https://example.com/photo9.jpg', TRUE, '123e4567-e89b-12d3-a456-426614174408', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    UNION ALL
    SELECT 
        'R010', 'Olivia', 'Lopez', '98765432105', '10', '05', '2000', '123e4567-e89b-12d3-a456-426614174019', '123e4567-e89b-12d3-a456-426614174139', 'Diagnose 10', 'Content 10', 'https://example.com/photo10.jpg', TRUE, '123e4567-e89b-12d3-a456-426614174409', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP;