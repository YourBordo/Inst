package com.netcracker.fapi.controller;

import com.netcracker.fapi.entity.Likes;
import com.netcracker.fapi.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/post={id}", method = RequestMethod.GET)
    public List<Likes> getLikesByPostId(@PathVariable(name = "id")  long id) {
        return likeService.findByPostId(id);
    }

}
