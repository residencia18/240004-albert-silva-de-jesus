create table tb_category (
  id bigserial not null,
  name varchar(255) unique,
  primary key (id)
);

insert into tb_category (name) values ('Eletrônicos');
insert into tb_category (name) values ('Móveis');
insert into tb_category (name) values ('Roupas');
insert into tb_category (name) values ('Alimentos');