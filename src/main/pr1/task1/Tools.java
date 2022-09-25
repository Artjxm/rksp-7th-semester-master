package main.pr1.task1;

public class Tools {
    long
            initialTime,
            initialMemory;

    public Tools() {
        initialTime = System.nanoTime();
        initialMemory = Runtime.getRuntime().freeMemory();
    }

    public void getElapsedTime() {
        System.out.println(
                "Прошло времени: " +
                (System.nanoTime() - initialTime) * 1e-6  +
                " миллисекунд"
        );
    }

    public void getUsedMemory() {
        System.out.println(
                "Использовано памяти: " +
                Math.abs(Runtime.getRuntime().freeMemory() - initialMemory) / 1024 +
                " Мб"
        );
    }
}
