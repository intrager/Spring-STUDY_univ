package iducs.springboot.bootjpa.repository;

import iducs.springboot.bootjpa.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {
                                            // Generics는 엔티티와 Long으로
    @Modifying
    @Query("delete from ReplyEntity r where r.board.bno = :bno")
    void deleteByBno(@Param("bno") Long bno);
}
