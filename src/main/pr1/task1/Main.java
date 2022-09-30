package main.pr1.task1;

import java.util.Random;

public class Main {
    static Random random = new Random();

    public static void main(String[] args)  {
        System.out.println("Замеры начались\n");
        int[] array = random.ints(
                10000,
                0,
                100)
                .toArray();

        Function0.execute(array);

        System.out.println("\n");
        Function1 function1 = new Function1();
        function1.execute(array);

        System.out.println("\n");
        Function2.execute(array);
    }
}

