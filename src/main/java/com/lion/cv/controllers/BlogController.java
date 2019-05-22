package com.lion.cv.controllers;


import com.lion.cv.DataFiles.PostEntity;
import com.lion.cv.DataFiles.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/blog")
public class BlogController {
    public BlogController(PostRepository dataSources) {
        this.dataSources = dataSources;
    }

    PostRepository dataSources;



    @GetMapping
    public String ShowAll(Model model, Principal principal) {
        List<PostEntity> dataList = (List<PostEntity>) dataSources.findAll();
        Map<Long, String> imageMap = new HashMap<>();
        for (PostEntity item:dataList) {
            byte[] encode = Base64.getEncoder().encode(item.getByteFile());
            String encodedImage=new String(encode, StandardCharsets.UTF_8);
            imageMap.put(item.getId(), encodedImage);
        }
        model.addAttribute("imageMap", imageMap);
        model.addAttribute("dataClass", new PostEntity());
        model.addAttribute("datalist", dataList);
        return ("blog");
    }

    @PostMapping
    @RequestMapping("/delete")
    public String DeleteData(@RequestParam Long delete) {
        dataSources.deleteById(delete);
        return ("redirect:/");
    }
}
