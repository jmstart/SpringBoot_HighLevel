package com.jiaming.repository;

import com.jiaming.bean.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author jmstart
 * @create 2020-05-26 14:47
 */
public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {

}
