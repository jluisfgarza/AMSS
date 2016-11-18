//This is the old interface
interface AceInterface {
  public void setName(String n);
  public String getName();
}

class AceClass implements AceInterface  {
  String name;
  public void setName(String n) {
    name = n;
  }
  public String getName() {
    return name;
  }
}
//This is the new interface to be adapted
interface AcmeInterface {
  public void setFirstName(String f);
  public void setLastName(String l);
  public String getFirstName();
  public String getLastName();
}

class AcmeClass implements AcmeInterface {
  String firstName;
  String lastName;
  public void setFirstName(String f) {
    firstName = f;
  }
  public void setLastName(String l) {
    lastName = l;
  }
  public String getFirstName() {
    return firstName;
  }
  public String getLastName() {
    return lastName;
  }
}

//This is the Adapter class
class AceToAcmeAdapter implements AceInterface {
  AcmeClass acmeObject;

  AceToAcmeAdapter(){
    acmeObject = new AcmeClass();
  }

  public void setName(String name) {
    //The String.split() method returns an array of Strings
    String [] firstLastName = name.split(" ");
    acmeObject.setFirstName( firstLastName[0] );
    acmeObject.setLastName( firstLastName[1] );
  }
  public String getName() {
    return acmeObject.getFirstName()+" " +acmeObject.getLastName();
  }
}

/*
public class AppAdapter { //This is the original client
  public static void main(String args[]) {
    //The client access an AceObject
    AceClass aceObject = new AceClass();
    aceObject.setName("Cary Grant");
    System.out.println("Customer's name: " + aceObject.getName());
  }
}
*/

public class AppAdapter { //This is the modified client
  public static void main(String args[]) {
    //The client belives as it will be accessing an AceObject
    AceToAcmeAdapter aceObject = new AceToAcmeAdapter();
    aceObject.setName("Cary Grant");
    System.out.println("Customer's name: " + aceObject.getName());
  }
}

// EJERCICIO: Elaborar una aplicacion que utilice el patron Adapter

// Existe una clase Temperatura que opera con temperaturas en grados Celsius, con
// metodos para getTemperatura y setTemperatura.

// La nueva clase Temperature opera con temperaturas en grados Fahrenheit, con
// metodos setTemperature y getTempreature.

// El cliente siempre espera guardar y recibir temperaturas en grados Celsius.

// El adaptador debera convertir las temperaturas de Celsius a Fahernheit y viceversa
// implementando los metodos getTemperatura y setTemperatura.

// Probar la clase cliente con acceso a Temperatura y Temperature (esta ultima
// mediante un adatador), para validar que las implementaciones y conversiones son correctas.
