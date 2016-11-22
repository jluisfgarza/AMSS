package entidades;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
Código para la Clase OrderDetail (detalle de la orden)
*/
public class OrderDetail{
  // Variables
  int iOrderDetailID; // ID de la orden (llave primaria)
  int iProductID; // ID del producto
  int iUnitPrice; // Precio por unidad
  int iQuantity;  // Cantidad total de productos
  int iOrderNumber; // Número de orden
  int iDiscount; // Descuento a aplicar en la orden
  /**
  Constructor default de la clase OrderDetail
  */
  public OrderDetail(int ordenid, int productoid, int precio,
  int cantidad, int numOrden, int descuento){

    iOrderDetailID = ordenid;
    iProductID = productoid;
    iUnitPrice = precio;
    iQuantity = cantidad;
    iOrderNumber = numOrden;
    iDiscount = descuento;
  }
  /**
  Método para asignrar el ID de la orden
  */
  public void setOrderID(int id) {
    iOrderDetailID = id;
  }/**
  Método para asignar el ID del producto
  */
  public void setProductID(int id) {
    iProductID =id;
  }
  /**
  Método para asignar el numero de precio por unidad
  */
  public void setUnitPrice(int price) {
    iUnitPrice = price;
  }
  /**
  Método para asignar la cantidad de productos
  */
  public void setQuantity(int sq){
    iQuantity = sq;
  }
  /**
  Método para asignar el numero de ordenes
  */
  public void setOrderNumber(int numero){
    iOrderNumber = numero;
  }
  /**
  Método para asignar el descuento (si aplica)
  */
  public void setDiscount(int ds){
    iDiscount=ds;
  }

  public int getOrderDetailID() {
    return iOrderDetailID;
  }
  /**
  Método para asignar el ID del producto
  */
  public int getProductID(){
    return iProductID;
  }
  /**
  Método para asignar el precio de cada unidad (producto)
  */
  public int getUnitPrice(){
    return iUnitPrice;
  }
  /**
  Método para asignar la cantidad de productos en la orden
  */
  public int getQuantity(){
    return iQuantity;
  }
  /**
  Método para asignar el número de orden
  */
  public int getOrderNumber(){
    return iOrderNumber;
  }
  /**
  Método para asignar el descuento (si aplica)
  */
  public int getDiscount(){
    return iDiscount;
  }

  public void agregarOrderDetail(int orderDetID, int productID, int unitPrice, int quantity, int orderNum, int discount, Connection con) {
    PreparedStatement psStatement;
    try {
      String query = "INSERT INTO OrderDetail (ID, ProductoID, Precio, Cantidad, NumeroDeOrden, Descuento) VALUES (?,?,?,?,?,?)";
      psStatement = con.prepareStatement(query);
      psStatement.setInt(1, orderDetID);
      psStatement.setInt(2, productID);
      psStatement.setInt(3, unitPrice);
      psStatement.setInt(4, quantity);
      psStatement.setInt(5, orderNum);
      psStatement.setInt(6, discount);
      psStatement.execute();
    }catch(SQLException e){ };
  }
}
