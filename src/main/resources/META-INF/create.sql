

USE ca3dev;
INSERT INTO users (user_name, user_pass) VALUES ('user', 'us#19Er');
INSERT INTO users (user_name, user_pass) VALUES ('admin', 'ad#19Min');
INSERT INTO roles (role_name) VALUES ('user');
INSERT INTO roles (role_name) VALUES ('admin');
INSERT INTO user_roles (user_name, role_name) VALUES ('user', 'user');
INSERT INTO user_roles (user_name, role_name) VALUES ('admin', 'user');
INSERT INTO user_roles (user_name, role_name) VALUES ('admin', 'admin');
