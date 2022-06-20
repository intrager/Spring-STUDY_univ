package iducs.springboot.hjsboard.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="reply201712046")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "board")
public class ReplyEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String text;
    private String replier;

    @ManyToOne(fetch = FetchType.LAZY)
    private BoardEntity board;
}
