package controles;
import java.sql.Connection;
import entidades.Producto;
import java.util.ArrayList;

public class ControlProducto  {
   Producto producto;

   public ControlProducto(){
     producto = new Producto();
   }

   public ArrayList<String> verProd(Connection con){
     ArrayList<String> prods = producto.verProductos(con);
     return( prods );
   }

   public boolean menosunostock(String np, Connection con){
     boolean check = producto.borraProducto(np, con);
     return( check );
   }
   public boolean masunostock(String np, int cant,Connection con){
     boolean check = producto.agregaProducto(np, cant, con);
     return( check );
   }

}
