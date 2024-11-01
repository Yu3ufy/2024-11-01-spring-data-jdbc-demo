
insert into customer( name) values ('Josh');
insert into cart( customer)  select id from customer where name = 'Josh';
insert into line_item(sku, cart)  select  '123',id from cart;
insert into line_item(sku, cart)  select  '345',id from cart;