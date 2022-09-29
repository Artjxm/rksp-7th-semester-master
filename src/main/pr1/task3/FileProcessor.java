package main.pr1.task3;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class FileProcessor {
    int counter = 0;
    String type;
    public ExecutorService handler = Executors.newSingleThreadExecutor();

    public void handle(File file) {
        handler.submit(() -> {
            try {
                Thread.sleep(file.size * 7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(file.type + "file with size " + file.size + " handled");
            counter++;
        });
    }

    FileProcessor(String type) {
        this.type = type;
    }
}
