package iducs.springboot.bootjpa.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_board")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;
    private String content;

    // foreign key
    @ManyToOne  // board to member. board가 Many, member가 One
    private MemberEntity writer;    // 연관관계 지정 or 1 : N 관계 연결, 두 객체를 연결 : left join

    public void changeTitle(String title) {
        this.title = title;
    }
    public void changeContent(String content) {
        this.content = content;
    }
}
/*
    현재 자바 관점(객체 관점)으로 보는 중
 */