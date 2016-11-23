package entidades;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
Código de la clase Categoria
(Catalogo)
*/
public class Categoria{
  
  public void agregarCategoria(int categoriaID, int nombre, int descrip, Connection con) {
    PreparedStatement psStatement;
    try {
      String query = "INSERT INTO Categoria (CategoriaID, NombreCat, Descripcion) VALUES (?,?,?)";
      psStatement = con.prepareStatement(query);
      psStatement.setInt(1, categoriaID);
      psStatement.setInt(2, nombre);
      psStatement.setInt(3, descrip);
      psStatement.execute();
    } catch(SQLException e){ };
  }
}
