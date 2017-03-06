package com.vv.java8.nullcheck;

import javafx.beans.binding.ObjectBinding;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by vasudvis on 12/23/2016.
 */
public class AvoidNullCheck {


    public static void main(String[] args) {
        applyIfNotNull("Sachin", System.out::println);
        applyIfNotNull("Sachin", (val) -> System.out.println(val));
        applyIfNotNull(null, System.out::println);
//
//        if (obj != null) {
//            obj.foo();
//        }

        String username1 = "Username 1";
        String username2 = "Username 2";

        if (username1 != null) {
            System.out.println(username1);
            if (username2 != null) {
                System.out.println(username2);
            }
        }
        Consumer<String> consumer1 = (val) -> System.out.println(val);
        Consumer<String> consumer2 = (val) -> System.out.println(val);


        applyIfNotNull(username1, (val) -> {
            System.out.println(val);
            applyIfNotNull(username2, System.out::println);
        });

        applyIfPresent("tim", System.out::println);
        User user = new User();
       // applyIfNotNull(user, ()->user.setName(""));

    }

    public static <T> void applyIfNotNull(T value, Consumer<T> function) {
        if (value != null) {
            function.accept(value);
        }
    }

    public static <T> Optional<Boolean> applyIfPresent(T value, Consumer<T> function) {
        if (value != null) {
            function.accept(value);
            return Optional.of(true);
        } else {
            return Optional.empty();
        }
    }
}

class User {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
