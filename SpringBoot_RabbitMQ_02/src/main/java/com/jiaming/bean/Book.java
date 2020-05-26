package com.jiaming.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author jmstart
 * @create 2020-05-24 13:06
 */
@Setter
@Getter
@ToString
public class Book {

    private String bookName;
    private String author;

    public Book() {
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }
}
