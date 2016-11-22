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
  // Variables
  int iNumeroProductos; // Variable de el numero de productos en el carrito
  int iCartID;          // ID (llave primaria) de el carrito
  int iPrecioTotal;     // Precio total de los productos dentro del carrito

  /**
  Constructor default de la clase carrito
  */
  public Carrito(int cartID, int numeroProductos, int precioTotal){

    iNumeroProductos = numeroProductos;
    iCartID = cartID;
    iPrecioTotal = precioTotal;
  }
  /**
  Método para asignar el ID del carrito (llave priamria)
  */
  public void setCartID(int cartid){

    iCartID = cartid;
  }
  /**
  Método para asignar el numero de productos que van dentro del carrito
  */
  public void setNumeroProductos(int numprod){

    iNumeroProductos = numprod;
  }
  /**
  Método para asignar el precio total del carrito con todos sus productos.
  */
  public void setPrecioTotal(int precio){
    iPrecioTotal = precio;
  }
  /**
  Método para obtener el ID del carrito
  */
  public int getCartID(){
    return iCartID;
  }
  /**
  Método para obtener el numero de productos dentro del carrito
  */
  public int getNumeroProductos(){
    return iNumeroProductos;
  }
  /**
  Método para obtener el precio total de los productos dentro del carrito
  */
  public int getPrecioTotal(){
    return iPrecioTotal;
  }
  /**
  Metodo para agregar una nueva entidad de Carrito a la base de datos
  */
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
