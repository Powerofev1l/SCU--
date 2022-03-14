package com.example.booksystem.service;

import com.example.booksystem.entity.Book;
import com.example.booksystem.entity.Borrow;
import com.example.booksystem.entity.User;
import com.example.booksystem.util.OutDateMessage;
import com.example.booksystem.vo.DataVO;

import java.text.ParseException;
import java.util.List;

public interface BorrowService {

    //获取用户所有借书情况
    List<Borrow> getUserAllBorrow(Borrow borrow);

    //还书
    int backBook(Borrow borrow) throws ParseException;

    //执行借书逻辑 - 根据返回值判断归还情况
    int borrowBook(Book book, User user) throws ParseException;

    //获取所有逾期用户(用户id，用户名，书id，书名)
    DataVO<Borrow> getAllOutDate(int page, int limit) throws ParseException;
}
