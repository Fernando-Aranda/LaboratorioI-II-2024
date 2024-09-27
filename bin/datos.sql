-- Inserta algunos datos ficticios
INSERT INTO recursos (nombre, tipo, protegido) VALUES ('Imagen1', 'jpg', 0);
INSERT INTO recursos (nombre, tipo, protegido) VALUES ('Video1', 'mp4', 1);
INSERT INTO recursos (nombre, tipo, protegido) VALUES ('Documento1', 'pdf', 0);
INSERT INTO recursos (nombre, tipo, protegido) VALUES ('Video2', 'mp4', 1);

INSERT INTO usuarios (rut, nombre, permiso, recursos_multimedia_id) VALUES (15786780, 'Juan Perez', 1,1);
INSERT INTO usuarios (rut, nombre, permiso, recursos_multimedia_id) VALUES (11234202, 'Rosa Espinoza', 0,2);
INSERT INTO usuarios (rut, nombre, permiso, recursos_multimedia_id) VALUES (09233271, 'Pedro Gonzalez', 1,3);
INSERT INTO usuarios (rut, nombre, permiso, recursos_multimedia_id) VALUES (22739296, 'Maria Barroso', 0,4);

