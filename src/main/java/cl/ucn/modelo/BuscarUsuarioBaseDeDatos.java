package cl.ucn.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class BuscarUsuarioBaseDeDatos implements BuscarUsuario {

	private EntityManager em;

	public BuscarUsuarioBaseDeDatos(EntityManager em) {
	        this.em = em;
	    }

	@Override
	public Usuario buscarUsuario(int rut) {
		try {
			String jpql = "SELECT u FROM Usuario u WHERE u.rut = :rut";
			TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
			query.setParameter("rut", rut);
			return query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Usuario no encontrado en la base de datos.");
			return null;
		}
	}
}
