package com.data.structure.collection;

import com.data.structure.collection.util.Logger;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.*;


/*
========TreeMap========
1. Add First= 110600
2. Add Middle= 300
3. Add Last= 9700
4. Get First= 24400
5. Get Middle= 8100
6. Get Last= 7600
7. Remove First= 27100
8. Remove Middle= 15900
9. Remove Last= 8700
10. Size= 5700
========HashTable========
1. Add First= 11400
2. Add Middle= 400
3. Add Last= 17200
4. Get First= 17700
5. Get Middle= 7000
6. Get Last= 6600
7. Remove First= 10000
8. Remove Middle= 6900
9. Remove Last= 6700
10. Size= 6000
========HashMap========
1. Add First= 38600
2. Add Middle= 100
3. Add Last= 7100
4. Get First= 6300
5. Get Middle= 5700
6. Get Last= 5300
7. Remove First= 24900
8. Remove Middle= 8500
9. Remove Last= 6600
10. Size= 5200
========LinkedHashMap========
1. Add First= 51800
2. Add Middle= 9900
3. Add Last= 9600
4. Get First= 10900
5. Get Middle= 12300
6. Get Last= 9300
7. Remove First= 13800
8. Remove Middle= 7600
9. Remove Last= 6700
10. Size= 5200
 */

/*
A Map cannot contain duplicate keys and each key can map to at most one value. Some implementations allow null
    key and null value like the HashMap and LinkedHashMap, but some do not like the TreeMap.
The order of a map depends on specific implementations, e.g TreeMap and LinkedHashMap have predictable order, while HashMap does not.
There are two interfaces for implementing Map in java: Map and SortedMap, and three classes: HashMap, TreeMap and LinkedHashMap.
 */
public class MapPerformance {

    /*
    By default, the hashCode() and equals() methods implemented in Object class are used.
    The default hashCode() method gives distinct integers for distinct objects, and the equals()
    method only returns true when  two references refer to the same object. This implementation
    uses a hash table as the underlying data structure. It implements all of the Map operations
    and allows null values and one null key. This class is roughly equivalent to Hashtable - a
    legacy data structure before Java Collections Framework, but it is not synchronized and permits
    nulls. HashMap does not guarantee the order of its key-value elements. Therefore, consider
    to use a HashMap when order does not matter and nulls are acceptable.

    - Not Synchronized
    - Allow one null key, allow null values
    - One of HashMap's subclasses is LinkedHashMap, so in the event that you'd want predictable
    iteration order (which is insertion order by default), you could easily swap out the HashMap
    for a LinkedHashMap
    - Algorithm		Average	   Worst case
        Space		O(n)[1]	   O(n)
        Search		O(1)	   O(n)
        Insert		O(1)	   O(n)
        Delete		O(1)	   O(n)
    - Default capacity of the array is 16
    - Memory = 32 * SIZE + 4 * CAPACITY bytes
     */
    @Test
    public void hashMap() {
        Map<Integer, String> arrayMap = new HashMap<>();
        List<Long> action = action(arrayMap);
        System.out.println("========HashMap========");
        Logger.printList(action);
    }

    /*
    Similar to hashMap, but:

     - Is synchronized
     - Does not allow null keys or values
     */
    @Test
    public void hashTable() {
        Map<Integer, String> arrayMap = new Hashtable<>();
        List<Long> action = action(arrayMap);
        System.out.println("========HashTable========");
        Logger.printList(action);
    }

    /*
    This implementation uses a hash table and a linked list as the underlying data structures,
    thus the order of a LinkedHashMap is predictable, with insertion-order as the default order.
    This implementation also allows nulls like HashMap. So consider using a LinkedHashMap when
    you want a Map with its key-value pairs are sorted by their insertion order.
    LinkedHashMap will iterate in the order in which the entries were put into the map
    */
    @Test
    public void linkedHashMap() {
        Map<Integer, String> likedHashMap = new LinkedHashMap<>();
        List<Long> action = action(likedHashMap);
        System.out.println("========LinkedHashMap========");
        Logger.printList(action);
    }

    /*
    TreeMap will iterate according to the "natural ordering" of the keys according to their
    compareTo() method (or an externally supplied Comparator). Additionally, it implements
    the SortedMap interface, which contains methods that depend on this sort order.

    Each tree node contains: key, value, pointers to the left and right children, pointer to
    a parent and a boolean ‘colour’ flag. It means that a node occupies 12 bytes for header,
    20 bytes for 5 object fields and 1 byte for the flag, so the total consumption is
    12 + 20 + 1 = 40 (due to 8 byte alignment). The last flag seems to be odd in this design,
    because it causes each node to consume 7 bytes more (due to alignment). This situation could
    be solved by having 2 types of nodes – one class for red nodes and another for black ones.

    - Memory: 40 * SIZE bytes
    - Does not allow null keys or values
    - Ordered by comparator.
        Algorithm		Average	   Worst case
            Space		O(n)		   O(n)
            Search		O(log n)   	   O(log n)
            Insert		O(log n) 	   O(log n)
            Delete		O(log n)	   O(log n)
     */
    @Test
    public void treeMap() {
        Map<Integer, String> treeMap = new TreeMap<>();
        List<Long> action = action(treeMap);
        System.out.println("========TreeMap========");
        Logger.printList(action);
    }

    private String randomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }


    private List<Long> action(Map map) {
        List<Long> longs = new ArrayList<>(11);
        String first = randomString();
        int i = 0;
        longs.add(addObjects(map, first, i)); //0

        for (i = 1; i < 49999; i++) {
            addObjects(map, randomString(), i);
        }

        String middle = randomString();
        longs.add(addObjects(map, middle, i)); //1

        for (i = 1; i < 49999; i++) {
            addObjects(map, randomString(), i);
        }

        String last = randomString();

        longs.add(addObjects(map, last, i)); //2
        longs.add(getObjects(map, 0)); //3
        longs.add(getObjects(map, (map.size() - 1) / 2)); //4
        longs.add(getObjects(map, map.size() - 1)); //5
        longs.add(removeObjects(map, 0)); //6
        longs.add(removeObjects(map, (map.size() - 1) / 2)); //7
        longs.add(removeObjects(map, map.size() - 1)); //8
        longs.add(size(map)); //9
        return longs;
    }

    private Long addObjects(Map<Integer, String> map, String o, Integer i) {
        long startTime = System.nanoTime();
        map.put(i, o);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private Long removeObjects(Map<Integer, String> map, Integer i) {
        long startTime = System.nanoTime();
        map.remove(i);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private Long getObjects(Map<Integer, String> map, Integer i) {
        long startTime = System.nanoTime();
        map.get(i);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private Long size(Map<Integer, String> map) {
        long startTime = System.nanoTime();
        map.size();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
