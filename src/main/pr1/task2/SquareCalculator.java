package main.pr1.task2;

import java.util.Random;
import java.util.concurrent.Callable;


public class SquareCalculator implements Callable<Integer> {
    private final int inputNumber;

    public SquareCalculator(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        Thread.sleep(random.ints(
                        1000,
                        6000)
                .findFirst()
                .getAsInt());
        int num = inputNumber * inputNumber;
        System.out.println("\nРезультат умножения числа " + inputNumber + " = " + num);
        return null;
    }
}
