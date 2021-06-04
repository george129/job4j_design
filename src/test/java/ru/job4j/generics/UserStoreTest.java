package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserStoreTest {
    private UserStore user;
    private User[] users;

    @Before
    public void setUp() {
        user = new UserStore();
        users = new User[]{
                new User("001", "Admin"),
                new User("002", "Director"),
                new User("003", "Manager"),
                new User("004", "Buch"),
                new User("005", "User")
        };
        for (int i = 0; i < users.length; i++) {
            user.add(users[i]);
        }
    }

    @Test
    public void add() {
        User expected = new User("006","Guest");
        user.add(expected);
        assertEquals(expected, user.findById("006"));
    }

    @Test
    public void replace() {
        User expected = new User("001", "James Bond");
        user.replace("004", expected);
        assertEquals(expected, user.findById("004"));
    }

    @Test
    public void delete() {
        user.delete("005");
        assertNull(user.findById("006"));
        user.delete("002");
        assertNull(user.findById("002"));
    }

    @Test
    public void findByIdExtended() {
        assertEquals(users[0], user.findById("001"));
    }
}