package main.pr1.task2;

import java.util.Scanner;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вводите числа для нахождения их квадрата, " +
                "либо 0 для завершения программы: ");

        int num;
        while (true) {
            num = scanner.nextInt();
            if (num == 0) break;
        FutureTask<Integer> task = new FutureTask<>(new SquareCalculator(num));
        new Thread(task).start();
        }

        scanner.close();
    }
}
