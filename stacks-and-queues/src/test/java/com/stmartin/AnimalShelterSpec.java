package com.stmartin;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by martinshen on 2017/10/3.
 * Spec:
 * 1. design a class which is a queue.
 * 2. items in the queue are dogs and cats.
 * 3. support dequeueDog and dequeCat.
 */
public class AnimalShelterSpec {
    AnimalShelter shelter;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        shelter = new AnimalShelter();
    }

    @Test
    public void whenEnqueueAndDequeueThenOK() {
        shelter.enqueue("cat");
        shelter.enqueue("dog");
        assertEquals(shelter.dequeue(), "cat");
        assertEquals(shelter.dequeue(), "dog");
    }

    @Test
    public void whenEnqueueAndDequeueCatThenCat() {
        shelter.enqueue("dog");
        shelter.enqueue("cat");
        assertEquals(shelter.dequeueCat(), "cat");
    }

    @Test
    public void whenEnqueueAndDequeueDogThenDog() {
        shelter.enqueue("cat");
        shelter.enqueue("dog");
        assertEquals(shelter.dequeueDog(), "dog");
    }
}
