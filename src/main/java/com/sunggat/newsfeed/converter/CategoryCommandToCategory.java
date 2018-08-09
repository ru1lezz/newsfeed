package com.sunggat.newsfeed.converter;

import com.sunggat.newsfeed.command.CategoryCommand;
import com.sunggat.newsfeed.entity.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Nullable
    @Override
    public Category convert(CategoryCommand categoryCommand) {
        if(categoryCommand == null) {
            return null;
        }

        final Category category = new Category();
        category.setId(categoryCommand.getId());
        category.setName(categoryCommand.getName());
        return category;
    }
}
