package com.sunggat.newsfeed.service;

import com.sunggat.newsfeed.command.NewsCommand;
import com.sunggat.newsfeed.entity.News;

import java.util.Set;

public interface NewsService {
    Set<News> getNews();
    News findById(Long id);
    NewsCommand saveNewsCommand(NewsCommand newsCommand);
    Set<News> getNewsByCategory(String categoryName);
    Set<News> searchNews(String search);
    void deleteById(Long id);
}
