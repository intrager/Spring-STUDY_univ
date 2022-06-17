package iducs.springboot.hjsboard.service;

import iducs.springboot.hjsboard.domain.Board;
import iducs.springboot.hjsboard.domain.PageRequestDTO;
import iducs.springboot.hjsboard.domain.PageResultDTO;
import iducs.springboot.hjsboard.entity.BoardEntity;
import iducs.springboot.hjsboard.entity.MemberEntity;
import org.springframework.stereotype.Service;

@Service
public interface BoardService {
    Long register(Board dto);   // Board : DTO or Domain, create
    PageResultDTO<Board, Object[]> getList(PageRequestDTO pageRequestDTO);  // read list
    Board getById(Long bno);
    Long modify(Board dto);
    void deleteById(Long bno);

    /**
     * 문법이 추가된 것 (Java8 ~)
     * 저 인터페이스로부터 구현하는 메서드들은
     */
    default BoardEntity dtoToEntity(Board dto) {
        MemberEntity member = MemberEntity.builder()
                .seq(dto.getWriterSeq())
                .build();
        BoardEntity board = BoardEntity.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
        return board;
    }
    default Board entityToDto(BoardEntity entity, MemberEntity member) {
        Board dto = Board.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writerSeq(member.getSeq())
                .writerId(member.getId())
                .writerName(member.getName())
                .writerEmail(member.getEmail())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }
}
