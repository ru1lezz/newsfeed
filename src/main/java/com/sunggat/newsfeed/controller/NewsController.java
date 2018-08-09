package com.sunggat.newsfeed.controller;

import com.sunggat.newsfeed.command.CategoryCommand;
import com.sunggat.newsfeed.command.NewsCommand;
import com.sunggat.newsfeed.service.CategoryService;
import com.sunggat.newsfeed.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class NewsController {
    private final NewsService newsService;
    private final CategoryService categoryService;

    public NewsController(NewsService newsService, CategoryService categoryService) {
        this.newsService = newsService;
        this.categoryService = categoryService;
    }

    @GetMapping({"", "/", "index"})
    public String showAllNews(Model model) {
        model.addAttribute("newsList", newsService.getNews());
        model.addAttribute("categories", categoryService.listAllCategories());
        return "index";
    }

    @GetMapping("news/create")
    public String createNews(Model model) {
        NewsCommand newsCommand = new NewsCommand();
        newsCommand.setCategory(new CategoryCommand());
        newsCommand.setPublishedDate(new Date());
        model.addAttribute("news", newsCommand);
        model.addAttribute("categories", categoryService.listAllCategories());
        return "newsform";
    }

    @GetMapping("news/{id}/update")
    public String updateNews(@PathVariable String id, Model model) {
        model.addAttribute("news", newsService.findById(Long.valueOf(id)));
        model.addAttribute("categories", categoryService.listAllCategories());
        return "newsform";
    }

    @PostMapping("news")
    public String saveOrUpdate(@ModelAttribute NewsCommand newsCommand) {
        newsCommand.setPublishedDate(new Date());
        newsService.saveNewsCommand(newsCommand);
        return "redirect:/index";
    }

    @GetMapping("news/{id}/delete")
    public String deleteNews(@PathVariable String id) {
        newsService.deleteById(Long.valueOf(id));
        return "redirect:/index";
    }

    @GetMapping("news/category/{categoryName}")
    public String showNewsByCategory(@PathVariable String categoryName, Model model) {
        model.addAttribute("news", newsService.getNewsByCategory(categoryName));
        model.addAttribute("categories", categoryService.listAllCategories());
        return "news-by-category";
    }

    @GetMapping("news/")
    public String searchNews(@RequestParam (value = "search", required = false) String search, Model model) {
        model.addAttribute("news", newsService.searchNews(search.toLowerCase()));
        model.addAttribute("categories", categoryService.listAllCategories());
        return "search-news-result";
    }
}
