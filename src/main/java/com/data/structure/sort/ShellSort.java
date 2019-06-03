package com.data.structure.sort;

public class ShellSort {

    public static void main(String[] args) {
        Integer[] integers = {54, 26, 93, 17, 77, 31, 44, 55, 20};
        sort(integers);

    }

    public static void sort(Integer[] array) {
        for (int gap = array.length - array.length/3; gap > 0; gap -= array.length/3) {

            for(int i = gap; i<array.length; i++){
                int newElement = array[i];
                int j = i;
                while(j >= gap && array[j-gap] > newElement){
                    array[j] = array[j-gap];
                    j -= gap;
                }

                array[j] = newElement;
            }
        }
    }
}
