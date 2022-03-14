package com.example.booksystem.entity;


import lombok.Data;

import java.util.Date;

/*
	user_id INT NOT NULL,
	book_id INT NOT NULL,
	borrow_date DATE NOT NULL
 */
public class Borrow {
    private Integer userId;
    private Integer bookId;
    private String userName;
    private String bookName;
    private String borrowDate;

    public Borrow() {
    }

    public Borrow(Integer userId, Integer bookId, String borrowDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "userId=" + userId +
                ", bookId=" + bookId +
                ", borrowDate=" + borrowDate +
                '}';
    }
}
