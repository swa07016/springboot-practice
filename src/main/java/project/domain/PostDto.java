package project.domain;

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
    
    public String setTitle(String _title) {
        this.title = _title;
        return title;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String setContent(String _content) {
        this.content = _content;
        return content;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public String setTag(String _tag) {
        this.tag = _tag;
        return tag;
    }
    
    public String getTag() {
        return this.tag;
    }
    
    public String setThumbnail(String _thumbnail) {
        this.thumbnail = _thumbnail;
        return thumbnail;
    } 
    
    public String getThumbnail() {
        return this.thumbnail;
    }
}