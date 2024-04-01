create sequence categoria_seq start with 1 increment by 1;
create sequence produto_seq start with 1 increment by 1;

create table tb_categoria (
    id number(19,0) not null,
    nome varchar2(150 char) not null,
    primary_key (id)
);

create table tb_produto (
    valor float(53) not null,
    categoria_id number(19, 0) not null,
    id number(19,0) not null,
    nome varchar2(150 char) not null,
    descricao varchar2(250 char) not null,
    primary_key (id)
);
