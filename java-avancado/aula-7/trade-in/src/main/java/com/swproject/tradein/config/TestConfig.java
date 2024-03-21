package com.swproject.tradein.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.swproject.tradein.entities.Category;
import com.swproject.tradein.entities.Employee;
import com.swproject.tradein.entities.Product;
import com.swproject.tradein.entities.Usuario;
import com.swproject.tradein.entities.enums.PerfilTipo;
import com.swproject.tradein.repositories.CategoryRepository;
import com.swproject.tradein.repositories.EmployeeRepository;
import com.swproject.tradein.repositories.ProductRepository;
import com.swproject.tradein.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

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

    Category cat1 = new Category(null, "Electronics");
    Category cat2 = new Category(null, "Books");
    Category cat3 = new Category(null, "Computers");

    Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
    Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
    Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
    Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
    Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

    categoryRepositoy.saveAll(Arrays.asList(cat1, cat2, cat3));
    productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    p1.getCategories().add(cat2);
    p2.getCategories().add(cat1);
    p3.getCategories().add(cat3);
    p4.getCategories().add(cat3);
    p5.getCategories().add(cat2);

    productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    Usuario obj1 = new Usuario(null, "maria@gmail.com", "123456", PerfilTipo.ADMIN);
    Usuario obj2 = new Usuario(null, "alex@hotmail.com", "098765", PerfilTipo.FUNCIONARIO);
    Usuario obj3 = new Usuario(null, "bob@gamil.com", "234567", PerfilTipo.FUNCIONARIO);
    Usuario obj4 = new Usuario(null, "ana@gmail.com", "987654", PerfilTipo.FUNCIONARIO);
    Usuario obj5 = new Usuario(null, "carlos@hotmail.com", "192938", PerfilTipo.ADMIN);

    userRepository.saveAll(Arrays.asList(obj1, obj2, obj3, obj4, obj5));

    Employee emp1 = new Employee(null, "Maria Brown", "123.456.789-01", Instant.parse("2019-06-20T19:53:07Z"), obj1);
    Employee emp2 = new Employee(null, "Alex Green", "189.876.543-21", Instant.parse("2019-06-20T19:53:07Z"), obj2);
    Employee emp3 = new Employee(null, "Bob Grey", "678.456.459-91", Instant.parse("2019-06-20T19:53:07Z"), obj1);
    Employee emp4 = new Employee(null, "Ana White", "109.876.543-21", Instant.parse("2019-06-20T19:53:07Z"), obj4);
    Employee emp5 = new Employee(null, "Carlos Black", "897.456.099-78", Instant.parse("2019-06-20T19:53:07Z"), obj5);
    Employee emp6 = new Employee(null, "Carlos Black", "453.456.099-78", Instant.parse("2019-06-20T19:53:07Z"), obj3);

    emp1.getProductsSold().add(p1);
    emp2.getProductsSold().add(p2);
    emp3.getProductsSold().add(p3);
    emp4.getProductsSold().add(p4);
    emp5.getProductsSold().add(p5);
    emp6.getProductsSold().add(p1);

    employeeRepository.saveAll(Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6));


  }
}
