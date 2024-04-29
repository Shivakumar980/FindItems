package com.webdevproject.finditem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webdevproject.finditem.model.LostItemDetails;
import com.webdevproject.finditem.service.LostItemService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/li")
@Slf4j
public class LostItemController {
    
    @Autowired
    LostItemService lostItemService;

    @PostMapping("/postlostitem")
    public String postLostItem(@RequestBody LostItemDetails lostItemDetails) {
             System.out.println(lostItemDetails);
            Integer updatedCount = lostItemService.postLostItem(lostItemDetails);
            System.out.println("updatedCount "+updatedCount);
            if(updatedCount ==1)
            return "Item Added";

            return "Item Add Error";
        
    }


    @GetMapping("/lostitem/{userId}")
    public List<LostItemDetails> findMyPost(@PathVariable("userId") String userId) {
        
        return lostItemService.findMyPost(userId);
    }

    @GetMapping("/lostitem")
    public List<LostItemDetails> findAllPost() {
        
        return lostItemService.findAllPost();
    }

    
}
