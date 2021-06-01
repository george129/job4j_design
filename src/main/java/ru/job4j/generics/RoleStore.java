package ru.job4j.generics;

public class RoleStore<T extends Base> implements Store<T>{
    @Override
    public void add(T model) {

    }

    @Override
    public boolean replace(String id, T model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public T findById(String id) {
        return null;
    }
}
