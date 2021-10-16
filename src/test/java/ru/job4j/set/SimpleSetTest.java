package ru.job4j.set;

import org.junit.Test;

import javax.imageio.ImageTranscoder;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenWrongIndex() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        Iterator<Integer> itr = set.iterator();
        itr.next();
        itr.next();
    }

    @Test
    public void checkElementsCount() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        int counter = 0;
        Iterator<Integer> itr = set.iterator();
        for (; itr.hasNext(); itr.next()) {
            counter++;
        }
        assertThat(counter, is(4));
    }


    @Test
    public void checkSeveralValues() {
        Set<String> set = new SimpleSet<>();
        set.add("apple");
        set.add("branch");
        set.add("zen");
        assertTrue(set.contains("branch"));
        assertTrue(set.contains("apple"));
        assertTrue(set.contains("zen"));
    }


}