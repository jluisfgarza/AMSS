package entidades;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
Código para la clase Producto
*/
public class Producto{
  PreparedStatement psStatement;

  public void agregarProducto(int productoID, String nombre, int discount, int unitsOrder, int unitsStock, int unitPrice, int quantityPerUnit, String desc, Connection con) {
    try {
      String query = "INSERT INTO OrderDetail (ID, NombreProducto, Descuento, UnidadesEnOrden, UnidadesEnAlmacen, PrecioPorUnidad, CantidadPorUnidad, DescripcionProducto) VALUES (?,?,?,?,?,?,?,?)";
      psStatement = con.prepareStatement(query);
      psStatement.setInt(1, productoID);
      psStatement.setString(2, nombre);
      psStatement.setInt(3, discount);
      psStatement.setInt(4, unitsOrder);
      psStatement.setInt(5, unitsStock);
      psStatement.setInt(6, unitPrice);
      psStatement.setInt(7, quantityPerUnit);
      psStatement.setString(8, desc);
      psStatement.execute();
    }catch(SQLException e){ };
  }

  public void borraProducto(int id, Connection con) {
    try {
      String query = "UPDATE Producto SET UnidadesEnAlmacen = UnidadesEnAlmacen - 1 WHERE UnidadesEnAlmacen > 1 and ID = " + id;
      psStatement = con.prepareStatement(query);
      psStatement.execute();

    }catch(SQLException e){ };
  }

}
