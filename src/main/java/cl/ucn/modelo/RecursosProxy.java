package cl.ucn.modelo;
import java.util.List;

import cl.ucn.util.Util;

public class RecursosProxy implements MultimediaInterface {
	private List<Usuario> listaUsuarios;
	private Util buscador;
	private RecursosMultimedia base;

	public RecursosProxy(RecursosMultimedia base) {
		super();
		this.base = base;
		listaUsuarios = buscador.loadCsv();
	}
	
	public RecursosMultimedia getRecursosMultimedia (Usuario usuario) {
		if(listaUsuarios.contains(usuario) && usuario.tienePermiso()) {	// usuario en base de datos y tiene permiso
			return base;
		}else {
			System.out.println("Usuario no está en la base de datos");
		}
		
		return null;
	}
}
