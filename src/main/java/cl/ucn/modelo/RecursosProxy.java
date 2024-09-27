package cl.ucn.modelo;


public class RecursosProxy implements MultimediaInterface {
	
	private RecursosMultimedia recursoReal;
    private Usuario usuario;

    public RecursosProxy(RecursosMultimedia recursoReal, Usuario usuario) {
        this.recursoReal = recursoReal;
        this.usuario = usuario;
    }
	
	@Override
	public void cargar() {
		// TODO Auto-generated method stub
        if (usuario.tienePermiso()) {
            recursoReal.cargar();
        } else {
            System.out.println("Usuario no tiene permisos para cargar el archivo.");
        }
	}

	@Override
	public void mostrar() {
		// Control de acceso
        if (usuario.tienePermiso()) {
            recursoReal.mostrar();
        } else {
            System.out.println("Usuario no tiene permisos para visualizar el archivo.");
        }
    }
}
