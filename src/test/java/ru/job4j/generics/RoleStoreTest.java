package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoleStoreTest {
    private RoleStore rosto;
    private Role[] roles;

    @Before
    public void setUp() {
        rosto = new RoleStore();
        roles = new Role[]{
                new Role("001", "Admin"),
                new Role("002", "Director"),
                new Role("003", "Manager"),
                new Role("004", "Buch"),
                new Role("005", "User")
        };
        for (int i = 0; i < roles.length; i++) {
            rosto.add(roles[i]);
        }
    }

    @Test
    public void add() {
        Role expected = new Role("006","Guest");
        rosto.add(expected);
        assertEquals(expected, rosto.findById("006"));
    }

    @Test
    public void replace() {
        Role expected = new Role("001", "James Bond");
        rosto.replace("004", expected);
        assertEquals(expected, rosto.findById("004"));
    }

    @Test
    public void delete() {
        rosto.delete("005");
        assertNull(rosto.findById("006"));
        rosto.delete("002");
        assertNull(rosto.findById("002"));
    }

    @Test
    public void findByIdExtended() {
        assertEquals(roles[0], rosto.findById("001"));
    }
}