package iducs.springboot.bootjpa.repository;

import iducs.springboot.bootjpa.entity.MemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<MemoEntity, Long> {
    // Spring Data JPA를 데이터 엑세스를 담당하는 객체를 생성하는데 활용
}
