package entidades;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//Clase Informacion Personal
public class InformacionPersonal
{
  int iInfoPersonalId;
  String sTelefono;
  String sMail;
  String sCiudad;
  String sPais;
  String sDireccion;
  String sCodigoPostal;

//Constructor
  public InformacionPersonal(int pId, String phn, String eml, String cty, String pais, String addrs, String pstCode)
  {
    iInfoPersonalId = pId;
    sTelefono = phn;
    sMail = eml;
    sCiudad = cty;
    sPais = pais;
    sDireccion = addrs;
    sCodigoPostal = pstCode;
  }

  //Metodos Sets
  public void setInfoPersonalId(int pId)
  {
    iInfoPersonalId = pId;
  }

  public void setTelefono(String phn)
  {
    sTelefono = phn;
  }

  public void setMail(String eml)
  {
    sMail = eml;
  }

  public void setCiudad(String cty)
  {
    sCiudad = cty;
  }

  public void setPais(String pais)
  {
    sPais = pais;
  }

  public void setDireccion(String addrs)
  {
    sDireccion = addrs;
  }

  public void setCodigoPostal(String codPost)
  {
    sCodigoPostal = codPost;
  }

  //Metodos Get
  public int getInformacionPersonalId()
  {
    return iInfoPersonalId;
  }

  public String getTelefono()
  {
    return sTelefono;
  }

  public String getMail()
  {
    return sMail;
  }

  public String getCiudad()
  {
    return sCiudad;
  }

  public String getPais()
  {
    return sPais;
  }

  public String getDireccion()
  {
    return sDireccion;
  }

  public String getCodigoPostal()
  {
    return sCodigoPostal;
  }

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
