package com.ws.webservicewithjQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class WebserviceWithJQueryApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(WebserviceWithJQueryApplication.class, args);
//	}
//
//}
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class WebserviceWithJQueryApplication {
  private static List<User> users = new ArrayList<>();

  static {
    users.add(new User("Alice", "alice@example.com"));
    users.add(new User("Bob", "bob@example.com"));
    users.add(new User("Charlie", "charlie@example.com"));
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
    users.add(user);
    return user;
  }

  @PutMapping("/api/users/{index}")
  public User updateUser(@PathVariable int index, @RequestBody User user) {
    users.set(index, user);
    return user;
  }

  @DeleteMapping("/api/users/{index}")
  public void deleteUser(@PathVariable int index) {
    users.remove(index);
  }
}

class User {
  private String name;
  private String email;

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
