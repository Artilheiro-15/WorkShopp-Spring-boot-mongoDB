package com.atillaJrWorkshopmongo.repository;

import com.atillaJrWorkshopmongo.domain.User;
//esse repositori vou imolementar usando Spring data

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
  // so com isso ai acima   um obj UserRepository vai ser capaz de fazer varias operaçoes basicas comos meus usuarios
  //salvar reculperar deletar atualizar tudo isso ja esta imbutido no UserRepository
}
