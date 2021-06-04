package ru.job4j.generics;

public class User extends Base {
    private final String name;

    public User(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return super.getId().equals(user.getId()) && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return (name + super.getId()).hashCode();
    }

    @Override
    public String toString() {
        return "User{ id=" + super.getId()
                + "name=" + name
                + '}';
    }
}
