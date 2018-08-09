package com.sunggat.newsfeed.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Size(max=255)
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedDate;
    @OneToOne
    private Category category;

    public News() {

    }

    public News(String name, String content, Date publishedDate) {
        this.name = name;
        this.content = content;
        this.publishedDate = publishedDate;
    }

    public News(String name, String content, Date publishedDate, Category category) {
        this.name = name;
        this.content = content;
        this.publishedDate = publishedDate;
        this.category = category;
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

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != null ? !id.equals(news.id) : news.id != null) return false;
        if (name != null ? !name.equals(news.name) : news.name != null) return false;
        if (content != null ? !content.equals(news.content) : news.content != null) return false;
        if (publishedDate != null ? !publishedDate.equals(news.publishedDate) : news.publishedDate != null)
            return false;
        return category != null ? category.equals(news.category) : news.category == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (publishedDate != null ? publishedDate.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
