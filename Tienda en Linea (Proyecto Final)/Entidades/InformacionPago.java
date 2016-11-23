package entidades;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Informacion de Pago
public class InformacionPago
{

  public void agregarInformacionPago(int infPagoId, String fechaPago, String dir, String fechaExpir, int pin, int numTarjeta, Connection con) {
    PreparedStatement psStatement;
    try {
      String query = "INSERT INTO InformacionPago (InfoPagoID, FechaPago, Direccion, ExpiracionTjt, PintTarjeta, NumeroTarjeta) VALUES (?,?,?,?,?,?)";
      psStatement = con.prepareStatement(query);
      psStatement.setInt(1, infPagoId);
      psStatement.setString(2, fechaPago);
      psStatement.setString(3, dir);
      psStatement.setString(4, fechaExpir);
      psStatement.setInt(5, pin);
      psStatement.setInt(6, numTarjeta);
      psStatement.execute();
    }catch(SQLException e){ };
  }
}
