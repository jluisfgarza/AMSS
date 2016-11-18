set data format ymd

create database cajero
  use cajero

  CREATE TABLE cliente(
    usuario VARCHAR(20) NOT NULL,
    password VARCHAR(15) NOT NULL,
    cuenta int(10) NOT NULL,
    nombre VARCHAR(40) NOT NULL,
    PRIMARY KEY (usuario)
  )

  CREATE TABLE cuenta (
    idcuenta int(10) NOT NULL,
    saldo float(15,2) NOT NULL,
    PRIMARY KEY (idcuenta),
    FOREIGN KEY (idcuenta) REFERENCES cliente (cuenta)
  )
