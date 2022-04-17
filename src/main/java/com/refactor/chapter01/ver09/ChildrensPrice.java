package com.refactor.chapter01.ver09;

/**
 * @author qianliu
 */
public class ChildrensPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

}
