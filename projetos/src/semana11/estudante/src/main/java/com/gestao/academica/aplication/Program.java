package com.gestao.academica.aplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gestao.academica.entities.Estudante;

public class Program {

  public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();

    // Estudante p1 = new Estudante(null, "Casio Oliveira", "casio@gmail.com",
    // "123456");
    // Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
    // Pessoa p3 = new Pessoa(null, "Maria Joaquina", "maria@gmail.com");

    // Inserir dados
    // em.getTransaction().begin();
    // em.persist(p1);
    // em.persist(p2);
    // em.persist(p3);
    // em.getTransaction().commit();

    // Buscar por Id

    Estudante p = em.find(Estudante.class, 2);
    System.out.println(p);

    // em.getTransaction().begin();
    // Pessoa p = em.find(Pessoa.class, 5);
    // em.remove(p);
    // em.getTransaction().commit();

    System.out.println("Pronto!...");
    emf.close();
    em.close();
  }
}
