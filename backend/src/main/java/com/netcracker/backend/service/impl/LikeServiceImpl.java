package com.netcracker.backend.service.impl;

import com.netcracker.backend.entity.Likes;
import com.netcracker.backend.entity.Post;
import com.netcracker.backend.entity.User;
import com.netcracker.backend.repository.LikeRepository;
import com.netcracker.backend.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;

    @Override
    public Likes find(long id) {
        return likeRepository.findById(id);
    }

}
