package com.gestao.academica.aplication;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gestao.academica.model.Curso;
import com.gestao.academica.model.Estudante;

public class Program {

  public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();

    // Curso c1 = new Curso(null, "Arquitetura de Software", 6);
    // Curso c2 = new Curso(null, "Engenharia de Software", 7);
    // Estudante p1 = new Estudante(null, "Alex Oliveira", "alex@gmail.com", "191817", c1);
    // Estudante p2 = new Estudante(null, "Maria Joaquina", "maria@gmail.com", "345678", c2);

    // // Inserir dados
    // em.getTransaction().begin();
    // em.persist(c1);
    // em.persist(c2);
    // em.persist(p1);
    // em.persist(p2);
    // em.getTransaction().commit();

    listarTodos(em).forEach(System.out::println);

    // Buscar por Id

    // Estudante p = em.find(Estudante.class, 3);
    // System.out.println(p);

    // em.getTransaction().begin();
    // Pessoa p = em.find(Pessoa.class, 5);
    // em.remove(p);
    // em.getTransaction().commit();

    System.out.println("Pronto!...");
    emf.close();
    em.close();
  }

  public static List<Estudante> listarTodos(EntityManager entityManager) {
    return entityManager.createQuery("SELECT e FROM Estudante e", Estudante.class).getResultList();
  }
}
