package com.back;

import com.back.Service.WiseSayingService;
import com.back.Service.WiseSayingServiceImpl;
import com.back.domain.WiseSaying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br;
        System.out.println("== 명언 앱 ==");

        WiseSayingService wService = new WiseSayingServiceImpl();

        while(true){
            br = new BufferedReader(new InputStreamReader(System.in));
            String cmd = br.readLine();
            if(cmd.equals("종료")) {
                System.out.println("명령) 종료");
                break;
            }else if(cmd.equals("등록")){
                System.out.println("명령) 등록");
                System.out.print("명언 : ");
                WiseSaying wiseSaying = new WiseSaying();
                BufferedReader poemInput = new BufferedReader(new InputStreamReader(System.in));
                String poem = poemInput.readLine();

                System.out.print("작가 : ");
                BufferedReader authorInput = new BufferedReader(new InputStreamReader(System.in));
                String author = authorInput.readLine();

                wiseSaying.setPoem(poem);
                wiseSaying.setAuthor(author);
                try{
                    wService.createWiseSaying(wiseSaying);
                }catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }else if(cmd.equals("목록")) {
                List<WiseSaying> list = wService.viewAllWiseSaying();
                System.out.println(
                        "번호 / 작가 / 명언\n" +
                        "----------------------");
                Collections.reverse(list);
                for(WiseSaying ws : list) {
                    int id = ws.getId();
                    String author = ws.getAuthor();
                    String poem = ws.getPoem();
                    System.out.println(id + " / " + author + " / " + poem);
                }
            }else if(cmd.contains("삭제?id=")) {
                int delId = Integer.parseInt(cmd.replaceAll("[^0-9]", ""));
                try{
                    wService.deleteWiseSaying(delId);
                }catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }else if(cmd.contains("수정?id=")) {
                int editId = Integer.parseInt(cmd.replaceAll("[^0-9]", ""));
                try{
                    WiseSaying wiseSaying = wService.findById(editId);

                    System.out.println("명언(기존) : " + wiseSaying.getPoem());

                    System.out.print("명언 : ");
                    BufferedReader poemInput = new BufferedReader(new InputStreamReader(System.in));
                    String poem = poemInput.readLine();

                    System.out.println("작가(기존) : " + wiseSaying.getAuthor());
                    System.out.print("작가 : ");
                    BufferedReader authorInput = new BufferedReader(new InputStreamReader(System.in));
                    String author = authorInput.readLine();

                    wService.updateWiseSaying(editId, author, poem);
                }catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }

        }

    }

}
