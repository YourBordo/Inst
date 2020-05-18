package com.netcracker.backend.service;

import com.netcracker.backend.entity.Likes;
import com.netcracker.backend.entity.Post;
import com.netcracker.backend.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LikeService {
    Likes find(long id);
    List<Likes> findByPostId(long postId);

}
