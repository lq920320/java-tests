package com.refactor.chapter01.ver03;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    /**
     * 姓名
     */
    private String _name;
    /**
     * 租借记录
     */
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    ;

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        // 总消费金。
        double totalAmount = 0;
        // 常客积点
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            // 取得一笔租借记。
            Rental rental = (Rental) rentals.nextElement();
            // double thisAmount = rental.getCharge();
            // add frequent renter points （累计常客积点。
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            // show figures for this rental（显示此笔租借记录）
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + rental.getCharge() + "\n";
            totalAmount += rental.getCharge();
        }
        // add footer lines（结尾打印）
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return result;
    }

}
