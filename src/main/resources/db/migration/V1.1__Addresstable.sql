create table address(
   address_id int ,
   street varchar(50),
   city varchar(20),
   primary key (address_id)
);

insert into address values (1, '15 Yemen Road', 'Yemen');
insert into address values (2, 'Wallstreet', 'New York');
insert into address values (3, 'Houston Street', 'New York');