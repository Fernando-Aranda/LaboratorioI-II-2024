package cl.ucn.main;

import cl.ucn.util.Util;

import cl.ucn.modelo.Usuario;
import jakarta.persistence.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("multimediaApp");
        EntityManager em = emf.createEntityManager();
        
        Util buscador = new Util();
        List<Usuario> listaUsuarios = buscador.loadCsv() ;

        // Parte 1
        int rut = 89830291;
        String jpql = "SELECT u from Usuario u WHERE u.rut = :rut";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setParameter("rut", rut);
        try {
            Usuario usuario = query.getSingleResult();
            System.out.println("El usuario: " + usuario.getRut() + " existe!");
        }catch (NoResultException e){
            System.out.println("El usuario no existe!");
            for (Usuario usuario : listaUsuarios) {
				System.out.println(usuario.toString()+"\n");
			}
        }
        

        // Parte 2
        jpql = "SELECT u from Usuario u";
        TypedQuery<Usuario> query1 = em.createQuery(jpql, Usuario.class);
        List<Usuario> usuarios = query1.getResultList();
        for (Usuario usuario : usuarios){

            System.out.println("Rut: " + usuario.getRut() + " Permiso: " + usuario.isTienePermiso() + " Archivo: " +
                    usuario.getRecursosMultimedia().getNombre() + " Protegido: " + usuario.getRecursosMultimedia().isProtegido());

        }

        em.close();

    }
}
