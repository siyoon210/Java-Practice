package com.fastcampus3.businesscard.exam;

import java.io.File;

public class FileExam {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(".").append(File.separator).append("json_data").append(File.separator).append("json.json");

        File file = new File(sb.toString());
        if (file.exists()) {
            System.out.println("존재");
        } else {
            System.out.println("존재x");
        }
    }
}
