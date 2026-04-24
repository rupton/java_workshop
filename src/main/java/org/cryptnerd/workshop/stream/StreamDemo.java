package org.cryptnerd.workshop.stream;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> magicNumbers = new ArrayList<>(Arrays.asList(1, 100, 1000, 10000));
        Stream<Integer> magicNumberStream = magicNumbers.stream();
        magicNumberStream.forEach(System.out::println);
    }
}

