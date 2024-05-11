
    create table token (
        data_criacao datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint,
        token varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuarios (
        ativo BOOLEAN not null,
        data_criacao datetime(6),
        data_modificacao datetime(6),
        id bigint not null auto_increment,
        codigo_verificador varchar(200),
        criado_por varchar(255),
        modificado_por varchar(255),
        password varchar(255),
        username varchar(255) not null,
        role enum ('ROLE_ADMIN','ROLE_CLIENTE') not null,
        primary key (id)
    ) engine=InnoDB;

    alter table token 
       add constraint UK_9k4m2cghvqnkxf0xak4u6f84g unique (usuario_id);

    alter table usuarios 
       add constraint UK_m2dvbwfge291euvmk6vkkocao unique (username);

    alter table token 
       add constraint FKuolrabau7u5l9hpfyvvim6f7 
       foreign key (usuario_id) 
       references usuarios (id);
