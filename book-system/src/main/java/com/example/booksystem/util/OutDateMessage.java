package com.example.booksystem.util;

public class OutDateMessage {
    private Integer uId;
    private Integer bId;
    private String uName;
    private String bName;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    @Override
    public String toString() {
        return "OutDateMessage{" +
                "uId=" + uId +
                ", bId=" + bId +
                ", uName='" + uName + '\'' +
                ", bName='" + bName + '\'' +
                '}';
    }
}
