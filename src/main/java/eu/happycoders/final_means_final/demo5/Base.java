package eu.happycoders.final_means_final.demo5;

import java.util.HashSet;

class Base {
    public static final HashSet<Base> SET = new HashSet<>();

    Base() {
        SET.add(this);
    }
}