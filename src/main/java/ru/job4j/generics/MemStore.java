/**
 * 1. Реализуйте методы в классе MemStore.
 * 2. Реализуйте методы в классе UserStore.
 * 3. Создайте и реализуйте класс RoleStore.
 */

package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base>  implements Store<T> {
    private final Map<String, T> mem = new HashMap<>();

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public void add(T model) {
        mem.put(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        return mem.replace(id, model) != null;
    }

    @Override
    public boolean delete(String id) {
        return mem.remove(id, mem.get(id));
    }

    @Override
    public T findById(String id) {
        return mem.get(id);
    }
}
