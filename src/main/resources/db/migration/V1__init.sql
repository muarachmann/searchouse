CREATE TABLE logement (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  type varchar(100) NOT NULL,
  latitude varchar(50) NOT NULL,
  longitude varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
)

ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into logement
values(2,'appartement', '9.0', '1.1');

insert into logement
values(3,'appartement', '9.0', '2.1');
