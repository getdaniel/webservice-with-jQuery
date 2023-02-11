package com.ws.webservicewithjQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class WebserviceWithJQueryApplication {
  private static List<User> users = new ArrayList<>();
  public static int usersCount = 6;

  static {
    users.add(new User(1, "Dagimawi Amare", "dagim@example.com"));
    users.add(new User(2, "Daniel Getaneh", "dan@example.com"));
    users.add(new User(3, "Dejen Aschalew", "dej@example.com"));
    users.add(new User(4, "Desalegn", "desie@example.com"));
    users.add(new User(5, "Mebratu Awoke", "mebrat@example.com"));
    users.add(new User(6, "Minuyelet Entewew", "muller@example.com"));
  }

  public static void main(String[] args) {
    SpringApplication.run(WebserviceWithJQueryApplication.class, args);
  }

  @GetMapping("/api/users")
  public List<User> getUsers() {
    return users;
  }
  
  @GetMapping("/api/users/{id}")
  public User retriveUser(@PathVariable int id) {
	  User user = findById(id);
	  
	  if (user == null) {
		  System.out.println("Id: " + id + " not found!");
	  }
	  
	  return user;
  }
  
  @PostMapping("/api/users")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    if (user.getName() == null || user.getName().trim().length() == 0 ||
        user.getEmail() == null || user.getEmail().trim().length() == 0) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    if (user.getId() == null) {
      user.setId(++usersCount);  
    }
    
    users.add(user);
  		
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }

  @PutMapping("/api/users/{id}")
  public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int id) {

    User existingUser = findById(id);

    if (existingUser != null) {
        if(user.getName().isEmpty() || user.getEmail().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        return new ResponseEntity<>(existingUser, HttpStatus.OK);

    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/api/users/{id}")
  public void deleteUser(@PathVariable int id) {
	  
	    users.remove(findById(id));
  }
  
  //method that find a particular user from the list 
  public User findById(Integer id) {
	  for(User user:users) {
		  if(user.getId() == id)
			  return user;
	  }
	  return null;
  }  
}