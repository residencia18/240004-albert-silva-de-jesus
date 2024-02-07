package com.energiacoelho.dao.impl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.energiacoelho.dao.ClienteDao;
import com.energiacoelho.dao.ImovelDao;
import com.energiacoelho.model.Cliente;
import com.energiacoelho.model.Imovel;
import com.energiacoelho.views.Views;

public class ImovelDaoImpl implements ImovelDao {

  EntityManagerFactory emf = Persistence.createEntityManagerFactory("energia-coelho-jpa");
  EntityManager em = emf.createEntityManager();

  public List<Imovel> imoveis = new ArrayList<Imovel>();
  private ClienteDao clienteDao = new ClienteDaoImpl();

  @Override
  public void adicionar(Imovel imovel) {
    imoveis.add(imovel);
  }

  @Override
  public void cadastrar() {

    Views.limparTela();
    System.out.println("\n\t===== CADASTRO DE IMÓVEL =====");

    System.out.print("\n\tCPF do Cliente: ");
    String cpfCliente = Views.scan.nextLine();

    Integer clientId = clienteDao.findClientIdByCpf(cpfCliente);

    if (clientId != null) {
      // Cliente encontrado, prossegue com o cadastro do imóvel
      System.out.print("\n\tMatrícula do Imóvel: ");
      String matriculaImovel = Views.scan.nextLine();

      System.out.print("\n\tEndereço do Imóvel: ");
      String enderecoImovel = Views.scan.nextLine();

      int ultimaLeituraImovel = obterInteiroValido("\n\tLeitura atual (em kWh): ");

      Cliente cliente = clienteDao.findById(clientId);

      em.getTransaction().begin();
      em.persist(new Imovel(cliente, matriculaImovel, enderecoImovel, ultimaLeituraImovel));
      em.getTransaction().commit();

      Views.limparTela();
      System.out.println("\n\tImóvel cadastrado com sucesso!");
      Views.pausar(Views.scan);

    } else {
      // Cliente não encontrado
      System.out.println("\n\tCliente não encontrado com o CPF informado!");
      Views.pausar(Views.scan);
    }
  }

  @Override
  public void listar() {

    Views.limparTela();
    System.out.print("\n\t===== LISTAGEM DE IMÓVEIS =====");

    imoveis = findAll(em);

    if (imoveis.size() > 0) {
      for (Imovel imovel : imoveis) {
        System.out.println(imovel.toString());
        System.out.print("\t================================");
      }
    } else {
      System.out.println("\n\tNão há imóveis cadastrados!");
    }

    Views.pausar(Views.scan);
  }

