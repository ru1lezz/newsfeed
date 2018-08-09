package com.sunggat.newsfeed.service;

import com.sunggat.newsfeed.command.NewsCommand;
import com.sunggat.newsfeed.converter.NewsCommandToNews;
import com.sunggat.newsfeed.converter.NewsToNewsCommand;
import com.sunggat.newsfeed.entity.News;
import com.sunggat.newsfeed.repository.CategoryRepository;
import com.sunggat.newsfeed.repository.NewsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final NewsToNewsCommand newsToNewsCommand;
    private final NewsCommandToNews newsCommandToNews;
    private final CategoryRepository categoryRepository;

    public NewsServiceImpl(NewsRepository newsRepository,
                           NewsToNewsCommand newsToNewsCommand,
                           NewsCommandToNews newsCommandToNews,
                           CategoryRepository categoryRepository) {
        this.newsRepository = newsRepository;
        this.newsToNewsCommand = newsToNewsCommand;
        this.newsCommandToNews = newsCommandToNews;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<News> getNews() {
        Set<News> newsSet = new HashSet<>();
        newsRepository.findAll().iterator().forEachRemaining(newsSet::add);
        return newsSet;
    }

    @Override
    public News findById(Long id) {
        return newsRepository.findById(id).get();
    }

    @Override
    @Transactional
    public NewsCommand saveNewsCommand(NewsCommand newsCommand) {
        News detachedNews = newsCommandToNews.convert(newsCommand);

        News savedNews = newsRepository.save(detachedNews);

        return newsToNewsCommand.convert(savedNews);
    }

    @Override
    public Set<News> getNewsByCategory(String categoryName) {
        Set<News> newsSet = new HashSet<>();
        newsRepository.findByCategoryName(categoryName).iterator().forEachRemaining(newsSet::add);
        return newsSet;
    }

    @Override
    public Set<News> searchNews(String search) {
        Set<News> newsSet = new HashSet<>();
        newsRepository.searchNews(search).iterator().forEachRemaining(newsSet::add);
        return newsSet;
    }

    @Override
    public void deleteById(Long id) {
        newsRepository.deleteById(id);
    }

}
