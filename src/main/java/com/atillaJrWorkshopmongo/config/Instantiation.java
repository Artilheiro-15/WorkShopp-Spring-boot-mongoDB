package com.atillaJrWorkshopmongo.config;

import com.atillaJrWorkshopmongo.domain.Post;
import com.atillaJrWorkshopmongo.domain.User;
import com.atillaJrWorkshopmongo.repository.PostRepository;
import com.atillaJrWorkshopmongo.repository.UserRepository;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Override
  public void run(String... args) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

    //com isso aqui eu Limpo os usuarios do banco de dados
    userRepository.deleteAll();
    postRepository.deleteAll();

    User Atilla = new User(null, "Atilla Brown", "Atilla@gmail.com");
    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");

    Post post1 = new Post(
      null,
      sdf.parse("21/03/2023"),
      "Partiu viagem",
      "Vou viajar para Sao Paulo. Abraços! ",
      maria
    );
    Post post2 = new Post(
      null,
      sdf.parse("23/03/2023"),
      "Bom Dia ",
      "Acordei feliz Hoje!",
      maria
    );

    //Com isso aqui eu salvo vo salvar os usuarios automaticamente la no banco de dados
    userRepository.saveAll(Arrays.asList(Atilla, maria, alex));
    postRepository.saveAll(Arrays.asList(post1, post2));
  }
}
