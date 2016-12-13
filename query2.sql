show databases;
create database db;
use db;
show tables;
create table table1(name varchar(10), age int(2), empid int(2) primary key);
describe table1;
insert into table1 values("vivek",21,1);
insert into table1 values("vinay",22,2);
insert into table1 values("sachin",23,3);
insert into table1 values("vivekDdwwd",21,4);
create table table2(name varchar(10), did int(2)primary key, empid int(2), foreign key(empid) references table1(empid));
drop table table2;

insert into table2 values("exe",11,2);
insert into table2 values("hr",12,1);
insert into table2 values("sales",13,2);
insert into table2 values("finance",14,4);
select * from table2;
select * from table1;