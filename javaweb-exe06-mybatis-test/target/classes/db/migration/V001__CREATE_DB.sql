create database mobile_shop;
create user 'mshop'@'localhost' identified by 'hudp3ymVq5pMU47h';
create user 'mshop'@'%' identified by 'hudp3ymVq5pMU47h';
grant all on mobile_shop.* to 'mshop'@'localhost';
grant all on mobile_shop.* to 'mshop'@'%';
