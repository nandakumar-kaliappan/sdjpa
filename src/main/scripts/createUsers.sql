drop database if exists bookdb;
drop user `bookadmin`@`%`;
drop user `bookuser`@`%`;

create database if not exists bookdb character set utf8mb4 collate utf8mb4_unicode_ci;
create user `bookadmin`@`%` identified by 'password';
create user `bookuser`@`%` identified by 'password';

grant select, insert, update, delete, create, drop, references, index, alter, execute, create view, create routine, alter routine, event, trigger
	on `bookdb`.* to `bookadmin`@`%`;

grant select, insert, update, delete, show view on `bookdb`.* to `bookuser`@`%`;
