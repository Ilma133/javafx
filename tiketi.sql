create database zadaca_baza;
use zadaca_baza;
create table tiket (
Id int auto_increment primary key,
TipUsluge varchar(50) not null,
NaslovProblema varchar(500) not null,
ImeOsobe varchar(100) not null,
Datum datetime not null,
NacinPrijave varchar(50) not null,
Prioritet varchar(50) not null,
Opis varchar(5000) not null,
Agent varchar(50) not null,
Email varchar(50) not null,
Telefon varchar(50) not null,
Statusy varchar(50), 
DatumRjesavanja datetime
);

drop table tiket;

select * from tiket;