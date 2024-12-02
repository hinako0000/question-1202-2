CREATE TABLE IF NOT EXISTS roles(
	role_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	role_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
	user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	user_name VARCHAR(50) NOT NULL,
	password VARCHAR(100) NOT NULL,
	role_id INT NOT NULL,
	FOREIGN KEY (role_id) REFERENCES roles (role_id)
);