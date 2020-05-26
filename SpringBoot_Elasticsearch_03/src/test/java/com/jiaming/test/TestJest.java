package com.jiaming.test;

import com.jiaming.bean.Article;
import com.jiaming.repository.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jmstart
 * @create 2020-05-26 14:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void testSave() {

        Article article = new Article();
        article.setId(1);
        article.setAuthor("佳明");
        article.setTitle("Java算法编程");
        article.setContent("算法与数据结构、加Java知识心得");

        articleRepository.index(article);
    }
}
