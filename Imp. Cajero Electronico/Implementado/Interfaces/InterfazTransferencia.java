package interfaces;

import java.sql.Connection;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controles.ControlTransferencia;

@WebServlet(urlPatterns = "/Transferencia",
  initParams = {
     @WebInitParam(name = "class", value = "interfaces.InterfazTransferencia")
  }
)
public class InterfazTransferencia extends HttpServlet {
   //espacio para variables para session request/response etc
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  HttpSession sesion;
  Connection connectionDB;

   ///Redirige cualquier GET recibido a POST
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      doPost(request,response);
   }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        thisRequest = request;
        thisResponse = response;
        String operacion;

        connectionDB = (Connection) request.getServletContext().getAttribute("DBConnection");

        sesion = thisRequest.getSession(false);
         if (sesion == null) ///El usuario no esta logeado
          thisResponse.sendRedirect("index.html");

        operacion = thisRequest.getParameter("operacion");
      if (operacion == null ) ///Es la primera llamada a ExtraerEfectivo (viene de menu.html, con usuario exitosamente logeado)
         solicitarNumeroCuentaTarget();
      else if(operacion.equals("transferir"))
         TransferirDinero();
      else if (operacion.equals("Menu")){
         RequestDispatcher reqDispatcher = request.getRequestDispatcher("Menu");
         reqDispatcher.forward(request, response);
       }
   }

   private void encabezadoHTML() throws ServletException, IOException
   {
      thisResponse.setContentType("text/html");
      out = thisResponse.getWriter();

      out.println("<!DOCTYPE html> \n" +
         "<html> \n" +
         "<head> \n" +
         "<meta charset=\"utf-8\"> \n" +
         "<link rel=\"stylesheet\" href=\"assets/css/style.css\">\n" +
         "<link rel=\"stylesheet\" href=\"assets/css/login.css\">\n" +
         "<link href=\"https://fonts.googleapis.com/css?family=Lato|Roboto\" rel=\"stylesheet\">\n" +
         "</head> \n" +
         "<body> \n" +
         "<title>Banco AMSS</title> \n" +
         "<h1>Cajero Electronico</h1> \n" +
         "<h2>Extraer efectivo</h2>\n"+
         "Introduzca el numero de cuenta a la que desea realizar la transferencia.</p>");
   }

  private void solicitarNumeroCuentaTarget() throws ServletException, IOException
  {
      encabezadoHTML(); ///Preparar encabezado de la pagina Web
      out.println(
         "<form method=POST action=Transferencia> \n" +
            "<input type=hidden name=operacion value=transferir> \n" +
            "No. cuenta destino: <input type=text name=cuentaDestino size=15 autofocus></p> \n" +
            "Cantidad a transferir: <input type=text name=Cantidad size=15 autofocus></p> \n" +
            "<input type=submit value=Transferir name=B1></p> \n" +
         "</form> \n"
      );
      out.println(
         "<form method=POST action=Extraer> \n" +
            "<input type=hidden name=operacion value='Menu'> \n" +
            "<input type=submit value=Cancelar name=B2></p> \n" +
            "</form> \n" +
        "</body>" +
        "</html>"
      );
  }

 private void TransferirDinero() throws ServletException, IOException
 {
  int ncuentaSource, ncuentaDest;
  boolean result;
  String sCuentaSource;
  String sCantidad = thisRequest.getParameter("Cantidad");
  String sCuentaDest = thisRequest.getParameter("cuentaDestino");

  float cantidad = Float.valueOf(sCantidad.trim()).floatValue();
  HttpSession sesionUsuarioTranferencia = thisRequest.getSession(false);
  sCuentaSource = (String) sesionUsuarioTranferencia.getAttribute("cuenta");
  ncuentaSource = Integer.parseInt(sCuentaSource);
  ncuentaDest = Integer.parseInt(sCuentaDest);

  ControlTransferencia CT = new ControlTransferencia();
  result = CT.TransferirDinero(ncuentaSource, ncuentaDest, cantidad, connectionDB);
  if (result == true && ncuentaSource != ncuentaDest)
  {
    float saldoCuentaSource = CT.consultaSaldo(ncuentaSource, connectionDB);

    thisResponse.setContentType("text/html");
      out = thisResponse.getWriter();

      out.println("<!DOCTYPE html> \n" +
         "<html> \n" +
         "<head> \n" +
         "<meta charset=\"utf-8\"> \n" +
         "<link rel=\"stylesheet\" href=\"assets/css/style.css\">\n" +
         "<link rel=\"stylesheet\" href=\"assets/css/login.css\">\n" +
         "<link href=\"https://fonts.googleapis.com/css?family=Lato|Roboto\" rel=\"stylesheet\">\n" +
         "</head> \n" +
         "<body> \n" +
         "<title>Banco AMSS</title> \n" +
         "<h1>Cajero Electronico</h1> \n" +
         "<h2>Extraer efectivo</h2>\n"+
         "Operacion exitosa.</p> \n" +
        "Su saldo actual despues de la transferencia es: " + saldoCuentaSource +".</p> \n" +
        "<form method=POST action='Transferencia'> \n" +
        "<input type='hidden' name='operacion' value='Menu'> \n" +
        "<input type='submit' value='Menu'></p> \n" +
        "</form> \n" +
        "</body> \n" +
        "</html>"
        );
  }else{

    thisResponse.setContentType("text/html");
      out = thisResponse.getWriter();

      out.println("<!DOCTYPE html> \n" +
         "<html> \n" +
         "<head> \n" +
         "<meta charset=\"utf-8\"> \n" +
         "<link rel=\"stylesheet\" href=\"assets/css/style.css\">\n" +
         "<link rel=\"stylesheet\" href=\"assets/css/login.css\">\n" +
         "<link href=\"https://fonts.googleapis.com/css?family=Lato|Roboto\" rel=\"stylesheet\">\n" +
         "</head> \n" +
         "<body> \n" +
         "<title>Banco AMSS</title> \n" +
         "<h1>Cajero Electronico</h1> \n" +
         "<h2>Extraer efectivo</h2>\n"+
         "<p>Revise que la cantidad no exceda su saldo, o esa mayor a lo que puede extraer en una sesion. <br> O la cuenta a transferir no existe o es su misma cuenta, revise sus datos...</p> \n" +
         "<form> \n" +
         "<input type='hidden' name='operacion' value='Menu'> \n" +
         "<input type='submit' value='Menu'></p> \n" +
         "</form> \n" +
         "</body> \n" +
        "</html>"
        );

  }

 }

}
