/*package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class usr{
 @Autowired
 private mongoser mongoser;
 @GetMapping("/checkconnection")
 public String cc() {
    boolean isConnected =mongoser.checkcon();
    if(isConnected){
        return "Connected m
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import com.example.demo.req; // if req is your model clas*/
package com.example.demo;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;  

public interface UserRepository extends MongoRepository<req, String> {
    List<req> findAll();
    Optional<req> findById(String id); 
    // This is fine for finding by ID
    // No need for a custom delete method; use MongoRepository's deleteById
}
