package iducs.springboot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloApplication {

    @GetMapping("/")
    public String home() {
        return "<h1>Welcome Home</h1>";
    }

    @GetMapping("/comso")
    public String comso() {
        return "<h1>Hello Comso Student</h1>";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

}
