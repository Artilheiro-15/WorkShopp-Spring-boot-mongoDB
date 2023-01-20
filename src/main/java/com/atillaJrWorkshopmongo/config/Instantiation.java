package com.atillaJrWorkshopmongo.config;

import com.atillaJrWorkshopmongo.domain.User;
import com.atillaJrWorkshopmongo.repository.UserRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    //com isso aqui eu removo os usuarios do banco de dados
    userRepository.deleteAll();

    User Atilla = new User(null, "Atilla Brown", "Atilla@gmail.com");
    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");

    //Com isso aqui eu salvo vo salvar os usuarios automaticamente la no banco de dados
    userRepository.saveAll(Arrays.asList(Atilla, maria, alex));
  }
}
