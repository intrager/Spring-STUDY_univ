package iducs.springboot.bootjpa.domain;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {    // 레코드(ResultSet 객체를 활용)를 객체로
    private Long seq;
    private String id;
    private String pw;
    private String name;
    private String email;
    private String phone;
    private String address;
}
