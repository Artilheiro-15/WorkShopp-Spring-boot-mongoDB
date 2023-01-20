package com.atillaJrWorkshopmongo.resources;

import com.atillaJrWorkshopmongo.domain.User;
import com.atillaJrWorkshopmongo.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserService service;

  //Dessa forma aki eu vou buscar la no banco de dados os usuarios e
  // gardar na minha list e depois eu devolvo essa lista na resposta da requisiçao
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<User>> findAll() {
    List<User> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }
}
