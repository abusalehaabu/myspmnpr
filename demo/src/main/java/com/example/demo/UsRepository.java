/*package com.example.demo;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface adrep extends MongoRepository<us, String> {
    Optional<us> findByEmailAndPassword(String email, String password);
}*/
package com.example.demo;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsRepository extends MongoRepository<us, String> {
    Optional<us> findByUsername(String username);
    // ✅ This is all you need for login
}

