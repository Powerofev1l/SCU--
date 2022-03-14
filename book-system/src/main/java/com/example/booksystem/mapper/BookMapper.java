package com.example.booksystem.mapper;

import com.example.booksystem.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BookMapper {
    //使用Book传参做模糊处理
    List<Book> queryBooks(Book books);

    //分页一次尝试
    List<Book> queryBooksByMap(Map map);

    //根据id查询book
    Book queryById(int id);

    //根据查询条件获取所得查询结果数量
    int selectCount(Book books);

    //保存书籍
    int saveBook(Book book);

    //编辑书籍 - 根据id
    int editBook(Book book);

    //删除书籍 - 根据id
    int deleteBook(int id);

}
