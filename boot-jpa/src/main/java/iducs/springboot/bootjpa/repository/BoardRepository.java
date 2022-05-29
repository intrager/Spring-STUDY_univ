package iducs.springboot.bootjpa.repository;

import iducs.springboot.bootjpa.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    @Query("select b, w from BoardEntity b left join b.writer w where b.bno =:bno")
    Object getBoardWithWriter(@Param("bno") Long bno);

    // JPQL : Java
    @Query(value = "select b, w, count(r) " +
        "from BoardEntity b left join b.writer w " +
        "left join ReplyEntity r on r.board = b " +
        "group by b",
        countQuery = "select count(b) from BoardEntity b")
    Page<Object[]> getBoardWithReplyCount(Pageable pageable);
}
// 교수님께서는 왜 이 Query 구문이 나오는 코드를 좋아하지 않는다고 하신 걸까
//// 개인적으로는 JPA라지만, 그래도 query를 가끔씩은 쳐보는 것도 이유가 있어서가 아닐까 생각한다.