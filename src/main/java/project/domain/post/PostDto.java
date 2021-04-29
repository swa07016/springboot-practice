package project.domain.post;

public class PostDto {
    private String title;
    private String content;
    private String tag;
    private String thumbnail;    
    
    public PostDto(String _title, String _content, String _tag, String _thumbnail) {
        this.title = _title;
        this.content = _content;
        this.tag = _tag;
        this.thumbnail = _thumbnail;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public String getTag() {
        return this.tag;
    }
    
    public String getThumbnail() {
        return this.thumbnail;
    }
    
    
}