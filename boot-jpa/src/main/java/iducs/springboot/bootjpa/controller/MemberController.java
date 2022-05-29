package iducs.springboot.bootjpa.controller;

import iducs.springboot.bootjpa.domain.Member;
import iducs.springboot.bootjpa.domain.PageRequestDTO;
import iducs.springboot.bootjpa.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members") // localhost:8888/memobers로 시작
public class MemberController {

    final MemberService memberService;
    // 생성자 주입 : (Constructor Injection) vs. @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // registration form 멤버 등록 페이지
    @GetMapping("/regform")
    public String getRegform(Model model) {
        // 정보를 전달받을 빈(empty) 객체를 보냄
        model.addAttribute("member", Member.builder().build());
        return "/members/regform";  // view resolving
    }

    // 멤버 등록
    @PostMapping("")
    public String postMember(@ModelAttribute("member") Member member, Model model) {
        memberService.create(member);
        model.addAttribute("member", member);
        return "/members/member";
    }

    // 멤버 메인 페이지
    @GetMapping("")
    public String getMembers(PageRequestDTO pageRequestDTO, Model model) {
        // PageRequestDTO.builder().build() or new PageRequestDTO() 가 pageRequestDTO 매개변수에 배정
        // 정보를 전달받을 빈(empty) 객체를 보냄
        // List<Member> members = memberService.readAll();
        model.addAttribute("list", memberService.readListBy(pageRequestDTO));   // .getDtoList()까지 쓰는 건 비추
        return "/members/members";
    }

    // 상세 페이지   // /members/일련변호 - @PathVariable 매핑해서 접근
    @GetMapping("/{idx}")
    public String getMember(@PathVariable("idx") Long seq, Model model) {
        Member member = memberService.readById(seq);
        model.addAttribute("member", member);
        return "/members/member";   // view resolving : member.html
    }

    // 수정 페이지
    @GetMapping("/{idx}/upform")
    public String getUpform(@PathVariable("idx") Long seq, Model model) {
        // 정보를 전달받을 빈(empty) 객체를 보냄
        Member member = memberService.readById(seq);
        model.addAttribute("member", member);
        return "/members/upform";
    }

    // 멤버 정보 수정
    @PutMapping("/{idx}")
    public String putMember(@ModelAttribute("member") Member member, Model model) { // ModelAttribute는 form에서 가져오는 거
        memberService.update(member);
        model.addAttribute("member", member);
        return "/members/member";
    }

    // 삭제 페이지
    @GetMapping("/{idx}/delform")
    public String getDelform(@PathVariable("idx") Long seq, Model model) {
        // 정보를 전달받을 빈(empty) 객체를 보냄
        Member member = memberService.readById(seq);
        model.addAttribute("member", member);
        return "/members/delform";
    }

    // 멤버 삭제
    @DeleteMapping("/{idx}")
    public String deleteMember(@ModelAttribute("idx") Long seq) {
        Member member = memberService.readById(seq);
        memberService.delete(member);
        return "redirect:/members";
    }
}
