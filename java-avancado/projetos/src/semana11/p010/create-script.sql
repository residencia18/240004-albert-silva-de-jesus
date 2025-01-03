create table Cliente (id integer not null auto_increment, cpf varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table Fatura (id integer not null auto_increment, dataEmissao date, matriculaImovel varchar(255), penultimaLeitura integer not null, quitado bit not null, reembolso tinyblob, ultimaLeitura integer not null, valorTotal double precision, imovel_id integer, primary key (id)) engine=InnoDB
create table Imovel (id integer not null auto_increment, endereco varchar(255), matricula varchar(255), penultimaLeitura integer not null, ultimaLeitura integer not null, cliente_id integer, primary key (id)) engine=InnoDB
create table Pagamento (id integer not null auto_increment, data date, valor double precision not null, fatura_id integer, primary key (id)) engine=InnoDB
create table Reembolso (id integer not null auto_increment, data date, valor double precision not null, primary key (id)) engine=InnoDB
alter table Fatura add constraint FK5bvrqk64oq5uy0re2pbnlmtat foreign key (imovel_id) references Imovel (id)
alter table Imovel add constraint FKls02qfkc5vkdu0vpdq6b9jgoq foreign key (cliente_id) references Cliente (id)
alter table Pagamento add constraint FK8ovq2qxu6qj34rtxo3bmji3nc foreign key (fatura_id) references Fatura (id)
