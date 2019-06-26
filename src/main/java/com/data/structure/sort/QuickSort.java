package com.data.structure.sort;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] integers = {54, 26, 93, 17, 77, 31, 44, 55, 20};
        quickSort(integers, 0, integers.length);
        for (Integer intValue : integers) {
            System.out.println(intValue);
        }
        System.out.println(integers);
    }

    static void quickSort(Integer[] array, int start, int end) {
        if (end - start < 2) return;

        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex + 1, end);
    }

    static int partition(Integer[] array, int start, int end) {
        int pivot = array[start];
        int i = start;
        int j = end;

        while(i < j){
            while (i < j && array[--j] >= pivot);
            if (i < j){
                array[i] = array[j];
            }

            while (i < j && array[++i] <= pivot);
            if (i < j){
                array[j] = array[i];
            }
        }

        array[j] = pivot;

        return j;
    }
}
