/*package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

import org.springframework.context.annotation.Role;

@Service
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder
    @Async
    public CompletableFuture<Optional<com.example.demo.User>> createUser(String id, String email, com.example.demo.User user) {
        Optional<com.example.demo.User> existingUser = userRepository.findByIdAndEmail(id, email);
        if (existingUser.isPresent()) {
            return CompletableFuture.completedFuture(Optional.empty()); // User already exists
        } else {
            userRepository.save(user); // Save new user
            return CompletableFuture.completedFuture(Optional.of(user));
        }
    }

    // Asynchronous get user by ID
    @Async
    public CompletableFuture<Optional<com.example.demo.User>> getUserById(String id) {
        Optional<com.example.demo.User> user = userRepository.findById(id);
        return CompletableFuture.completedFuture(user);
    }

    // Asynchronous delete user by ID
    @Async
    public CompletableFuture<Optional<com.example.demo.User>> deleteUser(String id) {
        Optional<com.example.demo.User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id); // Delete user if present
        }
        return CompletableFuture.completedFuture(user);
    }

    // Update user details by ID
    public com.example.demo.User updateUser(String id, com.example.demo.User updatedUser) {
        Optional<com.example.demo.User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            com.example.demo.User existingUser = userOpt.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setAge(updatedUser.getAge());  // Assuming age exists in User entity
            return userRepository.save(existingUser);
        }
        return null;  // Return null if user not found
    }
}
*/
package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UsRepository usRepository;
    //private adrep adrep;
    @Autowired
    private passwordservice passwordService;
    @Autowired
private applirepo applirepo;

    // Method to hash a password and save a new user
    //@Autowired
    public void registerUser(String id,String sub, String clgn ,String ppa) {
        req req=new req(id,sub,clgn,ppa);
        if(id==null||sub==null||clgn==null||ppa==null){
            System.out.println("all fields must filled");
        }
        userRepository.save(req);
    }
    
    //@Async
    //public CompletableFuture<Optional<us>> getUserByemailandpass(String email,String password) {
      //  // Simulate a time-consuming task (e.g., database query)
       // Optional<us> user = adrep.findByemailAndpassword(String email,String password);
        //Optional<us> user=adrep.findByEmailAndPassword(email, password);
        
        // Return the result wrapped in CompletableFuture
        //return CompletableFuture.completedFuture(user);
    //}
public List<req> findall() {
    return userRepository.findAll();
} 
  @PostConstruct
    public void init() {
        createUser(); // <- this is needed!
    }
    public void createUser() {
        String username = "test@example.com";
        String password = "12qwas";
    
        // Check if user with this email already exists
        Optional<us> existingUser = usRepository.findByUsername(username);
    
        if (existingUser.isPresent()) {
            System.out.println("⚠️ User with this email already exists");
        } else {
            String encodepass=passwordService.hashPassword(password);
            us user = new us(username,encodepass);
            usRepository.save(user);
            System.out.println("✅ New user created.");
        }
    }
public void log(String username, String rawPassword) {

    // Fetch the user by username from the database
    Optional<us> existingUser = usRepository.findByUsername(username);

    if (existingUser.isPresent()) {
        us user = existingUser.get();

        // Use passwordservice to compare the raw password with the stored (hashed) password
        if(passwordService.checkPassword(rawPassword, user.getPassword())) {
            // Login successful
            System.out.println("✅ Login successful for: " + username);
        } else {
            throw new IllegalArgumentException("❌ Incorrect password.");
        }

    } else {
        throw new IllegalArgumentException("❌ Username not found.");
    }
}
    
    public Optional<req> deleteUser(String id) {
        Optional<req> user = userRepository.findById(id);  // Fetch the user first
        if (user.isPresent()) {
            userRepository.deleteById(id);  // Delete by ID
        }
        return user;  // Return the Optional containing the user (before it was deleted)
    }
   
      public Optional<req> getUserById(String id) {
        return userRepository.findById(id);
    }

    public req updateUser(req updatedUser) {
        return userRepository.save(updatedUser); // Updates by ID
    }
    public void applij(String i, String name, String email, String quali) {
    if (i == null || name == null || email == null || quali == null) {
        System.out.println("All fields must be filled");
        return;
    }

    if (!userRepository.existsById(i)) {
        System.out.println("Invalid ID – no matching request found in 'req' collection.");
        return;
    }

    appli re = new appli(i, name, email, quali);
    applirepo.save(re);
}

 public List<appli> getUsersById(String i) {
        return applirepo.findAllByI(i);
    }
   @Autowired
private applirepo repo;

public void deleteByI(String i) {
    repo.deleteByi(i); // This uses your custom ID field
}

    }




//public String logu(String email, String password) {
  //  if (adrep.findByEmailAndPassword(email,password).isPresent()) {
   //     return "Login successful";
    //} else {
      //  return "Invalid credentials";
    //}
//}
//public CompletableFuture<Optional<com.example.demo.User>> getUserById(String id) {
 //   Optional<com.example.demo.User> user = userRepository.findById(id);
   // return CompletableFuture.completedFuture(user);
//}
/*package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsRepository usRepository;  // Renamed from adrep for clarity

    @Autowired
    private passwordservice passwordService;

    // Register new User (assumes 'User' is a separate entity from 'us')
    public void registerUser(String id, String username, String password) {
        if (userRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("ID already taken");
        } else if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username already taken");
        }

        String hashedPassword = passwordService.hashPassword(password);
        User user = new User(id, username, hashedPassword);
        userRepository.save(user);
    }

    @Async
    public CompletableFuture<Optional<us>> getUserByEmailAndPassword(String email, String password) {
        Optional<us> user = usRepository.findByEmailAndPassword(email, password);
        return CompletableFuture.completedFuture(user);
    }

    @Async
    public CompletableFuture<Optional<User>> getUserById(String id) {
        Optional<User> user = userRepository.findById(id);  // Correct method name
        return CompletableFuture.completedFuture(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public String logu(String email, String password) {
        if (usRepository.findByEmailAndPassword(email, password).isPresent()) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }
}
 */