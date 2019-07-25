/* Create users table */
CREATE table users (
  id bigint(11) NOT null AUTO_INCREMENT ,
  username varchar (255) NOT null ,
  nom varchar (255) NOT NULL ,
  prenom varchar (255) NOT NULL ,
  email varchar (255) NOT NULL ,
  telephone varchar (255) NOT NULL ,
  active tinyint (1) DEFAULT '0' NOT NULL ,
  roles varchar (255),
  permissions varchar (255),
  photo varchar (255),
  password varchar (255) NOT null ,
  confirmation_token varchar (255) NOT NULL ,
  primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* Create details for agents */
CREATE TABLE agent_details (
  id bigint(11) NOT NULL AUTO_INCREMENT ,
  user_id bigint(255) NOT NULL ,
  ville varchar (255) NOT NULL ,
  societe varchar (255) NOT NULL ,
  cv varchar (255) NOT NULL ,
  apropos varchar (255) NOT NULL ,
  PRIMARY KEY (id) ,
  FOREIGN KEY (user_id) REFERENCES users(id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Create logements table */

CREATE TABLE logements (
  id bigint(11) NOT NULL AUTO_INCREMENT,
  user_id bigint(255) NOT NULL ,
  type varchar(255) NOT NULL ,
  latitude varchar(255) NOT NULL ,
  longitude varchar(255) NOT NULL ,
  ville varchar (255) NOT NULL ,
  quartier varchar (255) NOT NULL ,
  prix double  NOT NULL ,
  piece varchar (255) NOT NULL ,
  photo varchar (255) NOT NULL ,
  status tinyint (1) DEFAULT '0' NOT NULL ,
  PRIMARY KEY (id) ,
  FOREIGN KEY (user_id) REFERENCES users(id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;



/*
insert into logement
values(3,'appartement', '9.0', '2.1');
*/