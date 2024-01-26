package com.example.crud_2_post.repository;

import com.example.crud_2_post.model.Post;
import com.example.crud_2_post.model.Status;
import com.example.crud_2_post.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
//    List<Blog> findAllByUserIdAndAndStatusContainingIgnoreCase(Long userId, String status);
//    List<Blog> findAllByStatusContainingIgnoreCase(String status);
//    List<Blog> findAllByOrderByLikeCount();
//    List<Blog> findAllByOrderByLikeCountDesc();

    List<Post> findAllByUserInAndStatus(List<User> users, Status status);
    List<Post> findAllByOrderByLikesDesc();
    List<Post> findAllByStatus(Status status);
    List<Post> findTop4ByOrderByLikesDesc();
}
