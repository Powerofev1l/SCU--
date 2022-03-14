package com.example.booksystem.controller;

import com.example.booksystem.entity.Book;
import com.example.booksystem.service.BookService;
import com.example.booksystem.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/getAllBooks")
    @Deprecated
    public DataVO getAllBooks() {
        List<Book> books = bookService.queryAllBooks();
        int count = books.size();
        DataVO booksVO = new DataVO(0, "", count, books);
        return booksVO;
    }

    @RequestMapping("/selectBooks")
    @Deprecated
    public DataVO getAllBooks(Integer bId, String bName, String bPublisher, String bAuthor, String bDigest, Integer page, Integer limit) {
        Book book = new Book();
        book.setbId(bId);
        book.setbName(bName);
        book.setbPublisher(bPublisher);
        book.setbAuthor(bAuthor);
        book.setbDigest(bDigest);
        List<Book> books = bookService.queryBooksByBook(book);
        int count = books.size();
        DataVO booksVO = new DataVO(0, "", count, books);
        return booksVO;
    }

    @RequestMapping("/selectBooksPage")
    public DataVO getAllBooksPage(Integer bId, String bName, String bPublisher, String bAuthor, String bDigest, Integer page, Integer limit) {
        return bookService.queryByAll(bId, bName, bPublisher, bAuthor, bDigest, page, limit);
    }


    @PostMapping("/addBook")
    public Boolean addBooks(String bName, String bPublisher, String bAuthor, String bPubdate,
                            String bDigest, Integer bSum, Integer bSurplus) {
        if (bSum < 0) {
            return false;
        }
        bSurplus = bSum;
        Book book = new Book(bName, bAuthor, bPublisher, bPubdate, bDigest, bSum, bSurplus);
        return bookService.saveBook(book) != 0;
    }

    @PostMapping("/editBook")
    public Boolean editBook(Integer bId, String bName, String bAuthor, String bPublisher, String bDigest) {
        Book book = new Book(bId, bName, bAuthor, bPublisher, bDigest);
        return bookService.editBook(book) != 0;
    }

    //需先查询选书表中该书籍有无对应学生选择，若无可删，若有不可删
    @RequestMapping("/deleteBook")
    public Boolean deleteBook(Integer bId) {
        int jud = bookService.deleteBook(bId);
        return jud == 1;
    }

}
