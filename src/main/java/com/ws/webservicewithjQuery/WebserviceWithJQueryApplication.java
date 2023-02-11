package com.ws.webservicewithjQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/api/users")
  public User createUser(@RequestBody User user) {
	if(user.getId() == null){
		 user.setId(++usersCount);  
	}  
	// add user to the users list
    users.add(user);
    
    return user;
  }

  @PutMapping("/api/users/{id}")
  public User updateUser(@RequestBody User user, @PathVariable int id) {
	  	  
	  User existingUser = findById(id);
	  
	  if (existingUser != null) {
	      existingUser.setName(user.getName());
	      existingUser.setEmail(user.getEmail());
	      
	      return existingUser;
	      
	  } else {
	      return null;
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
