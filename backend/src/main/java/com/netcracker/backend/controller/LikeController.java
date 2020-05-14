package com.netcracker.backend.controller;

import com.netcracker.backend.entity.Likes;
import com.netcracker.backend.entity.Post;
import com.netcracker.backend.entity.User;
import com.netcracker.backend.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    LikeService likeService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Likes getLike(@PathVariable(name = "id")  long id) {
        return likeService.find(id);
    }

    @RequestMapping(value = "/post/", method = RequestMethod.GET)
    public List<Likes> getLikesByPost(@RequestBody Post post) {
        return likeService.find(post);
    }

}
