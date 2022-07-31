CREATE DATABASE cidadaos
default charset utf8
default collate utf8_general_ci

USE cidadaos;

/*cpf, nome, endereco e sexo.*/
CREATE TABLE cidadaos(
id INT AUTO_INCREMENT PRIMARY KEY,
first_name varchar(200), 
social_security_number varchar(14),
address varchar(300),
sex enum('M','F') 
charset utf8);

select * from cidadaos
