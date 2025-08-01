package com.back.Repository;

import com.back.domain.WiseSaying;

import java.util.*;

public class MemoryWiseSayingRepository implements WiseSayingRepository {

    private final Map<Integer, WiseSaying> Repository = new HashMap<>();
    private int sequence = 1;

    @Override
    public void save(WiseSaying wiseSaying) {
        wiseSaying.setId(sequence++);
        Repository.put(wiseSaying.getId(), wiseSaying);
        System.out.println(wiseSaying.getId() + "번 명언이 등록되었습니다.");
    }

    @Override
    public List<WiseSaying> findAll() {
        return new ArrayList<>(Repository.values());
    }

    @Override
    public WiseSaying findById(int id){
        return Repository.get(id);
    }

    @Override
    public void deleteById(int wiseId) {
        Repository.remove(wiseId);
    }

}
