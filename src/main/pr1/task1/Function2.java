package main.pr1.task1;

public class Function2 {
    public static void execute(int[] array) {
        Tools tools = new Tools();

        MyForkJoin forkJoin = new MyForkJoin(array);
        forkJoin.fork();

        System.out.println(
                "Сумма элементов при помощи метода ForkJoin = " +
                        forkJoin.join()
        );
        tools.getElapsedTime();
        tools.getUsedMemory();
    }
}
