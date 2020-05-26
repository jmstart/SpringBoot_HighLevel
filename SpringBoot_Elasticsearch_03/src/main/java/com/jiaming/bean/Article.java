package com.jiaming.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author jmstart
 * @create 2020-05-26 14:06
 */
@Setter
@Getter
@ToString
@Document(indexName = "jiaming", type = "article")
public class Article {

    private Integer id;
    private String author;
    private String title;
    private String content;

    public Article() {
    }

    public Article(Integer id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }
}
