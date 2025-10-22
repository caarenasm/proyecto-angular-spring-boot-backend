package com.springboot.backend.andres.usersapp.users_backend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.andres.usersapp.users_backend.entities.User;
import com.springboot.backend.andres.usersapp.users_backend.services.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService service;
    @GetMapping
    public List<User> list()  {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> show(@PathVariable Long id) {
        Optional<User> userOptional = service.findById(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }
    
   @PutMapping("/{id}")
   public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
    Optional<User> useOptional = service.findById(id);

        if (useOptional.isPresent()) {
            User userDB = useOptional.get();
            userDB.setEmail(user.getEmail());
            userDB.setLastname(user.getLastname());
            userDB.setName(user.getName());
            userDB.setPassword(user.getPassword());
            userDB.setPassword(user.getPassword());
            return ResponseEntity.ok(service.save(userDB));
        }
       return ResponseEntity.notFound().build();
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {
    Optional<User> useOptional = service.findById(id);
        if (useOptional.isPresent()) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
   } 
}
