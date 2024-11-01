drop table if exists line_item;
drop table if exists cart;
drop table if exists customer;

create table if not exists customer
(
    id   serial primary key,
    name text not null
);

create table if not exists cart
(
    id       serial primary key,
    customer bigint references customer (id)
);

create table if not exists line_item
(
    id  serial primary key,
    sku text not null,
    cart bigint references cart (id)

);

