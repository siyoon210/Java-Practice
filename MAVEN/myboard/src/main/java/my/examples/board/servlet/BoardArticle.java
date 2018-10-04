package my.examples.board.servlet;

import java.time.LocalDateTime;

public class BoardArticle {
    private Long cid;
    private String name;
    private String title;
    private String content;
    private LocalDateTime date;

    public BoardArticle() {
    }

    public BoardArticle(String name, String title, String content ) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now();
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
