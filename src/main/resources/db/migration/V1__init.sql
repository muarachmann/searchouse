CREATE TABLE logement (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  type varchar(100) NOT NULL,
  latitude varchar(50) NOT NULL,
  longitude varchar(50) NOT NULL,
  ville varchar (50) NOT NULL,
  quartier varchar (50) NOT NULL,
  prix varchar (50) NOT NULL,
  piece varchar (50) NOT NULL,
  photo varchar (50) NOT NULL,

  PRIMARY KEY (id)
)




ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE agent (
  idAgent bigint(20) NOT NULL AUTO_INCREMENT,
  nom varchar(100) NOT NULL,
  prenom varchar(50) NOT NULL,
  userName varchar(50) NOT NULL,
  ville varchar (50) NOT NULL,
  psswd varchar (50) NOT NULL,
  societe varchar (50) NOT NULL,
  telephone varchar (50) NOT NULL,


  PRIMARY KEY (idAgent)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*
insert into logement
values(2,'appartement', '9.0', '1.1');

insert into logement
values(3,'appartement', '9.0', '2.1');
*/