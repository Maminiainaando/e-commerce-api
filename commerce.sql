create table users(
    id int primary key,
    username varchar (50),
    email varchar (50),
    work varchar (50),
    password varchar (50)
);
create table review(
    reviewid int primary key,
    rating int,
    comment varchar (100)
);
create table promo(
    promoid int primary key,
    expirationdate date,
    category varchar (50)
);
create table product(
    productid int primary key,
    productname varchar (50),
    price float,
    stockquantity int,
    category varchar (100),
    categorydescription varchar (500)
);
create table orders(
    orderid int primary key,
    orderdate date,
    offlineorder boolean,
    quantity int,
    unitPrice float
);
create table cart(
    cartid int primary key,
    typecart varchar (50),
    usercart varchar (100)
);
create table client(
    clientid int primary key,
    clientname varchar (100),
    phonenumber varchar (300)
);