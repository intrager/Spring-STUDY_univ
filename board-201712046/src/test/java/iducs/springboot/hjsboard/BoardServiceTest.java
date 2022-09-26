package iducs.springboot.hjsboard;

import iducs.springboot.hjsboard.domain.Board;
import iducs.springboot.hjsboard.domain.PageRequestDTO;
import iducs.springboot.hjsboard.domain.PageResultDTO;
import iducs.springboot.hjsboard.entity.BoardEntity;
import iducs.springboot.hjsboard.repository.BoardRepository;
import iducs.springboot.hjsboard.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardServiceTest {
    // 필드 주입은 트렌드가 아니다?! 생성자 주입이 직접적용, 지연적용, 안정성 면에서 더 좋지만 그냥 일단 필드 주입을 함.
    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void testRegister() {    // 이 코드들은 Controller로 감
        IntStream.rangeClosed(1, 47).forEach(i -> {
            Board dto = Board.builder()
                    .title("title" + i)
                    .content("Content...")
                    .views(0L)
                    .writerSeq(Long.valueOf("" + i))
                    .build();
            boardService.register(dto);
        });
    }

//    @Test
//    public void testList() {
//        PageRequestDTO pageRequestDTO = new PageRequestDTO();
//        pageRequestDTO.setPage(3);  // setPage(3)을 통해서 현재 페이지를 1 -> 3 설정
//        pageRequestDTO.setSize(4);
//        PageResultDTO<Board, Object[]> result = boardService.getList(pageRequestDTO);
//        for(Board dto : result.getDtoList())    // 출력용
//            System.out.println(dto.getBno() + " : " + dto.getTitle());
//    }

    @Transactional
    @Test
    public void testLazyLoading() {
        Optional<BoardEntity> result = boardRepository.findById(10L);
        BoardEntity boardEntity = result.get();
        System.out.println(boardEntity.getTitle());
        System.out.println(boardEntity.getContent());
    }

    @Test
    public void testDeleteWithRepliesById() {
        Long bno = 3L;
        boardService.deleteWithRepliesById(bno);
    }
}
/*  5/26
(conn=74) Cannot add or update a child row: a foreign key constraint fails (`db_b201712046`.`tbl_board`,
CONSTRAINT `FKfs6d82h100x9hlmi1lox61y81` FOREIGN KEY (`writer_seq`) REFERENCES `tbl_member` (`seq`))
--> member와 board는 1 : N 관계임. 실행했을 때 테이블은 생성됐지만, member에 대한 (1에 대한) 데이터가 없어서 참조를 못 해 발생한 문제
--> 즉, member에 대한 데이터를 먼저 만들 것
 */