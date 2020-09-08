package algorithms.didi;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 三个线程分别输出a、b、c
 * 要求三个线程按照顺序输出，并且循环输出10次
 */
public class VolatileTest {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(10);
        while (true) {
            boolean acquire = semaphore.tryAcquire(10, TimeUnit.MILLISECONDS);
            if (!acquire) {
                System.out.println("没有获取到许可");
                break;
            }

            int index = new Random(10000).nextInt();
            CountDownLatch countDownLatch = new CountDownLatch(3);
            RunnableImpl threadA = new RunnableImpl(index + "_A", null, countDownLatch);
            RunnableImpl threadB = new RunnableImpl(index + "_B", threadA, countDownLatch);
            RunnableImpl threadC = new RunnableImpl(index + "_C", threadB, countDownLatch);

            new Thread(threadA).start();
            new Thread(threadB).start();
            new Thread(threadC).start();
            countDownLatch.await();
            System.out.println("================");
        }
        System.out.println("结束了");
    }


    private static class RunnableImpl implements Runnable {

        private volatile boolean done;

        private String msg;

        private  RunnableImpl parent;

        private CountDownLatch countDownLatch;

        public RunnableImpl(String msg, RunnableImpl parent, CountDownLatch countDownLatch) {
            this.msg = msg;
            this.parent = parent;
            this.countDownLatch = countDownLatch;
        }

        public boolean isDone() {
            return done;
        }

        @Override
        public void run() {
            if (!Objects.isNull(parent)) {
                if (!this.parent.isDone()) {
                    Thread.onSpinWait();
                }
            }
            System.out.println(System.currentTimeMillis() + " " + msg);
            for (int index = 0; index < 1000000000; index++) {
                Thread.onSpinWait();
            }


            this.done = true;
            countDownLatch.countDown();
        }
    }
}
