package com.example.booksystem.service.Impl;

import com.example.booksystem.entity.Book;
import com.example.booksystem.entity.Borrow;
import com.example.booksystem.entity.User;
import com.example.booksystem.mapper.BookMapper;
import com.example.booksystem.mapper.BorrowMapper;
import com.example.booksystem.service.BorrowService;
import com.example.booksystem.util.DateUtil;
import com.example.booksystem.util.OutDateMessage;
import com.example.booksystem.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowMapper borrowMapper;

    @Autowired
    private BookMapper bookMapper;

    //获取用户所有借阅情况
    @Override
    public List<Borrow> getUserAllBorrow(Borrow borrow) {
        return borrowMapper.getAllBorrow(borrow);
    }


    //归还书籍的同时删除书现有书籍信息
    //添加事务 - 还书还一半
    @Override
    @Transactional
    public int backBook(Borrow borrow) throws ParseException {
        int bId = borrow.getBookId();
        Book book = bookMapper.queryById(bId);
        book.setbSurplus(book.getbSurplus() + 1);
        bookMapper.editBook(book);

        Borrow borrow1 = borrowMapper.getBorrow(borrow);
        int dateGap = (int) DateUtil.getDateGap(borrow1.getBorrowDate(), LocalDate.now().toString());
        borrowMapper.deleteBorrow(borrow);
        return dateGap;
    }

    /*
    借书流程： 判断用户是否已经借阅该书籍，判断用户是否存在逾期未还书籍，判断书籍是否还有余量
    不满足以上三者才可以借书
    返回值1-没有余量 2-已经借阅 3-存在逾期未还
     */
    @Override
    @Transactional
    public int borrowBook(Book book, User user) throws ParseException {
        if (book.getbSurplus() == 0) {
            return 1;
        }
        Borrow borrow = new Borrow();
        borrow.setUserId(user.getuId());
        borrow.setBookId(book.getbId());
        if (borrowMapper.getBorrow(borrow) != null) {
            return 2;
        }
        borrow.setUserId(user.getuId());
        borrow.setBookId(null);
        List<Borrow> allBorrow = borrowMapper.getAllBorrow(borrow);
        String now = LocalDate.now().toString();
        for(Borrow borrow1: allBorrow) {
            if (DateUtil.getDateGap(borrow1.getBorrowDate(), now) > 30) {
                return 3;
            }
        }
        borrow.setBookId(book.getbId());
        borrow.setBookName(book.getbName());
        borrow.setUserName(user.getuName());
        borrow.setBorrowDate(now);
        borrowMapper.addBorrow(borrow);
        //借阅成功书籍余量-1
        book.setbSurplus(book.getbSurplus() - 1);
        borrowMapper.surplusMinus(book);
        return 0;
    }

    //获取所有逾期书籍
    @Override
    public DataVO<Borrow> getAllOutDate(int page, int limit) throws ParseException {
        List<Borrow> allBorrow = borrowMapper.getAllBorrow(new Borrow());
        List<Borrow> outBorrow = new ArrayList<>();
        List<Borrow> show = new ArrayList<>();
        int count = outBorrow.size();
        int start = (page-1) * limit;

        String now = LocalDate.now().toString();
        for (Borrow borrow1: allBorrow) {
            if (DateUtil.getDateGap(borrow1.getBorrowDate(), now) > 30) {
                outBorrow.add(borrow1);
            }
        }

        for (int i = start; i < outBorrow.size() && i < start + limit; i++) {
            show.add(outBorrow.get(i));
        }

        DataVO<Borrow> borrowDataVO = new DataVO<>(0, "", show.size(), show);
        return borrowDataVO;
    }
}
