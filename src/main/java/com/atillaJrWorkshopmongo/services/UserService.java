package com.atillaJrWorkshopmongo.services;

import com.atillaJrWorkshopmongo.domain.User;
import com.atillaJrWorkshopmongo.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//essa class vai ser um serviço que pode ser injetavel em outras class
@Service
public class UserService {

  @Autowired
  private UserRepository repo;

  public List<User> findAll() {
    return repo.findAll();
  }
}
