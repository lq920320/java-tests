package com.refactor.chapter01.ver02;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 顾客
 *
 * @author zetu
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
            Rental each = (Rental) rentals.nextElement();
            double thisAmount = amountFor(each);
            // add frequent renter points （累计常客积点。
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            // show figures for this rental（显示此笔租借记录）
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        // add footer lines（结尾打印）
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return result;
    }

    private double amountFor(Rental rental) {
        double thisAmount = 0;
        // determine amounts for each line
        switch (rental.getMovie().getPriceCode()) {
            // 取得影片出租价格
            // 普通片
            case Movie.REGULAR:
                thisAmount += 2;
                if (rental.getDaysRented() > 2) {
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                }
                break;
            // 新片
            case Movie.NEW_RELEASE:
                thisAmount += rental.getDaysRented() * 3;
                break;
            // 儿童。
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3) {
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                }
                break;
            default:
                break;
        }
        return thisAmount;
    }
}
