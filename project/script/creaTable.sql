#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS projetDB ;
USE projetDB;

#------------------------------------------------------------
# Table: Product
#------------------------------------------------------------

CREATE TABLE Product(
        Id    int (11) Auto_increment  NOT NULL ,
        Name  Varchar (25) ,
        Price Int ,
        PRIMARY KEY (Id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Ingredient
#------------------------------------------------------------

CREATE TABLE Ingredient(
        Id   int (11) Auto_increment  NOT NULL ,
        Name Varchar (25) ,
        PRIMARY KEY (Id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Command
#------------------------------------------------------------

CREATE TABLE Command(
        Id             int (11) Auto_increment  NOT NULL ,
        TimeOrderer     TimeStamp ,
        TimeDeliver    TimeStamp ,
        Id_Product     Int ,
        Id_Size        Int ,
        Id_DeliveryMan Int ,
        Id_Customer    Int ,
	Id_Vehicle     Int ,
        PRIMARY KEY (Id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: DeliveryMan
#------------------------------------------------------------

CREATE TABLE DeliveryMan(
        Id   int (11) Auto_increment  NOT NULL ,
        Name Varchar (25) ,
        PRIMARY KEY (Id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: VehicleType
#------------------------------------------------------------

CREATE TABLE VehicleType(
        Id   int (11) Auto_increment  NOT NULL ,
        Name Varchar (25) ,
        PRIMARY KEY (Id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Vehicle
#------------------------------------------------------------

CREATE TABLE Vehicle(
        Id             int (11) Auto_increment  NOT NULL ,
        Name           Varchar (25) ,
        Id_VehicleType Int ,
        PRIMARY KEY (Id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Size
#------------------------------------------------------------

CREATE TABLE Size(
        Id          int (11) Auto_increment  NOT NULL ,
        Name        Varchar (25) ,
        Coefficient Double ,
        PRIMARY KEY (Id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Customer
#------------------------------------------------------------

CREATE TABLE Customer(
        Id        int (11) Auto_increment  NOT NULL ,
        Lastname  Varchar (25) ,
        Firstname Varchar (25) ,
        Address   Varchar (100) ,
        Solde     Numeric ,
        PRIMARY KEY (Id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Constitute
#------------------------------------------------------------

CREATE TABLE Constitute(
        Id_Ingredient Int NOT NULL ,
        Id_Product Int NOT NULL ,
        PRIMARY KEY (Id_Ingredient ,Id_Product )
)ENGINE=InnoDB;
CREATE DATABASE IF NOT EXISTS projetDB ;
USE projetDB;

#------------------------------------------------------------
# Table: CONSTRAINTS
#------------------------------------------------------------

ALTER TABLE Command ADD CONSTRAINT FK_Command_Id_Product FOREIGN KEY (Id_Product) REFERENCES Product(Id);
ALTER TABLE Command ADD CONSTRAINT FK_Command_Id_Size FOREIGN KEY (Id_Size) REFERENCES Size(Id);
ALTER TABLE Command ADD CONSTRAINT FK_Command_Id_DeliveryMan FOREIGN KEY (Id_DeliveryMan) REFERENCES DeliveryMan(Id);
ALTER TABLE Command ADD CONSTRAINT FK_Command_Id_Customer FOREIGN KEY (Id_Customer) REFERENCES Customer(Id);
ALTER TABLE Command ADD CONSTRAINT FK_Command_Id_Vehicle FOREIGN KEY (Id_Vehicle) REFERENCES Vehicle(Id);
ALTER TABLE Vehicle ADD CONSTRAINT FK_Vehicle_Id_VehicleType FOREIGN KEY (Id_VehicleType) REFERENCES VehicleType(Id);
ALTER TABLE Constitute ADD CONSTRAINT FK_Constitute_Id FOREIGN KEY (Id_Ingredient) REFERENCES Ingredient(Id);
ALTER TABLE Constitute ADD CONSTRAINT FK_Constitute_Id_Product FOREIGN KEY (Id_Product) REFERENCES Product(Id);
