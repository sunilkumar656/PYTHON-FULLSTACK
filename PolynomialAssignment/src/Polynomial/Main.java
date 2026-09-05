
package Polynomial;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        int k = 7;

        BigInteger[] x = {
            BigInteger.valueOf(1),
            BigInteger.valueOf(2),
            BigInteger.valueOf(3),
            BigInteger.valueOf(4),
            BigInteger.valueOf(5),
            BigInteger.valueOf(6),
            BigInteger.valueOf(7)
        };

        BigInteger[] y = {
            new BigInteger("13444211440455345511", 6),
            new BigInteger("aed7015a346d635", 15),
            new BigInteger("6aeeb69631c227c", 15),
            new BigInteger("e1b5e05623d881f", 16),
            new BigInteger("316034514573652620673", 8),
            new BigInteger("2122212201122002221120200210011020220200", 3),
            new BigInteger("20120221122211000100210021102001201112121", 3)
        };

        for (int i = 0; i < k; i++) {
            System.out.println("x = " + x[i] + ", y = " + y[i]);
        }

        BigInteger answer = BigInteger.ZERO;

        for (int i = 0; i < k; i++) {

            BigInteger numerator = y[i];
            BigInteger denominator = BigInteger.ONE;

            for (int j = 0; j < k; j++) {

                if (i != j) {
                    numerator = numerator.multiply(x[j].negate());

                    denominator = denominator.multiply(
                        x[i].subtract(x[j])
                    );
                }
            }

            answer = answer.add(
                numerator.divide(denominator)
            );
        }

        System.out.println();
        System.out.println("Answer = " + answer);
    }
}

