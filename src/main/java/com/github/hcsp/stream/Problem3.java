package com.github.hcsp.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Problem3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "bb", "ccc", "d");
        // [1,2,3,1]


        System.out.println(list.stream().map(String::length).collect(new MyToListCollector()));
//        MySetCollector myCollector = new MySetCollector();//new MyCollector();
//
//
//        List<Integer> result = myCollector.getSupplier().get();
//
//        list.stream().map(String::length).forEach(element -> {
//            myCollector.getBiConsumer().accept(result, element);
//        });


    }
}

class MyToListCollector implements Collector<Integer, List, List> {
    @Override
    public Supplier<List> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List, Integer> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List, List> finisher() {
        return x -> x;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}

//class MyCollector implements Collector<Integer, List, Void> {
//    @Override
//    public Supplier<List> supplier() {
//        return ArrayList::new;
//    }
//
//    @Override
//    public BiConsumer<List, Integer> accumulator() {
//        return List::add;
//    }
//
//    @Override
//    public BinaryOperator<List> combiner() {
//        return null;
//    }
//
//    @Override
//    public Function<List, Void> finisher() {
//        return null;
//    }
//
//    @Override
//    public Set<Characteristics> characteristics() {
//        return null;
//    }
//}
//
//class MySetCollector implements Collector<Integer, Set, Void> {
//    @Override
//    public Supplier<Set> supplier() {
//        return HashSet::new;
//    }
//
//    @Override
//    public BiConsumer<Set, Integer> accumulator() {
//        return Set::add;
//    }
//
//    @Override
//    public BinaryOperator<Set> combiner() {
//        return null;
//    }
//
//    @Override
//    public Function<Set, Void> finisher() {
//        return null;
//    }
//
//    @Override
//    public Set<Characteristics> characteristics() {
//        return null;
//    }
//}

