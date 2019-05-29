package com.data.structure.ooo;

import org.junit.Assert;
import org.junit.Test;

public class Polymorphism extends SubClass {
    static String hideMe(String s1) {
        return s1 + s1;
    }
}

class SubClass {
    static String hideMe(String s1) {
        return s1;
    }

    @Test
    public void testHide() {
        String s1 = "test";

        Assert.assertEquals(s1 + s1, Polymorphism.hideMe(s1));
        Assert.assertEquals(s1, SubClass.hideMe(s1));
    }
}
