package semana4.atvemsala.redesocial;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
        return usuario;
      }
    }
    System.out.println("\n\tOps, usuário não encontrado, ou senha incorreta!");
    Utils.pausar();
    Utils.limparTela();
    return null;
  }

  public void criarAmizade(ListaUsuarios usuarios) {

    Scanner scan = new Scanner(System.in);

    Utils.limparTela();
    System.out.println("\n\t========== CRIAR AMIZADE ==========");

    System.out.print("\n\tInforme o e-mail do usuário: ");
    String emailAmigo = scan.nextLine();

    for (Usuario usuario : usuarios.getUsuarios()) {

      if (usuario.getEmail().equals(emailAmigo)) {

        int idAmigo = usuario.getId();
        usuario.adicionarAmigo("\tID: " + idAmigo + "\tEmail: " + emailAmigo);
        listarAmigos(usuario.getAmigos());
        System.out.println("\n\tOps, amizade criada com sucesso!");
        Utils.pausar();
        Utils.limparTela();
        return;
      }
    }
    System.out.println("\n\tOps, usuário não encontrado!");
    Utils.pausar();
    Utils.limparTela();
  }

  public void listarAmigos(List<String> amigos) {

    Utils.limparTela();
    System.out.println("\n\t========== AMIGOS ==========");

    for (String amigo : amigos) {
      System.out.print(amigo);
      System.out.println("\t===========================");
    }
  }

}