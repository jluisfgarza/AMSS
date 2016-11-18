// EJERCICIO: Restaurant
// Implementar componentes: Hamburguesa y Sandwich
// Implementar ingredientes: Jamon, Queso, Pepinillos, Tocino, Catsup, Papas.
// Implementar 2 ejemplos de Hamburguesa y 2 de Sandwich con ingredientes diferentes.
// Incluir el costo total basado en la suma de costos de cada ingrediente.

//*************   COMPONENTS   ************************************************
abstract class Comida {
   String description = "Plato Principal";
   public String getDescription() {
      return description;
   }
   public abstract double cost();
}

class Hamburguesa_KrabbyPatty extends Comida {
   public Hamburguesa_KrabbyPatty() {
      description = "Sale una Cangreburguer";
   }
   public double cost() {
      return 4.99;
   }
}

class ClubSandwich extends Comida {
   public ClubSandwich() {
      description = "Club Sandwich";
   }
   public double cost() {
      return 3.99;
   }
}

class Hamburguesa_MiniKrabbyPatty extends Comida {
   public Hamburguesa_MiniKrabbyPatty() {
      description = "Sale Mini Cangreburguer para el chico";
   }
   public double cost() {
      return 2.99;
   }
}

class JRSandwich extends Comida {
   public JRSandwich() {
      description = "Jr. Sandwich";
   }
   public double cost() {
      return 2.99;
   }
}

//*************   DECORATORS   ************************************************
abstract class Ingredientes extends Comida {
   public abstract String getDescription();
}

class Jamon extends Ingredientes {
   Comida comida;
   public Jamon(Comida comida) {
      this.comida = comida;
   }
   public String getDescription() {
      return comida.getDescription() + ", Jamon";
   }
   public double cost() {
      return 0.2 + comida.cost();
   }
}

class Queso extends Ingredientes {
   Comida comida;
   public Queso(Comida comida) {
      this.comida = comida;
   }
   public String getDescription() {
      return comida.getDescription() + ", Queso";
   }
   public double cost() {
      return 0.15 + comida.cost();
   }
}

class Pepinillos extends Ingredientes {
   Comida comida;
   public Pepinillos(Comida comida) {
      this.comida = comida;
   }
   public String getDescription() {
      return comida.getDescription() + ", Pepinillos";
   }
   public double cost() {
      return 0.10 + comida.cost();
   }
}

class Tocino extends Ingredientes {
   Comida comida;
   public Tocino(Comida comida) {
      this.comida = comida;
   }
   public String getDescription() {
      return comida.getDescription() + ", Tocino";
   }
   public double cost() {
      return 0.05 + comida.cost();
   }
}

class Catsup extends Ingredientes {
   Comida comida;
   public Catsup(Comida comida) {
      this.comida = comida;
   }
   public String getDescription() {
      return comida.getDescription() + ", Catsup";
   }
   public double cost() {
      return 0.05 + comida.cost();
   }
}

class Papas extends Ingredientes {
   Comida comida;
   public Papas(Comida comida) {
      this.comida = comida;
   }
   public String getDescription() {
      return comida.getDescription() + ", Papas";
   }
   public double cost() {
      return 0.05 + comida.cost();
   }
}

public class Restaurant {
   public static void main(String args[]) {
      Comida comida;

      comida = new Hamburguesa_KrabbyPatty();
      comida = new Jamon(comida);
      comida = new Queso(comida);
      comida = new Tocino(comida);
      comida = new Pepinillos(comida);
      comida = new Catsup(comida);
      comida = new Papas(comida);
      System.out.println(comida.getDescription()
         + " $" + comida.cost());

      comida = new ClubSandwich();
      comida = new Queso(comida);
      comida = new Jamon(comida);
      comida = new Pepinillos(comida);
      System.out.println(comida.getDescription()
         + " $" + comida.cost());

      comida = new Hamburguesa_MiniKrabbyPatty();
      comida = new Jamon(comida);
      comida = new Queso(comida);
      comida = new Catsup(comida);
      System.out.println(comida.getDescription()
         + " $" + comida.cost());

      comida = new JRSandwich();
      comida = new Queso(comida);
      comida = new Jamon(comida);
      System.out.println(comida.getDescription()
         + " $" + comida.cost());
   }
}
