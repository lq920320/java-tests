package com.refactor.chapter01.ver02;

/**
 * 电影类
 *
 * @author 泽兔
 */
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public String getTitle() {
        return _title;
    }

    public void setPriceCode(int priceCode) {
        _priceCode = priceCode;
    }

}