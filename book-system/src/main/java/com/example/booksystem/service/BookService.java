package com.example.booksystem.service;

import com.example.booksystem.entity.Book;
import com.example.booksystem.vo.DataVO;

import javax.xml.crypto.Data;
import java.util.List;

public interface BookService {

    List<Book> queryAllBooks();
    List<Book> queryBooksByBook(Book book);
    int getCount(Book book);
    int saveBook(Book book);
    int editBook(Book book);
    int deleteBook(int id);

    DataVO<Book> queryByAll(Integer bId, String bName, String bPublisher, String bAuthor, String bDigest, Integer page, Integer limit);
}
