package my.examples.guestbook.servlet;

import java.time.LocalDateTime;

public class Guestbook {
    private  Long id;
    private String name;
    private String content;
    private LocalDateTime regate;

    public Guestbook(){
        regate = LocalDateTime.now();
    }

    public Guestbook(String name, String content){
        this();//자신의 기본 생성자 호출
        this.name = name;
        this.content = content;
    }
    public Guestbook(Long id, String name, String content){
        this(name, content);//자신의 기본 생성자 호출
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getRegate() {
        return regate;
    }

    public void setRegate(LocalDateTime regate) {
        this.regate = regate;
    }
}
