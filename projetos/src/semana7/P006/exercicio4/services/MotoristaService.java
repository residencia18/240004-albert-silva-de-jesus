package semana7.P006.exercicio4.services;

import java.util.ArrayList;
import java.util.List;

import semana7.P006.exercicio4.entities.Motorista;
import semana7.P006.exercicio4.repositories.MotoristaRepository;
import semana7.P006.exercicio4.views.Views;

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

    System.out.print("\tMatricula do Motorista: ");
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
  public void carregarArquivo(String nomeArquivo) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void salvarArquivo(String nomeArquivo) {
    // TODO Auto-generated method stub
    
  }
}
