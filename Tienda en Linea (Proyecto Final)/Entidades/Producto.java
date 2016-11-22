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
  // //Variables
  // int iProductID; // ID del producto (llave primaria)
  // String sProductName;   // Nombre del Producto
  // int iSupplierId;  // ID del Proovedor (llave secundaria)
  // int iDiscount; // Descuento a aplicar (si aplica)
  // int iUnitsOnOrder; // Número de unidades pedidas
  // int iUnitsInStock; // Número de unidades en almacén
  // int iUnitPrice; // Precio de la unidad
  // int iQuantityPerUnit; // Cantidad por unidad (prodcuto)
  // String sProductDescription; // Descripcion del producto
  // /**
  // Constructor default de la clase Producto
  // */
  // public Producto(int productoID, String productoName, int proveedorID,
  // int descuento, int unidadesPorOrden, int unidadesEnStock, int precioUnidad
  // ,int cantidadPorUnidad, String descripcion){
  //
  //   iProductID = productoID;
  //   sProductName = productoName;
  //   iSupplierId = proveedorID;
  //   iDiscount = descuento;
  //   iUnitsOnOrder = unidadesPorOrden;
  //   iUnitsInStock = unidadesEnStock;
  //   iQuantityPerUnit = cantidadPorUnidad;
  //   sProductDescription = descripcion;
  //   iUnitPrice = precioUnidad;
  // }
  // /**
  //  Método para asignar el ID del producto
  // */
  // public void setProductID(int id){
  //   iProductID = id;
  // }
  // /**
  // Método para asignar el nombre del producto
  // */
  // public void setProductName(String nombre){
  //   sProductName = nombre;
  // }
  // /**
  // Método para asignar el ID del Proovedor
  // */
  // public void setSupplierID(int id){
  //   iSupplierId = id;
  // }
  // /**
  // Método para asignar el descuento
  // */
  // public void setDiscount(int ds){
  //   iDiscount = ds;
  // }
  // /**
  // Método para asignar el numero de unidades pedidas
  // */
  // public void setUnitsOnOrder(int uni){
  //   iUnitsOnOrder = uni;
  // }
  // /**
  // Método para asignar el numero de unidades que existen en almacen
  // */
  // public void setUnitsInStock(int uni){
  //   iUnitsInStock = uni;
  // }
  // /**
  // Método para asignar el numero de cantidad que hay por unidad.
  // */
  // public void setQuantityPerUnit(int uni){
  //   iQuantityPerUnit = uni;
  // }
  // /**
  // Método para asignar la descripcion del producto
  // */
  // public void setPDescription(String des){
  //   sProductDescription = des;
  // }
  // /**
  // Método para asignar el precio de cada producto
  // */
  // public void setProductPrice(int pr){
  //   iUnitPrice = pr;
  // }
  // /**
  // Método para obtener el nombre del producto
  // */
  // public String getProductName(){
  //   return sProductName;
  // }
  // /**
  // Método para obtener el ID del proveedor
  // */
  // public int getSupplierID(){
  //   return iSupplierId;
  // }
  // /**
  // Método para obtener el ID del producto
  // */
  // public int getProductID(){
  //   return iProductID;
  // }
  // /**
  // Método para obtener el Descuento a aplicar
  // */
  // public int getDiscount(){
  //   return iDiscount;
  // }
  // /**
  // Método para obtener la cantidad de unidades en orden
  // */
  // public int getUnitsOnOrder(){
  //   return iUnitsOnOrder;
  // }
  // /**
  // Método para obtener el numero de unidades en almacen
  // */
  // public int getUnitsInStock(){
  //   return  iUnitsInStock;
  // }
  // /**
  // Método para obtener el numero de cantidad por unidad
  // */
  // public int getQuantityPerUnit(){
  //   return iQuantityPerUnit;
  // }
  // /**
  // Método para obtener la descripcion del producto
  // */
  // public String getProductDescription(){
  //   return sProductDescription;
  // }
  // /**
  // Método para obtener el precio por producto
  // */
  // public int getProductPrice(){
  //   return iUnitPrice;
  // }

  public void agregarProducto(int productoID, String nombre, int discount, int unitsOrder, int unitsStock, int unitPrice, int quantityPerUnit, String desc, Connection con) {
    PreparedStatement psStatement;
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
}
