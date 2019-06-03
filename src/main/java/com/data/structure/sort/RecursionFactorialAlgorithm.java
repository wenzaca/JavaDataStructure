package com.data.structure.sort;

public class RecursionFactorialAlgorithm {

    public static int recursiveFactorial(int num){

        if(num == 0){
            return 1;
        }
        return num * recursiveFactorial(num-1);
    }
}
