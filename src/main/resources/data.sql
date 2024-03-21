INSERT INTO product (name, description, starting_price, final_price, image, category, tag)
VALUES
    ('Buceo extremo', 'Emocionante experiencia de buceo en aguas profundas', 150.99, 199.99, 'buceo_extremo.jpg', 0, 'aventura'),
    ('Kit de snorkel', 'Kit completo de snorkel para explorar arrecifes de coral', 49.99, 59.99, 'snorkel.jpg', 2, 'accesorio'),
    ('Curso de buceo avanzado', 'Curso intensivo para mejorar tus habilidades de buceo', 199.99, 249.99, 'curso_avanzado.jpg', 1, 'formación'),
    ('Excursión a la barrera de coral', 'Viaje en barco para explorar la impresionante barrera de coral', 99.99, 149.99, 'excursion_coral.jpg', 0, 'naturaleza'),
    ('Traje de neopreno', 'Traje de neopreno de alta calidad para buceo en aguas frías', 79.99, 99.99, 'neopreno.jpg', 2, 'equipo'),
    ('Curso de buceo básico', 'Curso introductorio para principiantes en el mundo del buceo', 149.99, 199.99, 'curso_basico.jpg', 1, 'formación'),
    ('Paquete de fotografía submarina', 'Equipo completo para capturar impresionantes imágenes bajo el agua', 199.99, 249.99, 'fotografia_submarina.jpg', 0, 'foto'),
    ('Accesorios de buceo', 'Una amplia selección de accesorios para buceadores de todos los niveles', 29.99, 39.99, 'accesorios_buceo.jpg', 2, 'accesorio'),
    ('Tour nocturno de buceo', 'Experiencia única de buceo nocturno para explorar la vida marina bajo la luz de la luna', 129.99, 179.99, 'buceo_nocturno.jpg', 0, 'aventura'),
    ('Botellas de oxígeno', 'Botellas de oxígeno de alta presión para buceo seguro y prolongado', 89.99, 109.99, 'botellas_oxigeno.jpg', 2, 'equipo'),
    ('Curso de rescate acuático', 'Aprende técnicas de rescate y primeros auxilios en el agua', 179.99, 229.99, 'rescate_acuatico.jpg', 1, 'formación'),
    ('Viaje a islas tropicales', 'Paquete de vacaciones que incluye buceo en aguas cristalinas y playas paradisíacas', 799.99, 999.99, 'islas_tropicales.jpg', 0, 'vacaciones');



INSERT INTO item (id, weight, stock)
VALUES
    (2, 1.8, 10),
    (5, 3, 20),
    (8, 2.5, 5),
    (10, 2, 2);



INSERT INTO activity (id, level_required, time_starts, time_ends, available_spaces, available) VALUES
    (1, 0, '2024-03-21 10:00:00', '2024-03-21 12:00:00', 20, true),
    (3, 0, '2024-03-21 10:00:00', '2024-03-21 12:00:00', 10, true),
    (4, 0, '2024-03-21 10:00:00', '2024-03-21 12:00:00', 0, false),
    (6, 0, '2024-03-21 10:00:00', '2024-03-21 12:00:00', 7, true),
    (7, 0, '2024-03-21 10:00:00', '2024-03-21 12:00:00', 2, true),
    (9, 0, '2024-03-21 10:00:00', '2024-03-21 12:00:00', 9, true),
    (11, 2, '2024-03-22 14:00:00', '2024-03-22 16:00:00', 0, false),
    (12, 2, '2024-03-22 14:00:00', '2024-03-22 16:00:00', 0, false);



INSERT INTO user_ (nickname, password, name, surnames, email, phone, birthday, address, level, registration_date, last_login, role)
VALUES
    ('RashBack', '$2a$12$K4tojeaYWMK55KzWzDWtLOuuUjRTkycWhSGHYWA2LXMZqmZUtuXPO', 'David', 'Tejerina', 'a', 630156482, '2000-03-22 16:00:00', 'Getafe', 0, NOW(), NOW(), 0),
    ('ElDon', '$2a$12$K4tojeaYWMK55KzWzDWtLOuuUjRTkycWhSGHYWA2LXMZqmZUtuXPO', 'Alex', 'Peña', 'b', 630926482, '1997-03-22 16:00:00', 'Pinto', 2, NOW(), NOW(), 0),
    ('Administrador', '$2a$12$K4tojeaYWMK55KzWzDWtLOuuUjRTkycWhSGHYWA2LXMZqmZUtuXPO', 'Administrador', 'Administrador', 'admin', null, null, null, null, null, null, 1);



INSERT INTO Cart (user_id, product_id, amount)
VALUES
    (1, 1, 1),
    (1, 3, 1),
    (2, 2, 7),
    (2, 1, 1);


INSERT INTO Wish_list (user_id, product_id)
VALUES
    (1, 1),
    (1, 3),
    (2, 2),
    (2, 1);

