package iducs.springboot.bootjpa;

import iducs.springboot.bootjpa.entity.MemoEntity;
import iducs.springboot.bootjpa.repository.MemberRepository;
import iducs.springboot.bootjpa.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class FindByIdTests {
    // POJO (Plain Old Java Object) : 가장 기본적인 자바 객체 형태-필드, getter, setter
    // Beans 규약을 준수, 생성자가 복잡하지 않음
    // DI(Dependency Injection) : 의존성 주입, Spring Framework가 의존성을 해결하는 방법
    @Autowired
    MemoRepository memoRepository;  // MemoRepository 클래스형 객체를 Spring으로 생성

    @Test
    void testFindById() {
        Long mno = 100L;
        Optional<MemoEntity> result = memoRepository.findById(mno);
        if(result.isPresent()) {
            MemoEntity memo = result.get();
            System.out.println("해당 메모의 텍스트는 : " + memo.getMemoText());
        }
    }
}
