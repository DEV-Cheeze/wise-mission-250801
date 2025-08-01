package com.back.Service;

import com.back.domain.WiseSaying;

import java.util.List;

public interface WiseSayingService {

    void createWiseSaying(WiseSaying wiseSaying);
    void deleteWiseSaying(int wiseId);
    void updateWiseSaying(int id, String Author, String poem);
    WiseSaying findById(int wiseId);
    List<WiseSaying> viewAllWiseSaying();

}
