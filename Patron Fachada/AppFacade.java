import java.util.Arrays;

class Fachada {

  getTotal
}

class Cliente {
  int numCliente;
  String nomCliente;
  String domicilio;
  public creaCliente(int n, String nombre, String dom){
    numCliente = n;
    nomCliente = nombre;
    domicilio = dom;
  }
}

class Pedido {
  int idl
  creaPedido

  getPedido
}

class Detalle {
  String detalle;
  public String creaDetalle(){
    detalle = "";
  }
}

class Articulo {
  int numArt;
  String nombre;
  double precio;
  agregaArticulo (int num, String nom, double p){
    numArt = num;
    nombre = nom;
    precio = p;
  }
  public int getNumero(){
    return numArt;
  }
  public double getPrecio(){
    return precio;
  }
  public String getNombre() {
    return nombre;
  }
}

public class ConFachada {
   public static void main(String argc[] ) {
      Articulo articulo;
      Vector<Articulo> articulos;
      Iterator<Articulo> it;

      Fachada orden = new Fachada();
      orden.creaCliente(5, "Juan Perez", "Monterrey, N.L.");
      orden.creaDetalle();
      orden.creaPedido(5);//Requiere idCliente
      orden.agregaArticulo(100, "Alambre calibre 10", 550.90f);
      orden.agregaArticulo(150, "Pinzas pericas 16 pulgadas", 380f);
      orden.agregaArticulo(200, "Candado Philips reforzado", 270.50f);

      System.out.println("Contenido de la orden:");
      articulos = orden.getPedido();
      it = articulos.iterator();
      while(it.hasNext()) {
         articulo = it.next();
         System.out.println("   " + articulo.getNumero() + " " + articulo.getNombre() + " " + articulo.getPrecio());
      }
      System.out.println("\t\t TOTAL DE LA ORDEN: " + orden.getTotal());
   }
}
