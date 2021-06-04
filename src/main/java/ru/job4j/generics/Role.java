package ru.job4j.generics;

public class Role extends Base {
    private final String name;

    public Role(String id, String name) {
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

        Role role = (Role) o;

        return super.getId().equals(((Role) o).getId()) && name.equals(((Role) o).getName());
    }

    @Override
    public int hashCode() {
        return (name + super.getId()).hashCode();
    }

    @Override
    public String toString() {
        return "Role{ "
                + "Id=" + super.getId()
                + " name=" + name + ' '
                + '}';
    }
}
