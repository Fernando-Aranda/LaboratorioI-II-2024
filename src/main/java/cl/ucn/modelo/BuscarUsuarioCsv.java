package cl.ucn.modelo;
import cl.ucn.util.Util;
import java.util.List;

public class BuscarUsuarioCsv implements BuscarUsuario {
	
	private Util util;
	
	public BuscarUsuarioCsv(Util util) {
        this.util = util;
    }
	
	@Override
    public Usuario buscarUsuario(int rut) {
        List<Usuario> usuarios = util.loadCsv();
        for (Usuario usuario : usuarios) {
            if (usuario.getRut() == rut) {
                System.out.println("Usuario encontrado en el CSV.");
                return usuario;
            }
        }
        System.out.println("Usuario no encontrado en el CSV.");
        return null;
    }

}
