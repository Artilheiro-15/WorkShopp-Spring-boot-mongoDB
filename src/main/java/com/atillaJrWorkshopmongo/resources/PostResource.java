package com.atillaJrWorkshopmongo.resources;

import com.atillaJrWorkshopmongo.domain.Post;
import com.atillaJrWorkshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

  @Autowired
  private PostService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Post> findPosts(@PathVariable String id) {
    Post obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }
}
