create table customer2(
   customer_id int,
   email_id varchar(50),
   name varchar(20),
   date_of_birth date,
   id int  references address(address_id),
   primary key (customer_id)
);


