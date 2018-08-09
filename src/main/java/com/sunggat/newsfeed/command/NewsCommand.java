package com.sunggat.newsfeed.command;

import com.sunggat.newsfeed.entity.Category;

import java.util.Date;

public class NewsCommand {
    private Long id;
    private String name;
    private String content;
    private Date publishedDate;
    private CategoryCommand category;

    public NewsCommand() {
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

    public CategoryCommand getCategory() {
        return category;
    }

    public void setCategory(CategoryCommand category) {
        this.category = category;
    }
}
