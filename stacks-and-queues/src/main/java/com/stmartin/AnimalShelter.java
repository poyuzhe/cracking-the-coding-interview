package com.stmartin;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by martinshen on 2017/10/3.
 * Animal Shelter: design a class which is a queue, whose items are only dogs and cats. Additional operations include
 * dequeueDog and dequeueCat.
 */
class AnimalShelter {
    LinkedList<Animal> catList = new LinkedList<>();
    LinkedList<Animal> dogList = new LinkedList<>();

    public void enqueue(String animal) {
        int biggestCat = catList.size() == 0 ? 0 : catList.getLast().index;
        int biggestDog = dogList.size() == 0 ? 0 : dogList.getLast().index;
        int currentIndex = biggestCat > biggestDog ? biggestCat : biggestDog;
        if (animal.equals("cat")) {
            catList.add(new Animal("cat", currentIndex + 1));
        } else if (animal.equals("dog")) {
            dogList.add(new Animal("dog", currentIndex + 1));
        }
    }

    public String dequeue() {
        if (catList.size() == 0 && dogList.size() == 0) {
            throw new NoSuchElementException();
        }
        if (catList.size() == 0) {
            return dogList.removeFirst().name;
        }
        if (dogList.size() == 0) {
            return catList.removeFirst().name;
        }
        if (catList.getFirst().index < dogList.getFirst().index) {
            return catList.removeFirst().name;
        } else {
            return dogList.removeFirst().name;
        }
    }

    public String dequeueCat() {
        return catList.removeFirst().name;
    }

    public String dequeueDog() {
        return dogList.removeFirst().name;
    }

    public static class Animal {
        String name;
        int index;

        public Animal(String type, int index) {
            this.name = type;
            this.index = index;
        }
    }
}
