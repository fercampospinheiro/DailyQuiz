delimiter ;

drop schema if exists `dailyquiz`;

CREATE DATABASE `dailyquiz`
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_unicode_ci;

use dailyquiz;

create table membro
(
  id int auto_increment not null,
  nome varchar(50)not null ,
  username varchar(10) not null,
  senha char(64) not null,
  unique(nome),
  primary key (id));



