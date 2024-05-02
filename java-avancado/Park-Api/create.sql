    create table usuarios (
        data_criacao datetime(6),
        data_modificacao datetime(6),
        id bigint not null auto_increment,
        role enum ('ROLE_ADMIN','ROLE_CLIENTE') not null,
        username varchar(100) not null,
        password varchar(200) not null,
        criado_por varchar(255),
        modificado_por varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuarios 
       add constraint UK_m2dvbwfge291euvmk6vkkocao unique (username);
