create table if not exists Ingredient
(
    id
    serial
    primary
    key,
    code
    varchar
(
    4
) not null unique,
    name varchar
(
    25
) not null,
    type varchar
(
    10
) not null
    );
alter table Taco
    add foreign key (taco_order) references Taco_Order (id);
alter table Ingredient_Ref
    add foreign key (ingredient) references Ingredient (code);

create table if not exists Usr (
    id          serial primary key,
    city        varchar,
    fullname    varchar,
    password    varchar,
    phoneNumber varchar,
    state       varchar,
    street      varchar,
    username    varchar,
    zip         varchar
);