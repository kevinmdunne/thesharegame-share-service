create table "shares" (
  id varchar(255) not null,
  symbol varchar(20) not null,
  fullname varchar(255) not null,
  price real not null,
  stock_exchange_id varchar(255) not null,
  primary key (id)
);

create table "stockexchanges" (
  id varchar(255) not null,
  symbol varchar(20) not null,
  fullname varchar(255) not null,
  primary key (id)
);