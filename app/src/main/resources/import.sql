drop all objects;

create table `recipients` (`id` int primary key auto_increment,`own_name` varchar(50),`telephone_number` varchar(50),`birthdate` DATE,`register_date` DATE,`last_update` DATE);

create table `documents` (`id` int auto_increment,`recipient_id` int,`document_type` varchar(10),`description` varchar(100),`register_date` DATE,`last_update` DATE,primary key (`id`),foreign key (`recipient_id`) references `recipients`(`id`));

insert into `recipients` (`own_name`, `telephone_number`, `birthdate`, `register_date`, `last_update`) values ('Zé Pamonha', '+5511966580021', '1971-10-05', '1999-02-06', '2021-06-06');
insert into `recipients` (`own_name`, `telephone_number`, `birthdate`, `register_date`, `last_update`) values ('Roberval Pereira', '+5511964002232', '1982-01-19', '2015-05-09', '2020-08-13');
insert into `recipients` (`own_name`, `telephone_number`, `birthdate`, `register_date`, `last_update`) values ('Kleitu Robertson', '+5561977411235', '1988-11-12', '2016-06-09', '2019-04-11');
insert into `recipients` (`own_name`, `telephone_number`, `birthdate`, `register_date`, `last_update`) values ('Astrozilda Molecular', '+5582933657720', '1991-12-12', '2014-04-19', '2019-04-21');
insert into `recipients` (`own_name`, `telephone_number`, `birthdate`, `register_date`, `last_update`) values ('Keyrrison Gutenberg Alves', '+5521988565223', '1995-02-12', '2010-01-19', '2023-06-22');


insert into `documents` (`recipient_id`, `document_type`, `description`, `register_date`, `last_update`) values (1, 'RG', '100731089', '2021-06-06', '2021-06-06');
insert into `documents` (`recipient_id`, `document_type`, `description`, `register_date`, `last_update`) values (1, 'CPF', '44399446048', '2021-06-06', '2021-06-06');
insert into `documents` (`recipient_id`, `document_type`, `description`, `register_date`, `last_update`) values (2, 'CPF', '93064591061', '2015-05-09', '2020-08-13');
insert into `documents` (`recipient_id`, `document_type`, `description`, `register_date`, `last_update`) values (3, 'CPF', '65791718047', '2016-06-09', '2019-04-11');
insert into `documents` (`recipient_id`, `document_type`, `description`, `register_date`, `last_update`) values (4, 'CPF', '49581377000', '2014-04-19', '2014-04-19');
insert into `documents` (`recipient_id`, `document_type`, `description`, `register_date`, `last_update`) values (4, 'RG', '367769141', '2014-04-19', '2014-04-19');
insert into `documents` (`recipient_id`, `document_type`, `description`, `register_date`, `last_update`) values (5, 'RG', '367769141', '2010-01-19', '2010-01-21');
insert into `documents` (`recipient_id`, `document_type`, `description`, `register_date`, `last_update`) values (5, 'CPF', '18706463045', '2010-01-19', '2010-01-21');
