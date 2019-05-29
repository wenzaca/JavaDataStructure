package com.data.structure.ooo;

import java.io.IOException;

public class Override extends Overridden {
    @java.lang.Override
    public String overrideMe(String string) {
        return string + string;
    }

    // Not override
    public String notOverrideMe(String string) {
        return string + string;
    }

    // Not override
    public Integer overrideMe(Integer int1) {
        return int1;
    }

    // Not override
    public String overrideMe(Boolean bool) {
        return String.valueOf(bool);

    }

    /*
    Not an override, because:
    - Cannot reduce level of visibility
    - Cannot override method that throws checked exceptions which is higher in hierarchy than overridden method.

    @java.lang.Override
    private String overrideMe(String string) throws Exception{
        return string+string;
    }
    */
    /*
    Not  an override, because:
    - Cannot override private, static or final method

    @java.lang.Override
    public static final Integer tryToOverrideMe(Integer int1) throws IOException {
        return int1;
    }
     */

}

class Overridden {
    protected String overrideMe(String string) throws IOException {
        return string;
    }

    private static final Integer tryToOverrideMe(Integer int1) throws IOException {
        return int1;
    }
}
