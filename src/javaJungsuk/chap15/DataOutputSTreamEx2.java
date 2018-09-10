package javaJungsuk.chap15;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class DataOutputSTreamEx2 {
    public static void main(String[] args) {
        ByteArrayOutputStream bos =null;
        DataOutputStream dos = null;

        byte[] result = null;

        try {
            bos = new ByteArrayOutputStream();
            dos = new DataOutputStream(bos);
            dos.writeInt(10);
            dos.writeFloat(20.0f);
            dos.writeBoolean(true);

            result = bos.toByteArray();

            String[] hex = new String[result.length];

            for(int i=0; i<result.length; i++){
                if(result[i] <0){
                    hex[i] = String.format("%02x", result[i]+256);
                    //부호가 있는 byte 단위의 범위는 -128~127 이기 때문에, 0~255사이의 값으로 변환하기 위해서 +256을 시행
                } else{
                    hex[i] =String.format("%02x", result[i]);
                }
            }

            System.out.println("10진수 : " + Arrays.toString(result));
            System.out.println("16진수 : " + Arrays.toString(hex));
            dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
