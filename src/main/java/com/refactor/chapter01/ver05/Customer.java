package com.refactor.chapter01.ver05;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 客户端类
 *
 * @author 泽兔
 * @date 2022/4/17
 */
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
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + each.getCharge() + "\n";
        }
        // add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    /**
     * // 译注：此即所谓query method
     *
     * @return {@link double}
     */
    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

}