package iducs.springboot.bootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
// @RestController // 응답으로써 string 형을 브라우저에게 줌
public class JSPController {
    @GetMapping("/")
    public String getHome() {
        // return "<h1>RestController : 실제로 전달하고 싶은 내용";
        return "index"; // view의 이름
    }
}
