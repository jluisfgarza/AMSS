package controles;
import java.sql.Connection;
import entidades.Usuario;

public class ControlLogin {
   Usuario usuario;

   public ControlLogin(){
     usuario = new Usuario();
   }

   public void agregarUsuario (int usuarioId, String nombre, String apellido, String psswrd, boolean admin, Connection con) {
      usuario.agregar(usuarioId, nombre, apellido, psswrd, admin, con);
   }

   ///Valida al cliente en la base de datos
   public int validarUsuario(String user, String password, Connection con) {
      int ncuenta = usuario.validar(user, password, con);
      return( ncuenta );
   }

}
