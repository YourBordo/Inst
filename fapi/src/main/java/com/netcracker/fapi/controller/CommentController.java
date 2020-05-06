package com.netcracker.fapi.controller;


import com.netcracker.fapi.entity.Comment;
import com.netcracker.fapi.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Comment getCommentById(@PathVariable(name = "id") long id) {
        return commentService.find(id);
    }

    @RequestMapping(value = "/post={id}", method = RequestMethod.GET)
    public List<Comment> getCommentByPostId(@PathVariable(name = "id") long id) {
        return commentService.findAllByPostId(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.add(comment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Comment deleteComment(@PathVariable(name = "id") Long id) {
        return commentService.delete(id);
    }

}
