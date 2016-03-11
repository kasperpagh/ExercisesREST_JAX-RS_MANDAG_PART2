DROP TABLE IF EXISTS PERSON;
create table PERSON
(
    id int not null auto_increment primary key,
    fName  VARCHAR(40),
    lName  VARCHAR(60),
    phone varchar(40)
);

insert into PERSON(id,fName,lName,phone) values (null,"john1","johnsenA","12345");
insert into PERSON(id,fName,lName,phone) values (null,"john2","johnsenB","12345");
insert into PERSON(id,fName,lName,phone) values (null,"john3","johnsenC","12345");
insert into PERSON(id,fName,lName,phone) values (null,"john4","johnsenD","12345");
insert into PERSON(id,fName,lName,phone) values (null,"john5","johnsenE","12345");