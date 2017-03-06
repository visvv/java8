package com.vv.java8.lambdas;

import java.util.Comparator;

/**
 * Created by vasudvis on 2/18/2017.
 */
public class SimpleRep {

    public static void main(String args){
        Comparator<String> cpm1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        Comparator<String> cpm2 = (String s1, String s2) -> {return s1.compareTo(s2);};

        Comparator<String> cpm3 = (s1, s2) -> {return s1.compareTo(s2);};

        Comparator<String> cpm4 = (s1, s2) ->  s1.compareTo(s2);


        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running...");
            }
        };

        Runnable run2 = ()->{System.out.println("Simple java...");};

        Runnable run3 = ()-> System.out.println("Simple java...");









    }
}
