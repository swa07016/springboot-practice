package project.domain.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private String tag;
    private String thumbnail;    
    private String regdate;
    private String author;
    
    public Post(String _title, String _content, String _tag, String _thumbnail) {
        this.title = _title;
        this.content = _content;
        this.tag = _tag;
        this.thumbnail = _thumbnail;
    }
    
    
    public Post(Long _id, String _title, String _content, String _tag, String _thumbnail, String _regdate, String _author) {
        this.id = _id;
        this.title = _title;
        this.content = _content;
        this.tag = _tag;
        this.thumbnail = _thumbnail;
        this.regdate = _regdate;
        this.author = _author;
    }
    
    public Long setId(Long _id) {
        this.id = _id;
        return id;
    }
    
    public Long getId() {
        return this.id;
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
    
    public String setRegdate(String _regdate) {
        this.regdate = _regdate;
        return this.regdate;
    }
    
    public String getRegdate() {
        return this.regdate;
    }
    
    public String setAuthor(String _author) {
        this.author = _author;
        return this.author;
    }
    
    public String getAuthor() {
        return this.author;
    }

    public static class Builder {
        private Long id;
        private String title;
        private String content;
        private String tag;
        private String thumbnail;    
        private String regdate;
        private String author;
        
        public Builder(Long _id) {
            this.id = _id;
        }
        
        public Builder title(String _title) {
            this.title = _title;
            return this;
        }
        
        public Builder content(String _content) {
            this.content = _content;
            return this;
        }
    
        public Builder tag(String _tag) {
            this.tag = _tag;
            return this;
        }
        
        public Builder thumbnail(String _thumbnail) {
            this.thumbnail = _thumbnail;
            return this;
        } 
        
        public Builder regdate(String _regdate) {
            this.regdate = _regdate;
            return this;
        }
        
        public Builder author(String _author) {
            this.author = _author;
            return this;
        }
        
        public Post build() {
            return new Post(this);
        }
    }
    
    private Post(Builder builder) {
        title = builder.title;
        content = builder.content;
        tag = builder.tag;
        thumbnail = builder.thumbnail;   
        regdate = builder.regdate;
        author = builder.author;
    }
}