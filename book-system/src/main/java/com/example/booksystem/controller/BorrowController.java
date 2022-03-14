package com.example.booksystem.controller;

import com.example.booksystem.entity.Book;
import com.example.booksystem.entity.Borrow;
import com.example.booksystem.entity.User;
import com.example.booksystem.service.BorrowService;
import com.example.booksystem.util.Const;
import com.example.booksystem.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

@RestController
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    //获取所有过期情况
    @RequestMapping("/getOutUsers")
    public DataVO getOutUsers(int page, int limit) throws ParseException {
        DataVO<Borrow> allOutDate = borrowService.getAllOutDate(page, limit);
        return allOutDate;
    }

    //查询用户借阅情况
    @RequestMapping("/getUserBorrow")
    public DataVO getUserBorrows(HttpSession session) {
        User user = (User) session.getAttribute(Const.USER);
        Borrow borrow = new Borrow();
        borrow.setUserId(user.getuId());
        List<Borrow> allBorrow = borrowService.getUserAllBorrow(borrow);
        DataVO dataVO = new DataVO(0, "", allBorrow.size(), allBorrow);
        return dataVO;
    }

    //借阅书籍
    //若借阅成功，返回前端信息；否则借阅失败
    @PostMapping("/borrowBook")
    public int checkBorrow(HttpSession session, Integer bId, String bName, Integer bSurplus) throws ParseException {
        User user = (User) session.getAttribute(Const.USER);
        Book book = new Book();
        book.setbId(bId);
        book.setbName(bName);
        book.setbSurplus(bSurplus);
        return borrowService.borrowBook(book, user);
    }

    //归还书籍 - 删除原有借书信息,书籍余量+1
    @PostMapping("/backBook")
    public int backBook(HttpSession session, Integer bookId) throws ParseException {
        Borrow borrow = new Borrow();
        User user = (User) session.getAttribute(Const.USER);
        borrow.setUserId(user.getuId());
        borrow.setBookId(bookId);
        return borrowService.backBook(borrow);
    }

    //查询
}
