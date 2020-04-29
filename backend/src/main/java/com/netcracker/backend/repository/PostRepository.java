package com.netcracker.backend.repository;

import com.netcracker.backend.entity.Complaint;
import com.netcracker.backend.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository  extends CrudRepository<Post, Long> {
    Post findById(long id);
    List<Post> findAllByUserId(long id);
}
