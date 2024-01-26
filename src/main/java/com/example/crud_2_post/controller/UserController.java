package com.example.crud_2_post.controller;
import com.example.crud_2_post.model.User;
import com.example.crud_2_post.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping
    public ResponseEntity showAll() {
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity add(@RequestBody User user) {
        return new ResponseEntity(userRepository.save(user), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity edit(@RequestBody User user, @PathVariable Long id) {
        user.setId(id);
        return new ResponseEntity(userRepository.save(user), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        userRepository.deleteById(id);
        return new ResponseEntity("xoa thanh cong" , HttpStatus.OK);
    }
}
