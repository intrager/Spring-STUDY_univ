package iducs.springboot.bootjpa.controller;

import iducs.springboot.bootjpa.domain.PageRequestDTO;
import iducs.springboot.bootjpa.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards")
public class BoardController {
    public final BoardService boardService;
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")
    public String getBoards(PageRequestDTO pageRequestDTO, Model model) {
        // ?page=nn&size=mm
        // new PageRequestDTO(3, 5) : 생성자를 호출하여 초기화
        // 11 ~ 15 번째의 레코드들을 접근함
        // PageRequestDTO.builder().build() or new PageRequestDTO()가 pageRequestDTO 매개변수에 배정
        model.addAttribute("list", boardService.getList(pageRequestDTO));
        return "/boards/boards";    // view resolving
    }
}
