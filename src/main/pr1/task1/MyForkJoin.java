package main.pr1.task1;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class MyForkJoin extends RecursiveTask<Integer> {
    int[] array;
    public MyForkJoin(int[] array) {this.array = array;}

    @Override
    protected Integer compute() {
        if(array.length <= 2) {
            try{
                Thread.sleep(1);
            }catch(InterruptedException ignored){}
            return Arrays.stream(array).sum();
        }

        MyForkJoin array1stHalf = new MyForkJoin(
                Arrays.copyOfRange(
                                array,
                                0,
                                array.length/2));
        MyForkJoin array2stHalf = new MyForkJoin(
                Arrays.copyOfRange(
                                array,
                                array.length/2,
                                array.length));

        array1stHalf.fork();
        array2stHalf.fork();

        return array1stHalf.join() + array2stHalf.join();
    }
}
