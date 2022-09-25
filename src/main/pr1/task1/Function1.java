package main.pr1.task1;

import java.util.Arrays;

public class Function1 {
    public void execute(int[] array) {
        int sum;
        Tools tools = new Tools();

        MyThread thread1 = new MyThread(
                Arrays.copyOfRange(
                        array,
                        0,
                        5000)
        );
        MyThread thread2 = new MyThread(
                Arrays.copyOfRange(
                        array,
                        5000,
                        10000)
        );

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ignored) {}

        sum = thread1.getSum() + thread2.getSum();

        System.out.println(
                "Сумма элементов при помощи многопоточного метода = " +
                        sum
        );
        tools.getElapsedTime();
        tools.getUsedMemory();
    }
}
