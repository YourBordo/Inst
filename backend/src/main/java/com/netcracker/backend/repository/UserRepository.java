package com.netcracker.backend.repository;

import com.netcracker.backend.entity.Comment;
import com.netcracker.backend.entity.Post;
import com.netcracker.backend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByNickname(String nickname);
    User findById(long id);
    User findByEmail(String email);
    User findByComments(List<Comment> comments);
    User findByPosts(List<Post> posts);
}
