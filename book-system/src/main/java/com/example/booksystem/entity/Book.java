package com.example.booksystem.entity;


import lombok.Data;

import java.util.Date;

/*
	b_id INT PRIMARY KEY AUTO_INCREMENT,
	b_name VARCHAR(50) NOT NULL,
	b_publisher VARCHAR(50) NOT NULL,
	b_pubdate DATE NOT NULL,
	b_author VARCHAR(50) NOT NULL,
	b_digest VARCHAR(100) NOT NULL,
	b_sum INT NOT NULL,
	b_surplus INT NOT NULL
 */
public class Book {
    private Integer bId;
    private String bName;
    private String bAuthor;
    private String bPublisher;
    private String bPubdate;
    private String bDigest;
    private Integer bSum;
    private Integer bSurplus;

    public Book() {
    }

    public Book(Integer bId, String bName, String bAuthor, String bPublisher, String bDigest) {
        this.bId = bId;
        this.bName = bName;
        this.bPublisher = bPublisher;
        this.bAuthor = bAuthor;
        this.bDigest = bDigest;
    }

    public Book(String bName, String bAuthor, String bPublisher, String bPubdate, String bDigest, Integer bSum, Integer bSurplus) {
        this.bName = bName;
        this.bPublisher = bPublisher;
        this.bPubdate = bPubdate;
        this.bAuthor = bAuthor;
        this.bDigest = bDigest;
        this.bSum = bSum;
        this.bSurplus = bSurplus;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public String getbPublisher() {
        return bPublisher;
    }

    public void setbPublisher(String bPublisher) {
        this.bPublisher = bPublisher;
    }

    public String getbPubdate() {
        return bPubdate;
    }

    public void setbPubdate(String bPubdate) {
        this.bPubdate = bPubdate;
    }

    public String getbDigest() {
        return bDigest;
    }

    public void setbDigest(String bDigest) {
        this.bDigest = bDigest;
    }

    public Integer getbSum() {
        return bSum;
    }

    public void setbSum(Integer bSum) {
        this.bSum = bSum;
    }

    public Integer getbSurplus() {
        return bSurplus;
    }

    public void setbSurplus(Integer bSurplus) {
        this.bSurplus = bSurplus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bId=" + bId +
                ", bName='" + bName + '\'' +
                ", bAuthor='" + bAuthor + '\'' +
                ", bPublisher='" + bPublisher + '\'' +
                ", bPubdate='" + bPubdate + '\'' +
                ", bDigest='" + bDigest + '\'' +
                ", bSum=" + bSum +
                ", bSurplus=" + bSurplus +
                '}';
    }
}
