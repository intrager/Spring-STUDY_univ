package iducs.springboot.bootjpa.controller;

import iducs.springboot.bootjpa.entity.MemberEntity;
import iducs.springboot.bootjpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class MemoController {

    @Autowired
    MemberService memberService;
    // MemberService ms = new MemberServiceImpl();

    @GetMapping("/404")
    public String get404() {
        return "404";
    }
    @GetMapping("/blank")
    public String getBlank() {
        return "blank";
    }
    @GetMapping("/buttons")
    public String getButtons() {
        return "buttons";   // http://localhost:8888/buttons.html
    }
    @GetMapping("/cards")
    public String getCards() {
        return "cards";
    }
    @GetMapping("/forgot-password")
    public String getForgotPassword() {
        return "forgot-password";
    }
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }
    @GetMapping("/utilities-animation")
    public String getUtilitiesAnimation(){
        return "utilities-animation";
    }
    @GetMapping("/utilities-border")
    public String getUtilitiesBorder(){
        return "utilities-border";
    }
    @GetMapping("/utilities-color")
    public String getUtilitiesColor(){
        return "utilities-color";
    }
    @GetMapping("/utilities-other")
    public String getUtilitiesOther(){
        return "utilities-other";
    }

    @GetMapping("/th")
    public String getThymeleaf() {
        return "thymeleaf";
    }

    // tables.html 파일 리팩토링
    // 실질적으로 static과 templates가 최상위 디렉토리이다.
    @GetMapping("/tables")
    public String getTables() {
        return "tables";
    }
    @GetMapping("/charts")
    public String getCharts() {
        return "charts";
    }

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
}
