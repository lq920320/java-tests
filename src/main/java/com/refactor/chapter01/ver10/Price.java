package com.refactor.chapter01.ver10;

/**
 * @author qianliu
 */
public abstract class Price {
    /**
     * 取得价格代号
     *
     * @return {@link int}
     */
    abstract int getPriceCode();

    /**
     * 取得费用
     *
     * @param daysRented 租期
     * @return {@link double}
     */
    abstract double getCharge(int daysRented);
}
