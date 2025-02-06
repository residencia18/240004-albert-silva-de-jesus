create table if not exists tb_usuarios (
  data_criacao timestamp(6),
  data_modificacao timestamp(6),
  id bigserial not null,
  role varchar(25) not null check (role in ('ROLE_ADMIN','ROLE_COMUM')),
  username varchar(100) not null unique,
  password varchar(200) not null,
  criado_por varchar(255),
  modificado_por varchar(255),
  primary key (id)
);

INSERT INTO tb_usuarios (data_criacao, data_modificacao, role, username, password)
VALUES 
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_ADMIN', 'JoaoSilva@gmail.com', '654321'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'MariaSilva@gmail.com', '234567'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'JoseSilva@gmail.com', '345678'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'AnaSilva@gmail.com', '456789'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'PauloSilva@gmail.com', '567890'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'PedroSilva@gmail.com', '678901'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'CarlosSilva@gmail.com', '789012'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'AntonioSilva@gmail.com', '890123'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'FranciscoSilva@gmail.com', '901234'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'LuizSilva@gmail.com', '012345'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'MiguelSilva@gmail.com', '123456'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'EduardoSilva@gmail.com', '234567'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'GabrielSilva@gmail.com', '345678'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'RafaelSilva@gmail.com', '456789'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'LucasSilva@gmail.com', '567890'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'MateusSilva@gmail.com', '678901'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'RodrigoSilva@gmail.com', '789012'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'GustavoSilva@gmail.com', '890123'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'PedroSilva2@gmail.com', '901234'),
    ('2021-01-01 00:00:00', '2021-01-01 00:00:00', 'ROLE_COMUM', 'PauloSilva2@gmail.com', '012345');
