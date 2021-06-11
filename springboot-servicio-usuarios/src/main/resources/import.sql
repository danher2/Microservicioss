INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('andres','$2a$10$0VAnEzz6qYhDjUVIilLyjuG0oQ3omz8iuND1TBHCNJZ99M9w/0gvK',true, 'Andres', 'Guzman','profesor@bolsadeideas.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$8iXSV6djuxH7y8UV0YiCLOZxLX23ujKHtFtnQwwuQKopR75ISKtjm',true, 'John', 'Doe','jhon.doe@bolsadeideas.com');


INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);