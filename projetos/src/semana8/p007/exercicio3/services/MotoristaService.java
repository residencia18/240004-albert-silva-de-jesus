package semana8.p007.exercicio3.services;

import java.util.ArrayList;
import java.util.List;

import semana8.p007.exercicio3.entities.Motorista;
import semana8.p007.exercicio3.persistencia.JsonMotoristas;
import semana8.p007.exercicio3.repositories.MotoristaRepository;
import semana8.p007.exercicio3.views.Views;

public class MotoristaService implements MotoristaRepository {
  
  public static List<Motorista> motoristas = new ArrayList<>();

  @Override
  public void adicionar(Motorista motorista) {
    motoristas.add(motorista);
  }

  @Override
  public List<Motorista> getMotoristas() {
    return motoristas;
  }

  @Override
  public void cadastrarMotorista() {

    Views.limparTela();
    System.out.println("\n\t===== CADASTRO DE MOTORISTA =====");

    System.out.print("\n\tNome do Motorista: ");
    String nome = Views.scan.nextLine();

    System.out.print("\tCNH do Motorista: ");
    String matricula = Views.scan.nextLine();

    motoristas.add(new Motorista(nome, matricula));

    System.out.println("\n\tMotorista cadastrado com sucesso!");
    Views.pausar(Views.scan);
  }

  @Override
  public void listarMotoristas() {

    Views.limparTela();
    System.out.print("\n\t===== LISTA DE MOTORISTAS =====");

    for (Motorista motorista : motoristas) {
      System.out.println(motorista.toString());
      System.out.print("\t============================");
    }
    Views.pausar(Views.scan);
  }

  @Override
  public void carregarArquivoJSON(String nomeArquivo) {
    motoristas = JsonMotoristas.carregarMotoristasDeArquivoJSON(nomeArquivo);

    if (motoristas != null) {
      Views.limparTela();
      System.out.println("\n\tMotoristas carregados do arquivo: " + nomeArquivo);
      Views.pausar(Views.scan);
    }
    
  }

  @Override
  public void salvarArquivoJSON(String nomeArquivo) {
    JsonMotoristas.salvarMotoristasEmArquivoJSON(motoristas, nomeArquivo);
    
  }
}
