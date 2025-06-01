/*package com.example.demo;


import java.security.KeyStore;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/admin")
 public class userc {
@Autowired
    private UserService UserService;
    @GetMapping("/form")
    public String show(){
        return "form";
    }
@PostMapping("/submit")
    public User addUser(@RequestParam String name,@RequestParam String age,Model model ) {
        User user = new User();
        user.setName(name);
        user.setAge(Integer.parseInt(age));
        UserService.creatUser(user);
        model.addAttribute("message", "User added successfully");.
    return "result";
    }
    @GetMapping
    public List<User> gaus() {
        return UserService.gau();
    }
    //@GetMapping("/id")
    //public User getUserById(@RequestBody User user) {
      //  return UserService.getUserById(user);
    //}
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        
        return UserService.getUserById(id);
}

    @GetMapping("/del/{id}")
    public void deleteUser(@PathVariable String id) {
    UserService.deletUser(id);
    }
      @GetMapping("/up/{id}")
    public User updateEmployee(@PathVariable String id,@RequestBody User userup) {
        if (userup == null) {
            return null;  // Or throw an exception, depending on your use case
        }
    
        // Now you can access the properties of the userup object
        
        // Call your service to update the employee
        return UserService.updateEmployee(id, userup);
    }
      

@PostMapping("/{id}")
public User fetchEmployee(@RequestBody User userQuery) {
    // Fetch employee based on the query data in the request body
    User employee = UserService. getEmployeeByNameAndAge(userQuery.getName(),userQuery.getAge());
    
    // Return the fetched user object in the response body
    return employee;
}
}*/
/*package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class userc {
    
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

@GetMapping("/")
    public String showForm() {
        return "form";
    }
@PostMapping("/submit")
public String cu(String id,String email,User user) {
    Optional<User> existingUser = userRepository.findByIdAndEmail(id,email);
    if (existingUser.isPresent()) {
        return "ex";  // Return an error message if the user ID exists
    }
    Optional<User> exid = userRepository.findById(id);
    if (exid.isPresent()) {
        return "exid";  // Return an error message if the user ID exists
    }
    Optional<User> em = userRepository.findByEmail(email);
    if(em.isPresent()){
            return "emex";
        }
        else{
    userService.createUser(id,email,user);
    
    return "redirect:/suc"; //
    }
    // Asynchronously check if the user exists
    
} 
@GetMapping("/suc")
    public String showSuccess() {
        return "suc";  // Show a success message after the form is submitted
    }
    @GetMapping("/my")
    public List<User> getAllUsers() {
        return userService.gau();
    }

    @GetMapping("/id/{id}")
    public String getUserById(@PathVariable String id, Model model) {
        // Fetch the user by ID
       CompletableFuture<Optional<User>> uget= userService.getUserById(id);
        
        // Check if the user is present
        Optional<User> userOptional = uget.join(); 
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            
            // Add the user to the model
            model.addAttribute("use", user);
        } else {
            // Handle the case where user is not found (optional)
            model.addAttribute("error", "User not found");
        }
    
        // Return the view name to render the user details page
        return "userDetails"; // Make sure the HTML file is named userDetails.html
    }


   /*  @GetMapping("/del/{id}")
    public String deleteUser(@Deprecated String id,User user) {
        CompletableFuture<Optional<User>> uop= userService.deletUser(id);
        CompletableFuture<Optional<User>> uget= userService.deletUser(id);
        Optional<User> use = uop.join(); 
        if(use.isPresent()) {
        userService.deletUser(id);
        return "del";
        } else {
        return "hh";
        }
    }*/
 //  @PostMapping("/up/{id}")
