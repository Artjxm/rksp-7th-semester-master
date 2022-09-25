package main.pr1.task1;

public class MyThread extends Thread {
    int[] array;
    int sum = 0;
    public MyThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i : array) {
            sum += i;
            try{
                Thread.sleep(1);
            }catch(InterruptedException ignored){}
        }
    }

    public int getSum() {
        return sum;
    }
}
