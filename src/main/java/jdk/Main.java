package jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    private static Long sum = 0L;

    public static void main(String[] args) {

        System.out.println("main start sum = " + sum);

        ExecutorService service = new ThreadPoolExecutor(
                10, 10, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        for (int i = 0; i < 10; i++) {
            new Add().run();
        }
        service.shutdown();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println("main interrupt exception");
        }
        System.out.println("main end sum = " + sum);
    }

    static class Add implements Runnable {

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + thread.getId() + " start add!");
            for (int i = 0; i < 10000; i++) {
                sum++;
            }
            System.out.println(thread.getName() + thread.getId() + " add over!");
        }
    }
}

