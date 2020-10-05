package corebanking.customer.Util;


public class IdGenerator {
    private static IdGenerator instance = new IdGenerator();

    //todo: it is not the right way, we should be careful about the unique customerNumber, it is just a test for singelton pattern

    private volatile int next =  10000;

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }

    public synchronized int getNextSequence() {
        return next++;
    }
}
