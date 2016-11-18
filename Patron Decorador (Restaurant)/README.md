//Ejemplo de implementacion del patron Decorator.

//Extraido del libro: Head First Design Pattens


//*************   COMPONENTS   ************************************************
abstract class Beverage {
   String description = "Unknown Beverage";
   public String getDescription() {
      return description;
   }
   public abstract double cost();
}

class Espresso extends Beverage {
   public Espresso() {
      description = "Espresso";
   }
   public double cost() {
      return 1.99;
   }
}

class HouseBlend extends Beverage {
   public HouseBlend() {
      description = "House Blend Coffee";
   }
   public double cost() {
      return .89;
   }
}

class DarkRoast extends Beverage {
   public DarkRoast() {
      description = "Dark Roast Coffee";
   }
   public double cost() {
      return .99;
   }
}

//*************   DECORATORS   ************************************************
abstract class CondimentDecorator extends Beverage {
   public abstract String getDescription();
}

class Mocha extends CondimentDecorator {
   Beverage beverage;
   public Mocha(Beverage beverage) {
      this.beverage = beverage;
   }
   public String getDescription() {
      return beverage.getDescription() + ", Mocha";
   }
   public double cost() {
      return .20 + beverage.cost();
   }
}

class Soy extends CondimentDecorator {
   Beverage beverage;
   public Soy(Beverage beverage) {
      this.beverage = beverage;
   }
   public String getDescription() {
      return beverage.getDescription() + ", Soy";
   }
   public double cost() {
      return .15 + beverage.cost();
   }
}

class Whip extends CondimentDecorator {
   Beverage beverage;
   public Whip(Beverage beverage) {
      this.beverage = beverage;
   }
   public String getDescription() {
      return beverage.getDescription() + ", Whip";
   }
   public double cost() {
      return .10 + beverage.cost();
   }
}

public class StarbuzzCoffee {
   public static void main(String args[]) {
      Beverage beverage;
      beverage = new Espresso();      
      System.out.println(beverage.getDescription()
         + " $" + beverage.cost());

      beverage = new DarkRoast();
      beverage = new Mocha(beverage);
      beverage = new Mocha(beverage);
      beverage = new Whip(beverage);
      System.out.println(beverage.getDescription()
         + " $" + beverage.cost());

      beverage = new HouseBlend();
      beverage = new Soy(beverage);
      beverage = new Mocha(beverage);
      beverage = new Whip(beverage);
      System.out.println(beverage.getDescription()
         + " $" + beverage.cost());
   }

}

// EJERCICIO: Restaurant
// Implementar componentes: Hamburguesa y Sandwich
// Implementar ingredientes: Jamon, Queso, Pepinillos, Tocino, Catsup, Papas.
// Implementar 2 ejemplos de Hamburguesa y 2 de Sandwich con ingredientes diferentes.
// Incluir el costo total basado en la suma de costos de cada ingrediente.
 
