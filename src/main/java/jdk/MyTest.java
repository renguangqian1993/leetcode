package jdk;

import com.aliyun.tea.utils.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class MyTest {
    private static final int MAX_PARTIES = 0xffff;
    private static final int MAX_PHASE = Integer.MAX_VALUE;
    private static final int PARTIES_SHIFT = 16;
    private static final int PHASE_SHIFT = 32;
    private static final int UNARRIVED_MASK = 0xffff;      // to mask ints
    private static final long PARTIES_MASK = 0xffff0000L; // to mask longs
    private static final long COUNTS_MASK = 0xffffffffL;
    private static final long TERMINATION_BIT = 1L << 63;
    // some special values
    private static final int ONE_ARRIVAL = 1;
    private static final int ONE_PARTY = 1 << PARTIES_SHIFT;
    private static final int ONE_DEREGISTER = ONE_ARRIVAL | ONE_PARTY;
    private static final int EMPTY = 1;
    private static final int NCPU = Runtime.getRuntime().availableProcessors();
    static final int SPINS_PER_ARRIVAL = (NCPU < 2) ? 1 : 1 << 8;

    public static void cyclicBarrierTest() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new SimpleDateFormat("HH:mm:ss.SSS").format(new Date())
                        + " action ");
            }
        });

        for (int index = 1; index <= 10; index++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long now = System.currentTimeMillis();
                    try {
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(new SimpleDateFormat("HH:mm:ss.SSS").format(new Date())
                            + " " + Thread.currentThread().getName() + " done ");
                }
            }, "thread-" + index).start();
        }
    }

    public static void main(String[] args) throws Exception {
        cyclicBarrierTest();
    }

}

class LockTest {
    private final ReentrantLock reentrantLock = new ReentrantLock();

    public void lock() {
        long now = System.currentTimeMillis();
        final ReentrantLock reentrantLock = this.reentrantLock;
        System.out.println(new SimpleDateFormat("HH:mm:ss.SSS").format(new Date())
                + " " + Thread.currentThread().getName() + " lock before ");
        reentrantLock.lock();
        System.out.println(new SimpleDateFormat("HH:mm:ss.SSS").format(new Date())
                + " " + Thread.currentThread().getName() + " lock after ");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(new SimpleDateFormat("HH:mm:ss.SSS").format(new Date())
                + " " + Thread.currentThread().getName() + " unlock before ");
        reentrantLock.unlock();
        System.out.println(new SimpleDateFormat("HH:mm:ss.SSS").format(new Date())
                + " " + Thread.currentThread().getName() + " unlock after ");
    }
}
