package project.domain;

public class Post {
    
    private Long id;
    private String thumbnail;
    private String title;
    private String content;
    private String regdate;
    private String author;
    
    public Post(Long id, String title, String thumbnail,  String content, String regdate, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.regdate = regdate;
        this.author = author;
    }
    
    public Long getId() {
        return id;
    }
    
    public Long setId(Long _id) {
        this.id = _id;
        return _id;
    }
}