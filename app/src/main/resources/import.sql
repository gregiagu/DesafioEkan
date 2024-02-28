drop all objects;

create table `beneficiarios` (`id` int primary key auto_increment, `nome` varchar(50), `telefone` varchar(50), `data_nascimento` DATE, `data_inclusao` DATE, `data_atualizacao` DATE);

insert into `beneficiarios` (`nome`, `telefone`, `data_nascimento`, `data_inclusao`, `data_atualizacao`) values ('Zé Pamonha', '+5511966580021', '1971-10-05', '1999-02-06', '2021-06-06');
insert into `beneficiarios` (`nome`, `telefone`, `data_nascimento`, `data_inclusao`, `data_atualizacao`) values ('Roberval Pereira', '+5511964002232', '1982-01-19', '2015-05-09', '2020-08-13');
insert into `beneficiarios` (`nome`, `telefone`, `data_nascimento`, `data_inclusao`, `data_atualizacao`) values ('Kleitu Robertson', '+5561977411235', '1988-11-12', '2016-06-09', '2019-04-11');
insert into `beneficiarios` (`nome`, `telefone`, `data_nascimento`, `data_inclusao`, `data_atualizacao`) values ('Astrozilda Molecular', '+5582933657720', '1991-12-12', '2014-04-19', '2019-04-21');
insert into `beneficiarios` (`nome`, `telefone`, `data_nascimento`, `data_inclusao`, `data_atualizacao`) values ('Keyrrison Gutenberg Alves', '+5521988565223', '1995-02-12', '2010-01-19', '2023-06-22');

create table `documentos` (`id` int auto_increment, `beneficiario_id` int, `tipoDocumento` varchar(10), `descricao` varchar(100), `data_inclusao` DATE, `data_atualizacao` DATE, primary key (`id`), foreign key (`beneficiario_id`) references `beneficiarios`(`id`));

insert into `documentos` (`beneficiario_id`, `tipoDocumento`, `descricao`, `data_inclusao`, `data_atualizacao`) values (1, 'RG', '100731089', '2021-06-06', '2021-06-06');
insert into `documentos` (`beneficiario_id`, `tipoDocumento`, `descricao`, `data_inclusao`, `data_atualizacao`) values (1, 'CPF', '44399446048', '2021-06-06', '2021-06-06');
insert into `documentos` (`beneficiario_id`, `tipoDocumento`, `descricao`, `data_inclusao`, `data_atualizacao`) values (2, 'CPF', '93064591061', '2015-05-09', '2020-08-13');
insert into `documentos` (`beneficiario_id`, `tipoDocumento`, `descricao`, `data_inclusao`, `data_atualizacao`) values (3, 'CPF', '65791718047', '2016-06-09', '2019-04-11');
insert into `documentos` (`beneficiario_id`, `tipoDocumento`, `descricao`, `data_inclusao`, `data_atualizacao`) values (4, 'CPF', '49581377000', '2014-04-19', '2014-04-19');
insert into `documentos` (`beneficiario_id`, `tipoDocumento`, `descricao`, `data_inclusao`, `data_atualizacao`) values (4, 'RG', '367769141', '2014-04-19', '2014-04-19');
insert into `documentos` (`beneficiario_id`, `tipoDocumento`, `descricao`, `data_inclusao`, `data_atualizacao`) values (5, 'RG', '367769141', '2010-01-19', '2010-01-21');
insert into `documentos` (`beneficiario_id`, `tipoDocumento`, `descricao`, `data_inclusao`, `data_atualizacao`) values (5, 'CPF', '18706463045', '2010-01-19', '2010-01-21');
