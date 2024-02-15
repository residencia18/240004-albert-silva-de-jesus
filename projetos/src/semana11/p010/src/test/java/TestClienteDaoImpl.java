import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.energiacoelho.dao.impl.ClienteDaoImpl;
import com.energiacoelho.model.Cliente;
import com.energiacoelho.views.Views;

public class TestClienteDaoImpl {

  private ClienteDaoImpl clienteDaoImpl;

  @BeforeEach
  public void setUp() {
    clienteDaoImpl = new ClienteDaoImpl();
  }

  @Test
  public void testAdicionarCliente() {
    Cliente cliente = new Cliente("João da Silva", "98765432100");

    // Adiciona um cliente
    clienteDaoImpl.adicionar(cliente);

    // Verifica se o cliente foi adicionado corretamente
    Cliente clienteEncontrado = clienteDaoImpl.findById(cliente.getId());
    Assertions.assertNotNull(clienteEncontrado);
    Assertions.assertEquals(cliente, clienteEncontrado);
  }

  @Test
  public void testCadastrarCliente() {
    // Simula entrada do usuário para o cadastro
    Views.scan = Mockito.mock(Scanner.class); // Supondo que Views.scan seja um objeto Scanner
    when(Views.scan.nextLine()).thenReturn("Alex da Silva", "12345678900"); // Simula nome e CPF do cliente

    // Chama o método a ser testado
    clienteDaoImpl.cadastrar();

    // Verifica se o cliente foi cadastrado corretamente
    Cliente clienteCadastrado = clienteDaoImpl.findById(7); // Supondo que o cliente seja cadastrado com ID 7
    Assertions.assertNotNull(clienteCadastrado);
    Assertions.assertEquals("Alex da Silva", clienteCadastrado.getNome());
    Assertions.assertEquals("12345678900", clienteCadastrado.getCpf());
  }
}