import java.util.Arrays;

class DifficultProduct {
  char nameChars[];
  public DifficultProduct() {
     nameChars = new char[7];
   }
  public void setFirstNameCharacter(char c) {
    nameChars[0] = c;
  }
  public void setSecondNameCharacter(char c) {
    nameChars[1] = c;
  }
  public void setThirdNameCharacter(char c) {
    nameChars[2] = c;
  }
  public void setFourthNameCharacter(char c) {
    nameChars[3] = c;
  }
  public void setFifthNameCharacter(char c) {
    nameChars[4] = c;
  }
  public void setSixthNameCharacter(char c) {
    nameChars[5] = c;
  }
  public void setSeventhNameCharacter(char c) {
    nameChars[6] = c;
  }
  public String getName() {
    //Convertir el arreglo a un string
    String name = Arrays.toString(nameChars); // name = [ p, r, i, n, t, e, r ]
    //Eliminar "[", "]" y "," del string
    name = name.substring(1, name.length()-1).replaceAll(",", ""); // name = "p r i n t e r"
    //Elinar los espacios del string
    name = name.substring(0, name.length()).replaceAll(" ", ""); // name = "printer"
    return name;
  }
}

class SimpleProductFacade {
  DifficultProduct difficultProduct;
  public SimpleProductFacade() {
    difficultProduct = new DifficultProduct();
  }
  public void setName(String name) {
    char chars[] = name.toCharArray();
    if(chars.length > 0)
      difficultProduct.setFirstNameCharacter(chars[0]);
    if(chars.length > 1)
      difficultProduct.setSecondNameCharacter(chars[1]);
    if(chars.length > 2)
      difficultProduct.setThirdNameCharacter(chars[2]);
    if(chars.length > 3)
      difficultProduct.setFourthNameCharacter(chars[3]);
    if(chars.length > 4)
      difficultProduct.setFifthNameCharacter(chars[4]);
    if(chars.length > 5)
      difficultProduct.setSixthNameCharacter(chars[5]);
    if(chars.length > 6)
      difficultProduct.setSeventhNameCharacter(chars[6]);
  }    
  public String getName() {
    return new String(difficultProduct.getName());
  }
}
//Using the complex class DifficultProduct
public class AppFacade {
  public static void main(String args[]) {
    DifficultProduct product = new DifficultProduct();
    product.setFirstNameCharacter('p');
    product.setSecondNameCharacter('r');
    product.setThirdNameCharacter('i');
    product.setFourthNameCharacter('n');
    product.setFifthNameCharacter('t');
    product.setSixthNameCharacter('e');
    product.setSeventhNameCharacter('r');
    System.out.println("This product is a " + product.getName());
  }
}
/*
//Using the Facade
public class AppFacade {
  public static void main(String args[]) {
    SimpleProductFacade product = new SimpleProductFacade();
    product.setName("printer");
    System.out.println("This product is a " + product.getName());
  }
}
*/

// EJERCICIO: Implementar una aplicacion que utilice el patron fachada.
// Deseamos preparar la lista de articulos que se surtiran a un cliente.
// El sistema tiene cuatro clases: Cliente, Pedido, Detalle, y Articulo.

// Implementar una clase Fachada que haga transparente a la aplicación
// cuales clases deben ser invocadas para tener todos los detalles del pedido.
// Para ello, crear una intancia de Cliente, una de Pedido, y una de Detalle
// con los articulos correspondientes.
// La aplicacion debera mostrar los articulos incluidos en el pedido y
// el costo total del pedido.

//Incluir dos versiones de implementacion de aplicacion, una con fachada y una sin ella.

// La solución debe trabajar para un codigo similar al siguiente.
/*
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
*/




  
