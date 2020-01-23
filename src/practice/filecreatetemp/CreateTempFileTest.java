package practice.filecreatetemp;

import java.io.File;
import java.io.IOException;

public class CreateTempFileTest {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                final File tempFile = File.createTempFile("pre", ".suff");
                System.out.println("tempFile.getName() = " + tempFile.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
