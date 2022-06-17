package iducs.springboot.hjsboard.domain;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    private Long bno;
    private String title;
    private String content; // <- BoardEntity
    private LocalDateTime regDate;  // <-- BoardEntity <-- BaseEntity // 게시글 등록
    private LocalDateTime modDate;  // <-- BoardEntity <-- BaseEntity

    private Long writerSeq; // <- MemberEntity
    private String writerId;
    private String writerName;
    private String writerEmail;
}