  @Override
  public void editar() {

    Views.limparTela();
    System.out.println("\n\t===== EDIÇÃO DE IMOVEL =====");

    System.out.print("\n\tDigite a matrícula do imóvel: ");
    String matricula = Views.scan.nextLine();

    Integer imovelId = findImovelIdByMatricula(matricula);

    if (imovelId != null) {

      Imovel imovelParaEditar = findById(imovelId);

      Views.limparTela();
      System.out.print("\n\t===== DADOS DO IMOVEL =====");
      System.out.println(imovelParaEditar.toString());

      try {

        System.out.print("\n\tDeseja realmente editar este imóvel? (S/N): ");
        String opcao = Views.scan.nextLine();

        if (!opcao.equalsIgnoreCase("s") && !opcao.equalsIgnoreCase("n")) {
          throw new InputMismatchException("Opção inválida. Digite 'S' para confirmar ou 'N' para cancelar.");
        }

        if (opcao.equalsIgnoreCase("s")) {

          Views.limparTela();
          System.out.print("\n\tDigite o novo endereço do imóvel: ");
          String novoEndereco = Views.scan.nextLine();

          System.out.print("\n\tDigite a nova leitura atual (em kWh): ");
          int novaLeitura = Views.scan.nextInt();

          Views.scan.nextLine(); // Limpar o buffer do scanner

          imovelParaEditar.setEndereco(novoEndereco);
          imovelParaEditar.setUltimaLeitura(novaLeitura);

          update(imovelParaEditar);

          Views.limparTela();
          System.out.print("\n\t===== IMOVEL EDITADO =====");
          System.out.println(imovelParaEditar.toString());
          System.out.println("\n\tImóvel editado com sucesso!");
          Views.pausar(Views.scan);
          return;

        } else {
          System.out.println("\n\tOperação cancelada!");
          Views.pausar(Views.scan);
          return;
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\t" + e.getMessage());
        Views.scan.nextLine(); // Limpar o buffer do scanner antes de continuar o loop
      }
    } else {
      System.out.println("\n\tOps, Imóvel não encontrado!..");
      Views.pausar(Views.scan);
    }
  }

  @Override
  public void excluir() {

    Views.limparTela();
    System.out.println("\n\t===== EXCLUSÃO DE IMOVEL =====");

    System.out.print("\n\tDigite a matrícula do imóvel: ");
    String matricula = Views.scan.nextLine();

    Integer imovelId = findImovelIdByMatricula(matricula);

    if (imovelId != null) {
      Imovel imovelParaRemover = findById(imovelId);

      Views.limparTela();
      System.out.print("\n\t===== DADOS DO IMOVEL =====");
      System.out.println(imovelParaRemover.toString());

      try {

        System.out.print("\n\tDeseja realmente excluir este imóvel? (S/N): ");
        String opcao = Views.scan.nextLine();

        if (opcao.equalsIgnoreCase("s")) {
          Views.limparTela();
          imoveis.remove(imovelParaRemover);
          delete(imovelParaRemover);

          System.out.println("\n\tImóvel removido com sucesso!");
          Views.pausar(Views.scan);

        } else {
          System.out.println("\n\tOperação cancelada!");
          Views.pausar(Views.scan);
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\t" + e.getMessage());
        Views.scan.nextLine(); // Limpar o buffer do scanner antes de continuar o loop
      }
    } else {
      System.out.println("\n\tOps, Imóvel não encontrado!..");
      Views.pausar(Views.scan);
    }

  }

  @Override
  public void pesquisar() {

    Views.limparTela();
    System.out.print("\n\t===== PESQUISA DE IMÓVEL =====\n");

    try {

      System.out.print("\n\tDigite a matrícula do imóvel: ");
      String matricula = Views.scan.nextLine();

      Integer imovelId = findImovelIdByMatricula(matricula);

      if (imovelId != null) {
        Imovel imovel = findById(imovelId);
        Views.limparTela();
        System.out.print("\n\t===== DADOS DO IMOVEL =====");
        System.out.println(imovel.toString());
        System.out.println("\t===========================");

      } else {
        throw new NoSuchElementException("\n\tImóvel não encontrado!");
      }

    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());

    } catch (Exception e) {
      System.out.println("\n\tOps, ocorreu um erro inesperado: " + e.getMessage());

    } finally {
      Views.pausar(Views.scan);
    }
  }

  @Override
  public Imovel buscaImovel() {

    Views.limparTela();
    System.out.println("\n\t===== PESQUISA DE IMÓVEL POR MATRÍCULA =====");

    int totalImoveis = countImoveis();

    if (totalImoveis == 0) {
      Views.limparTela();
      System.out.println("\n\tNão há imóveis cadastrados!");
      Views.pausar(Views.scan);
      return null;
    }

    do {

      System.out.print("\n\tDigite a matrícula do imóvel: ");
      String matricula = Views.scan.nextLine();
      Views.limparTela();

      Integer imovelId = findImovelIdByMatricula(matricula);

      if (imovelId != null) {
        Imovel imovel = findById(imovelId);
        exibirDetalhesImovel(imovel);

        if (confirmarImovelCorreto(imovel)) {
          Views.pausar(Views.scan);
          return imovel;
        }

      } else {
        Views.limparTela();
        System.out.println("\n\tImóvel não encontrado!");
      }

    } while (Views.confirmarRepeticao());

    Views.pausar(Views.scan);
    return null;
  }

  @Override
  public Imovel findById(Integer id) {
    return em.find(Imovel.class, id);
  }

  public List<Imovel> findAll(EntityManager entityManager) {
    return entityManager.createQuery("SELECT i FROM Imovel i", Imovel.class).getResultList();
  }

  public void update(Imovel imovel) {

    String jpql = "SELECT i FROM Imovel i WHERE i.id = 1";
    TypedQuery<Imovel> query = em.createQuery(jpql, Imovel.class);
    imovel = query.getSingleResult();

    System.out.println(imovel.toString());

    em.getTransaction().begin();
    imovel.setEndereco(imovel.getEndereco());
    imovel.setUltimaLeitura(imovel.getUltimaLeitura());
    em.persist(imovel);
    em.getTransaction().commit();
  }

  public void delete(Imovel imovel) {

    if (imovel != null) {

      try {

        em.getTransaction().begin();
        // Verifica se o cliente está gerenciado pela EntityManager
        if (!em.contains(imovel)) {
          // Se não estiver, carrega o cliente gerenciado antes de excluí-lo
          imovel = em.find(Imovel.class, imovel.getId());
        }

        em.remove(imovel);
        em.getTransaction().commit();

      } finally {
        System.out.println("Imóvel removido com sucesso!");
      }
    } else {
      System.out.println("Cliente passado como parâmetro é nulo.");
    }
  }

  public Integer findImovelIdByMatricula(String matricula) {

    TypedQuery<Integer> query = em.createQuery("SELECT i.id FROM Imovel i WHERE i.matricula = :matricula",
        Integer.class);
    query.setParameter("matricula", matricula);

    List<Integer> results = query.getResultList();
    if (!results.isEmpty()) {
      return results.get(0);

    } else {
      return null;
    }
  }

  private static int obterInteiroValido(String prompt) {

    int valor = 0;
    boolean valorValido = false;

    do {

      try {
        System.out.print(prompt);
        valor = Integer.parseInt(Views.scan.nextLine());
        valorValido = true; // Se chegou aqui, o valor é válido

      } catch (NumberFormatException e) {
        Views.limparTela();
        System.out.println("\n\tPor favor, digite um valor inteiro válido.");
        Views.pausar(Views.scan);
      }

    } while (!valorValido);

    return valor;
  }

  private void exibirDetalhesImovel(Imovel imovel) {
    System.out.print("\n\t===== DADOS DO IMOVEL =====");
    System.out.println(imovel.toString());
    System.out.println("\t===========================");
  }

  private boolean confirmarImovelCorreto(Imovel imovel) {

    while (true) {

      System.out.print("\n\tEsse é o Imóvel correto? (S/N): ");
      String resposta = Views.scan.nextLine();

      if (resposta.equalsIgnoreCase("S")) {
        return true;

      } else if (resposta.equalsIgnoreCase("N")) {
        return false;

      } else {
        Views.limparTela();
        System.out.println("\n\tOpção inválida. Digite 'S' para confirmar ou 'N' para cancelar.");
      }
    }
  }

  private int countImoveis() {

    return 0;
  }

}
