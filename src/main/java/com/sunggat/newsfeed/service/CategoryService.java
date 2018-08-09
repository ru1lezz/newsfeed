package com.sunggat.newsfeed.service;

import com.sunggat.newsfeed.command.CategoryCommand;

import java.util.Set;

public interface CategoryService {

    Set<CategoryCommand> listAllCategories();
}
