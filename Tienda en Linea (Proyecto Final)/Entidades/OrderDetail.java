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
