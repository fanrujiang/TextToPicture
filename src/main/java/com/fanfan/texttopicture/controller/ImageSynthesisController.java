package com.fanfan.texttopicture.controller;


import com.alibaba.dashscope.exception.NoApiKeyException;
import com.fanfan.texttopicture.service.ImageSynthesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ImageSynthesisController {

    @Autowired
    private ImageSynthesisService imageSynthesisService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/synthesize")
    public String synthesize(@RequestParam("size") String size, @RequestParam("prompt") String prompt, @RequestParam("style") String style, Model model) {
        try {
            List<String> imageUrls = imageSynthesisService.callImageSynthesis(1, size, prompt, style);
            model.addAttribute("imageUrls", imageUrls);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "result";
    }

    @PostMapping("/synthesize1")
    public List<String> synthesize1(@RequestParam("size") String size, @RequestParam("prompt") String prompt, @RequestParam("style") String style) throws NoApiKeyException {

        return imageSynthesisService.callImageSynthesis(1, size, prompt, style);
    }
}
