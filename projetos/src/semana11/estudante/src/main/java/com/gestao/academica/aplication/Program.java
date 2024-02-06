package com.gestao.academica.aplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gestao.academica.model.Curso;
import com.gestao.academica.model.Estudante;

public class Program {

  public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();

    Curso c1 = new Curso(null, "Segurança da Informação", 6);
    Estudante p1 = new Estudante(null, "Huelbert Lima", "huelbert@gmail.com",
    "098765", c1);
    // Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
    // Pessoa p3 = new Pessoa(null, "Maria Joaquina", "maria@gmail.com");

    // Inserir dados
    em.getTransaction().begin();
    em.persist(c1);
    em.persist(p1);
    // em.persist(p2);
    // em.persist(p3);
    em.getTransaction().commit();

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
}
