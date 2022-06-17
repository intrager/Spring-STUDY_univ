package iducs.springboot.hjsboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
@EnableJpaAuditing
public class Board201712046Application {

    public static void main(String[] args) {
        SpringApplication.run(Board201712046Application.class, args);
    }

    @Bean // 메소드를 호출하여 Bean 객체를 생성
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() { // put, delete
        return new HiddenHttpMethodFilter();
    }
}
