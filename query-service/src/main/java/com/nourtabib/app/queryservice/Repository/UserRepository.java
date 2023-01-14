package com.nourtabib.app.queryservice.Repository;

import com.nourtabib.app.queryservice.Entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity,String> {
    Optional<UserEntity> findById(Long id);
    void deleteById(Long id);
    List<UserEntity> findByFirstName(String firstName);
}
