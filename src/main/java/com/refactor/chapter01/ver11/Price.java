package com.refactor.chapter01.ver11;

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

//	public int getFrequentRenterPoints(int daysRented) {
//		if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
//			return 2;
//		else
//			return 1;
//	}

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
