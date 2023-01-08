create table doador(

        id bigint not null auto_increment,
        nome varchar(100) not null,
    	email varchar(100) not null unique,
    	telefone varchar(15) not null,
    	nascimento varchar(30) not null,
    	cep varchar(9) not null,
    	rua varchar(50) not null,
    	bairro varchar(50) not null,
    	cidade varchar(20) not null,
    	uf varchar(2) not null,
    	numero varchar(20),
    	complemento varchar(100),

    	primary key (id)
);