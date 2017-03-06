package com.vv.java8.stream;

import java.util.stream.IntStream;

/**
 * Created by vasudvis on 12/27/2016.
 */
public class PrintNumber {
    public static void main(String[] args) {
        IntStream.range(1,101).forEach(System.out::println);

        for(int i=1; i <= 100; i++){
            System.out.println(i);
        }



    }
}
