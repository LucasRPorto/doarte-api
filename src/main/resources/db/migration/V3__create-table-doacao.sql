create table doacao (
    id_doacao bigint not null auto_increment,
    id_usuario bigint not null,
    email varchar(100) not null,
    nome_produto varchar(100) not null,
    valor decimal(10, 2) not null,
    metodo_pagamento varchar(50) not null,
    status_pagamento varchar(50) not null,
    primary key (id_doacao)
);