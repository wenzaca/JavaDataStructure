package com.data.structure.entity;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

public class Brother {

    private String name;
    private List<String> brothers;


    public Brother() {
        this.name = new Timestamp(System.currentTimeMillis()).toString();
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        this.brothers.add(new String(array, Charset.forName("UTF-8")));
        new Random().nextBytes(array);
        this.brothers.add(new String(array, Charset.forName("UTF-8")));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBrothers() {
        return brothers;
    }

    public void setBrothers(List<String> brothers) {
        this.brothers = brothers;
    }
}
