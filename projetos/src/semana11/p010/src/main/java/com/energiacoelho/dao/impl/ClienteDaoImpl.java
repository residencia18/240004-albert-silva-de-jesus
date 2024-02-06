package com.energiacoelho.dao.impl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.energiacoelho.dao.ClienteDao;
import com.energiacoelho.model.Cliente;
import com.energiacoelho.views.Views;

public class ClienteDaoImpl implements ClienteDao {

  EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
  EntityManager em = emf.createEntityManager();

  public static List<Cliente> clientes = new ArrayList<>();

  @Override
  public void adicionar(Cliente cliente) {
    clientes.add(cliente);
  }

  @Override
  public void cadastrar() {

    Views.limparTela();
    System.out.println("\n\t===== CADASTRO DE CLIENTE =====");

    System.out.print("\n\tNome do Cliente: ");
    String nome = Views.scan.nextLine();

    System.out.print("\n\tDigite o CPF: ");
    String cpf = Views.scan.nextLine();

    clientes.add(new Cliente(nome, cpf));
    // insert(new Cliente(nome, cpf));

    Views.limparTela();
    System.out.println("\n\tCliente cadastrado com sucesso!");
    Views.pausar(Views.scan);
  }

  @Override
  public void listar() {

    Views.limparTela();
    System.out.print("\n\t===== LISTAGEM DE CLIENTES =====");

    // clientes = findAll();

    if (clientes.size() > 0) {
      for (Cliente cliente : clientes) {
        System.out.println(cliente.toString());
        System.out.print("\t================================");
      }
    } else {
      System.out.println("\n\tNão há clientes cadastrados!");
    }

    Views.pausar(Views.scan);
  }

  @Override
  public void editar() {

    Views.limparTela();
    System.out.println("\n\t===== EDIÇÃO DE CLIENTE =====");

    System.out.print("\n\tDigite o CPF do cliente: ");
    String cpf = Views.scan.nextLine();

    Integer clienteId = findClientIdByCpf(cpf);

    if (clienteId != null) {
      Cliente clienteParaEditar = findById(clienteId);

      Views.limparTela();
      System.out.print("\n\t===== DADOS DO CLIENTE =====");
      System.out.println(clienteParaEditar.toString());

      try {
        System.out.print("\n\tDeseja realmente editar este cliente? (S/N): ");
        String opcao = Views.scan.nextLine();

        if (!opcao.equalsIgnoreCase("s") && !opcao.equalsIgnoreCase("n")) {
          throw new InputMismatchException("Opção inválida. Digite 'S' para confirmar ou 'N' para cancelar.");
        }

        if (opcao.equalsIgnoreCase("s")) {
          Views.limparTela();
          System.out.print("\n\tDigite o novo nome do cliente: ");
          String nome = Views.scan.nextLine();

          System.out.print("\n\tDigite o novo CPF: ");
          cpf = Views.scan.nextLine();

          clienteParaEditar.setNome(nome);
          clienteParaEditar.setCpf(cpf);

          // update(clienteParaEditar);

          Views.limparTela();
          System.out.print("\n\t===== CLIENTE EDITADO =====");

          System.out.println(clienteParaEditar.toString());
          System.out.println("\n\tCliente editado com sucesso!");
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
      System.out.println("\n\tOps, Cliente não encontrado!..");
      Views.pausar(Views.scan);
    }
  }

  @Override
  public void excluir() {

    Views.limparTela();
    System.out.println("\n\t===== EXCLUSÃO DE CLIENTE =====");

    System.out.print("\n\tDigite o CPF do cliente: ");
    String cpf = Views.scan.nextLine();

    Integer clienteId = findClientIdByCpf(cpf);

    if (clienteId != null) {
      Cliente clienteParaRemover = findById(clienteId);

      Views.limparTela();
      System.out.print("\n\t===== DADOS DO CLIENTE =====");
      System.out.println(clienteParaRemover.toString());

      try {

        System.out.print("\n\tDeseja realmente excluir este cliente? (S/N): ");
        String opcao = Views.scan.nextLine();

        if (opcao.equalsIgnoreCase("s")) {
          Views.limparTela();
          clientes.remove(clienteParaRemover);
          // deleteById(clienteParaRemover.getId());

          System.out.println("\n\tCliente removido com sucesso!");
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
      System.out.println("\n\tOps, Cliente não encontrado!..");
      Views.pausar(Views.scan);
    }
  }

  @Override
  public void pesquisar() {

    Views.limparTela();
    System.out.println("\n\t===== PESQUISA DE CLIENTE =====");

    try {
      System.out.print("\n\tDigite o CPF do cliente: ");
      String cpf = Views.scan.nextLine();

      Integer clienteId = findClientIdByCpf(cpf);

      if (clienteId != null) {
        Cliente clienteEncontrado = findById(clienteId);

        Views.limparTela();
        System.out.print("\n\t===== DADOS DO CLIENTE =====");

        System.out.println(clienteEncontrado.toString());
        System.out.println("\t================================");
        Views.pausar(Views.scan);

      } else {
        throw new NoSuchElementException("\n\tOps, Cliente não encontrado!..");
      }
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
      Views.pausar(Views.scan);

    } catch (Exception e) {
      System.out.println("\n\tOps, ocorreu um erro inesperado: " + e.getMessage());
      Views.pausar(Views.scan);
    }
  }

  @Override
  public Cliente findById(Integer id) {
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public Integer findClientIdByCpf(String cpf) {
    throw new UnsupportedOperationException("Unimplemented method 'findClientIdByCpf'");
  }

}
