package cl.ucn.modelo;

public class BuscarUsuarioAdapter implements BuscarUsuario {

	private BuscarUsuario databaseSearch;
    private BuscarUsuario csvSearch;

    public BuscarUsuarioAdapter(BuscarUsuario databaseSearch, BuscarUsuario csvSearch) {
        this.databaseSearch = databaseSearch;
        this.csvSearch = csvSearch;
    }

    @Override
    //Buscar usuario por rut
    public Usuario buscarUsuario(int rut) {
        Usuario usuario = databaseSearch.buscarUsuario(rut);
        
        if (usuario == null) {
            usuario = csvSearch.buscarUsuario(rut);
        }
        return usuario;
    }

}
