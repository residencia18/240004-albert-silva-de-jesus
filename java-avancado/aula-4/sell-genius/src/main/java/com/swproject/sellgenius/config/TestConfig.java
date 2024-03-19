package com.swproject.sellgenius.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.swproject.sellgenius.entities.Category;
import com.swproject.sellgenius.entities.Product;
import com.swproject.sellgenius.entities.User;
import com.swproject.sellgenius.repositories.CategoryRepository;
import com.swproject.sellgenius.repositories.ProductRepository;
import com.swproject.sellgenius.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CategoryRepository categoryRepositoy;

  @Autowired
  private ProductRepository productRepository;

  @SuppressWarnings("null")
  @Override
  public void run(String... args) throws Exception {

    Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

    categoryRepositoy.saveAll(Arrays.asList(cat1, cat2, cat3));

    User obj1 = new User(null, "maria@gmail.com", "123456", User.Role.ROLE_ADMIN);
    User obj2 = new User(null, "alex@hotmail.com", "098765", User.Role.ROLE_USUARIO);
    User obj3 = new User(null, "bob@gamil.com", "234567", User.Role.ROLE_USUARIO);
    User obj4 = new User(null, "ana@gmail.com", "987654", User.Role.ROLE_USUARIO);
    User obj5 = new User(null, "carlos@hotmail.com", "192938", User.Role.ROLE_USUARIO);

    userRepository.saveAll(Arrays.asList(obj1, obj2, obj3, obj4, obj5));

    Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

  }
}
