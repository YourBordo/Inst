package com.netcracker.backend.repository;

import com.netcracker.backend.entity.Comment;
import com.netcracker.backend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    Comment findById(long id);
    List<Comment> findAllByPostId(long id);
}