//public User updateUser(@PathVariable String id, @RequestBody User userUp) {
/*@GetMapping("/del/{id}")
public String deluser(@PathVariable String id, User user) {
    // Call the service to delete the user asynchronously
    CompletableFuture<Optional<User>> uget = userService.deletUser(id, user);

    // Block and wait for the result of the CompletableFuture
    Optional<User> us = uget.join(); // Join to get the result

    // Check if the user was found and delete
    if (us.isPresent()) {
        userService.deletUser(id); // You might want to delete the user here
        return "del";  // User deleted successfully
    } 
}
}*/
/*@GetMapping("/id/{id}")
public String getUserById(@PathVariable String id,User user) {
    // Fetch the user by ID
   CompletableFuture<Optional<User>> uget= userService.delus(id);
    
    // Check if the user is present
    Optional<User> userOptional = uget.join(); 
    if (userOptional.isPresent()) {
        User use = userOptional.get();
        userService.delus(id);
        return "del";
    }
    else {
        return "nod";
}
//}
@GetMapping("/del/{id}")
public String getUserById(@PathVariable String id, User user) {
    // Fetch the user by ID asynchronously
    CompletableFuture<Optional<User>> uget = userService.delus(id);
    
    // Wait for the result of the CompletableFuture
    Optional<User> userOptional = uget.join();
    
    // Check if the user is present
    if (userOptional.isPresent()) {
        // If the user exists, return "del"
        return "del";
    } else {
        // If the user does not exist, return "nod"
        return "nod";
    }
}

@GetMapping("/del")
public String fetchEmplo() {
     userService.deluss();
     return"dd";
}
} */
 //if (userUp == null) {
   //return null;  // Or throw an exception, depending on your logic
 //}return userService.updateEmployee(id, userUp);

   package com.example.demo;
   import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
   import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletResponse;
   
   @Controller
   public class UserController {
   
       @Autowired(required = true)
       private UserService userService;
   
       // Display the registration form (GET request)
        @GetMapping("/")
    public String showDashboard(HttpServletResponse response) {
        // Prevent caching
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        
        return "dashboard"; // Thymeleaf will render dashboard.html
    }
@GetMapping("/login")
public String showlog(HttpServletResponse response) {
    return "login";  // register.html in /templates/
}
@PostMapping("/login")
public String logi(@RequestParam String username,
                   @RequestParam String password,
                   Model model) {
    try {
        userService.log(username, password); // performs the login check
        System.out.println("✅ Login successful");

        model.addAttribute("message", "✅ Login successful");
        return "logd"; // or: return "redirect:/register";

    } catch (Exception e) {
        model.addAttribute("message", e.getMessage());
        return "login"; // show login form with error
    }
}
@GetMapping("/logd")
public String shadp(){
    return "logd";
}
@GetMapping("/suc")
    public String showSuccess() {
        return "suc";  // Show a success message after the form is submitted
      // register.html in /templates/
}
       //@GetMapping("/log")
       //public String log(/*@RequestParam String email,@RequestParam String password,Model model*/) {
          //try {
            //  userService.logu(email, password);
              //model.addAttribute("messege","user login successfully");
         //     return "register";
          //} catch (Exception e) {
            //model.addAttribute("message", e.getMessage());
          
          // return "log";  // return a view name (register.html or register.jsp)
          //}
       //}
   
       // Handle registration form submission (POST request)
       @GetMapping("/register")
       public String showRegistrationForm(HttpServletResponse response) {
           // Prevent browser from caching this page (essential for back/forward button disabling)
           response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
           response.setHeader("Pragma", "no-cache");
           response.setDateHeader("Expires", 0);
       
           return "register";  // register.html in /templates/
       }
       @PostMapping("/register")
       public String registerUser(@RequestParam String id,@RequestParam String sub,@RequestParam String clgn, 
         @RequestParam String ppa, Model model) {
           try {
               // Call service to register the user with hashed password
               userService.registerUser(id,sub,clgn,ppa);
   
               // Add a success message to the model and return the success view
               model.addAttribute("message", "DETAILS INSERTED          successfully!"); 
               return "logd";  // You can redirect to another page or show a success message
           } catch (Exception e) {
               // Add an error message if user registration fails
               model.addAttribute("message", e.getMessage());
               return "register";         
  }
}
@GetMapping("/documents")
public String getAllDocuments(Model model) {
    List<req> documents = userService.findall(); // fixed method name
    model.addAttribute("documents", documents);  
    return "documents"; // This points to documents.html
}
@GetMapping("/form-page")
public String gf(){
    return "form-page";
}
       @PostMapping("/submit-form")
       public String formp(@RequestParam String i,@RequestParam String name,@RequestParam 
String email, 
         @RequestParam String quali, Model model) {
           try {
               // Call service to register the user with hashed password
               userService.applij(i,name,email,quali);
   
               // Add a success message to the model and return the success view
               model.addAttribute("message", "DETAILS INSERTED         successfully!"); 
               return "form-page";  // You can redirect to another page or show a success message
           } catch (Exception e) {
               // Add an error message if user registration fails
               model.addAttribute("message", e.getMessage());
               return "errorp";
           }         
  }
 @GetMapping("/dele-doc")
    public String gdd() {
        return "dele-doc"; // Corrected the typo in the return string
    }

     @PostMapping("/dele-doc")
    public String deleteDocument(@RequestParam String id, RedirectAttributes redirectAttributes) {
        // Assuming userService.deleteUser(id) returns an Optional
        Optional<req> deletedDocument = userService.deleteUser(id);

        // Check if the document was deleted successfully
        if (deletedDocument.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "Document deleted successfully.");
        } else {
            redirectAttributes.addFlashAttribute("message", "Document not found or could not be deleted.");
        }

        // Redirect back to the form page
        return "redirect:/dele-doc";  // This ensures the message is shown on the same page after the redirect
    }
    //}
    //@PostMapping("/upd-d")
    //public String updp(@PathVariable id){
      //  if

    //}
 @GetMapping("/g-u")
    public String showSearchForm() {
        return "g-u";
    }

    // Step 2: Handle form submission and fetch user
    @PostMapping("/g-u")
    public String fetchUserById(@RequestParam String id, Model model) {
        Optional<req> user = userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "s-u";
        } else {
            model.addAttribute("message", "User not found.");
            return "error";
        }
    }

    // Step 3: Handle update request
    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute req updatedUser) {
        userService.updateUser(updatedUser);
        return "success"; // Show success page
    }
     @GetMapping("/g-j")
    public String enterIdForm() {
        return "g-j"; // Show the form
    }

    @PostMapping("/g-j")
    public String getUsersById(@RequestParam("i") String i, Model model) {
        List<appli> users = userService.getUsersById(i);
        if (users.isEmpty()) {
            return "userNotFound";
        } else {
            model.addAttribute("users", users);
            return "userList";
        }
    }

}//@GetMapping("/del")
//public String fetchEmplo() {
  //   userService.deluss();
    // return"dd";
//}