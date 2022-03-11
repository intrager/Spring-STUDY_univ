package iducs.springboot.boothello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComsoController {

    @GetMapping("/")
    public String home() {
        return "<h1>Spring Boot Hello</h1>";
    }
    @GetMapping("/sample")
    public String sample() {
        return "Spring Boot Sample";
    }

}
