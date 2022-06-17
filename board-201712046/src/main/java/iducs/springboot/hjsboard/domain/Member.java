package iducs.springboot.hjsboard.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {    // 레코드(ResultSet 객체를 활용)를 객체로
    // 컴파일하면 객체가 생김
    // DTO(Data Transfer Object) : Client <-> Controller <-> Service
    // domain : Controller에서 주로 사용됨
    private Long seq;
    private String id;
    private String pw;
    private String name;
    private String email;
    private String phone;
    private String address;
    // Date : 날짜 시간 관련
}
