package interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import java.util.ArrayList;

import controles.ControlProducto;

//Utilizando urlPatterns permite agregar parametros a la anotacion
@WebServlet(urlPatterns = "/Stock++",
  initParams = {
     @WebInitParam(name = "class", value = "interfaces.InterfazCompra")
  }
)
public class InterfazAgrega extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  HttpSession sesion;
  PrintWriter out;
  Connection con;
  ArrayList<String> listaprod;

   ///Redirige cualquier GET recibido a POST
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doPost(request,response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      thisRequest = request;
      thisResponse = response;
      String operacion;
      ///La conexion se establece en ContextListener
      con = (Connection) getServletContext().getAttribute("DBConnection");
      ControlProducto cProd = new ControlProducto();
      listaprod = cProd.verProd(con);

      ///Solo permitir acceso si existe una sesion
      sesion = thisRequest.getSession(false);
      if (sesion == null) ///El usuario no esta logeado
         thisResponse.sendRedirect("index.html");

      operacion = thisRequest.getParameter("operacion");
      if (operacion == null ) ///Es la primera llamada a ExtraerEfectivo (viene de menu.html, con usuario exitosamente logeado)
         solicitarCompra();
       else if(operacion.equals("altastock"))
          altastock();
      else if (operacion.equals("Menu")){
         RequestDispatcher rd = request.getRequestDispatcher("Menu");
         rd.forward(request, response);
      }
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
         "<title>Tienda en Linea</title> \n" +
         "<h1>Tienda en Linea</h1> \n" +
         "<h2>Lista de Productos</h2>\n"+
         "<p>Introduce el ID del producto a agregar a inventarios y la cantidad</p>\n"

      );
   }
  ///Es importante observar que todas las formas (form) definen la accion POST para
  ///que el metodo doPost sea el que se ejecuta en todos los casos.
   private void solicitarCompra() throws ServletException, IOException {
      encabezadoHTML(); ///Preparar encabezado de la pagina Web
      out.println(
         "<form method=POST action=Stock++> \n" +
         listaprod + "</br></br>" +
             "<input type=hidden name=operacion value=altastock> \n" +
             "<input type=text name=prodid size=15 autofocus placeholder=\"ID del Producto: \"></p> \n" +
             "<input type=text name=prodcant size=15 autofocus placeholder=\"Cantidad: \"></p> \n" +
            "<input type=submit value=Enviar name=B1></p> \n" +
         "</form> \n"
      );

      out.println(
         "<form method=POST action=Stock++> \n" +
            "<input type=hidden name=operacion value=Menu> \n" +
            "<input type=submit value=Cancelar name=B2></p> \n" +
            "</form> \n" +
        "</body>" +
        "</html>"
      );
   }

   private void altastock() throws ServletException, IOException {
      boolean resultado;
      String errorMsg = null;
      String id = thisRequest.getParameter("prodid");
      String cant = thisRequest.getParameter("prodcant");

      if (id.length() > 0 && cant.length() > 0 ) {
        id = id.trim();
        cant = cant.trim();

          ControlProducto ce = new ControlProducto();
          int intcant = Integer.parseInt(cant);
          resultado = ce.masunostock(id, intcant, con);

          if (resultado == true) { ///Compra exitosa
             encabezadoHTML();///Preparar encabezado de la pagina Web
             out.println(
                "Stock agregado exitosamente.</p> \n" +
                "<form method=POST action='Stock++'> \n" +
                   "<input type='hidden' name='operacion' value='Menu'> \n" +
                   "<input type='submit' value='Menu'></p> \n" +
                 "</form> \n" +
                "</body> \n" +
                "</html>"
             );
          }
          else {
             errorMsg = "El id del producto no esta dado de alta por un admin";
          }

      } else {
         errorMsg = "Por favor indique una id.";
      }
      if(errorMsg != null) {
        thisResponse.setContentType("text/html");
        out.println("<h3><font color=\"#e74c3c\">" + errorMsg + "</font></h3>");
        solicitarCompra();
      }
   }
}
