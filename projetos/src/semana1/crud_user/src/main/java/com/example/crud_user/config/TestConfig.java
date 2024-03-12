package com.example.crud_user.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.crud_user.entities.User;
import com.example.crud_user.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @SuppressWarnings("null")
  @Override
  public void run(String... args) throws Exception {

    User obj1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
    User obj2 = new User("Alex Green", "alex@hotmail.com", "977777777", "123456");
    User obj3 = new User("Bob Grey", "bob@gamil.com", "966666666", "123456");
    User obj4 = new User("Ana White", "ana@gmail.com", "955555555", "123456");
    User obj5 = new User("Carlos Black", "carlos@hotmail.com", "944444444", "123456");

    userRepository.saveAll(Arrays.asList(obj1, obj2, obj3, obj4, obj5));

  }
}
