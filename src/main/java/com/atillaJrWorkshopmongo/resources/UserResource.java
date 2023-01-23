package com.atillaJrWorkshopmongo.resources;

import com.atillaJrWorkshopmongo.domain.Post;
import com.atillaJrWorkshopmongo.domain.User;
import com.atillaJrWorkshopmongo.dto.UserDTO;
import com.atillaJrWorkshopmongo.services.UserService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserService service;

  //Dessa forma aki eu vou buscar la no banco de dados os usuarios e
  // gardar na minha list e depois eu devolvo essa lista na resposta da requisiçao
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<UserDTO>> findAll() {
    List<User> list = service.findAll();
    List<UserDTO> listDto = list
      .stream()
      .map(x -> new UserDTO(x))
      .collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<UserDTO> findById(@PathVariable String id) {
    User obj = service.findById(id);
    return ResponseEntity.ok().body(new UserDTO(obj));
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
    User obj = service.fromDTO(objDto);
    obj = service.insert(obj);
    URI uri = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(obj.getId())
      .toUri();
    return ResponseEntity.created(uri).build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> delete(@PathVariable String id) {
    // CrudRepository<User, String> service;
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> update(
    @RequestBody UserDTO objDto,
    @PathVariable String id
  ) {
    User obj = service.fromDTO(objDto);

    obj.setId(id);
    obj = service.update(obj);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
  public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
    User obj = service.findById(id);
    return ResponseEntity.ok().body(obj.getPots());
  }
}
