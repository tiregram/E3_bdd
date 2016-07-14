USE projetDB;

INSERT INTO Customer(Lastname, Firstname, Address, Solde)
VALUES('Margerit', 'Arthur', '42 Rue Open Source', 30);

INSERT INTO Customer(Lastname, Firstname, Address, Solde)
VALUES('Vigier', 'Thibault', '10 Boulevard Orleans', 10);

INSERT INTO Customer(Lastname, Firstname, Address, Solde)
VALUES('Gouriou', 'Stephen', '3 Avenue de Taillebourg', 30);

# Sizes

INSERT INTO Size(Name, Coefficient)
VALUES('Naine', 0.66);

INSERT INTO Size(Name, Coefficient)
VALUES('Humaine', 1);

INSERT INTO Size(Name, Coefficient)
VALUES('Ogresse', 1.33);

# Ingredients

INSERT INTO Ingredient(Name)
VALUES('Tomate');

INSERT INTO Ingredient(Name)
VALUES('Mozarella');

INSERT INTO Ingredient(Name)
VALUES('Champignons');

INSERT INTO Ingredient(Name)
VALUES('Jambon');

INSERT INTO Ingredient(Name)
VALUES('Ananas');

# Produits

INSERT INTO Product(Name, Price)
VALUES('MargeritA', 10); # tomate + moza 

INSERT INTO Product(Name, Price)
VALUES('Regina', 12); # tomate + moza + jamon + champis

INSERT INTO Product(Name, Price)
VALUES('Hawaiienne', 15); # Tomate Moza Jambon Ananas

# Consitute

INSERT INTO Constitute
VALUES(1,1);

INSERT INTO Constitute
VALUES(1,2);

INSERT INTO Constitute
VALUES(1,3);

INSERT INTO Constitute
VALUES(2,1);

INSERT INTO Constitute
VALUES(2,2);

INSERT INTO Constitute
VALUES(2,3);

INSERT INTO Constitute
VALUES(3,2);

INSERT INTO Constitute
VALUES(4,2);

INSERT INTO Constitute
VALUES(4,3);

INSERT INTO Constitute
VALUES(5,3);

#Delivery Man

INSERT INTO DeliveryMan(Name)
VALUES('Mario');

INSERT INTO DeliveryMan(Name)
VALUES('Luigi');

INSERT INTO DeliveryMan(Name)
VALUES('Browser');

#VehiculeType

INSERT INTO VehicleType(Name)
VALUES('Voiture');

INSERT INTO VehicleType(Name)
VALUES('Scooter');

INSERT INTO VehicleType(Name)
VALUES('Tuk Tuk');

#Vehicule

INSERT INTO Vehicle
VALUES(1,'Peugeot 208',1);

INSERT INTO Vehicle
VALUES(2,'Tesla S', 1);

INSERT INTO Vehicle
VALUES(3,'Vespa', 2);

INSERT INTO Vehicle
VALUES(4,'Mazaki', 3);

# command

INSERT INTO Command (TimeOrderer, TimeDeliver, Id_Customer, Id_DeliveryMan, Id_Product, Id_Size, Id_Vehicle)
VALUES('2016-04-20 23:15:00','2016-04-20 23:55:00', 1,2, 1,1,1 );

INSERT INTO Command (TimeOrderer, TimeDeliver, Id_Customer, Id_DeliveryMan, Id_Product, Id_Size, Id_Vehicle)
VALUES('2016-01-19 19:15:00','2016-01-19 20:15:00', 2,3, 2,2,4 );

INSERT INTO Command (TimeOrderer, TimeDeliver, Id_Customer, Id_DeliveryMan, Id_Product, Id_Size, Id_Vehicle)
VALUES('2016-03-01 10:30:00','2016-03-01 10:35:00', 3,1, 1,3,4 );

INSERT INTO Command (TimeOrderer, TimeDeliver, Id_Customer, Id_DeliveryMan, Id_Product, Id_Size, Id_Vehicle)
VALUES('2016-06-24 18:30:00','2016-06-24 19:50:00', 3,1, 2,1,3 );

INSERT INTO Command (TimeOrderer, TimeDeliver, Id_Customer, Id_DeliveryMan, Id_Product, Id_Size, Id_Vehicle)
VALUES('2016-08-24 18:30:00','2016-08-24 18:31:00', 1,2, 1,2,1 );

INSERT INTO Command (TimeOrderer, TimeDeliver, Id_Customer, Id_DeliveryMan, Id_Product, Id_Size, Id_Vehicle)
VALUES('2016-08-24 18:30:00','2016-08-24 18:55:00', 1,2, 3,2,4 );




