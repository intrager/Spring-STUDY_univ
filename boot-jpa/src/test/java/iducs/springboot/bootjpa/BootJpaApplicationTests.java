package iducs.springboot.bootjpa;

import iducs.springboot.bootjpa.entity.MemberEntity;
import iducs.springboot.bootjpa.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
class BootJpaApplicationTests {

    // POJO(Plain Old Java Object) : 가장 기본적인 자바 객체 형태-필드, getter, setter
    // Beans 규약을 준수, 생성자가 복잡하지 않음
    // DI(Dependency Injection) : 의존성 주입, Spring Framework가 의존성을 해결하는 방법
    @Autowired
    MemberRepository memberRepository;  // MemberRepository 클래스형 객체를 Spring을 통하여 생성

    // sequence number 1 ~ 50 넣을거니까 상관없지? 라는 의미의 테스트 코드
    @Test   // Unit Test : JUnit 도구 활용 -> 통합 테스트(Integration Test)
    void contextLoads() {
        // Integer 데이터 흐름, Lambda식 - 함수형 언어의 특징을 활용
        IntStream.rangeClosed(1, 50).forEach(i -> {
            MemberEntity member = MemberEntity.builder()
                    .id("id " + i)
                    .pw("pw " + i)
                    .name("name " + i)
                    .email("email " + new Random().nextInt(100))
                    .phone("phone " + new Random().nextInt(50))
                    .address("address " + i)
                    .build();
            memberRepository.save(member);
        });
    }
}
