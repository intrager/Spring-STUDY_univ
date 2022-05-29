package iducs.springboot.bootjpa.repository;

import iducs.springboot.bootjpa.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {
                                            // Generics는 엔티티와 Long으로
}
