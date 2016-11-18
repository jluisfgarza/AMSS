/* EJERCICIO: Elaborar una aplicacion que utilice el patron Adapter
 Existe una clase Temperatura que opera con temperaturas en grados Celsius, con
 metodos para getTemperatura y setTemperatura.
 La nueva clase Temperature opera con temperaturas en grados Fahrenheit, con
 metodos setTemperature y getTempreature.
 El cliente siempre espera guardar y recibir temperaturas en grados Celsius.
 El adaptador debera convertir las temperaturas de Celsius a Fahernheit y viceversa
 implementando los metodos getTemperatura y setTemperatura.
 Probar la clase cliente con acceso a Temperatura y Temperature (esta ultima
 mediante un adatador), para validar que las implementaciones y conversiones son correctas.}

  Juan Luis Flores
  A01280767
*/

interface CelsiusInterface {
  public double getTemperatura();
  public void setTemperatura(double t);
}

class Celsius implements CelsiusInterface {
  double temp;
  public double getTemperatura() {
    return temp;
  }
  public void setTemperatura(double t) {
    temp = t;
  }
}

interface FarenheitInterface {
  public double getTemperature();
  public void setTemperature(double t);
}

class Farenheit implements FarenheitInterface {
  double temp;
  public double getTemperature() {
    return temp;
  }
  public void setTemperature(double t){
    temp = t;
  }
}

class CelsiusToFarenheit implements CelsiusInterface {
  Farenheit farTemp;

  CelsiusToFarenheit() {
    farTemp = new Farenheit();
  }

  public void setTemperatura(double celciusT) {
    double newTemp = celciusT * 1.8 + 32;
    farTemp.setTemperature(newTemp);
  }

  public double getTemperatura() {
    double newCelsius = (farTemp.getTemperature() - 32 ) / 1.8;
    return newCelsius;
  }
}

public class AppAdapter { //This is the modified client
  public static void main(String args[]) {
    //The client belives as it will be accessing an AceObject
    CelsiusToFarenheit cTfObject = new CelsiusToFarenheit();
    cTfObject.setTemperatura(30.2);
    System.out.println("Temperatura en Celsius " + cTfObject.getTemperatura());
  }
}
