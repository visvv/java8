package com.vv.java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vasudvis on 12/19/2016.
 */
public class TestStream {
    public static void main(String[] args) {
        List<String> names =  new ArrayList<String>(){{
            add("one");
            add("two");
            add("three");
            add("four");
            add("five");
            add("six");
        }};

        names.stream().forEach(System.out::println);
        names.stream().forEach(TestStream::show);

        names.stream().map(String::toUpperCase)
                .filter((name)-> name.equals("SIX"))
                .forEach(System.out::println);



    }


    public static void show(String name){
        System.out.println(name);
    }
}
