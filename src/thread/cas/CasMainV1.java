package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasMainV1 {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value = "+atomicInteger.get());

        boolean result1 = atomicInteger.compareAndSet(0, 1);
        System.out.println("result = " + result1 + ", value = "+atomicInteger.get());

        boolean result2 = atomicInteger.compareAndSet(0,1);
        System.out.println("result = " + result2 + ", value = "+atomicInteger.get());

    }
}
