package com.netcracker.backend.controller;

import com.netcracker.backend.entity.Complaint;
import com.netcracker.backend.entity.Post;
import com.netcracker.backend.service.ComplaintService;
import com.netcracker.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Post getPostById(@PathVariable(name = "id")  long id) {
        return postService.find(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Post addPost(@RequestBody Post post) {
        return postService.add(post);
    }

}