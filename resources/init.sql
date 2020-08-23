/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  ever
 * Created: Aug 23, 2020
 */
--DROPS THE TABLE..
DROP TABLE IF EXISTS roperos;

-- CREATE THE Table roperos;
CREATE TABLE roperos (
	id serial NOT NULL,
	marca varchar NOT NULL,
	tipoMadera varchar NOT NULL,
        descripcion varchar NOT NULL,
        dimension varchar NOT NULL,
	precio numeric(12,2) NOT NULL,
	CONSTRAINT roperos_pkey PRIMARY KEY (id)
);


--INSERT SOME Dummy data.
INSERT into roperos (marca,tipoMadera,descripcion,dimension,precio) values
('BR Roperos','madera prensada','Ropero para niños','1.50m x 2.00m  x 0.5 m',400),
('BR Roperos','madera prensada','Ropero para adultos','2.50m x 2.00m  x 0.7 m',800),
('CZU Roperos','Eucalipto','Ropero de Eucalipto modelo 1','2.50m x 2.00m  x 0.7 m',1200);

