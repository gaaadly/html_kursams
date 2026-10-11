package lt.techin.stream;

import java.util.List;

/** Provided immutable directory entry. @author JaroslavGr */
public final class User {
    private final String name;
    private final int age;
    private final String city;
    private final boolean active;
    private final List<String> interests;

    public User(String name, int age, String city, boolean active, List<String> interests) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.active = active;
        this.interests = List.copyOf(interests);
    }

    /** Convenience constructor for examples that need only name and age. */
    public User(String name, int age) {
        this(name, age, "", false, List.of());
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCity() { return city; }
    public boolean isActive() { return active; }
    public List<String> getInterests() { return interests; }
}
