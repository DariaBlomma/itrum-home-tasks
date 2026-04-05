package stream.task3;

import java.math.BigInteger;

public class ForkJoinPoolExample {
    public static void main(String[] args) {
        try {
            int n = 50;
            FactorialManager factorialManager = new FactorialManager();
            BigInteger result = factorialManager.calcFactorial(n);
            System.out.println("Факториал " + n + "! = " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Something went wrong" + e);
        }
    }
}

