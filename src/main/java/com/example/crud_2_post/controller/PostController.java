package com.example.crud_2_post.controller;

import com.example.crud_2_post.model.Post;
import com.example.crud_2_post.model.PostSearch;
import com.example.crud_2_post.model.Status;
import com.example.crud_2_post.model.User;
import com.example.crud_2_post.repository.PostRepository;
import com.example.crud_2_post.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @GetMapping
    public ResponseEntity<?> showAll() {
        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Post post) {
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Post post, @PathVariable Long id) {
        post.setId(id);
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        postRepository.deleteById(id);
        return new ResponseEntity<>("xoa thanh cong" , HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<?> search(@RequestBody PostSearch post){
        List<User> users = userRepository.getUsersByIdIn(post.getUserIds());
        List<Post> postList = postRepository.findAllByUserInAndStatus(users,post.getStatus());
        return new ResponseEntity<>(postList , HttpStatus.OK);
    }
    @GetMapping("/sort")
    public ResponseEntity<?> sort(){
        return new ResponseEntity<>(postRepository.findAllByOrderByLikesDesc(),HttpStatus.OK);
    }
    @GetMapping("/search2")
    public ResponseEntity<?> search2(@RequestBody Status status) {
        List<Post> posts = postRepository.findAllByStatus(status);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @GetMapping("/top4")
    public ResponseEntity<List<Post>> topbon() {
        List<Post> list = postRepository.findAllByOrderByLikesDesc();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
