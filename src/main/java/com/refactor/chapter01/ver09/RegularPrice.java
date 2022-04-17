package com.refactor.chapter01.ver09;

/**
 * @author qianliu
 */
public class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

}