package com.data.structure.collection;

import com.data.structure.collection.util.Logger;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.*;

/*
========TreeSet========
1. Add First= 114600
2. Add Middle= 1200
3. Add Last= 11900
4. Get First= 5344900
5. Get Middle= 8208800
6. Get Last= 718700
7. Remove First= 27600
8. Remove Middle= 8600
9. Remove Last= 7100
10. Size= 8400
========HashSet========
1. Add First= 13100
2. Add Middle= 7000
3. Add Last= 9600
4. Get First= 11217200
5. Get Middle= 6907600
6. Get Last= 3527200
7. Remove First= 27000
8. Remove Middle= 7700
9. Remove Last= 5600
10. Size= 6000
========LinkedHashSet========
1. Add First= 67600
2. Add Middle= 7100
3. Add Last= 12400
4. Get First= 57600
5. Get Middle= 6057700
6. Get Last= 2332300
7. Remove First= 15200
8. Remove Middle= 1600
9. Remove Last= 1000
10. Size= 3300
*/

/*
1) Duplicates : All three implements Set interface means they are not allowed to store duplicates.

2) Thread safety : HashSet, TreeSet and LinkedHashSet are not thread-safe, if you use them in multi-threading
environment where at least one Thread  modifies Set you need to externally synchronize them.

3) Fail-Fast Iterator : Iterator returned by TreeSet, LinkedHashSet and HashSet are fail-fast Iterator. i.e.
If Iterator is modified after its creation by any way other than Iterators remove() method, it will throw
ConcurrentModificationException with best of effort. read more about fail-fast vs fail-safe Iterator here
 */
public class SetPerformance {

    /*
    HashSet is fastest
    Performance and Speed: HashSet offer constant time performance e.g. O(1) for add, contains and remove given hash
        function uniformly distribute elements in bucket.
    Ordering: HashSet does not maintain any order.
    Internal Implementation: HashSet is backed by an HashMap instance.
    Null : HashSet allows null
    Comparison : HashSet uses equals() method in Java for comparison
    */
    @Test
    public void hashSet() {
        Set<Object> arraySet = new HashSet<>();
        List<Long> action = action(arraySet);
        System.out.println("========HashSet========");
        Logger.printList(action);
    }

    /*
    LinkedHashSet is second on performance or almost similar to HashSet
    Performance and Speed: LinkedHashSet offer constant time performance e.g. O(1) for add, contains and remove
        given hash function uniformly distribute elements in bucket.
    Ordering: LinkedHashSet maintains insertion order of elements much like List interface.
    Internal Implementation: LinkedHashSet is implemented using HashSet and LinkedList.
    Null: LinkedHashSet allows null
    Comparison: LinkedHashSet uses equals() method in Java for comparison
     */
    @Test
    public void linkedHashSet() {
        Set<Object> vector = new LinkedHashSet<>();
        List<Long> action = action(vector);
        System.out.println("========LinkedHashSet========");
        Logger.printList(action);
    }

    /*
    TreeSet is bit slower because of sorting operation it needs to perform on each insertion
    Performance and Speed: TreeSet provides guaranteed O(log(n)) time for common operations like add, remove and contains
    Ordering: TreeSet maintains sorting order or elements.
    Internal Implementation: TreeSet is backed up by NavigableMap in Java and by default it uses TreeMap.
    Null:  TreeSet doesn't allow null but TreeSet doesn't allow null and throw java.lang.NullPointerException when
        you will insert null into TreeSet. Since TreeSet uses compareTo() method of respective elements to compare them
        which throws NullPointerException while comparing with null
    Comparison: TreeSet uses compareTo() method for maintaining ordering. That's why compareTo() should be consistent
        to equals in Java. failing to do so break general contact of Set interface i.e. it can permit duplicates.
     */
    @Test
    public void treeSet() {
        Set<Object> treeSet = new TreeSet<>();
        List<Long> action = action(treeSet);
        System.out.println("========TreeSet========");
        Logger.printList(action);
    }

    private String randomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }


    private List<Long> action(Set set) {
        List<Long> longs = new ArrayList<>(11);
        String first = randomString();
        longs.add(addObjects(set, first)); //0

        for (int i = 1; i < 49999; i++) {
            addObjects(set, randomString());
        }

        String middle = randomString();
        longs.add(addObjects(set, middle)); //1

        for (int i = 1; i < 49999; i++) {
            addObjects(set, randomString());
        }

        String last = randomString();

        longs.add(addObjects(set, last)); //2
        longs.add(getObjects(set, first)); //3
        longs.add(getObjects(set, middle)); //4
        longs.add(getObjects(set, last)); //5
        longs.add(removeObjects(set, first)); //6
        longs.add(removeObjects(set, middle)); //7
        longs.add(removeObjects(set, last)); //8
        longs.add(size(set)); //9
        return longs;
    }

    private Long addObjects(Set<Object> set, Object o) {
        long startTime = System.nanoTime();
        set.add(o);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private Long removeObjects(Set<Object> set, Object o) {
        long startTime = System.nanoTime();
        set.remove(o);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private Long getObjects(Set<Object> set, Object o) {
        long startTime = System.nanoTime();
        for (Iterator<Object> it = set.iterator(); it.hasNext(); ) {
            Object newObject = it.next();
            if (newObject.equals(o))
                break;
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private Long size(Set<Object> set) {
        long startTime = System.nanoTime();
        set.size();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}

