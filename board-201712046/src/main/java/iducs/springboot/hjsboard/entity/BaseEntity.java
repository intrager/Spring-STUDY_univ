package iducs.springboot.hjsboard.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass   // @Table을 생성하지 않고, 서브 클래스에 추가
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public abstract class BaseEntity {
    /**
     * BaseEntity에 abstract를 쓴 이유가 뭐임?
     */
    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name = "moddate")
    private LocalDateTime modDate;
}
