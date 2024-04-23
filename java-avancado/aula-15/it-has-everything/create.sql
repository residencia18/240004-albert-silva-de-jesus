    create table tb_category (
        id bigserial not null,
        name varchar(255) unique,
        primary key (id)
    );

    create table tb_employee (
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

    create table tb_employee_product (
        employee_id bigint not null,
        product_id bigint not null,
        primary key (employee_id, product_id)
    );

    create table tb_product (
        price float(53),
        id bigserial not null,
        description varchar(255),
        img_url varchar(255),
        name varchar(255) unique,
        primary key (id)
    );

    create table tb_product_category (
        category_id bigint not null,
        product_id bigint not null,
        primary key (category_id, product_id)
    );

    create table tb_user (
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

    alter table if exists tb_employee 
       add constraint FK4ntaoj36f33b01vt0et9ifmgx 
       foreign key (usuario_id) 
       references tb_user;

    alter table if exists tb_employee_product 
       add constraint FKm5qn49nilwnt5se7ddsxuqs8r 
       foreign key (product_id) 
       references tb_product;

    alter table if exists tb_employee_product 
       add constraint FKlcpqjoosigg0l2x0pybhswv8d 
       foreign key (employee_id) 
       references tb_employee;

    alter table if exists tb_product_category 
       add constraint FK5r4sbavb4nkd9xpl0f095qs2a 
       foreign key (category_id) 
       references tb_category;

    alter table if exists tb_product_category 
       add constraint FKgbof0jclmaf8wn2alsoexxq3u 
       foreign key (product_id) 
       references tb_product;
   