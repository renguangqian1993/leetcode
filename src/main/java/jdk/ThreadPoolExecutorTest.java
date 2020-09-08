package jdk;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();
        int corePoolSize = 1;
        int maximumPoolSize = 3;
        long keepAliveTime = 10;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(1);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                //do nothing
            }
        };

        ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                keepAliveTime, timeUnit,
                workQueue,
                threadFactory,
                rejectedExecutionHandler);
        for (int index = 0; index < 5; index++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    count.addAndGet(1);
                }
            });
            /**
             * index=0, activeCount=1
             * 第一个任务，创建一个核心线程去执行，不入队列，所以是1
             *
             * index=1, activeCount=1
             * 第二个任务，队列为空，核心线程已足够，入队列，所以还是1
             *
             * index=2, activeCount=2
             * 第三个任务，队列已满，核心线程已足够，最大线程不够，创建一个线程去执行，不入队列，所以为2
             *
             * index=3, activeCount=3
             * 第四个任务，队列已满，核心线程已足够，最大线程不够，创建一个线程去执行，不入队列，所以为3
             *
             * index=4, activeCount=3
             * 第五个任务，队列已满，核心线程已足够，最大线程已足够，不入队列、忽略掉该任务，所以还是3
             */
            System.out.printf("index=%d, activeCount=%d\n", index, pool.getActiveCount());
        }

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count.toString());
    }
}
