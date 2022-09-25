package main.pr1.task1;

public class Function0 {
    public static void execute(int[] array) {
        int sum = 0;
        Tools tools = new Tools();

        for (int i : array) {
            sum += i;
            try{
                Thread.sleep(1);
            }catch(InterruptedException ignored){}
        }

        System.out.println(
                "Сумма элементов при помощи последовательного метода = " +
                sum
        );
        tools.getElapsedTime();
        tools.getUsedMemory();
    }
}
