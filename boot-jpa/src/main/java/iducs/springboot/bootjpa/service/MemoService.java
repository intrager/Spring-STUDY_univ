package iducs.springboot.bootjpa.service;

import iducs.springboot.bootjpa.domain.Memo;

import java.util.List;

public interface MemoService {
    void create(Memo memo);
    Memo readById(Long mno);
    List<Memo> readAll();
    void update(Memo memo);
    void delete(Long mno);
}
