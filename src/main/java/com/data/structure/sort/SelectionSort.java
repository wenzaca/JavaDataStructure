package com.data.structure.sort;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSort {
    public static void main(String[] args) {
        sort(new Integer[]{54, 26, 93, 17, 77, 31, 44, 55, 20});
    }

    public static void sort(Integer[] array) {

        for (int i = array.length - 1; i >= 0; i--) {
            int maxValue =Integer.MIN_VALUE;
            int positionOfMax =0;
            for (int j = 0; j <= i; j++) {
                if (array[j] > maxValue) {
                    maxValue = array[j];
                    positionOfMax = j;
                }
            }
            Integer temp = array[i];
            array[i] = maxValue;
            array[positionOfMax] = temp;
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
