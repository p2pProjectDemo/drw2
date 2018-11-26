package com.drww.entity;

/**
 * className:customer
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-22 09:06
 */
public class Customer {

   private Integer  userId;
   private  String userName;
   private  String passWord;
   private  String telephone;
   private  String recommend;  // 推荐人
    private  String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Customer() {
    }

    public Customer(Integer userId, String userName, String passWord, String telephone, String recommend, String nickName) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.telephone = telephone;
        this.recommend = recommend;
        this.nickName = nickName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }
}
