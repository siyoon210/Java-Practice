package com.fastcampus3.businesscard;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        List<BusinessCard> businessCardList = new ArrayList<>();
        businessCardList.add(new BusinessCard(1,"홍길동", "010-1234-3456", "활빈당"));
        BusinessCard businessCard = new BusinessCard(2, "둘리", "010-1134-9999", "고길동네");
        businessCardList.add(businessCard);
        businessCardList.forEach(System.out::println);

        System.out.println("---");
        businessCardList.forEach(System.out::println);


        String bcToJson = null;
        String fileName = "." + File.separator + "json_data" + File.separator + "json.json";

        //File에 쓰기
        try {
            StringReader sr = new StringReader(bcToJson);
            FileWriter fw = new FileWriter(fileName);

            int data = 0;
            while ((data = sr.read()) != -1) {
                fw.write(data);
            }
            sr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //File에서 읽어오기
        try {
            FileReader fr = new FileReader(fileName);
            int data = 0;

            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }

            System.out.println();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
