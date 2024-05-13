
    create table token (
        date_creation datetime(6),
        id bigint not null auto_increment,
        user_id bigint,
        token varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuarios (
        active BOOLEAN not null,
        date_creation datetime(6),
        date_modification datetime(6),
        id bigint not null auto_increment,
        code_verifier varchar(200),
        creator_by varchar(255),
        modified_by varchar(255),
        password varchar(255),
        username varchar(255) not null,
        role enum ('ROLE_ADMIN','ROLE_CLIENTE') not null,
        primary key (id)
    ) engine=InnoDB;

    alter table token 
       add constraint UK_g7im3j7f0g31yhl6qco2iboy5 unique (user_id);

    alter table usuarios 
       add constraint UK_m2dvbwfge291euvmk6vkkocao unique (username);

    alter table token 
       add constraint FK7tipr2wekkpu7e3xxqwmxv77k 
       foreign key (user_id) 
       references usuarios (id);
