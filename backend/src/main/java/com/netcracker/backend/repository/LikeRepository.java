package com.netcracker.backend.repository;

import com.netcracker.backend.entity.Likes;
import com.netcracker.backend.entity.Post;
import com.netcracker.backend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends CrudRepository<Likes, Long> {
    List<Likes> findAllByPostAndUser(Post post, User user);
    List<Likes> findAllByPostId(long postId);
    Likes findById(long id);
}
