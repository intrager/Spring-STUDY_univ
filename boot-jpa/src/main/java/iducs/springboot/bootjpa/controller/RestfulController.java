package iducs.springboot.bootjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {
    @GetMapping("/restful")
    public String getRestful() {
        // return "{\'attributeName\':\'attributeValue\'}";
        return "<h1>Hello Java</h1>";
    }
}
