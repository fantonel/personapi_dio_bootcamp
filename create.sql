create table dio.person (id int8 not null, birthdate date not null, cpf varchar(255) not null, firstname varchar(255) not null, lastname varchar(255) not null, primary key (id))
create table dio.phone (id int8 not null, ddd int4 not null, ddi int4 not null, phoneoperator_id int4 not null, phonetype_id int4 not null, phoneusage_id int4 not null, prefix int4 not null, suffix int4 not null, person_id int8, primary key (id))
alter table if exists dio.person add constraint UK_ovihp2p82c97wbe60mv11txrj unique (cpf)
create sequence person_seq start 1 increment 1
create sequence phone_seq start 1 increment 1
alter table if exists dio.phone add constraint FKkk6uij3j6wikpnqlj9dymobs9 foreign key (person_id) references dio.person
create table dio.person (id int8 not null, birthdate date not null, cpf varchar(255) not null, firstname varchar(255) not null, lastname varchar(255) not null, primary key (id))
create table dio.phone (id int8 not null, ddd int4 not null, ddi int4 not null, phoneoperator_id int4 not null, phonetype_id int4 not null, phoneusage_id int4 not null, prefix int4 not null, suffix int4 not null, person_id int8, primary key (id))
alter table if exists dio.person add constraint UK_ovihp2p82c97wbe60mv11txrj unique (cpf)
create sequence person_seq start 1 increment 1
create sequence phone_seq start 1 increment 1
alter table if exists dio.phone add constraint FKkk6uij3j6wikpnqlj9dymobs9 foreign key (person_id) references dio.person
create table dio.person (id int8 not null, birthdate date not null, cpf varchar(255) not null, firstname varchar(255) not null, lastname varchar(255) not null, primary key (id))
create table dio.phone (id int8 not null, ddd int4 not null, ddi int4 not null, phoneoperator_id int4 not null, phonetype_id int4 not null, phoneusage_id int4 not null, prefix int4 not null, suffix int4 not null, person_id int8, primary key (id))
alter table if exists dio.person add constraint UK_ovihp2p82c97wbe60mv11txrj unique (cpf)
create sequence person_seq start 1 increment 1
create sequence phone_seq start 1 increment 1
alter table if exists dio.phone add constraint FKkk6uij3j6wikpnqlj9dymobs9 foreign key (person_id) references dio.person
