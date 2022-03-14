package com.example.booksystem.mapper;

import com.example.booksystem.entity.Book;
import com.example.booksystem.entity.Borrow;
import org.springframework.stereotype.Repository;


import java.util.List;
/*
借书步骤： 首先查询用户是否已借此书，其次查询用户是否存在逾期书籍，然后查询所借书籍是否有余量
不满足以上条件则可以进行借书
 */
@Repository
public interface BorrowMapper {

    //查询书籍余量
    int getSurplus(int id);

    //借/还书 原数据库余量-/+1
    int surplusMinus(Book book);

    //根据用户id与书籍id查询是否已借
    Borrow getBorrow(Borrow borrow);

    //借书 borrow表数据添加
    int addBorrow(Borrow borrow);

    //还书 borrow表数据减少
    int deleteBorrow(Borrow borrow);

    //查询所有借阅信息
    List<Borrow> getAllBorrow(Borrow borrow);
}
