CREATE TABLE CUSTOMERTABLE (
    customer_id int,
       email_id varchar(50),
       name varchar(20),
       date_of_birth date,
       id int  references address(address_id),
       primary key (customer_id)
);
insert into CUSTOMERTABLE values (1, 'martin@yh.com', 'Martin', date '2001-09-28' + interval '1 day', 1);
insert into CUSTOMERTABLE values (2, 'tim@hh.com', 'Tim',date '1991-09-08' + interval '100 day', 2);
insert into CUSTOMERTABLE values (3, 'jack@oiuu.com', 'Jack', date '1999-04-02' + interval '10 day', 3);