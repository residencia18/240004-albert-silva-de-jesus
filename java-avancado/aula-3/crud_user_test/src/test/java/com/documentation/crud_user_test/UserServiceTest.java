package com.documentation.crud_user_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.documentation.crud_user_test.entities.User;
import com.documentation.crud_user_test.repositories.UserRepository;
import com.documentation.crud_user_test.services.UserService;

public class UserServiceTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserService userService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  // Testa o método save() da classe UserService
  @Test
  public void testSave() {
    User user = new User();
    user.setId(1L);
    when(userRepository.save(user)).thenReturn(user);

    User savedUser = userService.save(user);
    assertEquals(user, savedUser);
    verify(userRepository, times(1)).save(user); // Verifica se o método save() foi chamado exatamente uma vez com o
                                                 // usuário especificado
  }

  // Testa o método findAll() da classe UserService
  @Test
  public void testFindAll() {
    User user1 = new User();
    User user2 = new User();
    when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

    List<User> userList = userService.findAll();
    assertEquals(2, userList.size());
    verify(userRepository, times(1)).findAll(); // Verifica se o método findAll() foi chamado exatamente uma vez
  }

  // Testa o método searchById() da classe UserService com um ID válido
  @Test
  public void testSearchById_WithValidId() {
    User user = new User();
    user.setId(1L);
    when(userRepository.findById(1L)).thenReturn(Optional.of(user));

    User foundUser = userService.searchById(1L);
    assertNotNull(foundUser); // Verifica se o usuário encontrado não é nulo
    assertEquals(user, foundUser); // Verifica se o usuário encontrado é o mesmo que o usuário esperado
    verify(userRepository, times(1)).findById(1L); // Verifica se o método findById() foi chamado exatamente uma vez com
                                                   // o ID especificado
  }

  // Testa o método searchById() da classe UserService com um ID inválido
  @Test
  public void testSearchById_WithInvalidId() {
    when(userRepository.findById(1L)).thenReturn(Optional.empty());

    assertThrows(IllegalArgumentException.class, () -> {
      userService.searchById(1L);
    }); // Verifica se uma exceção é lançada quando o ID não é encontrado
    verify(userRepository, times(1)).findById(1L); // Verifica se o método findById() foi chamado exatamente uma vez com
                                                   // o ID especificado
  }
}
