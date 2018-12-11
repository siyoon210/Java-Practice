package fastcampus3.javaexam.src.main.java.my.examples.javaexam.folderfile;

public class File {
    private String name;
    private long length;

    public File(String name){
        this.name = name;
    }

    public void rename(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setLength(long length){
        this.length = length;
    }

    public long getLength(){
        return length;
    }
}


