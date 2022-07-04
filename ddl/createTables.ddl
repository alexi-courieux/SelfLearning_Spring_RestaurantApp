create table garageApp.car
(
    id    varchar(36)  not null
        primary key,
    brand varchar(255) not null,
    model varchar(255) null,
    year  int          not null,
    color varchar(6)   not null
);
