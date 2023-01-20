package com.atillaJrWorkshopmongo.services;

import com.atillaJrWorkshopmongo.domain.User;
import com.atillaJrWorkshopmongo.dto.UserDTO;
import com.atillaJrWorkshopmongo.repository.UserRepository;
import com.atillaJrWorkshopmongo.services.exception.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository repo;

  public List<User> findAll() {
    return repo.findAll();
  }

  public User findById(String id) {
    Optional<User> obj = repo.findById(id);
    return obj.orElseThrow(() ->
      new ObjectNotFoundException("Objeto não encontrado")
    );
  }

  public User insert(User obj) {
    return repo.insert(obj);
  }

  public User fromDTO(UserDTO objDto) {
    return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
  }
}
