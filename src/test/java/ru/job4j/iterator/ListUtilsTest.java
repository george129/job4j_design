package ru.job4j.iterator;

import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {
    private List<Integer> input;

    @Before
    public void setUp() {
        input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
    }

    @Test
    public void whenAddBefore() {
        ListUtils.addBefore(input, 1, 4);

        assertThat(input, is(Arrays.asList(0, 4, 1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        ListUtils.addBefore(input, 4, 2);
    }

    @Test
    public void whenAddAfterLast() {
        ListUtils.addAfter(input, 3, 4);

        assertThat(input, is(Arrays.asList(0, 1, 2, 3, 4)));
    }

    @Test
    public void whenRemoveIf() {
        Predicate<Integer> prdct = new Predicate<Integer>() {
            @Override
            public boolean test(Integer value) {
                return value < 3;
            }
        };
        ListUtils.removeIf(input, prdct);
        assertThat(input, is(Arrays.asList(3)));
    }

    @Test
    public void whenReplaceIf() {
        Predicate<Integer> prdct = new Predicate<Integer>() {
            @Override
            public boolean test(Integer value) {
                return value <= 3 && value > 1;
            }
        };

        ListUtils.replaceIf(input, prdct, 0);
        assertThat(input, is(Arrays.asList(0, 1, 0, 0)));
    }

    @Test
    public void whenReplaceAll() {
        List<Integer> checklist = new ArrayList<>(Arrays.asList(0, 2));
        ListUtils.removeAll(input, checklist);
        assertThat(input, is(Arrays.asList(1, 3)));
    }
}