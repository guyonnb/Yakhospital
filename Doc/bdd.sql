/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  27/05/2012 15:46:50                      */
/*==============================================================*/


drop table if exists DROIT;

drop table if exists SERVICE_COMPATIBLE;

drop table if exists PATIENT;

drop table if exists POSTE;

drop table if exists POSTE_DROIT;

drop table if exists LIT;

drop table if exists SERVICE;

drop table if exists SOIN;

drop table if exists TITULAIRE;

drop table if exists TYPE_SOIN;

/*==============================================================*/
/* Table : DROIT                                                */
/*==============================================================*/
create table DROIT
(
   ID_DROIT             int not null AUTO_INCREMENT,
   DESCRIPTION          varchar(255) not null,
   primary key (ID_DROIT)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*==============================================================*/
/* Table : SERVICE_COMPATIBLE                                       */
/*==============================================================*/
create table SERVICE_COMPATIBLE
(
   ID_SERVICE           int not null,
   SER_ID_SERVICE       int not null,
   primary key (ID_SERVICE, SER_ID_SERVICE)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*==============================================================*/
/* Table : PATIENT                                              */
/*==============================================================*/
create table PATIENT
(
   ID_PATIENT           int not null AUTO_INCREMENT,
   NOM_PATIENT          varchar(255) not null,
   PRENOM_PATIENT       varchar(255) not null,
   NSS                  char(13) not null,
   NUMERO_RUE           int,
   RUE                  varchar(255),
   CP                   char(5),
   VILLE                varchar(255),
   SEXE                 varchar(1),
   NAISSANCE            date,
   TEL                  char(10),
   TEL_URGENCE          char(10),
   NOTE                 varchar(1000),
   primary key (ID_PATIENT)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*==============================================================*/
/* Table : POSTE                                                */
/*==============================================================*/
create table POSTE
(
   ID_POSTE             int not null AUTO_INCREMENT,
   NOM_POSTE            varchar(255) not null,
   primary key (ID_POSTE)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*==============================================================*/
/* Table : POSTE_DROIT                                          */
/*==============================================================*/
create table POSTE_DROIT
(
   ID_POSTE             int not null,
   ID_DROIT             int not null,
   primary key (ID_POSTE, ID_DROIT)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*==============================================================*/
/* Table : LIT                                                */
/*==============================================================*/
create table LIT
(
   ID_LIT             int not null AUTO_INCREMENT,
   ID_SERVICE           int,
   NOM_LIT            varchar(255),
   primary key (ID_LIT)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*==============================================================*/
/* Table : SERVICE                                              */
/*==============================================================*/
create table SERVICE
(
   ID_SERVICE           int not null AUTO_INCREMENT,
   NOM_SERVICE          varchar(255) not null,
   primary key (ID_SERVICE)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*==============================================================*/
/* Table : SOIN                                                 */
/*==============================================================*/
create table SOIN
(
   ID_SOIN              int not null AUTO_INCREMENT,
   ID_PATIENT           int not null,
   ID_TYPE_SOIN         int,
   ID_LIT             int,
   ID_TITULAIRE         int,
   DATE_DEBUT_SOIN      datetime not null,
   DATE_FIN_SOIN        datetime not null,
   COMMENTAIRE          varchar(500),
   primary key (ID_SOIN)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*==============================================================*/
/* Table : TITULAIRE                                            */
/*==============================================================*/
create table TITULAIRE
(
   ID_TITULAIRE         int not null AUTO_INCREMENT,
   ID_POSTE             int,
   ID_SERVICE           int,
   NOM_TITULAIRE        varchar(255) not null,
   PRENOM_TITULAIRE     varchar(255) not null,
   NUM_PRO              numeric(8,0) not null,
   MDP                  varchar(512),
   primary key (ID_TITULAIRE)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*==============================================================*/
/* Table : TYPE_SOIN                                            */
/*==============================================================*/
create table TYPE_SOIN
(
   ID_TYPE_SOIN         int not null AUTO_INCREMENT,
   NOM_SOIN             varchar(255) not null,
   primary key (ID_TYPE_SOIN)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

alter table SERVICE_COMPATIBLE add constraint FK_COMPATIBLE_AVEC foreign key (ID_SERVICE)
      references SERVICE (ID_SERVICE) on delete cascade on update cascade;

alter table SERVICE_COMPATIBLE add constraint FK_EST_COMPATIBLE_AVEC foreign key (SER_ID_SERVICE)
      references SERVICE (ID_SERVICE) on delete cascade on update cascade;

alter table POSTE_DROIT add constraint FK_EST_ACCORDE foreign key (ID_DROIT)
      references DROIT (ID_DROIT) on delete cascade on update cascade;

alter table POSTE_DROIT add constraint FK_PEUT_EFFECTUER foreign key (ID_POSTE)
      references POSTE (ID_POSTE) on delete cascade on update cascade;

alter table LIT add constraint FK_APPARTIENT_A foreign key (ID_SERVICE)
      references SERVICE (ID_SERVICE) on delete set null on update cascade;

alter table SOIN add constraint FK_EST_EN_CHARGE foreign key (ID_TITULAIRE)
      references TITULAIRE (ID_TITULAIRE) on delete set null on update cascade;

alter table SOIN add constraint FK_EST_UN foreign key (ID_TYPE_SOIN)
      references TYPE_SOIN (ID_TYPE_SOIN) on delete no action on update cascade;

alter table SOIN add constraint FK_OCCUPE foreign key (ID_LIT)
      references LIT (ID_LIT) on delete set null on update cascade;

alter table SOIN add constraint FK_RECOIT foreign key (ID_PATIENT)
      references PATIENT (ID_PATIENT) on delete cascade on update cascade;

alter table TITULAIRE add constraint FK_EST foreign key (ID_POSTE)
      references POSTE (ID_POSTE) on delete cascade on update cascade;

alter table TITULAIRE add constraint FK_TRAVAILLE foreign key (ID_SERVICE)
      references SERVICE (ID_SERVICE) on delete cascade on update cascade;

