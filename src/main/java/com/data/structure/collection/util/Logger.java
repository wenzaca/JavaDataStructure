package com.data.structure.collection.util;

import java.util.List;

public class Logger {

    public static void printList(List<Long> action) {
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
}
