package main.pr1.task3;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        int amount = 30;
        ArrayDeque<File> queue = new ArrayDeque<>();

        FileGenerator fileGenerator = new FileGenerator();
        FileProcessor fileProcessorXML = new FileProcessor("XML");
        FileProcessor fileProcessorJSON = new FileProcessor("JSON");
        FileProcessor fileProcessorXLS = new FileProcessor("XLS");
        FileProcessor[] fileProcessors = new FileProcessor[] {
                fileProcessorXML,
                fileProcessorJSON,
                fileProcessorXLS };

        Future<Boolean> future = fileGenerator.generate(queue, amount);

        executor.submit(() -> {
            while (!future.isDone() || !queue.isEmpty()) {
                if (!queue.isEmpty()) {
                    File file = queue.poll();
                    for (FileProcessor processor : fileProcessors) {
                        if (Objects.equals(processor.type, file.type)) {
                            processor.handle(file);
                        }
                    }
                }
            }
        });

        fileGenerator.executor.shutdown();
        executor.shutdown();
        while ((fileProcessorXML.counter + fileProcessorJSON.counter + fileProcessorXLS.counter) != amount) {
            Thread.sleep(100);
        }
        for (FileProcessor processor : fileProcessors) {
            processor.handler.shutdown();
        }
    }
}
