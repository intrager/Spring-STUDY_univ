package iducs.springboot.bootjpa.domain;

import lombok.Builder;
import lombok.Data;

@Data   // @Getter, @Setter, @EqualsAndHashCode, @RequiredArgsConstructor 등을 합친 기능
@Builder    // builder().build()로 객체 생성, 초기화할 수 있도록 하는 설정
public class Memo { // DTO : Controller -> Service
    private Long mno;
    private String memoText;
}
