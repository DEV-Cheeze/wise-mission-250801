package com.back.Repository;

import com.back.domain.WiseSaying;

import java.util.List;

public interface WiseSayingRepository {

    void save(WiseSaying wiseSaying);
    List<WiseSaying> findAll();
    void deleteById(int wiseId);
    WiseSaying findById(int id);

}
