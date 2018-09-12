package fastcampus.io.file;

import java.io.File;

    public class FileExam02 {
        public static void main(String[] args) {
            File file = new File("."); //현재경로
            System.out.println("절대경로 :"+file.getAbsolutePath());
            //자바 머츄얼머신은 해당 프로젝트 디렉토리에서 실행된다는걸 알 수 있다.
        }
}
