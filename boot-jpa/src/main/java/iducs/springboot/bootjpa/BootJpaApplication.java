package iducs.springboot.bootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/**
 * domain -> entity -> repository -> service -> controller -> view(open API : rest)
 * domain : DTO(data transfer object) 객체 dto List, client -> controller <-> service
 * entity : 개체, service <-> repository <-> DBMS
 */

/**
 * repository : 데이터 처리, 개체 중심
 * service : dto -> entity, entity -> dto + business logic (통계 처리, 업무 처리)
 * controller : 요청 처리, 객체 중심
 */

/**
 * OOP (Object-Oriented Programming) language + JCF + Generics
 * Lambda (1.8 ~ ) + Stream (import java.util.stream.Stream
 * vs. IOStream : System.out - PrintStream)
 * vs. Functional Language : python, Lisp, Scala, etc.
 */

@SpringBootApplication
public class BootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootJpaApplication.class, args);
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}

/*
    Stream<String> builderStream =
    Stream.<String>builder()
    .add("Eric").add("Elena").add("Java")
    .build();

    List<String> builderStream = new ArrayList<String>();
    builderStream.add("Eric");
    builderStream.add("Elena");
    builderStream.add("Java");
 */