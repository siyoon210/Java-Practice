package fastcampus3.javaexam.src.main.java.my.examples.javaexam.folderfile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Folder {
    private String name;
    private List<File> files;
    private List<Folder> folders;

    // 기본 생성자는 생성자가 하나 없을 경우에 자동으로 생성된다.
    // 기본 생성자가 아닐 경우엔 사용자가 직접 만들어준다.
    // 생성자는 메소드와 비슷하지만 return타입이 없고, 클래스명과 이름이 같다.
    // 생성자는 필드를 초기화하는 코드를 가지고 있다.
    public Folder(String name){
        this.name = name;
        files = new ArrayList<>();
        folders = new ArrayList<>();
    }

    public void rename(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public long getLength(){
        return 0; //TODO length는 계산되야한다.
    }

    public void add(File file){
        files.add(file);
    }

    public void deleteFile(String fileName){
        // TODO fileName으로 파일을 지운다.
    }

    // 토론꺼리. 왜 files 를 리턴하지 않고, files.iterator()를 리턴할까?
    public Iterator<File> fileIterator(){
        return files.iterator();
    }

    public void add(Folder folder){
        folders.add(folder);
    }

    public void deleteFolder(String folderName){
        // TODO folderName으로 폴더를 삭제한다.
    }

    public Iterator<Folder> foderIterator(){
        return folders.iterator();
    }

}

// Folder folder = new Folder();
// 인스턴스 생성부터 필드에 값을 가지게 만드는 방법이 필요하다.
// 생성할 때 이름값을 넘겨줄 필요가 있다. 생성자를 이용.
// Folder folder = new Folder("영화");
