delimiter ;

drop schema if exists `dailyquiz`;

CREATE DATABASE `dailyquiz`
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_unicode_ci;

use dailyquiz;

create table membro
(
  id int UNSIGNED auto_increment not null,
  nome varchar(50)not null ,
  email varchar(50) not null,
  senha char(64) not null,
  datanascimento DATE,
  unique(nome),
  unique(email),
  primary key (id));



