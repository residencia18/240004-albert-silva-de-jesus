package p009.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;

import p009.dao.FaturaDao;
import p009.dao.ImovelDao;
import p009.db.DB;
import p009.db.DbException;
import p009.entities.Fatura;
import p009.entities.Imovel;
import p009.entities.Pagamento;
import p009.views.Views;

public class FaturaDaoImpl implements FaturaDao {

  private static List<Fatura> listaFatura = new ArrayList<>();
  private ImovelDao imovelDao = newImovelDao();

  private Connection conn;

  public FaturaDaoImpl() {
  }

  public FaturaDaoImpl(Connection conn) {
    this.conn = conn;
  }

  @Override
  public void registrarConsumo() {

    Imovel imovel = imovelDao.buscaImovel();

    if (imovel == null) {
      Views.cxMsg("\n\tImóvel não encontrado!");
      return;
    }

    while (true) {

      try {
        Views.limparTela();
        System.out.print("\n\tInforme a leitura realizada: ");

        // Use hasNextInt() para verificar se a entrada é um número inteiro
        if (Views.scan.hasNextInt()) {
          int valorLido = Views.scan.nextInt();

          if (imovel.getUltimaLeitura() > valorLido) {
            Views.cxMsg("\n\tA leitura atual não pode ser menor que a leitura antiga!");
            Views.pausar(Views.scan);
            continue;
          }

          imovel.setUltimaLeitura(valorLido);
          insert(new Fatura(imovel.getMatricula(), imovel.getUltimaLeitura(), imovel.getPenultimaLeitura()), imovel);
          listaFatura.add(new Fatura(imovel.getMatricula(), imovel.getUltimaLeitura(), imovel.getPenultimaLeitura()));
          Views.cxMsg("\n\tO consumo foi registrado e a fatura foi gerada!");
          break; // Encerra o loop

        } else {
          Views.cxMsg("\n\tPor favor, forneça um valor inteiro válido.");
          Views.scan.next(); // Limpe a entrada inválida para evitar loop infinito
        }

      } catch (InputMismatchException e) {
        Views.cxMsg("\n\tPor favor, forneça um valor inteiro válido.");
        Views.scan.next(); 

      } catch (Exception e) {
        // Trate a exceção de maneira adequada, como registrar em logs
        Views.cxMsg("\n\tOcorreu um erro ao registrar o consumo.");
        e.printStackTrace();
        break;
      }
    }
  }

  private void insert(Fatura obj, Imovel imovel) {

    PreparedStatement st = null;
    ResultSet rs = null;

    try {
      st = conn.prepareStatement(
          "INSERT INTO fatura (matriculaImovel, ultimaLeitura, penultimaLeitura, valorTotal, dataEmissao, quitado, imovel_id) VALUES (?, ?, ?, ?, ?, ?, ?)",
          Statement.RETURN_GENERATED_KEYS);

      st.setString(1, obj.getMatriculaImovel());
      st.setInt(2, obj.getUltimaLeitura());
      st.setInt(3, obj.getPenultimaLeitura());
      st.setDouble(4, Double.parseDouble(String.format(Locale.US, "%.2f", obj.getValorTotal())));
      st.setDate(5, java.sql.Date.valueOf(obj.getDataEmissao()));
      st.setBoolean(6, obj.isQuitado());

      if (imovel != null) {
        st.setInt(7, imovel.getId());

      } else {
        // Define como null se não houver imóvel associado.
        st.setNull(7, java.sql.Types.INTEGER);
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

  public static void novaFatura(Imovel imovel) {
    Fatura nova = new Fatura(imovel.getMatricula(), imovel.getUltimaLeitura(), imovel.getPenultimaLeitura());
    listaFatura.add(nova);
  }

  @Override
  public void todasAsFaturas() {

    Views.limparTela();
    System.out.println("=============== TODAS AS FATURAS ===============");
    System.out.println("");

    for (Fatura f : listaFatura) {
      System.out.println(f.toString());
    }

    Views.pausar(Views.scan);
  }

  public void faturasEmAberto() {

    Views.limparTela();
    System.out.println("=============== FATURAS EM ABERTO ===============");
    System.out.println("");

    for (Fatura fatura : listaFatura) {
      if (!fatura.isQuitado())
        System.out.println(fatura.toString());
    }
    Views.pausar(Views.scan);
  }

  @Override
  public Fatura obterFaturaPorMesEmissao() {

    Imovel imovel = imovelDao.buscaImovel();

    if (imovel == null) {
      Views.cxMsg("Imóvel não encontrado!");
      return null;
    }

    int valorLido = 0;
    int k = 0;
    while (valorLido > 12 || valorLido < 1) {

      try {

        Views.limparTela();
        System.out.print("Informe o mês referente à fatura: ");
        valorLido = Views.scan.nextInt();

      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
      if (valorLido > 12 || valorLido < 1) {
        Views.cxMsg("O mês informado é inválido!");
        k++;
      }
      if (k == 3) {
        Views.cxMsg("Limite de tentativas excedidas! Tente novamente!");
      }
    }

    for (Fatura fatura : listaFatura) {

      if (fatura.getMatriculaImovel().equalsIgnoreCase(imovel.getMatricula())
          && fatura.getDataEmissao().getMonthValue() == valorLido) {
        return fatura;
      }
    }
    return null;
  }

  public static void todosOsPagamentos() {

    Views.limparTela();
    System.out.println("=============== TODOS OS PAGAMENTOS ===============");
    System.out.println("");

    for (Fatura f : listaFatura) {

      System.out.println("===== IMÓVEL DE MATRÍCULA: " + f.getMatriculaImovel() + " =====");
      System.out.println("");

      for (Pagamento p : f.getPagamentos()) {
        System.out.println(p.toString());
      }
      System.out.println("");
    }

    Views.pausar(Views.scan);
  }

  public void pagamentosPorFatura() {

    Fatura encontrada = obterFaturaPorMesEmissao();

    if (encontrada == null) {
      Views.cxMsg("Não foi encontrado nenhuma fatura com as descrições informadas!");
      return;
    }

    Views.limparTela();
    System.out.println("=============== PAGAMENTOS RELACIONADOS À FATURA ===============");
    System.out.println("");

    for (Pagamento p : encontrada.getPagamentos()) {
      System.out.println(p.toString());
    }

    Views.pausar(Views.scan);
  }

  public void todosOsReembolsos() {

    Views.limparTela();
    System.out.println("=============== TODOS OS REEMBOLSOS ===============");
    System.out.println("");

    for (Fatura f : listaFatura) {
      System.out.println("===== IMÓVEL DE MATRÍCULA: " + f.getMatriculaImovel() + " =====");
      System.out.println("");
      System.out.println(f.getReembolso().toString());
      System.out.println("");
    }

    Views.pausar(Views.scan);
  }

  public void reembolsosPorFatura() {

    Fatura encontrada = obterFaturaPorMesEmissao();

    if (encontrada == null) {
      Views.cxMsg("Não foi encontrado nenhuma fatura com as descrições informadas!");
      return;
    }

    Views.limparTela();
    System.out.println("=============== REEMBOLSOS RELACIONADOS À FATURA ===============");
    System.out.println("");

    if (encontrada.getReembolso() != null)
      System.out.println(encontrada.getReembolso().toString());
    else
      System.out.println("Não há reembolsos para essa fatura!");

    Views.pausar(Views.scan);
  }

  public ImovelDaoImpl newImovelDao() {
    return new ImovelDaoImpl();
  }
}
