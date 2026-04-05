package stream.task3;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;

public class FactorialManager {
    BigInteger calcFactorial(int number) throws IllegalArgumentException {
        try(ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            if (number < 0) throw new IllegalArgumentException();
            if (number <= 1) {
                return BigInteger.ONE;
            }

            FactorialTask factorialTask = new FactorialTask(number);
            return forkJoinPool.invoke(factorialTask);
        }
    }
}
