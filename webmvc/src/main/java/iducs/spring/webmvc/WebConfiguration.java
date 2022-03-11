package iducs.spring.webmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 컴파일러에게 알려주는 주석
@Configuration
@EnableWebMvc
@ComponentScan  // 스프링이 찾아서 주입함
public class WebConfiguration implements WebMvcConfigurer {

}
