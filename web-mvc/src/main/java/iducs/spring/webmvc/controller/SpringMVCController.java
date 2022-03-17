package iducs.spring.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringMVCController {
    @GetMapping("/")
    public String getHome() {
        return "index";
    }
}
