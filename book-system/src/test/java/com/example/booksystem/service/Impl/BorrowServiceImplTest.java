package com.example.booksystem.service.Impl;

import com.example.booksystem.entity.Book;
import com.example.booksystem.entity.Borrow;
import com.example.booksystem.entity.User;
import com.example.booksystem.service.BorrowService;
import com.example.booksystem.vo.DataVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BorrowServiceImplTest {

    @Autowired
    private BorrowService borrowService;

    @Test
    void getUserAllBorrow() {
    }

    @Test
    void backBook() {
    }

    @Test
    void borrowBook() throws ParseException {
        Book book = new Book();
        User user = new User();
        book.setbId(2);
        book.setbName("haha");
        book.setbSurplus(1);
        user.setuId(1);
        user.setuName("heyhey");
        borrowService.borrowBook(book, user);
    }

    @Test
    void getAllOutDate() throws ParseException {
        DataVO<Borrow> allOutDate = borrowService.getAllOutDate(1, 5);
        System.out.println(allOutDate.getData().toString());
    }
}