create table if not exists tb_employee (
  experience_years integer not null,
  is_active boolean not null,
  start_date date,
  birth_date timestamp(6) with time zone,
  id bigserial not null,
  usuario_id bigint,
  cpf varchar(255) unique,
  name varchar(255),
  primary key (id)
);

insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (1, true, '2021-01-01', '2021-01-01 00:00:00', 1, '12345678901', 'João da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (2, true, '2021-01-01', '2021-01-01 00:00:00', 2, '12345678902', 'Maria da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (3, true, '2021-01-01', '2021-01-01 00:00:00', 3, '12345678903', 'José da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (4, true, '2021-01-01', '2021-01-01 00:00:00', 4, '12345678904', 'Ana da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (5, true, '2021-01-01', '2021-01-01 00:00:00', 5, '12345678905', 'Paulo da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (6, true, '2021-01-01', '2021-01-01 00:00:00', 6, '12345678906', 'Pedro da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (7, true, '2021-01-01', '2021-01-01 00:00:00', 7, '12345678907', 'Carlos da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (8, true, '2021-01-01', '2021-01-01 00:00:00', 8, '12345678908', 'Antônio da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (9, true, '2021-01-01', '2021-01-01 00:00:00', 9, '12345678909', 'Francisco da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (10, true, '2021-01-01', '2021-01-01 00:00:00', 10, '12345678910', 'Luiz da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (11, true, '2021-01-01', '2021-01-01 00:00:00', 11, '12345678911', 'Miguel da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (12, true, '2021-01-01', '2021-01-01 00:00:00', 12, '12345678912', 'Eduardo da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (13, true, '2021-01-01', '2021-01-01 00:00:00', 13, '12345678913', 'Gabriel da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (14, true, '2021-01-01', '2021-01-01 00:00:00', 14, '12345678914', 'Rafael da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (15, true, '2021-01-01', '2021-01-01 00:00:00', 15, '12345678915', 'Lucas da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (16, true, '2021-01-01', '2021-01-01 00:00:00', 16, '12345678916', 'Mateus da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (17, true, '2021-01-01', '2021-01-01 00:00:00', 17, '12345678917', 'Rodrigo da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (18, true, '2021-01-01', '2021-01-01 00:00:00', 18, '12345678918', 'Gustavo da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (19, true, '2021-01-01', '2021-01-01 00:00:00', 19, '12345678919', 'Pedro da Silva');
insert into tb_employee (experience_years, is_active, start_date, birth_date, usuario_id, cpf, name) values (20, true, '2021-01-01', '2021-01-01 00:00:00', 20, '12345678920', 'Paulo da Silva');