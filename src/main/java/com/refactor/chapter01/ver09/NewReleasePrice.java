package com.refactor.chapter01.ver09;

/**
 * @author qianliu
 */
public class NewReleasePrice extends Price {
	@Override
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
}