package com.swproject.shopall.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;

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

  @SuppressWarnings("null")
  @Override
  public void run(String... args) throws Exception {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

    Faker faker = new Faker(new Locale("en"));

    // Category cat1 = new Category(null, "Electronics");
    // Category cat2 = new Category(null, "Books");
    // Category cat3 = new Category(null, "Computers");

    // Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
    // Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
    // Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
    // Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
    // Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

    // categoryRepositoy.saveAll(Arrays.asList(cat1, cat2, cat3));
    // productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    // p1.getCategories().add(cat2);
    // p2.getCategories().add(cat1);
    // p3.getCategories().add(cat3);
    // p4.getCategories().add(cat3);
    // p5.getCategories().add(cat2);

    // productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    for (int i = 0; i < 5; i++) {
      // Gerando uma data de nascimento aleatória
      Instant randomBirthDate = faker.date().birthday().toInstant();

      // Criando um novo Employee com os dados aleatórios
      Employee employee = new Employee();
      employee.setName(faker.name().fullName());
      employee.setCpf(faker.number().digits(11));
      employee.setBirthDate(randomBirthDate);

      // Criando um novo Usuario com os dados aleatórios
      Usuario usuario = createUsuario(i + 1, faker);
      employee.setUsuario(usuario);

      // Criando um novo Produto com os dados aleatórios
      Product product = createProduct(i + 1);
      // Atribuindo o produto ao employee
      employee.getProductsSold().add(product);

      Category category = createCategory(i + 1);
      product.getCategories().add(category);
      productRepository.save(product);

      employeeRepository.save(employee);
      log.info("Employee: {}", employee);
    }
  }

  private Category createCategory(int index) {
    switch (index) {
      case 1:
        return categoryRepositoy.save(new Category(null, "Electronics"));
      case 2:
        return categoryRepositoy.save(new Category(null, "Books"));
      case 3:
        return categoryRepositoy.save(new Category(null, "Computers"));
      default:
        return null;
    }
  }

  private Product createProduct(int index) {
    switch (index) {
      case 1:
        return productRepository
            .save(new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""));
      case 2:
        return productRepository
            .save(new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""));
      case 3:
        productRepository.save(new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""));
      case 4:
        return productRepository
            .save(new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""));
      case 5:
        productRepository
            .save(new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""));
      default:
        return null;
    }
  }

  private Usuario createUsuario(int index, Faker faker) {
    switch (index) {
      case 1:
        return userRepository.save(new Usuario(null, faker.internet().emailAddress(), "123456", PerfilTipo.ADMIN));
      case 2:
        return userRepository
            .save(new Usuario(null, faker.internet().emailAddress(), "098765", PerfilTipo.FUNCIONARIO));
      case 3:
        return userRepository
            .save(new Usuario(null, faker.internet().emailAddress(), "234567", PerfilTipo.FUNCIONARIO));
      case 4:
        return userRepository
            .save(new Usuario(null, faker.internet().emailAddress(), "987654", PerfilTipo.FUNCIONARIO));
      case 5:
        return userRepository.save(new Usuario(null, faker.internet().emailAddress(), "192938", PerfilTipo.ADMIN));
      default:
        return null;
    }
  }
}
