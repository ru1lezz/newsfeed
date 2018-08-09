package com.sunggat.newsfeed.converter;

import com.sunggat.newsfeed.command.NewsCommand;
import com.sunggat.newsfeed.entity.News;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NewsCommandToNews implements Converter<NewsCommand, News> {

    private final CategoryCommandToCategory categoryConverter;

    public NewsCommandToNews(CategoryCommandToCategory categoryConverter) {
        this.categoryConverter = categoryConverter;
    }

    @Nullable
    @Override
    public News convert(NewsCommand newsCommand) {
        if(newsCommand == null) {
            return null;
        }

        final News news = new News();
        news.setId(newsCommand.getId());
        news.setName(newsCommand.getName());
        news.setContent(newsCommand.getContent());
        news.setPublishedDate(newsCommand.getPublishedDate());
        news.setCategory(categoryConverter.convert(newsCommand.getCategory()));
        return news;
    }
}
