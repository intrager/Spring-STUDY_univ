package iducs.springboot.bootjpa;

import iducs.springboot.bootjpa.entity.MemberEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberTests {
    // POJO (Plain Old Java Object) : 가장 기본적인 자바 객체 형태-필드, getter, setter
    // Beans 규약을 준수, 생성자가 복잡하지 않음
    // DI(Dependency Injection) : 의존성 주입, Spring Framework가 의존성을 해결하는 방법

    @Test
    void contextLoads() {
        // Integer 데이터 흐름, Lambda 식 - 함수형 언어의 특징을 활용
        IntStream.rangeClosed(1, 50).forEach(i -> {
            MemberEntity member = MemberEntity.builder()
                    .id("id-" + i)
                    .pw("pw-" + i)
                    .name("name-" + i)
                    .email("email" + i + "@induk.ac.kr")
                    .build();
            // memberRepository.save(member);
        });
    }
}
