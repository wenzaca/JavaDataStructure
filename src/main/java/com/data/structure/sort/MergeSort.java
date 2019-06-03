package com.data.structure.sort;

public class MergeSort {

    public static void main(String[] args) {
        Integer[] integers = {54, 26, 93, 17, 77, 31, 44, 55, 20};
        mergeSort(integers,0, 9);
        for (Integer intValue:integers) {
            System.out.println(intValue);
        }
        System.out.println(integers);
    }


    public static void mergeSort(Integer[] array, int start, int end) {

        if (end - start < 2)
            return; // The break condition, means that the array size is now 1, no way to split the array anymore

        int mid = (start + end +1) / 2;
        mergeSort(array, start, mid); // Invoke 54,26,93,17 -> 54,26 -> 54 -> 93 -> 26,54 ->
        mergeSort(array, mid, end); //                                  26 -> 17 -> 17,93
        merge(array, start, mid, end);


    }

    public static void merge(Integer[] array, int start, int mid, int end) {

        if(array[mid-1] <= array[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;
        Integer[] tempArray = new Integer[end-start];

        while (i< mid && j < end){
            tempArray[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array, i, array, start+tempIndex, mid - i);
        System.arraycopy(tempArray, 0, array, start, tempIndex); // if there is any leftovers on the left array, for example {32,36} and {33,34}
    }
}
