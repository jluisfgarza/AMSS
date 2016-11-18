package interfaces;

import java.sql.Connection;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controles.ControlExtraccion;

//Utilizando urlPatterns permite agregar parametros a la anotacion
@WebServlet(urlPatterns = "/Consulta",
  initParams = {
     @WebInitParam(name = "class", value = "interfaces.InterfazConsulta")
  }
)
public class InterfazConsulta extends HttpServlet{
  //espacio para variables para session request/response etc
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  HttpSession sesion;
  Connection connectionDB;
  PrintWriter out;

    ///Redirige cualquier GET recibido a POST
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      doPost(request,response);
   }

   public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
    thisRequest = request;
    thisResponse = response;

    connectionDB = (Connection) request.getServletContext().getAttribute("DBConnection");

    sesion = thisRequest.getSession(false);
      if (sesion == null) ///El usuario no esta logeado
         thisResponse.sendRedirect("index.html");

       consultarSaldo(); //Method: Consulta saldo
    }

    private void encabezadoHTML() throws ServletException, IOException {
      thisResponse.setContentType("text/html");
      out = thisResponse.getWriter();
      ///Preparar el encabezado de la pagina Web de respuesta
      out.println(
         "<!DOCTYPE html> \n" +
         "<html> \n" +
         "<head> \n" +
         "<meta charset=utf-8> \n" +
         "<link rel=\"stylesheet\" href=\"assets/css/style.css\">\n" +
         "<link rel=\"stylesheet\" href=\"assets/css/login.css\">\n" +
         "<link href=\"https://fonts.googleapis.com/css?family=Lato|Roboto\" rel=\"stylesheet\">\n" +
         "</head> \n" +
         "<body> \n" +
         "<title>Banco AMSS</title> \n" +
         "<h1>Cajero Electronico</h1> \n" +
         "<h2>Extraer efectivo</h2>\n"
      );

    }

    private void consultarSaldo() throws ServletException, IOException
    {
      HttpSession sesion = thisRequest.getSession(false);
      String sCuenta =  (String) sesion.getAttribute("cuenta");
      int nCuenta = Integer.parseInt(sCuenta);

      ControlExtraccion ce = new ControlExtraccion();
      float saldoActual = ce.consultaSaldo(nCuenta, connectionDB);

       if (sCuenta != null){
         encabezadoHTML();///Preparar encabezado de la pagina Web
          out.println(
           "Su saldo actual es: " +saldoActual+ "</p> \n" +
           "<form method=POST action='Menu'> \n" +
              "<input type=hidden name=operacion value=Menu> \n" +
              "<input type=submit value=Volver name=B2></p> \n" +
              "</form> \n" +
           "</body> \n" +
           "</html>"
        );
      }
    }

}
