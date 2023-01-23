package com.atillaJrWorkshopmongo.config;

import com.atillaJrWorkshopmongo.domain.Post;
import com.atillaJrWorkshopmongo.domain.User;
import com.atillaJrWorkshopmongo.dto.AuthorDTO;
import com.atillaJrWorkshopmongo.dto.CommentDTO;
import com.atillaJrWorkshopmongo.repository.PostRepository;
import com.atillaJrWorkshopmongo.repository.UserRepository;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
import javax.xml.stream.events.Comment;
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
    //  User bob = new User(null, "Bob Grey", "bob@gmail.com");

    //Com isso aqui eu vo salvar os usuarios automaticamente la no banco de dados
    userRepository.saveAll(Arrays.asList(Atilla, maria, alex));

    Post post1 = new Post(
      null,
      sdf.parse("21/03/2023"),
      "Partiu viagem",
      "Vou viajar para Sao Paulo. Abraços! ",
      new AuthorDTO(maria)
    );
    Post post2 = new Post(
      null,
      sdf.parse("23/03/2023"),
      "Bom Dia ",
      "Acordei feliz Hoje!",
      new AuthorDTO(maria)
    );

    CommentDTO c1 = new CommentDTO(
      "Boa Viagem mano!",
      sdf.parse("25/01/2023"),
      new AuthorDTO(Atilla)
    );

    CommentDTO c2 = new CommentDTO(
      "Aproveite!",
      sdf.parse("25/01/2023"),
      new AuthorDTO(alex)
    );

    CommentDTO c3 = new CommentDTO(
      "Tenha Um Otimo Dia!",
      sdf.parse("25/01/2023"),
      new AuthorDTO(Atilla)
    );

    //feito isso eu salvo os post no banco de dados
    post1.getComments().addAll(Arrays.asList(c1, c2));
    post2.getComments().addAll(Arrays.asList(c3));

    //Com isso aqui eu vo salvar os usuarios automaticamente la no banco de dados
    postRepository.saveAll(Arrays.asList(post1, post2));

    maria.getPots().addAll(Arrays.asList(post1, post2));
    userRepository.save(maria);
  }
}
