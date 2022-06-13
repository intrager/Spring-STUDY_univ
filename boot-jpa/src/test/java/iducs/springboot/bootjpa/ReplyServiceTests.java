package iducs.springboot.bootjpa;

import iducs.springboot.bootjpa.entity.BoardEntity;
import iducs.springboot.bootjpa.entity.ReplyEntity;
import iducs.springboot.bootjpa.repository.ReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyServiceTests {
    @Autowired
    ReplyRepository replyRepository;

    @Test
    public void testReplyInit() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Long seqLong = Long.valueOf(new Random().nextInt(10));
            seqLong = (seqLong == 0) ? 1 : seqLong;
            BoardEntity boardEntity = BoardEntity.builder()
                    .bno(seqLong)
                    .build();
            ReplyEntity replyEntity = ReplyEntity.builder()
                    .text("title" + 1)
                    .replier("Content - " + i)
                    .board(boardEntity)
                    .build();
            replyRepository.save(replyEntity);
        });
    }
}
