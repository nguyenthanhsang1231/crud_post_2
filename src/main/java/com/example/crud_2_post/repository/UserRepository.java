package com.example.crud_2_post.repository;

import com.example.crud_2_post.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getUsersByIdIn(List<Long> ids);
}
