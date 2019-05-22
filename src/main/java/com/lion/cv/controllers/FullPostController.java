package com.lion.cv.controllers;

import com.lion.cv.DataFiles.PostEntity;
import com.lion.cv.DataFiles.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fullpost")
public class FullPostController {
    PostRepository dataSources;
    PostEntity postClass;
    @Autowired
    public FullPostController(PostRepository dataSources) {
        this.dataSources = dataSources;
    }


    @GetMapping
    public String OpenFullPost(@RequestParam Long id, Model model){
        Map<Long, String> imageMap = new HashMap<>();
        List<PostEntity> dataList = (List<PostEntity>) dataSources.findAll();
        for (PostEntity post:dataList){
            if(post.getId().equals(id)){
                postClass = post;
            }
        }
        byte[] encode = Base64.getEncoder().encode(postClass.getByteFile());
        String encodedImage=new String(encode, StandardCharsets.UTF_8);
        imageMap.put(postClass.getId(), encodedImage);
        model.addAttribute("imageMap", imageMap);
        model.addAttribute("yourpost" , postClass);
        return ("fullpost");
    }


}
