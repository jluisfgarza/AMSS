//Component is a Composite or a Leaf. A Composite contains Components or Leafs.
//Corporate is Component; VP is a Leaf
//A Division is a Composite of Divisions or VPs.

//http://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html
import java.util.*;

abstract class Corporate {  //This is Component
  public String getName() {
    return "";
  }
  public void add(Corporate c) { }
  public Iterator iterator() {
    return null;
  }
  public void print() { }
}

class VP extends Corporate {  // This is a Leaf
  private String name;
  private String division;
  public VP(String n, String d) {
    name = n;
    division = d;
  }
  public String getName() {
    return name;
  }
  public void print() {
    System.out.println("Name: " + name + " Division: " + division);
  }
  public Iterator iterator() {
    return new VPIterator(this);
  }
}

class VPIterator implements Iterator {
  private VP vp;
  public VPIterator(VP v) {
    vp = v;
  }
  public VP next() {
    return vp;
  }
  public boolean hasNext() {
    return false;  //Leafs doesn't contain anything
  }
  public void remove() { } // Iterator requiere implementacion de este metodo.
}

class DivisionIterator implements Iterator {
  private Corporate[] corporate;
  private int location = 0;
  public DivisionIterator(Corporate[] c) {
    corporate = c;
  }
  public Corporate next() {
    return corporate[location++];
  }
  public boolean hasNext() {
    if(location < corporate.length && corporate[location] != null){
      return true;
    } else {
      return false;
    }
  }
  public void remove() { } // Iterator requiere implementacion de este metodo.
}


class Division extends Corporate {
  private Corporate[] corporate = new Corporate[100];
  private int number = 0;
  private String name;
  public Division(String n) {
    name = n;
  }
  public String getName() {
    return name;
  }
  public void add(Corporate c) {
    corporate[number++] = c;
  }
  public Iterator iterator() {
    return new DivisionIterator(corporate);
  }
  public void print() {
    Iterator iterator = iterator();
    while (iterator.hasNext()){
      Corporate c = (Corporate) iterator.next();
      c.print();
    }
  }
}


class Corporation extends Corporate { //This is the Composite
  private ArrayList<Corporate> corporate = new ArrayList<Corporate>();
  public void add(Corporate c) {
    corporate.add(c);  // Is a Division or a VP
  }
  public void print() {
    Iterator iterator = corporate.iterator();
    while (iterator.hasNext()){
      Corporate c = (Corporate) iterator.next();
      c.print();
    }
  }
}


public class AppComposite {
  Corporation corporation;

  public AppComposite() {
    corporation = new Corporation();
    Division rnd = new Division("R&D");
    rnd.add(new VP("Steve", "R&D"));
    rnd.add(new VP("Mike", "R&D"));
    rnd.add(new VP("Nancy", "R&D"));
    Division sales = new Division("Sales");
    sales.add(new VP("Ted", "Sales"));
    sales.add(new VP("Bob", "Sales"));
    sales.add(new VP("Carol", "Sales"));
    sales.add(new VP("Alice", "Sales"));
    Division western = new Division("Western Sales");
    western.add(new VP("Wally", "Western Sales"));
    western.add(new VP("Andre", "Western Sales"));
    sales.add(western);
    VP vp = new VP("Cary", "At Large");
    corporation.add(rnd);
    corporation.add(sales);
    corporation.add(vp);
    corporation.print();
  }

  public static void main(String args[]) {
    AppComposite c = new AppComposite();
  }
}

/*   Los ejercicios siguientes deben ser implementados de manera
     individual por cada estudiante (no en parejas).

     EJERCICIO 1: Un Robot contiene dos Brazos y dos Piernas.
     Un Brazo contiene tres Motores de pasos de distinta capacidad, cada Motor
     esta conectado a un "Tornillo de Bolas".
     Una Pierna contiene dos Motores de pasos de distinta capacidad, cada motor
     está conectado directamente.

   EJERCICIO 2: El menu de un restaurante está dividido en varios sub-menus.
     Por ejemplo, desayuno, comida y cena. A su vez cada sub-menú se divide en
     la variedad de platillos principales, bebidas y postres, disponibles en
     cada horario. En cada horario hay un chef diferente y queremos que su nombre
     aparezca en el menu.

   Subir el código fuente de las dos implementaciones en un solo ZIP, junto con
   los diagramas UML que representen la estructura de clases de cada ejercicio.

*/      
