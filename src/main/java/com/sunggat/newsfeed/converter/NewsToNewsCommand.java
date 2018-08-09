package com.sunggat.newsfeed.converter;

import com.sunggat.newsfeed.command.NewsCommand;
import com.sunggat.newsfeed.entity.News;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NewsToNewsCommand implements Converter<News, NewsCommand> {

    private final CategoryToCategoryCommand categoryConverter;

    public NewsToNewsCommand(CategoryToCategoryCommand categoryConverter) {
        this.categoryConverter = categoryConverter;
    }

    @Nullable
    @Override
    public NewsCommand convert(News news) {
        if(news == null) {
            return null;
        }

        NewsCommand newsCommand = new NewsCommand();
        newsCommand.setId(news.getId());
        newsCommand.setName(news.getName());
        newsCommand.setContent(news.getContent());
        newsCommand.setPublishedDate(news.getPublishedDate());
        newsCommand.setCategory(categoryConverter.convert(news.getCategory()));
        return newsCommand;
    }
}
