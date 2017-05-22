package com.yqc.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yangqc on 2017/5/22.
 */
public class LambdaTest1 {

    public List<Dog> animalToDog() {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(new Animal("dog" + i, i));
        }

        List dogList = list.stream().map(s -> {
            Animal animal = (Animal) s;
            return new Dog(animal.getName(), animal.getAge());
        }).collect(Collectors.toList());
        return dogList;
    }

    public static void main(String[] args) {

    }
}
