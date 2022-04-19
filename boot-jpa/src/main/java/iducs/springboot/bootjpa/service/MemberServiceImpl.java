package iducs.springboot.bootjpa.service;

import iducs.springboot.bootjpa.domain.MemberDTO;
import iducs.springboot.bootjpa.entity.MemberEntity;
import iducs.springboot.bootjpa.repository.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    final MemberRepository memberRepository;  // DI(Dependency Injection)

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public int create(MemberDTO member) {
        int ret = 0;
        try {
            MemberEntity entity = MemberEntity.builder()
                    .seq(member.getSeq())
                    .id(member.getId())
                    .pw(member.getPw())
                    .name(member.getName())
                    .email(member.getEmail())
                    .phone(member.getPhone())
                    .address(member.getAddress())
                    .build();
            memberRepository.save(entity);
            ret++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Optional<MemberEntity> readById(Long seq) {
        return memberRepository.findById(seq);
    }

//    @Override
//    public Optional<MemberEntity> readId(String id) {
//        return Optional.empty();
//    }

    @Override
    public List<MemberEntity> readAll() {
        return memberRepository.findAll();
    }

    @Override
    public int update(MemberDTO member) {
        int ret = 0;
        try {
            MemberEntity entity = MemberEntity.builder()
                    .seq(member.getSeq())
                    .id(member.getId())
                    .pw(member.getPw())
                    .name(member.getName())
                    .email(member.getEmail())
                    .phone(member.getPhone())
                    .address(member.getAddress())
                    .build();
            memberRepository.save(entity);
            ret++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public int delete(MemberEntity member) {
        int ret = 0;
        try {
            memberRepository.delete(member);
            ret++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
