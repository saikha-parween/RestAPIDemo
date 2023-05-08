create table userTable(
   user_id int,
   email_id varchar(50),
   name varchar(20),
   date_of_birth date,
   id int  references address(address_id),
   primary key (user_id)
);


