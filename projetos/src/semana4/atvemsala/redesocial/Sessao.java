package semana4.atvemsala.redesocial;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Sessao {

  private LocalDateTime dataHoraInicio;
  private LocalDateTime dataHoraFim;

  public Sessao() {
    dataHoraInicio = LocalDateTime.now();
  }

  public LocalDateTime getDataHoraInicio() {
    return dataHoraInicio;
  }

  public LocalDateTime getDataHoraFim() {
    return LocalDateTime.now();
  }

  public void setDataHoraFim() {
    this.dataHoraFim = LocalDateTime.now();
  }

  public static Usuario login(ListaUsuarios usuarios) {

    Scanner scan = new Scanner(System.in);

    Utils.limparTela();
    System.out.println("\n\t========== LOGIN ==========");

    System.out.print("\tEmail: ");
    String email = scan.nextLine();

    System.out.print("\n\tSenha: ");
    String senha = scan.nextLine();
    System.out.println("\t===========================");

    for (Usuario usuario : usuarios.getUsuarios()) {
      if (usuario.solicitarAutenticacao(email, senha)) {
        System.out.println("\n\tOps, usuário logado com sucesso!");
        Utils.pausar();
        Utils.limparTela();
        return usuario;
      }
    }
    System.out.println("\n\tOps, usuário não encontrado, ou senha incorreta!");
    Utils.pausar();
    Utils.limparTela();
    return null;
  }

  public void criarAmizade(ListaUsuarios usuarios){

    Scanner scan = new Scanner(System.in);

    Utils.limparTela();
    System.out.println("\n\t========== CRIAR AMIZADE ==========");

    System.out.print("\n\tInforme o e-mail do usuário: ");
    String emailAmigo = scan.nextLine();

    for (Usuario usuario : usuarios.getUsuarios()) {
      
      if(usuario.getEmail().equals(emailAmigo)){
        
      }
    }
    
  }
}