package com.sunggat.newsfeed.bootstrap;

import com.sunggat.newsfeed.entity.Category;
import com.sunggat.newsfeed.entity.News;
import com.sunggat.newsfeed.repository.CategoryRepository;
import com.sunggat.newsfeed.repository.NewsRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class NewsBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;

    public NewsBootstrap(NewsRepository newsRepository, CategoryRepository categoryRepository) {
        this.newsRepository = newsRepository;
        this.categoryRepository = categoryRepository;
    }

    private List<News> getNews() {
        List<News> news = new ArrayList<>();
        Optional<Category> sportCategoryOptional = categoryRepository.findById(1L);
        News sportNews = new News();
        sportNews.setCategory(sportCategoryOptional.get());
        sportNews.setName("France is the winner of World Cup");
        sportNews.setContent("New World Cup Champion is France");
        sportNews.setPublishedDate(new Date());
        news.add(sportNews);

        Optional<Category> technologyCategoryOptional = categoryRepository.findById(3L);
        News technologyNews = new News();
        technologyNews.setCategory(technologyCategoryOptional.get());
        technologyNews.setName("Apple announces iPhone X");
        technologyNews.setContent("The future of the smartphone");
        technologyNews.setPublishedDate(new Date());
        news.add(technologyNews);

        return news;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        newsRepository.saveAll(getNews());
    }
}
