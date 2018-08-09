package com.sunggat.newsfeed.repository;

import com.sunggat.newsfeed.entity.Category;
import com.sunggat.newsfeed.entity.News;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends CrudRepository<News, Long> {
    @Query("select n from News n where n.category.name = :categoryName")
    List<News> findByCategoryName(@Param("categoryName") String categoryName);
    @Query("select n from News n where lower(n.name) like concat('%', :search, '%') or lower(n.content) like concat('%', :search, '%') ")
    List<News> searchNews(@Param("search") String search);
}
