package com.data.structure.sort;

/*
In-place algorithm
O(n^2) time complexity
 */
public class BubbleSort {
    public static void main(String[] args) {
        sort(new Integer[]{54, 26, 93, 17, 77, 31, 44, 55, 20});
    }

    public static void sort(Integer[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int oldPosition = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = oldPosition;
                }
            }
        }
    }
}
