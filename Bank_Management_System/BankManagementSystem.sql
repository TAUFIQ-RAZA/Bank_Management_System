CREATE DATABASE bankManagementSystem;

USE bankManagementSystem;

CREATE TABLE signupone(
formno varchar(20),
name varchar(20),
fname varchar(20),
dob varchar(20),
gender varchar(20),
email varchar(30),
marital varchar(20),
address varchar(40),
city varchar(20),
state varchar(20),
pincode varchar(20));

SELECT * FROM signupone;


CREATE TABLE signuptwo(
formno varchar(20),
Religion varchar(20),
Category varchar(20),
Income varchar(20),
Education varchar(20),
Occupation varchar(30),
Pan varchar(20),
Aadhar varchar(20),
Senior_Citizen varchar(20),
Existing_Account varchar(20)
);

SELECT * FROM signuptwo;

CREATE TABLE signupthree (
formno varchar(20),
accountType varchar(20),
cardNumber varchar(30),
pinNumber varchar(20),
facility varchar(20));

select * from signupthree;


CREATE TABLE login(formno varchar(20),cardNumber varchar(30), pinNumber varchar(20));

SELECT * FROM login; 

CREATE TABLE bank(pin varchar(20), date varchar(50), type varchar(20), amount varchar(50));

SELECT * FROM bank; 
