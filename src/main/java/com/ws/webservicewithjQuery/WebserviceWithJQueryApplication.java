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
  public User updateUser(@RequestBody User user, Integer id) {
    users.set(id, user);
    
    return user;
  }

  @DeleteMapping("/api/users/{id}")
  public User deleteUser(Integer id) {
    User deletedUser = users.get(id);
    users.remove(id);
    
    return deletedUser;
  }
}
