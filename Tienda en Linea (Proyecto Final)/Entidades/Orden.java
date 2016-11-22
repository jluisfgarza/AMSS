import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//Orden
public class Orden
{
  //Atributos
  int iOrdenId;
  int iClienteId;
  int iNumOrden;
  String sFechaOrden;
  String sFechaRequerida;
  String sFechaEnvio;
  String sMetodoEnvio;

  //Constructor
  public Orden(int ordenId, int clienteId, int numOrden, String fechaOrden, String fechaReq, String fechaEnvio, String metodo)
  {
    iOrdenId = ordenId;
    iClienteId = clienteId;
    iNumOrden = numOrden;
    sFechaOrden = fechaOrden;
    sFechaRequerida = fechaReq;
    sFechaEnvio = fechaEnvio;
    sMetodoEnvio = metodo;
  }

  //Metodos Set
  public void setOrdenId(int ordenId)
  {
    iOrdenId = ordenId;
  }

  public void setClienteId(int ordenId, int clienteId, Connection con)
  {
    iClienteId = clienteId;
  }

  public void setNumeroOrden(int ordenId, int numOrden, Connection con)
  {
    iNumOrden = numOrden;
  }

  public void setFechaOrden(int ordenId, String fechaOrden, Connection con)
  {
    sFechaOrden = fechaOrden;
  }

  public void setFechaRequerida(int ordenId, String fechaReq, Connection con)
  {
    sFechaRequerida = fechaReq;
  }

  public void setFechaEnvio(int ordenId, String fechaEnvio, Connection con)
  {
    sFechaEnvio = fechaEnvio;
  }

  public void setMetodoEnvio(int ordenId, String metodo, Connection con)
  {
    sMetodoEnvio = metodo;
  }

  //Metodo Get
  public int getOrdenId()
  {
    return iOrdenId;
  }

  public int getClienteId()
  {
    return iClienteId;
  }

  public int getNumeroOrden()
  {
    return iNumOrden;
  }

  public String getFechaOrden()
  {
    return sFechaOrden;
  }

  public String getFechaRequerida()
  {
    return sFechaRequerida;
  }

  public String getFechaEnvio()
  {
    return sFechaEnvio;
  }

  public String getMetodoEnvio()
  {
    return sMetodoEnvio;
  }

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
