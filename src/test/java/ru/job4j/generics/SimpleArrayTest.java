package ru.job4j.generics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleArrayTest {
    private SimpleArray<Integer> sa;

    @Before
    public void setUp() {
        sa = new SimpleArray<>();
        sa.add(3);
        sa.add(5);
        sa.add(6);
    }

    @Test
    public void addAndGet() {
       Assert.assertEquals(3, (int) sa.get(0));
       Assert.assertEquals(5, (int) sa.get(1));
       Assert.assertEquals(6, (int) sa.get(2));
    }

    @Test
    public void set() {
        sa.set(1, 8);
        Assert.assertEquals(8, (int) sa.get(1));
    }

    @Test
    public void remove() {
        sa.add(9);
        Assert.assertEquals(6, (int) sa.get(2));
        sa.remove(0);
        Assert.assertEquals(5, (int) sa.get(0));
        Assert.assertEquals(6, (int) sa.get(1));
        Assert.assertEquals(9, (int) sa.get(2));
    }

    @Test
    public void size() {
        assertEquals(3, sa.size());
        sa.add(0);
        assertEquals(4, sa.size());
        sa.remove(3);
        assertEquals(3, sa.size());
    }

    @Test
    public void iterator() {
        Iterator<Integer> iter = sa.iterator();
        assertEquals(true, iter.hasNext());
        assertEquals(3, (int) iter.next());
        assertEquals(5, (int) iter.next());
        assertEquals(6, (int) iter.next());
    }

    @Test
    public void growCheck() {
        for (int i = 0; i < 250; i++) {
            sa.add(i);
        }
        for (; sa.size() > 0;) {
            sa.remove(sa.size() - 1);
        }

    }
}