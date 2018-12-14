package my.examples.javaexam.folderfile;

import java.util.ArrayList;
import java.util.List;

public class File {
    private String name;
    private List<String> list;

    public File() {
        list = new ArrayList<>();
    }

    public List<String> getList() {
        return list;
    }

    public void getHashcode() {
        System.out.println(this.hashCode());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printList() {
        for (String str : list) {
            System.out.println(str);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
