drop table if exists therapists;
create table therapists (id bigint generated by default as identity, name varchar(255), date bigint, phoneNumber varchar(255), primary key (id)); 