package iducs.springboot.bootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/**
 * domain -> entity -> repository -> service -> controller -> view(open API : rest)
 * domain : DTO(data transfer object) 객체 dto List, client -> controller <-> service
 * entity : 개체, service <-> repository <-> DBMS
 */

/**
 * repository : 데이터 처리, 개체 중심
 * service : dto -> entity, entity -> dto + business logic (통계 처리, 업무 처리)
 * controller : 요청 처리, 객체 중심
 */

/**
 * OOP (Object-Oriented Programming) language + JCF + Generics
 * Lambda (1.8 ~ ) + Stream (import java.util.stream.Stream
 * vs. IOStream : System.out - PrintStream)
 * vs. Functional Language : python, Lisp, Scala, etc.
 */

@SpringBootApplication
public class BootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootJpaApplication.class, args);
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}

/*
    Stream<String> builderStream =
    Stream.<String>builder()
    .add("Eric").add("Elena").add("Java")
    .build();

    List<String> builderStream = new ArrayList<String>();
    builderStream.add("Eric");
    builderStream.add("Elena");
    builderStream.add("Java");
 */

/**
 * Delete 동작 : 폼을 띄운다 -> 삭제한다.
 * 1. URL : /members/{idx}/delform <---> '/members' + ${member.seq} + '/delform'
 * 2. Controller - @GetMapping('/members/{idx}/delform')
 *      public String getDelform(@PathVariable("idx") Long seq, Model model)
 *   // service & repository 활용 findById(seq) : seq에 해당하는 member 객체 가져오기
 *      model.addAttribute("member", member);   // member 속성이름, 값
 *      return "/members/delform";  // delform.html에 member 속성의 값을 넘김
 *
 * 3. URL : /members/delform
 * th:action="@{'/members/' + ${member.seq}}" th:object="${member}" th:method="delete"
 *
 * 4. Controller : @DeleteMapping('/members/{idx}') // {idx} member primary key
 *      public String getDelete(@ModelAttribute("member") Member member, Model model)
 *      1) memberService.deleteById(seq);   // idx로 식별되는 member 객체
 *      2) memberService.delete(member);    // member 객체
 *      return "redirect:/members";    // 다시 컨트롤러에게 요청 - /members : 목록
 *
 *   Model : Controller에서 form으로 전송할  애트리뷰트
 *   @ModelAttribute : form에서 전송된 애트리뷰트 객체 접근
 *
 *   /members/{idx} 입력      {idx} member primary key
 *
 *   URN + URL = URI
 *
 *   문제 해결
 *      URI + HTTP Method
 *      Create Read Update Delete, Partial Update
 *      ( (Get,) Post, Put, Delete, Patch)
 *   처리 요청 -> DTO -> Controller -> DTO -> Service -> Entity -> Repository -> DBMS
 *                      Controller <- DTO <-         <- Entity <-            <-
 *   Client          [<- View]                                       Spring JPA - Hibernate
 *                                                                   Spring Data JDBC-MyBatis
 *                                                                          JDBC
 *   - Controller : 요청 흐름 제어, Java Code <- Servlet
 *   - View : 응답(response)을 화면에 출력, Thymeleaf 활용
 *   - Service : 업무 처리 담당(통계, 검색, 정렬), DTO -> Entity, Entity -> DTO
 *   - Repository : 데이터 접근 처리
 *
 *   - 문제 범위 : 도메인, 업무 범위, 업무 관점의 객체, DTO
 *   - 자료라기 보다는 데이터 접근 관점, 엔티티 - 데이터 처리 관점의 객체, Entity
 *
 *   ######################################################################################### 5/19
 *   Controller <-> Service <-> Repository
 *   - View (Template Engine : Thymeleaf) 처리 방식
 *   - REST 방식
 *   - Domain(DTO, VO) vs Entity
 *
 *   DB 프로그래밍 기본 연산 : CRUD - JPA로 아주 쉽게 처리 가능
 *   - create, read(one, list), update, delete
 *
 *   Pagination
 *   - 단순 페이지 처리 vs 검색 조건에 따른 페이지 처리
 *   - Page, Pageable 클래스 활용
 *
 *   Sort
 *
 *   Search
 *   - 검색 조건과 관련 있음
 *  ######################################################################################### 5/26
 *  Entity -> Domain -> Repository -> Service 순으로 만들 예정
 *  1. 데이터베이스에 테이블 생성을 위한 entity 객체 정의
 *  2. entity 객체들간의 관계를 고려하여 domain 객체(dto 객체) 정의
 *  3. entity 객체를 활용하여 실제로 데이터베이스 접근(CRUD 연산 등)을 수행하는 repository 객체 정의 (@Repository - Querydsl, JPQL 추가)
 *  4. service 인터페이스와 service 구현체를 정의 (@Service)
 *  5. 요청의 흐름을 고려하여 URI에 매핑하는 controller 객체 정의 (메서드 지정)
 *  (@Controller)
 *  6.1 요청의 흐름에 따라 View단 처리 - HTML Template (Thymeleaf 같은 엔진 포함) 수정
 *  6.2 요청의 흐름에 맞게 자료 전달 (REST API 방식, 즉 RESTful API)
 *
 * Querydsl을 다루다보면 잘 입력했음에도 불구하고 의존성 오류가 자주 발생함. 이 부분에 대해서는 따로 포스팅을 해야겠음.
 * MyBatis를 굳이 쓰는 이유 중 하나가 될 수도 있겠다.
 *
 * Controller -> DTO/Domain -> Service -> Entity -> Repository -> DBMS
 * Controller <- DTO/Domain <- Service <- Entity <- Repository <- DBMS
 */