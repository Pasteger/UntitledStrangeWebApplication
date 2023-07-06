package com.pasteger.uswa.repository;

import com.pasteger.uswa.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity save(UserEntity userEntity);
    List<UserEntity> findAll();
}
