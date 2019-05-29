package com.data.structure.collection;

import org.junit.Test;

import java.util.*;

/*
========ArrayList========
1. Add First= 7599
2. Add Middle= 101
3. Add Last= 6501
4. Get First= 5200
5. Get Middle= 4500
6. Get Last= 4700
7. Remove First= 70201
8. Remove Middle= 2099701
9. Remove Last= 1509000
10. Size= 5799
========VectorList========
1. Add First= 11201
2. Add Middle= 600
3. Add Last= 8800
4. Get First= 10100
5. Get Middle= 5000
6. Get Last= 5000
7. Remove First= 87201
8. Remove Middle= 1871100
9. Remove Last= 1602400
10. Size= 7599
========LinkedList========
1. Add First= 33499
2. Add Middle= 101
3. Add Last= 6400
4. Get First= 19400
5. Get Middle= 642900
6. Get Last= 6200
7. Remove First= 10800
8. Remove Middle= 2051900
9. Remove Last= 1608900
10. Size= 7700
========StackList========
1. Add First= 34701
2. Add Middle= 7000
3. Add Last= 16999
4. Get First= 10300
5. Get Middle= 5800
6. Get Last= 5500
7. Remove First= 68800
8. Remove Middle= 195599
9. Remove Last= 907800
10. Size= 6800
 */
public class ListPerformance {

    /*
    ArrayList is a part of collection framework and is present in java.util package. It provides us dynamic arrays in Java.
    Though, it may be slower than standard arrays but can be helpful in programs where lots of manipulation in the array is needed.

    ArrayList inherits AbstractList class and implements List interface.
    ArrayList is initialized by a size, however the size can increase if collection grows or shrunk if objects are removed from the collection.
    Java ArrayList allows us to randomly access the list.
    ArrayList can not be used for primitive types, like int, char, etc. We need a wrapper class for such cases (see this for details).
    ArrayList in Java can be seen as similar to vector in C++.

    Array list always grow in 50% when it is full.

    Complexity:
    - Get(Index): O(1)
    - Add(Object) at first: o(n)
    - Add(Object) at bottom: o(1) if array not full, if full o(n)
    - Add(Index,Object): o(n), worst case
    - Remove(index): o(n)

    Memory:
    - Occupy the size of the array (even if there is empty elements) multiplied by the object size
    (e.g. Array of 10 position filled with 7 integers would occupy 4(Integer size) * 10(size of array) bytes)
    - Memory is allocated in large blocks
     */
    @Test
    public void arrayList() {
        List<Object> arrayList = new ArrayList<>();
        List<Long> action = action(arrayList);
        System.out.println("========ArrayList========");
        printResult(action);
    }

    /*
    The Vector class implements a growable array of objects. Vectors basically falls in legacy classes but now it is fully compatible with collections.

    Vector implements a dynamic array that means it can grow or shrink as required. Like an array, it contains components that can be accessed using an integer index
    They are very similar to ArrayList but Vector is synchronised and have some legacy method which collection framework does not contain.
    It extends AbstractList and implements List interfaces.

    Vector always grow in 100% when it is full.
     */
    @Test
    public void vectorList() {
        List<Object> vector = new Vector(100000);
        List<Long> action = action(vector);
        System.out.println("========VectorList========");
        printResult(action);
    }

    /*
    Java Collection framework provides a Stack class which models and implements Stack data structure.
    The class is based on the basic principle of last-in-first-out. In addition to the basic push and pop operations,
    the class provides three more functions of empty, search and peek. The class can also be said to extend Vector and treats
    the class as a stack with the five mentioned functions. The class can also be referred to as the subclass of Vector.
     */
    @Test
    public void stackList() {
        List<Object> stack = new Stack();
        List<Long> action = action(stack);
        System.out.println("========StackList========");
        printResult(action);
    }

    /*
    Linked List are linear data structures where the elements are not stored in contiguous locations and every element is a separate object with a data part and address part.
    The elements are linked using pointers and addresses. Each element is known as a node. Due to the dynamicity and ease of insertions and deletions,
    they are preferred over the arrays. It also has few disadvantages like the nodes cannot be accessed directly instead we need to start from the
    head and follow through the link to reach to a node we wish to access.

    To store the elements in a linked list we use a doubly linked list which provides a linear data structure and also used to
    inherit an abstract class and implement list and deque interfaces.

    In Java, LinkedList class implements the list interface. The LinkedList class also consists of various constructors and methods like other java collections.

     Complexity:
    - Get(Index): O(n)
    - Add(Object) at first: o(1)
    - Add(Object) at bottom: o(n)
    - Remove(index): o(n)

    Memory:
    - Occupy the size of an Integer used to identify the next node plus the size of the object multiplied by the number of elements
    (e.g. LinkedList with 7 integers would occupy [4(Integer size)+ 4 (Object Integer)] * 7(size of array) bytes )
    - No unused memory
    - Memory may be available as multiple small blocks
    - Extra memory for the link between nodes
     */
    @Test
    public void linkedList() {
        List<Object> linkedList = new LinkedList<>();
        List<Long> action = action(linkedList);
        System.out.println("========LinkedList========");
        printResult(action);
    }

    private void printResult(List<Long> action) {
        System.out.println("1. Add First= " + action.get(0));
        System.out.println("2. Add Middle= " + action.get(1));
        System.out.println("3. Add Last= " + action.get(2));
        System.out.println("4. Get First= " + action.get(3));
        System.out.println("5. Get Middle= " + action.get(4));
        System.out.println("6. Get Last= " + action.get(5));
        System.out.println("7. Remove First= " + action.get(6));
        System.out.println("8. Remove Middle= " + action.get(7));
        System.out.println("9. Remove Last= " + action.get(8));
        System.out.println("10. Size= " + action.get(9));
    }

    private List<Long> action(List list) {
        ArrayList<Long> longs = new ArrayList<>();
        Object first = new Object();
        longs.add(addObjects(list, first)); //0

        for (int i = 1; i < 49999; i++) {
            addObjects(list, new Object());
        }

        Object middle = new Object();
        longs.add(addObjects(list, middle)); //1

        for (int i = 1; i < 49999; i++) {
            addObjects(list, new Object());
        }

        Object last = new Object();

        longs.add(addObjects(list, last)); //2
        longs.add(getObjects(list, 0)); //3
        longs.add(getObjects(list, (list.size() - 1) / 2)); //4
        longs.add(getObjects(list, list.size() - 1)); //5
        longs.add(removeObjects(list, first)); //6
        longs.add(removeObjects(list, middle)); //7
        longs.add(removeObjects(list, last)); //8
        longs.add(size(list)); //9
        return longs;
    }

    private Long addObjects(List list, Object o) {
        long startTime = System.nanoTime();
        list.add(o);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private Long removeObjects(List list, Object o) {
        long startTime = System.nanoTime();
        list.remove(o);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private Long getObjects(List list, Integer i) {
        long startTime = System.nanoTime();
        list.get(i);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private Long size(List list) {
        long startTime = System.nanoTime();
        list.size();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
