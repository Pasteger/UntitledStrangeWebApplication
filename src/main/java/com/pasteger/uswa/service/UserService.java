package com.pasteger.uswa.service;

import com.pasteger.uswa.entity.UserEntity;
import com.pasteger.uswa.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserEntity generateNewRandomUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(generateName());
        userEntity.setId(generateId());

        return repository.save(userEntity);
    }

    private String generateName() {
        Random random = new Random();
        StringBuilder name = new StringBuilder();
        int length = random.nextInt(2, 10);
        for (int i = 0; i < length; i++) {
            name.append((char) random.nextInt(65, 91));
        }
        return name.toString();
    }

    private Long generateId(){
        Long newId = 0L;
        List<UserEntity> users = repository.findAll();
        for (UserEntity user : users) {
            if (user.getId() > newId) {
                newId = user.getId();
            }
        }
        return ++newId;
    }
}
