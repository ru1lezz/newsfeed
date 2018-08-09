package com.sunggat.newsfeed.converter;

import com.sunggat.newsfeed.command.CategoryCommand;
import com.sunggat.newsfeed.entity.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Nullable
    @Override
    public CategoryCommand convert(Category category) {
        if(category != null) {
            final CategoryCommand categoryCommand = new CategoryCommand();
            categoryCommand.setId(category.getId());
            categoryCommand.setName(category.getName());
            return categoryCommand;
        }
        return null;
    }
}
