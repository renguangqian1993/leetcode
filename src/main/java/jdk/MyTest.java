package jdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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


    public static void main(String[] args) throws Exception {
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());

    }


}