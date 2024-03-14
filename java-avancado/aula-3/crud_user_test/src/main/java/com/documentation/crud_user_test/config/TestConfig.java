package com.documentation.crud_user_test.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.documentation.crud_user_test.entities.User;
import com.documentation.crud_user_test.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @SuppressWarnings("null")
  @Override
  public void run(String... args) throws Exception {

    User obj1 = new User("Maria Brown", "maria@gmail.com","789.666.999-02", "988888888", "123456");
    User obj2 = new User("Alex Green", "alex@hotmail.com", "888.777.999-62", "977777777", "123456");
    User obj3 = new User("Bob Grey", "bob@gamil.com", "966666666", "999.222.111-12", "123456");
    User obj4 = new User("Ana White", "ana@gmail.com", "955555555", "123.345.678-12", "123456");
    User obj5 = new User("Carlos Black", "carlos@hotmail.com", "944444444", "333.555.777-52", "123456");

    userRepository.saveAll(Arrays.asList(obj1, obj2, obj3, obj4, obj5));

  }
}
