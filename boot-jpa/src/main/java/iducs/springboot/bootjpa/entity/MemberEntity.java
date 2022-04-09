package iducs.springboot.bootjpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="t_member")
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq;   // long 기본형 Wrapper 클래스

    @Column(length = 30, nullable = false)
    private String id;

    @Column(length = 20, nullable = false)
    private String pw;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 50, nullable = true)
    private String email;

    @Column(length = 30, nullable = true)
    private String phone;

    @Column(length = 100, nullable = true)
    private String address;
}
