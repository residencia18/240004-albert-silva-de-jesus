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

import p009.dao.ClienteDao;
import p009.dao.ImovelDao;
import p009.db.DB;
import p009.db.DbException;
import p009.entities.Cliente;
import p009.entities.Imovel;
import p009.views.Views;

public class ImovelDaoImpl implements ImovelDao {

  public static List<Imovel> imoveis = new ArrayList<Imovel>();

  private Connection conn;

  public ImovelDaoImpl() {
  }

  public ImovelDaoImpl(Connection conn) {
    this.conn = conn;
  }

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

    ClienteDao clienteDao = DaoFactory.createClienteDao();
    Integer clientId = clienteDao.findClientIdByCpf(cpfCliente);

    if (clientId != null) {
      // Cliente encontrado, prossegue com o cadastro do imóvel
      System.out.print("\n\tMatrícula do Imóvel: ");
      String matriculaImovel = Views.scan.nextLine();

      System.out.print("\n\tEndereço do Imóvel: ");
      String enderecoImovel = Views.scan.nextLine();

      int ultimaLeituraImovel = obterInteiroValido("\n\tLeitura atual (em kWh): ");

      Cliente cliente = clienteDao.findById(clientId);
      Imovel novoImovel = new Imovel(cliente, matriculaImovel, enderecoImovel, ultimaLeituraImovel);

      insert(novoImovel);

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

    imoveis = findAll();

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
          deleteById(imovelParaRemover.getId());

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

  private void insert(Imovel obj) {

    PreparedStatement st = null;
    ResultSet rs = null;

    try {
      st = conn.prepareStatement(
          "INSERT INTO imovel (matricula, endereco, ultimaLeitura, cliente_id) VALUES (?, ?, ?, ?)",
          Statement.RETURN_GENERATED_KEYS);

      st.setString(1, obj.getMatricula());
      st.setString(2, obj.getEndereco());
      st.setInt(3, obj.getUltimaLeitura());

      if (obj.getCliente() != null) {
        st.setInt(4, obj.getCliente().getId());
      } else {
        // Define como null se não houver cliente associado.
        st.setNull(4, java.sql.Types.INTEGER);
      }

      int rowsAffected = st.executeUpdate();

      if (rowsAffected > 0) {
        rs = st.getGeneratedKeys();

        if (rs.next()) {

          int id = rs.getInt(1);
          obj.setId(id);
        }
      } else {
        throw new DbException("Unexpected error! No rows affected!");
      }
    } catch (SQLException e) {
      throw new DbException(e.getMessage());

    } finally {
      DB.closeResultSet(rs);
      DB.closeStatement(st);
    }
  }

  public List<Imovel> findAll() {

    PreparedStatement st = null;
    ResultSet rs = null;

    try {
      st = conn.prepareStatement(
          "SELECT cliente.*, imovel.matricula AS matricula, imovel.endereco, imovel.ultimaLeitura, imovel.penultimaLeitura "
              + "FROM cliente LEFT JOIN imovel "
              + "ON cliente.Id = imovel.cliente_id "
              + "ORDER BY cliente.nome");

      rs = st.executeQuery();

      Map<Integer, Cliente> clienteMap = new HashMap<>();
      List<Imovel> imoveis = new ArrayList<>();

      while (rs.next()) {
        Integer clienteId = rs.getInt("Id");

        Cliente cliente = clienteMap.get(clienteId);

        if (cliente == null) {
          cliente = instantiateCliente(rs);
          clienteMap.put(clienteId, cliente);
        }

        Imovel imovel = instantiateImovel(rs);
        cliente.addImovel(imovel);
        imoveis.add(imovel);
      }

      return imoveis;

    } catch (SQLException e) {
      throw new DbException(e.getMessage());

    } finally {
      DB.closeStatement(st);
      DB.closeResultSet(rs);
    }
  }

  private Imovel findById(Integer id) {

    PreparedStatement st = null;
    ResultSet rs = null;

    try {
      st = conn.prepareStatement(
          "SELECT imovel.*, cliente.nome AS nome, cliente.cpf  "
              + "FROM imovel " + "LEFT JOIN cliente ON imovel.cliente_id = cliente.Id "
              + "WHERE imovel.Id = ?");

      st.setInt(1, id);
      rs = st.executeQuery();

      if (rs.next()) {
        Cliente cliente = instantiateCliente(rs);
        Imovel imovel = instantiateImovel(rs, cliente);
        return imovel;
      }

      return null;

    } catch (SQLException e) {
      throw new DbException(e.getMessage());

    } finally {
      DB.closeStatement(st);
      DB.closeResultSet(rs);
    }
  }

  private void update(Imovel obj) {

    PreparedStatement st = null;
    try {

      st = conn.prepareStatement("UPDATE imovel "
          + "SET matricula = ?, endereco = ?, ultimaleitura = ?, penultimaleitura = ? " + "WHERE Id = ?");

      st.setString(1, obj.getMatricula());
      st.setString(2, obj.getEndereco());
      st.setInt(3, obj.getUltimaLeitura());
      st.setInt(4, obj.getPenultimaLeitura());
      st.setInt(5, obj.getId());

      int rowsAffected = st.executeUpdate();

      if (rowsAffected == 0) {
        throw new DbException("Ops, nenhum imovel encontrado para atualização!...");
      }

    } catch (SQLException e) {
      throw new DbException(e.getMessage());

    } finally {
      DB.closeStatement(st);
    }
  }

  private void deleteById(Integer id) {

    PreparedStatement st = null;
    try {

      st = conn.prepareStatement("DELETE FROM imovel WHERE Id = ?");

      st.setInt(1, id);

      st.executeUpdate();

    } catch (SQLException e) {
      throw new DbException(e.getMessage());

    } finally {
      DB.closeStatement(st);
    }
  }

  private Cliente instantiateCliente(ResultSet rs) throws SQLException {
    Cliente obj = new Cliente();
    obj.setId(rs.getInt("Id"));
    obj.setNome(rs.getString("nome"));
    obj.setCpf(rs.getString("cpf"));
    return obj;
  }

  private Imovel instantiateImovel(ResultSet rs) throws SQLException {
    Imovel imovel = new Imovel();
    imovel.setId(rs.getInt("Id"));
    imovel.setMatricula(rs.getString("matricula"));
    imovel.setEndereco(rs.getString("endereco"));
    imovel.setUltimaLeitura(rs.getInt("ultimaLeitura"));
    imovel.setPenultimaLeitura(rs.getInt("penultimaLeitura"));
    return imovel;
  }

  private Imovel instantiateImovel(ResultSet rs, Cliente cliente) throws SQLException {
    Imovel imovel = new Imovel();
    imovel.setId(rs.getInt("Id"));
    imovel.setMatricula(rs.getString("matricula"));
    imovel.setEndereco(rs.getString("endereco"));
    imovel.setUltimaLeitura(rs.getInt("ultimaLeitura"));
    imovel.setPenultimaLeitura(rs.getInt("penultimaLeitura"));
    imovel.setCliente(cliente);
    return imovel;
  }

  public Integer findImovelIdByMatricula(String matricula) {

    PreparedStatement st = null;
    ResultSet rs = null;

    try {

      st = conn.prepareStatement("SELECT id FROM imovel WHERE matricula = ?");

      st.setString(1, matricula);

      rs = st.executeQuery();

      if (rs.next()) {
        return rs.getInt("id");
      }

      return null;

    } catch (SQLException e) {
      throw new DbException(e.getMessage());

    } finally {
      DB.closeStatement(st);
      DB.closeResultSet(rs);
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

  @Override
  public Imovel buscaImovel() {

    Views.limparTela();
    System.out.print("\n\t===== PESQUISA DE IMÓVEL POR MATRÍCULA =====");

    if (imoveis.size() > 0) {

      while (true) {

        System.out.print("\n\tDigite a matrícula do imóvel: ");
        String matricula = Views.scan.nextLine();
        Views.limparTela();

        boolean imovelEncontrado = false;

        for (Imovel imovel : imoveis) {

          if (imovel.getMatricula().equals(matricula)) {
            Views.limparTela();
            System.out.print("\n\t===== DADOS DO IMOVEL =====");
            System.out.println(imovel.toString());
            System.out.println("\t===========================");

            // Pergunta se é o Imovel correto
            while (true) {

              System.out.print("\n\tEsse é o Imovel correto? (S/N): ");
              String resposta = Views.scan.nextLine();

              if (resposta.equalsIgnoreCase("S")) {
                Views.pausar(Views.scan);
                return imovel;
              } else

              if (resposta.equalsIgnoreCase("N")) {
                imovelEncontrado = true;
                break; // Retorna ao loop anterior para pedir uma nova matrícula

              } else {
                Views.limparTela();
                System.out.println("\n\tOpção inválida. Digite 'S' para confirmar ou 'N' para cancelar.");
              }
            }
          }
        }
        if (!imovelEncontrado) {
          Views.limparTela();
          System.out.println("\n\tImóvel não encontrado!");
        }
      }
    } else {
      Views.limparTela();
      System.out.println("\n\tNão há imóveis cadastrados!");
    }

    Views.pausar(Views.scan);
    return null; // Se não encontrou, retorna null
  }

}
