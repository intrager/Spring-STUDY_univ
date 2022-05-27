package iducs.springboot.bootjpa.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import iducs.springboot.bootjpa.domain.Member;
import iducs.springboot.bootjpa.domain.PageRequestDTO;
import iducs.springboot.bootjpa.domain.PageResultDTO;
import iducs.springboot.bootjpa.entity.MemberEntity;
import iducs.springboot.bootjpa.entity.QMemberEntity;
import iducs.springboot.bootjpa.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class MemberServiceImpl implements MemberService {

    // service : controller <-> repository, domain to entity. entity to domain
    final MemberRepository memberRepository;  // DI(Dependency Injection)

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void create(Member member) {
        MemberEntity entity = dtoToEntity(member);
        memberRepository.save(entity);
    }

    @Override
    public Member readById(Long seq) {
        Member member = null;

        Optional<MemberEntity> result = memberRepository.findById(seq);
        if(result.isPresent()) {
            member = entityToDto(result.get());
        }
        /*
        MemberEntity result = memberRepository.getById(seq);
        member = entityToDto(result);
        */
        return member;
    }

    @Override
    public PageResultDTO<Member, MemberEntity> readListBy(PageRequestDTO pageRequestDTO) {
        Pageable pageable = pageRequestDTO.getPageable(Sort.by("seq").descending());
        BooleanBuilder booleanBuilder = findByCondition(pageRequestDTO);
        Page<MemberEntity> result = memberRepository.findAll(booleanBuilder, pageable);
        // Page<MemberEntity> result = memberRepository.findAll(pageable);
        Function<MemberEntity, Member> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result, fn);
    }

    private BooleanBuilder findByCondition(PageRequestDTO pageRequestDTO) {
        String type = pageRequestDTO.getType();
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        QMemberEntity qMemberEntity = QMemberEntity.memberEntity;

        BooleanExpression expression = qMemberEntity.seq.gt(0L);    // where seq > 0 and title == "ti"
        booleanBuilder.and(expression);

        if(type == null || type.trim().length() == 0) {
            return booleanBuilder;
        }
        String keyword = pageRequestDTO.getKeyword();

        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if(type.contains("e"))  // email로 검색
            conditionBuilder.or(qMemberEntity.email.contains(keyword));
        if(type.contains("p"))  // phone으로 검색
            conditionBuilder.or(qMemberEntity.phone.contains(keyword));
        if(type.contains("a"))  // address로 검색
            conditionBuilder.or(qMemberEntity.address.contains(keyword));
        booleanBuilder.and(conditionBuilder);
        return booleanBuilder;  // 완성된 조건 or 술어(predicate)
    }

    @Override
    public List<Member> readAll() {
        List<Member> members = new ArrayList<>();   // 반환 리스트 객체
        // JpaRepository 구현체의 메서드 findAll(), List<T>
        List<MemberEntity> entities = memberRepository.findAll();   // entity들
        for(MemberEntity entity : entities) {
            Member member = entityToDto(entity);
            members.add(member);
        }
        return members;
    }

    @Override
    public void update(Member member) {
        MemberEntity entity = dtoToEntity(member);
        memberRepository.save(entity);
    }

    @Override
    public void delete(Member member) {
        MemberEntity entity = dtoToEntity(member);
        memberRepository.deleteById(entity.getSeq());   // 유일키로 지운다
        // memberRepository.delete(entity);
    }

    @Override
    public Member readByName(Member member) {
        return null;
    }

    @Override
    public Member readByEmail(String email) {
        return null;
    }


    /**
     * 주의 : DTO와 Entity의 pk number의 자료형을 똑같이 맞출 것
     * @param member
     * @return
     */
    private MemberEntity dtoToEntity(Member member) {
        MemberEntity entity = MemberEntity.builder()
                .seq(member.getSeq())
                .id(member.getId())
                .pw(member.getPw())
                .name(member.getName())
                .email(member.getEmail())
                .phone(member.getPhone())
                .address(member.getAddress())
                .build();
        return entity;
    }

    // Service -> Controller : entity -> dto로 변환 후 반환
    private Member entityToDto(MemberEntity entity) {
        Member member = Member.builder()
                .seq(entity.getSeq())
                .id(entity.getId())
                .pw(entity.getPw())
                .name(entity.getName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .address(entity.getAddress())
                .build();
        return member;
    }
}
