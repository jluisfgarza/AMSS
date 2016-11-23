package interfaces;

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

//Utilizando urlPatterns en lugar de urlPattern permite agregar mas parametros a la anotacion
@WebServlet(urlPatterns = "/Menu",
  initParams = {
     @WebInitParam(name = "class", value = "interfaces.MenuServlet")
  }
)
public class MenuServlet extends HttpServlet {

   //Redirige cualquier GET recibido a POST
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doPost(request,response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      PrintWriter out = response.getWriter();

      //Solo permitir acceso si existe una sesion
        HttpSession sesion = request.getSession(false);
      if (sesion == null) { ///El usuario no esta logeado
         response.setContentType("text/html");
		     out.println("<font color=red>Favor de proporcionar primero usuario y clave.</font>");
         RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
			   rd.include(request, response); ///include() permite que el mensaje anterior se incluya en la pagina Web
      } else {
         //Mostrar el menu de opciones
         response.setContentType("text/html");
         out.println(
            "<!DOCTYPE html> \n" +
            "<html> \n" +
            "<head> \n" +
            "<meta charset=utf-8> \n" +
            "<link rel=\"stylesheet\" href=\"assets/css/style.css\">\n" +
            "<link href=\"https://fonts.googleapis.com/css?family=Lato|Roboto\" rel=\"stylesheet\">\n" +
            "</head> \n" +
            "<body> \n" +
            "<title>Banco AMSS</title> \n" +
            "<h1>Tienda en Linea</h1> \n" +
            "<h2>Indica la operacion que deseas realizar</h2> </p>" +
            "<ul> \n" +
            "<li><a href=Comprar>Compra Producto</a></li></p>" +
            "<li><a href=Stock++>Agrega Stock</a></li></p>" +
            "<li><a href=Logout>Terminar la sesion</a></li></p>" +
            "</ul> \n" +
            "</body>" +
            "</html>"
         );
      }
   }
}
