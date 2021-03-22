package ru.job4j.it;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.it.EvenIterator;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class EvenIteratorTest {

    @Test
    public void noEven() {
        EvenIterator itr = new EvenIterator(new int[] {1, 3, 7});
        assertFalse(itr.hasNext());
    }

    @Test
    public void mixed1() {
        EvenIterator itr = new EvenIterator(new int[] {1, 3, 4});
        assertTrue(itr.hasNext());
        itr.next();
        assertFalse(itr.hasNext());
//        Assert.assertEquals(false, itr.hasNext());
    }

    @Test
    public void mixed2() {
        EvenIterator itr = new EvenIterator(new int[]{1, 2, 3});
        assertTrue(itr.hasNext());
        itr.next();
        assertFalse(itr.hasNext());
//        Assert.assertEquals(false, itr.hasNext());
    }

    @Test
    public void evenThenOddThenEven() {
        EvenIterator itr = new EvenIterator(new int[]{2, 3, 4});
        assertTrue(itr.hasNext());
        itr.next();
        assertTrue(itr.hasNext());
        itr.next();
        assertFalse(itr.hasNext());
//        Assert.assertEquals(false, itr.hasNext());
    }

    @Test
    public void get1() {
        EvenIterator itr = new EvenIterator(new int[]{1, 2, 3, 4, 5, 6, 8, 7});
        Assert.assertEquals(2, (int) itr.next());
        Assert.assertEquals(4, (int) itr.next());
        Assert.assertEquals(6, (int) itr.next());
        Assert.assertEquals(8, (int) itr.next());
        assertFalse(itr.hasNext());
    }

    @Test
    public void onlyOneEven() {
        EvenIterator itr = new EvenIterator(new int[]{1, 3, 1, 4, 3, 1});
        assertEquals(4, (int) itr.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void getException() {
        EvenIterator itr = new EvenIterator(new int[]{1, 11, 13});
        itr.next();
    }
}