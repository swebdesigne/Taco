create table if not exists Ingredient_Ref
(
    ingredient_code varchar(4)  not null,
    taco          bigint not null,
    taco_key      bigint not null
);
