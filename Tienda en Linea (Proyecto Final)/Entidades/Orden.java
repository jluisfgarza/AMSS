package entidades;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//Orden
public class Orden
{
  
  public void agregarOrden(int ordenId, int clienteId, int numOrden, String fechaOrden, String fechaReq, String fechaEnvio, String metodo, Connection con) {
    PreparedStatement psStatement;
    try {
      String query = "INSERT INTO Orden (ID, UsuarioID, NumOrden, FechaOrden, sFechaRequerida, FechaEnvio, MetodoEnvio) VALUES (?,?,?,?,?,?,?)";
      psStatement = con.prepareStatement(query);
      psStatement.setInt(1, ordenId);
      psStatement.setInt(2, clienteId);
      psStatement.setInt(3, numOrden);
      psStatement.setString(4, fechaOrden);
      psStatement.setString(5, fechaReq);
      psStatement.setString(6, fechaEnvio);
      psStatement.setString(7, metodo);
      psStatement.execute();
    }catch(SQLException e){};
  }
}
