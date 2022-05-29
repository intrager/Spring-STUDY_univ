package iducs.springboot.bootjpa.service;

import iducs.springboot.bootjpa.domain.Board;
import iducs.springboot.bootjpa.domain.PageRequestDTO;
import iducs.springboot.bootjpa.domain.PageResultDTO;
import iducs.springboot.bootjpa.entity.BoardEntity;
import iducs.springboot.bootjpa.entity.MemberEntity;
import iducs.springboot.bootjpa.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@Log4j2 // 화면에 출력되지 않고 로그 창에 뜸 -> 로그 파일에 저장됨, 시스템에 오류가 생겼을 때 등 오류를 남기기 위해서 사용하는 Annotation(도구)
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override   // From JpaRepository
    public Long register(Board dto) {   // Controller -> DTO 객체 -> Service
        log.info("board register : " + dto);
        BoardEntity boardEntity = dtoToEntity(dto);
        boardRepository.save(boardEntity);
        return boardEntity.getBno();    // 게시물 번호
    }

    @Override           // DTO    EN
    public PageResultDTO<Board, Object[]> getList(PageRequestDTO pageRequestDTO) {
        log.info(">>>>>" + pageRequestDTO);
                // EN       DTO
        Function<Object[], Board> fn =
                (entities -> entityToDto((BoardEntity) entities[0], // entities를 entity로 이름을 바꿔도 상관없음
                        (MemberEntity) entities[1], (Long) entities[2]));
        Page<Object[]> result =
                boardRepository.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("bno").descending()));
        return new PageResultDTO<>(result, fn);
    }
}
