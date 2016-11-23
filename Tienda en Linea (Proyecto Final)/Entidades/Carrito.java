package entidades;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
Código de la clase de Carrito
*/
public class Carrito{

  public void agregarCarrito(int carritoId, int numProductos, int precioTotal, Connection con) {
    PreparedStatement psStatement;
    try {
      String query = "INSERT INTO Carrito (CarritoID, NumeroProductos, PrecioTotal) VALUES (?,?,?)";
      psStatement = con.prepareStatement(query);
      psStatement.setInt(1, carritoId);
      psStatement.setInt(2, numProductos);
      psStatement.setInt(3, precioTotal);
      psStatement.execute();
    } catch(SQLException e){ };
  }

}
