package entidades;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//Clase Informacion Personal
public class InformacionPersonal
{  

  public void agregarInformacionPersonal(int pId, String tel, String mail, String ciudad, String pais, String dir, String cp, Connection con) {
    PreparedStatement psStatement;
    try {
      String query = "INSERT INTO InformacionPersonal (ID, Telefono, Correo, Ciudad, Pais, Direccion, CodigoPostal) VALUES (?,?,?,?,?,?,?)";
      psStatement = con.prepareStatement(query);
      psStatement.setInt(1, pId);
      psStatement.setString(2, tel);
      psStatement.setString(3, mail);
      psStatement.setString(4, ciudad);
      psStatement.setString(5, pais);
      psStatement.setString(6, dir);
      psStatement.setString(7, cp);
      psStatement.execute();
    }catch(SQLException e){};
  }
}
