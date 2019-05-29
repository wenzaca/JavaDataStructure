package com.data.structure.ooo;

/*
1) Overloaded methods are bonded using static binding in Java. Which occurs during compile time i.e. when you compile Java program. During the compilation process, compiler bind method calls to the actual method.

2) Overloaded methods are fast because they are bonded during compile time and no check or binding is required during runtime.

3) Most important rule of method overloading in Java is that two overloaded methods must have a different signature. Here is an example of What does method signature means in Java:

1) A number of argument to a method is part of method signature.
2) Type of argument to a method is also part of method signature
3) Order of argument also forms part of method signature provided they are of different type.
4) The return type of method is not part of the method signature in Java.
 */
public class Overloading {

    // Original
    public String concatenateStuffs(String string, String string2) {
        return string + string2;
    }

    // Overload
    public String concatenateStuffs(Integer int1, Integer int2) {
        return String.valueOf(int1 + int2);
    }

    // Overload
    public String concatenateStuffs(Integer int1) {
        return String.valueOf(int1 + int1);
    }

    // NotOverload
    public Integer concatenateStuffs(String int1) {
        return Integer.valueOf(int1);
    }

}
