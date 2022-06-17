package iducs.springboot.hjsboard.controller;

import iducs.springboot.hjsboard.domain.Board;
import iducs.springboot.hjsboard.domain.Member;
import iducs.springboot.hjsboard.domain.PageRequestDTO;
import iducs.springboot.hjsboard.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/boards")
public class BoardController {

    public final BoardService boardService;
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")
    public String getBoards(PageRequestDTO pageRequestDTO, Model model) {
        model.addAttribute("list", boardService.getList(pageRequestDTO));
        return "/boards/list";    // view resolving
    }

    @GetMapping("/regform")
    public String getRegform(Model model) {
        model.addAttribute("board", Board.builder().build());
        return "/boards/regform";  // view resolving
    }

    @PostMapping("")
    public String postBoard(@ModelAttribute("board") Board board, Model model) {
        boardService.register(board);
        model.addAttribute("board", board);
        return "boards/list";
    }

    @GetMapping("/{bno}")
    public String getBoardView(@PathVariable("bno") Long seq, Model model) {
        Board board = boardService.getById(seq);
        model.addAttribute("board", board);
        return "/boards/read";
    }


}
