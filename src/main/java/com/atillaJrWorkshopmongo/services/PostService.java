package com.atillaJrWorkshopmongo.services;

import com.atillaJrWorkshopmongo.domain.Post;
import com.atillaJrWorkshopmongo.repository.PostRepository;
import com.atillaJrWorkshopmongo.services.exception.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  @Autowired
  private PostRepository repo;

  public Post findById(String id) {
    Optional<Post> obj = repo.findById(id);
    return obj.orElseThrow(() ->
      new ObjectNotFoundException("Objeto não encontrado")
    );
  }

  public List<Post> findByTitle(String text) {
    return repo.searchTitle(text);
  }
}
