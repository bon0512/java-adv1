package thread.collection.java;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetMain {
    public static void main(String[] args) {

        Set<Integer> copySet = new CopyOnWriteArraySet<>();
        copySet.add(3);
        copySet.add(1);
        copySet.add(2);
        System.out.println("copySet = " + copySet);


        ConcurrentSkipListSet skipListSet = new ConcurrentSkipListSet<>();
        skipListSet.add(3);
        skipListSet.add(1);
        skipListSet.add(2);
        System.out.println("skipListSet = " + skipListSet);
    }
}
