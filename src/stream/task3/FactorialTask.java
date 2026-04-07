package stream.task3;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<BigInteger> {
    private final int start;
    private final int end;
    private final int THRESHOLD = 10;

    public FactorialTask(int number) {
        this.start = 2;
        this.end = number;
    }

    private FactorialTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected BigInteger compute() {
        if (end - start <= THRESHOLD) {
            System.out.println("Direct");
            BigInteger result = BigInteger.ONE;
            for (int i = start; i <= end; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }

            return result;
        }
        System.out.println("With pool");
        int mid = (start + end) / 2;
        FactorialTask leftTask = new FactorialTask(start, mid);
        FactorialTask rightTask = new FactorialTask(mid + 1, end);

        leftTask.fork();
        BigInteger rightResult =  rightTask.compute();
        BigInteger leftResult = leftTask.join();
        return leftResult.multiply(rightResult);
    }
}
