package iducs.springboot.bootjpa.service;

import iducs.springboot.bootjpa.domain.MemberDTO;
import iducs.springboot.bootjpa.entity.MemberEntity;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    int create(MemberDTO member);
    Optional<MemberEntity> readById(Long seq);
    // Optional<MemberEntity> readId(String id);
    List<MemberEntity> readAll();
    int update(MemberDTO member);
    int delete(MemberEntity member);
}
