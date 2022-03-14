package com.example.booksystem.service.Impl;

import com.example.booksystem.entity.Book;
import com.example.booksystem.mapper.BookMapper;
import com.example.booksystem.service.BookService;
import com.example.booksystem.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> queryAllBooks() {
        return bookMapper.queryBooks(new Book());
    }

    @Override
    public List<Book> queryBooksByBook(Book book) {
        return bookMapper.queryBooks(book);
    }

    @Override
    public int saveBook(Book book) {
        return bookMapper.saveBook(book);
    }

    @Override
    public int editBook(Book book) {
        return bookMapper.editBook(book);
    }

    @Override
    //返回0-该书籍已被借走，不可删除； 返回1-可以删除
    public int deleteBook(int id) {
        Book book = bookMapper.queryById(id);
        if (book.getbSurplus() != book.getbSum()) {
            return 0;
        }
        return bookMapper.deleteBook(id);
    }


    //根据分页信息进行查询
    @Override
    public DataVO<Book> queryByAll(Integer bId, String bName, String bPublisher, String bAuthor, String bDigest, Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();

        int start = (page-1) * limit;
        map.put("bId", bId);
        map.put("bName", bName);
        map.put("bPublisher", bPublisher);
        map.put("bAuthor", bAuthor);
        map.put("bDigest", bDigest);
        map.put("start", start);
        map.put("limit", limit);

        Book book = new Book();
        book.setbId(bId);
        book.setbAuthor(bAuthor);
        book.setbPublisher(bPublisher);
        book.setbName(bName);
        book.setbDigest(bDigest);
        int count = bookMapper.selectCount(book);
        List<Book> books = bookMapper.queryBooksByMap(map);
        DataVO<Book> dataVO = new DataVO<>(0, "", count, books);
        return dataVO;
    }

    @Override
    public int getCount(Book book) {
        return bookMapper.selectCount(book);
    }
}
