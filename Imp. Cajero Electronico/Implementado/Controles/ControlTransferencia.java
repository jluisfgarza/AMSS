package controles;

import entidades.Cuenta;
import java.sql.Connection;

public class ControlTransferencia
{
	Cuenta cuenta;

	public ControlTransferencia(){
	     cuenta = new Cuenta();
	   }

   public boolean TransferirDinero(int nCuentaPrincipal, int nCuentaDestino, float cantidad, Connection con)
   {
    // Obtener saldo de la cuenta principal
   	float saldoCuentaPrincipal = cuenta.getSaldo(nCuentaPrincipal, con);

			// Si la cantidad a transferir es menor a la cantidad de la cuenta principal
   	if (cantidad < saldoCuentaPrincipal)
   	{
      // Obtener el saldo de la cuenta desitno
   		float saldoCuentaDestino = cuenta.getSaldo(nCuentaDestino, con);
      // Calcular cambio en los saldos
      saldoCuentaPrincipal -= cantidad;
   		saldoCuentaDestino += cantidad;
      // Actualizar Saldos
   		cuenta.setSaldo(nCuentaPrincipal,saldoCuentaPrincipal, con);
   		cuenta.setSaldo(nCuentaDestino,saldoCuentaDestino, con);
   		return true;
   	}
    else
    {
      // Fondos insuficientes
   		return false;
   	}
   }

	 public float consultaSaldo(int ncuenta, Connection con)
	 {
	      return cuenta.getSaldo(ncuenta, con);
	 }

}
