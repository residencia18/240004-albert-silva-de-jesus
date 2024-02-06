package com.gestao.academica.aplication;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.gestao.academica.dto.EstudanteDTO;
import com.gestao.academica.model.Curso;
import com.gestao.academica.model.Estudante;

public class Program {

  public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();

    // Curso c1 = new Curso(null, "Arquitetura de Software", 6);
    // Curso c2 = new Curso(null, "Engenharia de Software", 7);
    // Estudante p1 = new Estudante(null, "Alex Oliveira", "alex@gmail.com",
    // "191817", c1);
    // Estudante p2 = new Estudante(null, "Maria Joaquina", "maria@gmail.com",
    // "345678", c2);

    // // Inserir dados
    // em.getTransaction().begin();
    // em.persist(c1);
    // em.persist(c2);
    // em.persist(p1);
    // em.persist(p2);
    // em.getTransaction().commit();

    // listarTodos(em).forEach(System.out::println);
    findAll(em);

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

  // Lista todos os nomes dos estudantes utilizando String jpql e
  // TypedQuery<String> query = em.createQuery(jpql, String.class);
  public static void listarNomesDosEstudantes(EntityManager em) {

    String jpql = "SELECT e.nome FROM Estudante e";
    TypedQuery<String> query = em.createQuery(jpql, String.class);
    List<String> nomes = query.getResultList();

    for (String nome : nomes) {
      System.out.println(nome);
    }
  }

  public static void listarTodosEstudantes(EntityManager entityManager) {

    List<Estudante> estudantes = entityManager
        .createQuery("SELECT e FROM Estudante e", Estudante.class)
        .getResultList();

    for (Estudante estudante : estudantes) {
      System.out.println(estudante);
    }
  }

  public static void findAll(EntityManager entityManager) {

    String jpql = "SELECT e FROM Estudante e";
    TypedQuery<Estudante> query = entityManager.createQuery(jpql, Estudante.class);
    List<Estudante> estudantes = query.getResultList();

    for (Estudante estudante : estudantes) {
      System.out.println(estudante);
    }
  }

  public static void findById(EntityManager entityManager, Long id) {

    Estudante estudante = entityManager.find(Estudante.class, id);
    if (estudante != null) {
      System.out.println(estudante);
    } else {
      System.out.println("Estudante com o ID " + id + " não encontrado.");
    }
  }

  public static void findByIdEstudante(EntityManager entityManager, Long id) {

    String jpql = "SELECT e FROM Estudante e WHERE e.id = :id";
    TypedQuery<Estudante> query = entityManager.createQuery(jpql, Estudante.class);
    query.setParameter("id", id);

    try {
      Estudante estudante = query.getSingleResult();
      System.out.println(estudante);

    } catch (NoResultException e) {
      System.out.println("Estudante com o ID " + id + " não encontrado.");
    }
  }

  public static void alterarEstudante(EntityManager entityManager, Long id, String nome, String email,
      String matricula) {

    Estudante estudante = entityManager.find(Estudante.class, id);
    if (estudante != null) {
      entityManager.getTransaction().begin();
      estudante.setNome(nome);
      estudante.setEmail(email);
      estudante.setMatricula(matricula);
      entityManager.getTransaction().commit();
    } else {
      System.out.println("Estudante com o ID " + id + " não encontrado.");
    }
  }

  public static void update(EntityManager em) {

    String jpql = "SELECT e FROM Estudante e WHERE e.id = 1";
    TypedQuery<Estudante> query = em.createQuery(jpql, Estudante.class);
    Estudante estudante = query.getSingleResult();

    System.out.println(estudante);

    em.getTransaction().begin();
    estudante.setNome("Alex Oliveira");
    em.persist(estudante);
    em.getTransaction().commit();
  }

  public static void delete(EntityManager em) {

    String jpql = "SELECT e FROM Estudante e WHERE e.id = 1";
    TypedQuery<Estudante> query = em.createQuery(jpql, Estudante.class);
    Estudante estudante = query.getSingleResult();

    System.out.println(estudante);

    em.getTransaction().begin();
    em.remove(estudante);
    em.getTransaction().commit();
  }

  public static void update(EntityManager em, Long id, String novoNome) {

    em.getTransaction().begin();
    Estudante estudante = em.find(Estudante.class, id);
    if (estudante != null) {
      System.out.println("Estudante antes da atualização:");
      System.out.println(estudante);

      estudante.setNome(novoNome);

      // Não é necessário chamar em.persist() já que o objeto estudante já está sendo
      // gerenciado pelo EntityManager
      em.getTransaction().commit();

      System.out.println("Estudante após a atualização:");
      System.out.println(estudante);
    } else {
      System.out.println("Estudante com o ID " + id + " não encontrado.");
    }
  }

  public static void gerarEstudanteDTO(EntityManager em) {

    String jpql = "SELECT new com.gestao.academica.dto.EstudanteDTO(e.nome, e.matricula) FROM Estudante e";
    TypedQuery<EstudanteDTO> query = em.createQuery(jpql, EstudanteDTO.class);
    List<EstudanteDTO> estudantes = query.getResultList();

    for (EstudanteDTO estudante : estudantes) {
      System.out.println(estudante);
    }
  }
  
  // Exemplo de consulta utilizando join entre as entidades Estudante e Curso para buscar os estudantes de um curso específico
  public static void mostrarEstudantesPorCurso(EntityManager em) {

    String jpql = "SELECT c FROM Curso c WHERE c.Id = 1";
    TypedQuery<Curso> query = em.createQuery(jpql, Curso.class);
    Curso c = query.getSingleResult();
    String jpqlEstudante = "SELECT e FROM Estudante e WHERE e.Curso = :curso";
    TypedQuery<Estudante> queryEstudante = em.createQuery(jpqlEstudante, Estudante.class);
    queryEstudante.setParameter("curso", c);
    List<Estudante> estudantes = queryEstudante.getResultList();

    for (Estudante estudante : estudantes) {
      System.out.println(estudante);
    }
  }

}