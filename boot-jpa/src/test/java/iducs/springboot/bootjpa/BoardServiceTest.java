package iducs.springboot.bootjpa;

import iducs.springboot.bootjpa.domain.Board;
import iducs.springboot.bootjpa.domain.PageRequestDTO;
import iducs.springboot.bootjpa.domain.PageResultDTO;
import iducs.springboot.bootjpa.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class BoardServiceTest {
    // 필드 주입은 트렌드가 아니다?! 생성자 주입이 직접적용, 지연적용, 안정성 면에서 더 좋지만 그냥 일단 필드 주입을 함.
    @Autowired
    BoardService boardService;

    @Test
    public void testRegister() {    // 이 코드들은 Controller로 감
        IntStream.rangeClosed(1, 47).forEach(i -> {
            Board dto = Board.builder()
                    .title("title" + i)
                    .content("Content...")
                    .writerSeq(Long.valueOf("" + i))
                    .build();
            Long bno = boardService.register(dto);
        });
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        pageRequestDTO.setPage(3);  // setPage(3)을 통해서 현재 페이지를 1 -> 3 설정
        pageRequestDTO.setSize(4);
        PageResultDTO<Board, Object[]> result = boardService.getList(pageRequestDTO);
        for(Board dto : result.getDtoList())    // 출력용
            System.out.println(dto.getBno() + " : " + dto.getTitle());
    }
}
/*  5/26
(conn=74) Cannot add or update a child row: a foreign key constraint fails (`db_b201712046`.`tbl_board`,
CONSTRAINT `FKfs6d82h100x9hlmi1lox61y81` FOREIGN KEY (`writer_seq`) REFERENCES `tbl_member` (`seq`))
--> member와 board는 1 : N 관계임. 실행했을 때 테이블은 생성됐지만, member에 대한 (1에 대한) 데이터가 없어서 참조를 못 해 발생한 문제
--> 즉, member에 대한 데이터를 먼저 만들 것
 */