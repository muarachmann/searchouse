CREATE TABLE agent (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nom varchar(100) NOT NULL,
  prenom varchar(50) NOT NULL,
  userName varchar(50) NOT NULL,
  ville varchar (50) NOT NULL,
  psswd varchar (50) NOT NULL,
  mail varchar (50) NOT NULL,
  societe varchar (50) NOT NULL,
  telephone varchar (50) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE logement (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  type varchar(100) NOT NULL,
  latitude varchar(50) NOT NULL,
  longitude varchar(50) NOT NULL,
  ville varchar (50) NOT NULL,
  quartier varchar (50) NOT NULL,
  prix double  NOT NULL,
  piece varchar (50) NOT NULL,
  photo varchar (50) NOT NULL,
  ida bigint(20) NOT NULL ,
  statut tinyint (1) DEFAULT '0' NOT NULL ,
  PRIMARY KEY (id),
  FOREIGN KEY (ida) REFERENCES agent(id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE table user (
  identifiant bigint(20) NOT null AUTO_INCREMENT,
  username varchar (50) NOT null ,
  password varchar (50) NOT null ,
  nom varchar (50) NOT NULL ,
  prenom varchar (50) NOT NULL ,
  email varchar (50) NOT NULL ,
  telephone varchar (50) NOT NULL ,
  primary key (identifiant)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*
insert into logement
values(2,'appartement', '9.0', '1.1');

insert into logement
values(3,'appartement', '9.0', '2.1');
*/