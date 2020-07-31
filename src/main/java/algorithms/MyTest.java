package algorithms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class MyTest {

    /**
     * ReentrantLock
     */
    /**
     * The number of bits to use for reader count before overflowing
     */
    private static final int LG_READERS = 7; // 127 readers
    // Values for lock state and stamp operations
    private static final long RUNIT = 1L;
    private static final long WBIT = 1L << LG_READERS;
    private static final long RBITS = WBIT - 1L;
    private static final long RFULL = RBITS - 1L;
    private static final long ABITS = RBITS | WBIT;
    private static final long SBITS = ~RBITS; // note overlap with ABITS
    // not writing and conservatively non-overflowing
    private static final long RSAFE = ~(3L << (LG_READERS - 1));
    /**
     * Initial value for lock state; avoids failure value zero.
     */
    private static final long ORIGIN = WBIT << 1;
    // Special value from cancelled acquire methods so caller can throw IE
    private static final long INTERRUPTED = 1L;
    // Bits for Node.status
    static final int WAITING = 1;
    static final int CANCELLED = 0x80000000; // must be negative

    /**
     * ReentrantReadWriteLock
     */
    static final int SHARED_SHIFT = 16;
    static final int SHARED_UNIT = (1 << SHARED_SHIFT);
    static final int MAX_COUNT = (1 << SHARED_SHIFT) - 1;
    static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;

    /**
     * Phaser
     */
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

    public static void main(String[] args) {
        phaserGroupTest();
    }

    public static void phaserTest() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        Phaser phaser = new Phaser(11);

        for (int times = 1; times <= 10; times++) {

            int phase = phaser.getPhase();

            for (int index = 1; index <= 10; index++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String threadName = Thread.currentThread().getName();
                        int phase = phaser.getPhase();
//                        System.out.println(dateFormat.format(new Date()) + " phase:" + phase + " threadName:" + threadName + " enter");
                        int milisecond = new Random().nextInt(100);
                        try {
                            if (milisecond > 0)
                                Thread.sleep(milisecond);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

//                        System.out.println(dateFormat.format(new Date()) + " phase:" + phase + " threadName:" + threadName + " milisecond:" + milisecond + " phaser:" + phaser.toString());

                        phaser.arriveAndAwaitAdvance();
                        System.out.println(dateFormat.format(new Date()) + " phase:" + phase + " threadName:" + threadName + " arriveAndAwaitAdvance" + " phaser:" + phaser.toString());

                    }
                }, "thread-" + index + "-" + phase).start();
            }

            System.out.println(dateFormat.format(new Date()) + " " + "main arriveAndAwaitAdvance before phaser:" + phaser.toString());
            phaser.arriveAndAwaitAdvance();
            System.out.println(dateFormat.format(new Date()) + " " + "main arriveAndAwaitAdvance after phaser:" + phaser.toString());
        }
    }

    public static void phaserGroupTest() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        Phaser phaser = new Phaser(1);


        for (int times = 1; times <= 10; times++) {
            final int finalTimes = times;

            Phaser childPhaser1 = new Phaser(phaser, 5);
            Phaser childPhaser2 = new Phaser(phaser, 5);

            for (int index = 1; index <= 5; index++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String threadName = Thread.currentThread().getName();
                        int milisecond = new Random().nextInt(1000);
                        try {
                            if (milisecond > 0)
                                Thread.sleep(milisecond);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        childPhaser1.arrive();
                        System.out.println(dateFormat.format(new Date()) + " childPhaser1 threadName:" + threadName + " arrive" + " phaser:" + childPhaser1.toString());
                    }
                }, "child_1-" + "times_" + finalTimes + "-index_" + index).start();
            }

            for (int index = 1; index <= 5; index++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String threadName = Thread.currentThread().getName();
//                                System.out.println(dateFormat.format(new Date()) + " childPhaser2 threadName:" + threadName + " enter");
                        int milisecond = new Random().nextInt(2000);
                        try {
                            if (milisecond > 0)
                                Thread.sleep(milisecond);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        childPhaser2.arrive();
                        System.out.println(dateFormat.format(new Date()) + " childPhaser2 threadName:" + threadName + " arrive" + " phaser:" + childPhaser2.toString());
                    }
                }, "child_2-" + "times_" + finalTimes + "-index_" + index).start();
            }

