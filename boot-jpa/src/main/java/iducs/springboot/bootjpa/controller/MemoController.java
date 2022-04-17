package iducs.springboot.bootjpa.controller;

import iducs.springboot.bootjpa.domain.Memo;
import iducs.springboot.bootjpa.entity.MemberEntity;
import iducs.springboot.bootjpa.service.MemberService;
import iducs.springboot.bootjpa.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/memos")
public class MemoController {
    // MemoService 인터페이스로부터 구현 가능한 객체를 생성해서 주입
    // Spring Bean 객체로 구현했기 때문에 Spring이 주입할 수 있음

    final MemoService memoService;  // 참조변수명 memoService

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    // registration form
    @GetMapping("/regform")
    public String getRegform(Model model) {
        model.addAttribute("memo", Memo.builder().build());
        return "/memos/regform";
    }

    // HttpServletRequest request
    @PostMapping("")
    public String postMemo(@ModelAttribute("memo") Memo memo, Model model) {
        memoService.create(memo);
        model.addAttribute("memo", memo);
        return "/memos/memo";
    }

    @GetMapping("")
    public String getMemos(Model model) {
        List<Memo> memos = memoService.readAll();
        model.addAttribute("list", memos);
        return "/memos/home";
    }

    @GetMapping("/{idx}")
    public String getMemo(@PathVariable("idx") Long mno, Model model) {
        Memo memo = memoService.readById(mno);
        model.addAttribute("memo", memo);
        return "/memos/memo";
    }

    // localhost:8888/memos/13/upform
    @GetMapping("/{idx}/upform")
    public String getUpform(@PathVariable("idx") Long mno, Model model) {
        Memo memo = memoService.readById(mno);  // entity -> domain
        model.addAttribute("memo", memo);
        return "/memos/upform";
    }

    @PutMapping("/{idx}")
    public String putMemo(@ModelAttribute("memo") Memo memo, Model model) {
        memoService.update(memo);
        model.addAttribute("memo", memo);
        return "/memos/memo";
    }

    @DeleteMapping("/{idx}")
    public String deleteMemo(@ModelAttribute("idx") Long mno) {
        memoService.delete(mno);
        return "redirect:/memos";
    }
}
