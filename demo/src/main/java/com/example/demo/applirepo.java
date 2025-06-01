package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface applirepo extends MongoRepository<appli, String> {
    List<appli> findAllByI(String i);
}
