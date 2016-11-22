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
  // Variables
  int iCategoryID;    //ID de la categoria (llave primaria)
  String sCategoryName; // Nombre de la categoria
  String sDescription;  // Descripcion de cada categoria
  /**
  Constructor default de la clase Categoria
  para inicializar todos las Variables
  */
  public Categoria(int categoria, String nombre, String descripcion){

    iCategoryID = categoria;
    sCategoryName = nombre;
    sDescription = descripcion;
  }
  /**
  Método para asignar el ID de la categoria
  */
  public void setCategoryID(int id){

    iCategoryID = id;
  }
  /**
  Método para asignar el nombre a una categoria
  */
  public void setCategoryName(String nombre){
    sCategoryName = nombre;
  }
  /**
  Método para asignar la descripcion de cada categoria
  */
  public void setCatDescription(String des){
    sDescription = des;
  }
  /**
  Método para obtener el ID de la categoria
  */
  public int getCategoryID(){
    return iCategoryID;
  }
  /**
  Método para obtener el nombre de la categoria
  */
  public String getCatName(){
    return sCategoryName;
  }
  /**
  Método para obtener la descripcion de alguna categoria
  */
  public String getCatDescription(){
    return sDescription;
  }
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
