package entidades;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Informacion de Pago
public class InformacionPago
{
  //Atributos
  int iInfoPagoId;
  String sFechaPago;
  String sDireccion;
  String sFechaExpiracionTarjeta;
  int iPinTarjetaCredito;
  int iNumTarjetaCredito;

  //Constructor
  public InformacionPago(int ipId, String fechaPago, int tarCreId, String dir, String fechaExpiracion, int pinTarjeta, int numTarjeta)
  {
    iInfoPagoId = ipId;
    sFechaPago = fechaPago;
    sDireccion = dir;
    sFechaExpiracionTarjeta = fechaExpiracion;
    iPinTarjetaCredito = pinTarjeta;
    iNumTarjetaCredito = numTarjeta;
  }

  //Metodos Set
  public void setInfoPagoId(int ipId)
  {
    iInfoPagoId = ipId;
  }

  public void setFechaPago(String fechaPago)
  {
    sFechaPago = fechaPago;
  }

  public void setDireccion(String dir)
  {
    sDireccion = dir;
  }

  public void setFechaExpiracionTarjeta(String fechaExpir)
  {
    sFechaExpiracionTarjeta = fechaExpir;
  }

  public void setPINTarjetaCredito(int pinTarjeta)
  {
    iPinTarjetaCredito = pinTarjeta;
  }

  public void setNumTarjetaCredito(int numTarjeta)
  {
    iNumTarjetaCredito = numTarjeta;
  }

  //Metodos Get
  public int getInformacionPagoId()
  {
    return iInfoPagoId;
  }

  public String getFechaPago()
  {
    return sFechaPago;
  }

  public String getDireccion()
  {
    return sDireccion;
  }

  public String getFechaExpiracionTarjeta()
  {
    return sFechaExpiracionTarjeta;
  }

  public int getPINTarjetaCredito()
  {
    return iPinTarjetaCredito;
  }

  public int getNumTarjetaCredito()
  {
    return iNumTarjetaCredito;
  }

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
