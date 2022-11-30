--liquibase formatted sql
changeset Dauren:1
Create Table Transactions(
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    limit_id int REFERENCES Limits(id),
    sum DECIMAL,
    account_from int,
    account_to int,
    currency_shortname varchar(3),
    expense_category varchar(20),
    date_of_transaction date,
    limit_exceeded boolean
)
Create Table Limits(
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    value DECIMAL,
    limit_date_time date,
    limit_currency_shortname varchar(3),
    remaining_usd DECIMAL,
    expense_category varchar
)

Create Table Currency(
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    value DECIMAL NOT NULL,
    date_of_value Date
)