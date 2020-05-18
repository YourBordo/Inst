package com.netcracker.fapi.services.impl;

import com.netcracker.fapi.entity.Likes;
import com.netcracker.fapi.entity.Post;
import com.netcracker.fapi.services.LikeService;
import com.netcracker.fapi.services.PostService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class LikeServiceImpl implements LikeService {

    @Value("${backend.server.url}")
    private String BackendUrl;


    @Override
    public Likes find(long id) {
        RestTemplate restTemplate = new RestTemplate();
        Likes like = restTemplate.getForObject(BackendUrl + "/api/like/" + id, Likes.class);
        return like;
    }

    @Override
    public List<Likes> findByPostId(long postId) {
        RestTemplate restTemplate = new RestTemplate();
        Likes[] likes = restTemplate.getForObject(BackendUrl + "/api/like/post="+postId, Likes[].class);
        return Arrays.asList(likes);

    }
}