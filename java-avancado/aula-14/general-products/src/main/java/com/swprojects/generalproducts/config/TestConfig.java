package com.swprojects.generalproducts.config;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.javafaker.Faker;

import com.swprojects.generalproducts.entities.Category;
import com.swprojects.generalproducts.entities.Employee;
import com.swprojects.generalproducts.entities.Product;
import com.swprojects.generalproducts.entities.UserSystem;
import com.swprojects.generalproducts.entities.UserSystem.Role;
import com.swprojects.generalproducts.repositories.CategoryRepository;
import com.swprojects.generalproducts.repositories.EmployeeRepository;
import com.swprojects.generalproducts.repositories.ProductRepository;
import com.swprojects.generalproducts.repositories.UserSystemRepository;

import br.com.caelum.stella.tinytype.CPF;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  public static final Logger log = LoggerFactory.getLogger(TestConfig.class);

  @Autowired
  private UserSystemRepository userRepository;

  @Autowired
  private CategoryRepository categoryRepositoy;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public void run(String... args) throws Exception {

    Faker faker = new Faker(new Locale("pt-BR"));

    Set<String> usedProductNames = new HashSet<>();
    Set<String> usedCategoryNames = new HashSet<>();
    Set<String> usedEmployeeNames = new HashSet<>();
    Set<String> usedUsernames = new HashSet<>();

    for (int i = 0; i < 20; i++) {
      // Gerando uma data de nascimento aleatória
      Instant randomBirthDate = faker.date().birthday().toInstant().truncatedTo(ChronoUnit.SECONDS);

      // Criando uma nova categoria com os dados aleatórios
      String newCategoryName = faker.commerce().department();
      while (usedCategoryNames.contains(newCategoryName)) {
        newCategoryName = faker.commerce().department();
      }
      usedCategoryNames.add(newCategoryName);

      Category category = new Category();
      category.setName(newCategoryName);
      categoryRepositoy.save(category);
      log.info("Category: {}", category);

      // Criando um novo produto aleatório com a biblioteca Faker e salvando o produto
      // no banco de dados
      String newProductName = faker.commerce().productName();
      while (usedProductNames.contains(newProductName)) {
        newProductName = faker.commerce().productName();
      }
      usedProductNames.add(newProductName);

      Product product = new Product();
      product.setName(newProductName);
      product.setDescription(faker.commerce().material());
      product.setPrice(faker.number().randomDouble(2, 10, 1000));
      product.setImgUrl(faker.internet().image());

      // Atribuindo a categoria ao produto e salvando o produto
      product.getCategories().add(category);
      productRepository.save(product);
      log.info("Product: {}", product);

      // Se não houver um administrador, cria um novo
      UserSystem usuario = new UserSystem();

      // Verifica se já existe pelo menos um administrador no banco de dados
      boolean isAdminExists = userRepository.existsByRole(Role.ROLE_ADMIN);

      if (!isAdminExists) {
        String newUsername = faker.internet().emailAddress();
        while (usedUsernames.contains(newUsername)) {
          newUsername = faker.internet().emailAddress();
        }
        usedUsernames.add(newUsername);

        usuario.setUsername(newUsername);
        usuario.setPassword(faker.number().digits(6));
        usuario.setRole(Role.ROLE_ADMIN);
        userRepository.save(usuario);
        log.info("Usuario ADMIN criado: {}", usuario);

      } else {
        // Se já existir um administrador, cria um funcionário
        String newUsername = faker.internet().emailAddress();
        while (usedUsernames.contains(newUsername)) {
          newUsername = faker.internet().emailAddress();
        }
        usedUsernames.add(newUsername);

        usuario.setUsername(newUsername);
        usuario.setPassword(faker.number().digits(6));
        usuario.setRole(Role.ROLE_COMUM);
        userRepository.save(usuario);
        log.info("Usuario FUNCIONARIO criado: {}", usuario);
      }

      // Gerar um número de CPF aleatório
      String cpfString = faker.number().digits(11);

      // Obter o CPF formatado com pontos e traço
      String cpfFormatado = new CPF(cpfString).getNumeroFormatado();

      // Criando um novo employee aleatório com a biblioteca Faker
      String newEmployeeName = faker.name().fullName();
      while (usedEmployeeNames.contains(newEmployeeName)) {
        newEmployeeName = faker.name().fullName();
      }
      usedEmployeeNames.add(newEmployeeName);

      Employee employee = new Employee();
      employee.setName(newEmployeeName);
      employee.setCpf(cpfFormatado);
      employee.setBirthDate(randomBirthDate);
      employee.setIsActive(faker.bool().bool());
      employee.setStartDate(faker.date().birthday());
      employee.setExperienceYears(faker.number().numberBetween(1, 10));

      // Atribuindo o usuário ao funcionário e salvando o funcionário no banco de
      // dados
      employee.getProductsSold().add(product);
      employee.setUsuario(usuario);
      employeeRepository.save(employee);
      log.info("Employee: {}", employee);
    }

  }
}