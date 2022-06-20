package iducs.springboot.hjsboard.repository;

import iducs.springboot.hjsboard.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchBoardRepository {
    BoardEntity searchBoard();
    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
