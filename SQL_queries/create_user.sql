CREATE USER 'webUser'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON * . * TO 'webUser'@'localhost';
ALTER USER 'webUser'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';