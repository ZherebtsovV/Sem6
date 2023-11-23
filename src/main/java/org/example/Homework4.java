package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Fruit {
    int weight;

    Fruit(int weight) {
        this.weight = weight;
    }
}

class Apple extends Fruit {
    Apple(int weight) {
        super(weight);
    }
}

class Orange extends Fruit {
    Orange(int weight) {
        super(weight);
    }
}

class GoldenApple extends Apple {
    GoldenApple(int weight) {
        super(weight);
    }
}

class Box<T extends Fruit> implements Iterable<T> {
    private List<T> fruits;

    Box() {
        this.fruits = new ArrayList<>();
    }

    void add(T fruit) {
        fruits.add(fruit);
    }

    double getWeight() {
        return fruits.stream().mapToDouble(f -> f.weight).sum();
    }

    void move(Box<? super T> box) {
        box.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return fruits.iterator();
    }
}

public class Homework4 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        System.out.println(appleBox.getWeight()); // 0
        appleBox.add(new Apple(2)); // Должно компилироваться
        appleBox.add(new Apple(4)); // Должно компилироваться
        System.out.println(appleBox.getWeight()); // 6
        // appleBox.add(new Orange(4)); // Не должно компилироваться!!!
        appleBox.add(new GoldenApple(4)); // Должно компилироваться
        System.out.println(appleBox.getWeight()); // 10

        Box<Orange> orangeBox = new Box<>();
        // orangeBox.add(new Apple(2)); // Не должно компилироваться!!!
        orangeBox.add(new Orange(8)); // Должно компилироваться
        System.out.println(orangeBox.getWeight()); // 8

        // orangeBox.move(appleBox); // Не должно компилироваться!!!
        // appleBox.move(orangeBox); // Не должно компилироваться!!!

        Box<GoldenApple> goldenAppleBox = new Box<>();
        goldenAppleBox.add(new GoldenApple(20)); // Должно компилироваться
        // goldenAppleBox.add(new Apple(20)); // Не должно компилироваться!!!

        // appleBox.move(goldenAppleBox); // Должно компилироваться
        goldenAppleBox.move(appleBox); // Должно компилироваться

        System.out.println(goldenAppleBox.getWeight()); // 0
        System.out.println(appleBox.getWeight()); // 30

        for (Apple apple : appleBox) { // Должно компилироваться
        }
        for (GoldenApple goldenApple : goldenAppleBox) { // Должно компилироваться
        }
        for (Orange orange : orangeBox) { // Должно компилироваться
        }
    }
}