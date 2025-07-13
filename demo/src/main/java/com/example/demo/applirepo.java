package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface applirepo extends MongoRepository<appli, String> {
    List<appli> findAllByI(String i);
     Optional<appli> deleteByi(String i);

}
