package com.energiacoelho.dao.impl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.energiacoelho.dao.FaturaDao;
import com.energiacoelho.dao.ImovelDao;
import com.energiacoelho.model.Fatura;
import com.energiacoelho.model.Imovel;
import com.energiacoelho.model.Pagamento;
import com.energiacoelho.views.Views;

public class FaturaDaoImpl implements FaturaDao {

  EntityManagerFactory emf = Persistence.createEntityManagerFactory("energia-coelho-jpa");
  EntityManager em = emf.createEntityManager();

  private List<Fatura> listaFatura = new ArrayList<>();
  private ImovelDao imovelDao = newImovelDao();

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
          novaFatura(imovel);
          em.getTransaction().begin();
          em.persist(
              new Fatura(imovel.getMatricula(), imovel.getUltimaLeitura(), imovel.getPenultimaLeitura(), imovel));
          em.getTransaction().commit();
          Views.scan.nextLine();
          Views.cxMsg("\n\tO consumo foi registrado e a fatura foi gerada!");
          break; // Encerra o loop

        } else {
          Views.cxMsg("\n\tPor favor, forneça um valor inteiro válido.");
          Views.scan.next(); // Limpe a entrada inválida para evitar loop infinito
        }

      } catch (InputMismatchException e) {
        Views.cxMsg("\n\tPor favor, forneça um valor inteiro válido." + e.getMessage());
        Views.scan.next();

      } catch (Exception e) {
        Views.cxMsg("\n\tOcorreu um erro ao registrar o consumo." + e.getMessage());
        e.printStackTrace();
        break;
      }
    }
  }

  @Override
  public void novaFatura(Imovel imovel) {
    Fatura nova = new Fatura(imovel.getMatricula(), imovel.getUltimaLeitura(), imovel.getPenultimaLeitura(), imovel);
    listaFatura.add(nova);
  }

  @Override
  public void todasAsFaturas() {

    Views.limparTela();
    System.out.println("=============== TODAS AS FATURAS ===============");
    System.out.println("");

    listaFatura = findAll(em);

    for (Fatura f : listaFatura) {
      System.out.println(f.toString());
    }

    Views.pausar(Views.scan);
  }

  public void faturasEmAberto() {

    Views.limparTela();
    System.out.println("=============== FATURAS EM ABERTO ===============");
    System.out.println("");

    listaFatura = buscarFaturasNaoQuitadasDoBanco();
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

  public List<Fatura> findAll(EntityManager entityManager) {
    return entityManager.createQuery("SELECT f FROM Fatura f", Fatura.class).getResultList();
  }

  public List<Fatura> buscarFaturasNaoQuitadasDoBanco() {
    TypedQuery<Fatura> query = em.createQuery("SELECT f FROM Fatura f WHERE f.quitado = false", Fatura.class);
    return query.getResultList();
  }

  public void todosOsPagamentos() {

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
