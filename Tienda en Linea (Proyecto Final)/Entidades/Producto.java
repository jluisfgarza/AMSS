package entidades;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
Código para la clase Producto
*/
public class Producto{
  PreparedStatement psStatement0, psStatement;

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

  public boolean borraProducto(String id, int cant, Connection con) {
    try {
      String current = "SELECT ID, UnidadesEnAlmacen FROM producto WHERE ID = " + id;
      psStatement0 = con.prepareStatement(current);
      ResultSet result = psStatement0.executeQuery();
      String s ="";
      while(result.next()){
        s = result.getString("UnidadesEnAlmacen");
      }
      if (Integer.parseInt(s) > 0 && Integer.parseInt(s) >= cant){
        String query = "UPDATE Producto SET UnidadesEnAlmacen = UnidadesEnAlmacen - " +cant + " WHERE UnidadesEnAlmacen >= 1 and ID = " + id;
        psStatement = con.prepareStatement(query);
        psStatement.execute();
        return true;
      }
      else
        return false;
    }catch(SQLException e){ };
    return false;
  }

  public boolean agregaProducto(String id, int cant, Connection con) {
    try {
      String current = "SELECT ID FROM producto WHERE ID = " + id;
      psStatement0 = con.prepareStatement(current);
      ResultSet result = psStatement0.executeQuery();
      if (result.next()){
        String query = "UPDATE Producto SET UnidadesEnAlmacen = UnidadesEnAlmacen + " +cant + " WHERE ID = " + id;
        psStatement = con.prepareStatement(query);
        psStatement.execute();
        return true;
      }
      else
        return false;
    }catch(SQLException e){ };
    return false;
  }

  public ArrayList<String> verProductos(Connection con) {
    try {
      String query = "SELECT ID, NombreProducto, UnidadesEnAlmacen FROM producto";
      psStatement = con.prepareStatement(query);
      ResultSet result = psStatement.executeQuery();

      ArrayList<String> array = new ArrayList<String>();
      while(result.next()){
        array.add("   ID: " +result.getString("ID") + "   Producto: " +result.getString("NombreProducto") + "  Stock: " + result.getString("UnidadesEnAlmacen"));
      }
      return array;
    }catch(SQLException e){}
     return null;
  }
}
