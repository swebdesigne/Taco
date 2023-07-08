create table if not exists Ingredient
(
    id   serial primary key,
    code varchar(4)  not null unique,
    name varchar(25) not null,
    type varchar(10) not null
);
alter table Taco
    add foreign key (taco_order) references Taco_Order (id);
alter table Ingredient_Ref
    add foreign key (ingredient_code) references Ingredient (code);