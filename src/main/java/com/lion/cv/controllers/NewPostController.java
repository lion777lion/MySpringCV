package com.lion.cv.controllers;


import com.lion.cv.DataFiles.PostEntity;
import com.lion.cv.DataFiles.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.security.Principal;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/new")
public class NewPostController {
    public NewPostController(PostRepository dataSources) {
        this.dataSources = dataSources;
    }

    PostRepository dataSources;

    @GetMapping
    public String AddPage(Model model){
        model.addAttribute("postClass", new PostEntity());
        return ("newpost");
    }

    @PostMapping
    public String AddNewData(@Valid @RequestParam MultipartFile file, PostEntity postClass, Principal principal) throws IOException {
        postClass.setName(principal.getName());
        byte[] byteFile = file.getBytes();
        LocalDateTime time = LocalDateTime.now();
        postClass.setByteFile(byteFile);
        postClass.setTime(time);
        dataSources.save(postClass);
        return ("redirect:/blog");
    }
}
