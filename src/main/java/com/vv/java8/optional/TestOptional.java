package com.vv.java8.optional;

import java.util.Optional;

/**
 * Created by vasudvis on 12/19/2016.
 */
public class TestOptional {
    public static void main(String[] args) {
        findUser(1L).ifPresent((user) -> {
            System.out.println(user);
        });
    }


    public static Optional<User> findUser(Long id) {
        if (id.equals(1L)) {
            return Optional.of(new User(1L, "Sam"));
        } else {
            return Optional.empty();
        }
    }
}


class User {
    private Long id;
    private String name;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
