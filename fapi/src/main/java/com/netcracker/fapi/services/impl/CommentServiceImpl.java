package com.netcracker.fapi.services.impl;


import com.netcracker.fapi.entity.Comment;
import com.netcracker.fapi.entity.Complaint;
import com.netcracker.fapi.services.CommentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class CommentServiceImpl implements CommentService {

    @Value("${backend.server.url}")
    private String BackendUrl;


    @Override
    public Comment find(long id) {
        RestTemplate restTemplate = new RestTemplate();
        Comment comment = restTemplate.getForObject(BackendUrl + "/api/comment/" + id, Comment.class);
        return comment;
    }

    @Override
    public List<Comment> findAllByPostId(long id) {
        RestTemplate restTemplate = new RestTemplate();
        Comment[] comments = restTemplate.getForObject(BackendUrl +
                "/api/comment/post="+id, Comment[].class);
        return Arrays.asList(comments);
    }

    @Override
    public Comment add(Comment comment) {
        RestTemplate restTemplate = new RestTemplate();
        Comment comment1 = restTemplate.postForObject(BackendUrl + "/api/comment/",comment, Comment.class);
        return comment1;
    }

    @Override
    public Comment delete(long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BackendUrl + "/api/comment/" + id);
        return null;
    }
}
