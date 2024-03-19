package com.swproject.sellgenius.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.swproject.sellgenius.entities.Category;
import com.swproject.sellgenius.entities.User;
import com.swproject.sellgenius.repositories.CategoryRepository;
import com.swproject.sellgenius.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CategoryRepository categoryRepositoy;

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

  }
}
