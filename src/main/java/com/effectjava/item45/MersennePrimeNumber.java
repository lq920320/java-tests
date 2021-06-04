package com.effectjava.item45;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;

/**
 * 打印梅森素数
 *
 * @author zetu
 * @date 2021/5/12
 */
public class MersennePrimeNumber {

    private static final BigInteger TWO = BigInteger.valueOf(2L);

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    public static void main(String[] args) {
        // stream
//        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
//                .filter(mersenne -> mersenne.isProbablePrime(50))
//                .limit(10)
//                .forEach(System.out::println);

        // parallel stream
        primes().parallel().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(10)
                .forEach(System.out::println);
    }

}
