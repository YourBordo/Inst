package com.netcracker.fapi.services;

import com.netcracker.fapi.entity.Likes;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LikeService {
    Likes find(long id);
    List<Likes> findByPostId(long postId);

}
