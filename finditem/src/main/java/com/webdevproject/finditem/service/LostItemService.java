package com.webdevproject.finditem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdevproject.finditem.model.LostItemDetails;
import com.webdevproject.finditem.repository.LostItemRepo;

@Service
public class LostItemService {
    

@Autowired
LostItemRepo lostItemRepo;

    public Integer postLostItem(LostItemDetails lostItem) {
    

        return lostItemRepo.postLostItem(lostItem);
    }

    public List<LostItemDetails> findMyPost(String userId) {
    

        return lostItemRepo.findMyPost(userId);
    }

    public List<LostItemDetails> findAllPost() {
    

        return lostItemRepo.findAllPost();
    }
}
