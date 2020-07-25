create database SisBanco;

drop database sisbanco; 
create table if not exists usuario(
id_user int not null auto_increment,
nome varchar(30) not null,
cpf varchar(14) not null,
rg varchar(14) not null,
estado varchar(15) not null,
cidade varchar(20) not null,
endereco varchar(35) not null,
cep varchar(10) not null,
telefone varchar(18) not null,
primary key ( id_user),
unique key cpf (cpf),
unique key rg (rg)
);

drop table conta;
select * from conta;

create table if not exists conta(
fkid_user int not null primary key auto_increment,
num_conta varchar(20)  not null ,
tipo_conta varchar(20) not null,
saldo float,
limite float,
constraint fkid_user foreign key (fkid_user) references usuario (id_user),
unique key num_conta(num_conta)
);


select * from conta, usuario;

SELECT u.id_user, u.nome,u.cpf,u.rg,c.num_conta,c.tipo_conta, c.saldo,c.limite FROM usuario as u JOIN conta as c ON (u.id_user = c.fkid_user)





