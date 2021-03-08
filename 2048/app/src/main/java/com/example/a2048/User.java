package com.example.a2048;


public class User {

    private String userName;
    private int userID;
    private int finalScore;
    private String country;

    public User(String userName, int userID, String country, int finalScore) {
        this.userName = userName;
        this.userID = userID;
        this.country = country;
        this.finalScore = finalScore;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

}
