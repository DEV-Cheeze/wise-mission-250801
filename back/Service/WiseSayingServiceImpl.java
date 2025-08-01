package com.back.Service;

import com.back.Repository.MemoryWiseSayingRepository;
import com.back.Repository.WiseSayingRepository;
import com.back.domain.WiseSaying;

import java.util.List;

public class WiseSayingServiceImpl implements WiseSayingService{

    WiseSayingRepository wiseSayingRepository = new MemoryWiseSayingRepository();

    @Override
    public void createWiseSaying(WiseSaying wiseSaying) {
        //조건 1 : 특수문자 x
        checkSpecialWords(wiseSaying.getAuthor(), wiseSaying.getPoem()); //throws Exception
        wiseSayingRepository.save(wiseSaying);
    }

    @Override
    public void deleteWiseSaying(int wiseId) {
        wiseSayingIsExists(wiseId);
        wiseSayingRepository.deleteById(wiseId);
        System.out.println(wiseId + "번 명언이 삭제되었습니다.");
    }

    @Override
    public void updateWiseSaying(int id, String author, String poem) {
        WiseSaying ws = wiseSayingRepository.findById(id);
        ws.update(author, poem);
    }

    @Override
    public List<WiseSaying> viewAllWiseSaying() {
        return wiseSayingRepository.findAll();
    }

    @Override
    public WiseSaying findById(int wiseId){
        wiseSayingIsExists(wiseId);
        return wiseSayingRepository.findById(wiseId);
    }

    public void checkSpecialWords(String author, String poem) { //특수문자 체크
        boolean authorCheck = author.matches(".*[^a-zA-Z가-힣0-9 ].*");
        boolean poemCheck = poem.matches(".*[^a-zA-Z가-힣0-9 ].*");

        if (authorCheck || poemCheck) throw new RuntimeException("작가, 명언에서는 특수문자가 허용되지 않습니다.");
    }

    public void wiseSayingIsExists(int wiseId){
        WiseSaying wiseSaying = wiseSayingRepository.findById(wiseId);
        if(wiseSaying == null){
            throw new RuntimeException(wiseId + "번 명언은 존재하지 않습니다.");
        }
    }

}
