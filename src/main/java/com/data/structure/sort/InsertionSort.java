package com.data.structure.sort;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSort {
    public static void main(String[] args) {
        sort(new Integer[]{54, 26, 93, 17, 77, 31, 44, 55, 20});
    }


    public static void sort(Integer[] array) {

        for (int j = 1; j <= array.length - 1; j++) {
            int i = 0;
            Integer newElement = array[j];
            for (i = j - 1; i >= 0; i--) {
                if (newElement >= array[i]) {
                    break;
                } else {
                    array[i + 1] = array[i];
                }
            }
            array[i + 1] = newElement;

        }
    }

    @Test
    public void testSort(){
        Integer[] integers = {54, 26, 93, 17, 77, 31, 44, 55, 20};
        sort(integers);
        Integer[] integersSorted = {17, 20, 26, 31, 44,54,55,77,93};
        Assert.assertArrayEquals(integers, integersSorted);
    }
}
