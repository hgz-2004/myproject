-- alter ms_user columns for task 5.2
ALTER TABLE ms_user MODIFY COLUMN username VARCHAR(50) NOT NULL;
ALTER TABLE ms_user MODIFY COLUMN password VARCHAR(50) NOT NULL;
ALTER TABLE ms_user ADD COLUMN email VARCHAR(100) NULL AFTER password;
