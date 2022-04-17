package iducs.springboot.bootjpa.controller;

import iducs.springboot.bootjpa.entity.MemberEntity;
import iducs.springboot.bootjpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/members")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/{idx}")
    public String getMember(@PathVariable("idx") Long seq, Model model) {
        Optional<MemberEntity> member = memberService.readById(seq);
        MemberEntity m = member.get();
        model.addAttribute("member", m);
        return "charts";
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        List<MemberEntity> list = memberService.readAll();
        model.addAttribute("members", list);
        return "index";
    }

    // MemberService ms = new MemberServiceImpl();
    @GetMapping("/buttons") // url - http://localhost:8888/buttons
    public String getButtons() {
        return "buttons"; // http://localhost:8888/buttons.html
    }
    @GetMapping("/cards") // url - http://localhost:8888/buttons
    public String getCards() {
        return "cards"; // http://localhost:8888/buttons.html
    }
    @GetMapping("/th")
    public String getThymeleaf() {
        return "thymeleaf";
    }
    @GetMapping("/tables")
    public String getTables() {
        return "tables";
    }
    @GetMapping("/charts")
    public String getCharts() {
        return "charts";
    }
}
