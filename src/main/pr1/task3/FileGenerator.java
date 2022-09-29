package main.pr1.task3;

import java.util.ArrayDeque;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;

public class FileGenerator {
    public ExecutorService executor = Executors.newSingleThreadExecutor();
    String[] types = new String[] { "XML", "JSON", "XLS" };

    public Future<Boolean> generate(ArrayDeque<File> queue, int amount) {
        return executor.submit(() -> {
            for (int i = 0; i < amount; i++) {
                int timer = (int) Math.round(1 + (Math.random() * 9));
                int size = (int) Math.round(10 + (Math.random() * 90));
                int rnd = new Random().nextInt(types.length);
                try {
                    Thread.sleep(100 * timer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (queue.size() >= 5) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add(new File(types[rnd], size));
                System.out.println(types[rnd] + "file with size " + size + " generated");
            }
            System.out.println("All files generated");
            return true;
        });
    }
}
