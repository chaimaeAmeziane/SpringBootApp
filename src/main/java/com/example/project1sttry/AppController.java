package com.example.project1sttry;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String homePage()
    {
        return "index";
    }
}