//            childPhaser1.arriveAndAwaitAdvance();
//            System.out.println(dateFormat.format(new Date()) + " times:" + times + " childPhaser1 " + "main awaitAdvance after phaser:" + childPhaser1.toString());
//
//            childPhaser2.arriveAndAwaitAdvance();
//            System.out.println(dateFormat.format(new Date()) + " times:" + times + " childPhaser2 " + "main awaitAdvance after phaser:" + childPhaser2.toString());

            System.out.println(dateFormat.format(new Date()) + " times:" + times + " phaser main awaitAdvance before phaser:" + phaser.toString());
            phaser.arriveAndAwaitAdvance();
            System.out.println(dateFormat.format(new Date()) + " times:" + times + " phaser main awaitAdvance after phaser:" + phaser.toString());
        }
    }

    public static void printParams() {
        System.out.println("MAX_PARTIES：" + Integer.toBinaryString(MAX_PARTIES));
        System.out.println("MAX_PHASE：" + Integer.toBinaryString(MAX_PHASE));
        System.out.println("PARTIES_SHIFT：" + Integer.toBinaryString(PARTIES_SHIFT));
        System.out.println("PHASE_SHIFT：" + Integer.toBinaryString(PHASE_SHIFT));
        System.out.println("UNARRIVED_MASK：" + Integer.toBinaryString(UNARRIVED_MASK));
        System.out.println("PARTIES_MASK：" + Long.toBinaryString(PARTIES_MASK));
        System.out.println("COUNTS_MASK：" + Long.toBinaryString(COUNTS_MASK));
        System.out.println("TERMINATION_BIT：" + Long.toBinaryString(TERMINATION_BIT));
        System.out.println("ONE_ARRIVAL：" + Integer.toBinaryString(ONE_ARRIVAL));
        System.out.println("ONE_PARTY：" + Integer.toBinaryString(ONE_PARTY));
        System.out.println("ONE_DEREGISTER：" + Integer.toBinaryString(ONE_DEREGISTER));
        System.out.println("EMPTY：" + Integer.toBinaryString(EMPTY));
    }

    public static void main2(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            System.out.println("所有线程都在等待状态1：" + Calendar.getInstance().getTime().toString());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程都在等待状态2：" + Calendar.getInstance().getTime().toString());
        });

        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("线程【" + name + "】进入：" + Calendar.getInstance().getTime().toString());
                Thread.sleep(1000L);
                System.out.println("线程【" + name + "】等待：" + Calendar.getInstance().getTime().toString());
                int awaitResult = cyclicBarrier.await();
                System.out.println("线程【" + name + "】执行：" + Calendar.getInstance().getTime().toString());
                System.out.println("线程【" + name + "】awaitResult：" + awaitResult);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        List<Thread> threads = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            Thread.sleep(2000L);
            Thread thread = new Thread(runnable, "" + index);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

    }

    public static void main3(String[] args) {
        System.out.println("LG_READERS：" + Long.toBinaryString(LG_READERS));
        System.out.println("RUNIT：" + Long.toBinaryString(RUNIT));
        System.out.println("WBIT：" + Long.toBinaryString(WBIT));
        System.out.println("RBITS：" + Long.toBinaryString(RBITS));
        System.out.println("RFULL：" + Long.toBinaryString(RFULL));
        System.out.println("ABITS：" + Long.toBinaryString(ABITS));
        System.out.println("SBITS：" + Long.toBinaryString(SBITS));
        System.out.println("RSAFE：" + Long.toBinaryString(RSAFE));
        System.out.println("ORIGIN：" + Long.toBinaryString(ORIGIN));
        System.out.println("INTERRUPTED：" + Long.toBinaryString(INTERRUPTED));
        System.out.println("WAITING：" + Integer.toBinaryString(WAITING));
        System.out.println("CANCELLED：" + Integer.toBinaryString(CANCELLED));

        System.out.println("===================================");

        System.out.println("SHARED_SHIFT：" + Integer.toBinaryString(SHARED_SHIFT));
        System.out.println("SHARED_UNIT：" + Integer.toBinaryString(SHARED_UNIT));
        System.out.println("MAX_COUNT：" + Integer.toBinaryString(MAX_COUNT));
        System.out.println("EXCLUSIVE_MASK：" + Integer.toBinaryString(EXCLUSIVE_MASK));

        System.out.println(Integer.toBinaryString(1 >>> SHARED_SHIFT));
    }

    public static void main4(String[] args) {
        StampedLock stampedLock = new StampedLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("读锁开始创建");

                    ScheduledExecutorService service = Executors.newScheduledThreadPool(20);
                    service.scheduleAtFixedRate(new Runnable() {
                        @Override
                        public void run() {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        long stamp = stampedLock.readLock();
                                        System.out.println("读锁==>>" + Thread.currentThread().getName() + ",写锁:" + stampedLock.isWriteLocked());
                                        long startTime = System.currentTimeMillis();

                                        long duration = 10 * 1000L;

                                        while (System.currentTimeMillis() - startTime < duration) {
                                            Thread.sleep(100L);
                                        }
                                        stampedLock.unlockRead(stamp);
                                        System.out.println("读锁<<==" + Thread.currentThread().getName());

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }).start();
                        }
                    }, 0, 100, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println("写锁开始创建");

                    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
                    service.scheduleAtFixedRate(new Runnable() {
                        @Override
                        public void run() {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        long stamp = stampedLock.writeLock();
                                        System.out.println("写锁==>>" + Thread.currentThread().getName() + ",读锁:" + stampedLock.isReadLocked());
                                        long startTime = System.currentTimeMillis();

                                        long duration = 10 * 1000L;

                                        while (System.currentTimeMillis() - startTime < duration) {
                                            Thread.sleep(100);
                                        }
                                        stampedLock.unlockWrite(stamp);
                                        System.out.println("写锁<<==" + Thread.currentThread().getName());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }).start();
                        }
                    }, 0, 100, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}