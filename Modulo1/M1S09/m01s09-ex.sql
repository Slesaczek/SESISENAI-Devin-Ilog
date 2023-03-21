create database loja_util;

-- drop table produto;
create table produto (
  id int primary key auto_increment,
  ativo boolean not null default true,
  sku varchar(50) not null unique,
  nome varchar(50) not null,
  descricao varchar(255),
  valor_unitario decimal(19,2) not null default 0.00
);



-- drop table cliente;
create table cliente (
  id int primary key auto_increment,
  ativo boolean not null default true,
  nome varchar(50) not null,
  cpf_cnpj varchar(50) not null unique
);

-- drop table venda;
create table venda (
  id int primary key auto_increment,
  data_venda datetime not null,
  cliente_id int not null,
  status varchar(1) not null default 'P', 
  quantidade decimal(19,2) not null,
  valor_total decimal(19,2) not null
);
ALTER TABLE venda ADD CONSTRAINT fk_venda_cliente_id FOREIGN KEY (cliente_id) REFERENCES cliente (id);

-- drop table venda_item;
create table venda_item (
  id int primary key auto_increment,
  venda_id int not null,
  produto_id int not null,
  quantidade decimal(19,2) not null,
  valor_unitario decimal(19,2) not null,
  valor_total decimal(19,2) not null
);
ALTER TABLE venda_item ADD CONSTRAINT fk_venda_item_venda_id FOREIGN KEY (venda_id) REFERENCES venda(id);
ALTER TABLE venda_item ADD CONSTRAINT fk_venda_item_produto_id FOREIGN KEY (produto_id) REFERENCES produto(id);
