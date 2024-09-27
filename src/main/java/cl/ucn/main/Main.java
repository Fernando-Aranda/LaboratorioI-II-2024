package cl.ucn.main;

import cl.ucn.util.Util;
import cl.ucn.modelo.*;
import jakarta.persistence.*;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("multimediaApp");
		EntityManager em = emf.createEntityManager();

		Util buscador = new Util();
		List<Usuario> listaUsuarios = buscador.loadCsv();

		// Parte 1
		int rut = 89830291;

		// Crear adaptadores y controlador, para buscar en base da datos y csv
		BuscarUsuario buscadorBaseDeDatos = new BuscarUsuarioBaseDeDatos(em);
		BuscarUsuario buscadorCsv = new BuscarUsuarioCsv(new Util());

		BuscarUsuario buscadorAdapter = new BuscarUsuarioAdapter(buscadorBaseDeDatos, buscadorCsv);

		// Buscar usuario utilizando el adaptador con el rut proporcionado
		Usuario usuario = buscadorAdapter.buscarUsuario(rut);

		if (usuario != null) {
			System.out.println("El usuario: " + usuario.getRut() + " existe!");

		} else {
			System.out.println("El usuario no existe!");
		}

		// Parte 2
		if (usuario != null) {
			RecursosMultimedia recurso = usuario.getRecursosMultimedia();

			if (recurso != null) {
				// Controlar acceso a través del Proxy
				RecursosProxy proxy = new RecursosProxy(recurso, usuario);
				proxy.cargar(); // Verifica si el usuario tiene permiso antes de cargar el recurso
				proxy.mostrar(); // Verifica si el usuario tiene permiso antes de mostrar el recurso
			} else {
				System.out.println("El usuario no tiene recursos multimedia asignados.");
			}
		}

		// Listar todos los usuarios y sus permisos
        String jpql = "SELECT u from Usuario u";
        TypedQuery<Usuario> query1 = em.createQuery(jpql, Usuario.class);
        List<Usuario> usuarios = query1.getResultList();
        for (Usuario usuarioIter : usuarios) {
            System.out.println("Rut: " + usuarioIter.getRut() + " Permiso: " + usuarioIter.isTienePermiso() + 
                " Archivo: " + (usuarioIter.getRecursosMultimedia() != null ? usuarioIter.getRecursosMultimedia().getNombre() : "N/A") + 
                " Protegido: " + (usuarioIter.getRecursosMultimedia() != null ? usuarioIter.getRecursosMultimedia().isProtegido() : "N/A"));
        }


		em.close();

	}
}
