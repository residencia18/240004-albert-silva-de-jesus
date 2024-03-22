package com.swproject.shopall.config;

import java.time.Instant;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.javafaker.Faker;
import com.swproject.shopall.entities.Category;
import com.swproject.shopall.entities.Employee;
import com.swproject.shopall.entities.Product;
import com.swproject.shopall.entities.Usuario;
import com.swproject.shopall.entities.enums.PerfilTipo;
import com.swproject.shopall.repositories.CategoryRepository;
import com.swproject.shopall.repositories.EmployeeRepository;
import com.swproject.shopall.repositories.ProductRepository;
import com.swproject.shopall.repositories.UsuarioRepository;

import br.com.caelum.stella.tinytype.CPF;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  public static final Logger log = LoggerFactory.getLogger(TestConfig.class);

  @Autowired
  private UsuarioRepository userRepository;

  @Autowired
  private CategoryRepository categoryRepositoy;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public void run(String... args) throws Exception {

    Faker faker = new Faker(new Locale("pt-BR"));

    for (int i = 0; i < 5; i++) {
      // Gerando uma data de nascimento aleatória
      Instant randomBirthDate = faker.date().birthday().toInstant();

      // Criando uma nova categoria com os dados aleatórios
      Category category = new Category();
      category.setName(faker.commerce().department());
      categoryRepositoy.save(category);
      log.info("Category: {}", category);

      // Criando um novo produto com os dados aleatórios
      Product product = new Product();
      product.setName(faker.commerce().productName());
      product.setDescription(faker.commerce().material());
      product.setPrice(faker.number().randomDouble(2, 10, 1000));
      productRepository.save(product);
      log.info("Product: {}", product);

      // Atribuindo a categoria ao produto
      product.getCategories().add(category);
      productRepository.save(product);
      log.info("Product: {}", product);

      // Gerar um número de CPF aleatório
      String cpfString = faker.number().digits(11);

      // Obter o CPF formatado
      String cpfFormatado = new CPF(cpfString).getNumeroFormatado();

      // Criando um novo Employee com os dados aleatórios
      Employee employee = new Employee();
      employee.setName(faker.name().fullName());
      employee.setCpf(cpfFormatado);
      employee.setBirthDate(randomBirthDate);

      // Criando um novo usuário com os dados aleatórios
      Usuario usuario = new Usuario();
      usuario.setUsername(faker.internet().emailAddress());
      usuario.setPassword(faker.number().digits(6));
      usuario.setPerfilTipo(PerfilTipo.FUNCIONARIO);
      userRepository.save(usuario);
      log.info("Usuario: {}", usuario);

      // Atribuindo o usuário ao funcionário
      employee.getProductsSold().add(product);
      employee.setUsuario(usuario);
      employeeRepository.save(employee);
      log.info("Employee: {}", employee);
    }
  }

}
