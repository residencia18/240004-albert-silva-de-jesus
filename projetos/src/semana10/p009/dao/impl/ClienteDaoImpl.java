package p009.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import p009.entities.Cliente;
import p009.entities.Imovel;
import p009.views.Views;
import p009.db.DB;
import p009.db.DbException;
import p009.dao.ClienteDao;

public class ClienteDaoImpl implements ClienteDao {

  public static List<Cliente> clientes = new ArrayList<>();

  private Connection conn;

  public ClienteDaoImpl() {
  }

  public ClienteDaoImpl(Connection conn) {
    this.conn = conn;
  }

  @Override
  public void adcionar(Cliente cliente) {
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
    insert(new Cliente(nome, cpf));

    Views.limparTela();
    System.out.println("\n\tCliente cadastrado com sucesso!");
    Views.pausar(Views.scan);
  }

  @Override
  public void listar() {

    Views.limparTela();
    System.out.print("\n\t===== LISTAGEM DE CLIENTES =====");

    clientes = findAll();

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

    for (Cliente cliente : clientes) {

      if (cliente.getCpf().equals(cpf)) {

        Views.limparTela();
        System.out.print("\n\t===== DADOS DO CLIENTE =====");
        System.out.println(cliente.toString());

        while (true) {

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

              System.out.println("\n\tDigite o novo CPF: ");
              cpf = Views.scan.nextLine();

              cliente.setNome(nome);
              cliente.setCpf(cpf);

              update(cliente);

              Views.limparTela();
              System.out.print("\n\t===== CLIENTE EDITADO =====");

              System.out.println(cliente.toString());
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
            // Limpar o buffer do scanner antes de continuar o loop
            Views.scan.nextLine();
          }
        }
      }
    }
    System.out.println("\n\tOps, Cliente não encontrado!..");
    Views.pausar(Views.scan);
    return;
  }

  @Override
  public void excluir() {

    Views.limparTela();
    System.out.println("\n\t===== EXCLUSÃO DE CLIENTE =====");

    System.out.print("\n\tDigite o CPF do cliente: ");
    String cpf = Views.scan.nextLine();

    Cliente clienteParaRemover = null;

    for (Cliente cliente : clientes) {

      if (cliente.getCpf().equals(cpf)) {
        clienteParaRemover = cliente;
        break;
      }
    }

    if (clienteParaRemover != null) {

      Views.limparTela();
      System.out.print("\n\t===== DADOS DO CLIENTE =====");
      System.out.println(clienteParaRemover.toString());

      try {

        System.out.print("\n\tDeseja realmente excluir este cliente? (S/N): ");
        String opcao = Views.scan.nextLine();

        if (opcao.equalsIgnoreCase("s")) {
          
          Views.limparTela();
          clientes.remove(clienteParaRemover);
          deleteById(clienteParaRemover.getId());

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

      Cliente clienteEncontrado = null;

      for (Cliente cliente : clientes) {
        if (cliente.getCpf().equals(cpf)) {
          clienteEncontrado = cliente;
          break;
        }
      }

      if (clienteEncontrado != null) {
        Views.limparTela();
        System.out.print("\n\t===== DADOS DO CLIENTE =====");
        System.out.println(clienteEncontrado.toString());
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

  public void insert(Cliente obj) {

    PreparedStatement st = null;
    try {

      st = conn.prepareStatement("INSERT INTO cliente " + "(nome, cpf) " + "VALUES " + "(?, ?)",
          Statement.RETURN_GENERATED_KEYS);

      st.setString(1, obj.getNome());
      st.setString(2, obj.getCpf());

      int rowsAffected = st.executeUpdate();

      if (rowsAffected > 0) {
        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
          int id = rs.getInt(1);
          obj.setId(id);

        }
        DB.closeResultSet(rs);

      } else {
        throw new DbException("Unexpected error! No rows affected!");
      }
    } catch (SQLException e) {
      throw new DbException(e.getMessage());

    } finally {
      DB.closeStatement(st);
    }
  }

  public List<Cliente> findAll() {

    PreparedStatement st = null;
    ResultSet rs = null;
    try {
      st = conn.prepareStatement(
          "SELECT cliente.*, imovel.matricula as matricula, imovel.endereco "
              + "FROM cliente " + "LEFT JOIN imovel ON cliente.Id = imovel.cliente_id "
              + "ORDER BY nome");

      rs = st.executeQuery();

      List<Cliente> list = new ArrayList<>();
      Map<Integer, Imovel> map = new HashMap<>();

      while (rs.next()) {

        Imovel imovel = map.get(rs.getInt("Id"));

        if (imovel == null) {
          imovel = instantiateImovel(rs);
          map.put(rs.getInt("Id"), imovel);
        }

        Cliente obj = instantiateCliente(rs, imovel);
        list.add(obj);
      }
      return list;

    } catch (SQLException e) {
      throw new DbException(e.getMessage());

    } finally {
      DB.closeStatement(st);
      DB.closeResultSet(rs);
    }
  }

  public void update(Cliente obj) {

    PreparedStatement st = null;
    try {

      st = conn.prepareStatement("UPDATE cliente " + "SET nome = ?, cpf = ? " + "WHERE Id = ?");

      st.setString(1, obj.getNome());
      st.setString(2, obj.getCpf());
      st.setInt(3, obj.getId());

      int rowsAffected = st.executeUpdate();

      if (rowsAffected == 0) {
        throw new DbException("Ops, nenhum cliente encontrado para atualização!...");
      }

    } catch (SQLException e) {
      throw new DbException(e.getMessage());

    } finally {
      DB.closeStatement(st);
    }
  }

  public void deleteById(Integer id) {

    PreparedStatement st = null;
    try {

      st = conn.prepareStatement("DELETE FROM cliente WHERE Id = ?");

      st.setInt(1, id);

      st.executeUpdate();

    } catch (SQLException e) {
      throw new DbException(e.getMessage());

    } finally {
      DB.closeStatement(st);
    }
  }

  private Cliente instantiateCliente(ResultSet rs, Imovel imovel) throws SQLException {
    Cliente obj = new Cliente();
    obj.setId(rs.getInt("Id"));
    obj.setNome(rs.getString("nome"));
    obj.setCpf(rs.getString("cpf"));
    obj.addImovel(imovel);
    imovel.setCliente(obj);
    return obj;
  }

  private Imovel instantiateImovel(ResultSet rs) throws SQLException {
    Imovel imovel = new Imovel();
    imovel.setId(rs.getInt("Id"));
    imovel.setMatricula(rs.getString("matricula"));
    imovel.setEndereco(rs.getString("endereco"));
    return imovel;
  }
}
