CREATE TABLE agent (
  id bigint(11) NOT NULL AUTO_INCREMENT,
  nom varchar(255) NOT NULL,
  prenom varchar(255) NOT NULL,
  userName varchar(255) NOT NULL,
  ville varchar (255) NOT NULL,
  psswd varchar (255) NOT NULL,
  mail varchar (255) NOT NULL,
  societe varchar (255) NOT NULL,
  telephone varchar (255) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE logement (
  id bigint(11) NOT NULL AUTO_INCREMENT,
  type varchar(255) NOT NULL,
  latitude varchar(255) NOT NULL,
  longitude varchar(255) NOT NULL,
  ville varchar (255) NOT NULL,
  quartier varchar (255) NOT NULL,
  prix double  NOT NULL,
  piece varchar (255) NOT NULL,
  photo varchar (255) NOT NULL,
  ida bigint(255) NOT NULL ,
  statut tinyint (1) DEFAULT '0' NOT NULL ,
  PRIMARY KEY (id),
  FOREIGN KEY (ida) REFERENCES agent(id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE table user (
identifiant bigint(11) NOT null AUTO_INCREMENT,
username varchar (255) NOT null ,
password varchar (255) NOT null ,
nom varchar (255) NOT NULL ,
prenom varchar (255) NOT NULL ,
email varchar (255) NOT NULL ,
telephone varchar (255) NOT NULL ,
primary key (identifiant)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*
insert into logement
values(2,'appartement', '9.0', '1.1');

insert into logement
values(3,'appartement', '9.0', '2.1');
*/