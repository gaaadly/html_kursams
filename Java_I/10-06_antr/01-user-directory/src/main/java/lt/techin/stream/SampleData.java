package lt.techin.stream;

import java.util.List;

/** Shared sample directory used in the brief. @author JaroslavGr */
public final class SampleData {
    private SampleData() { }

    public static List<User> users() {
        return List.of(
            new User("Zoe", 30, "Vilnius", true, List.of("Java", "Hiking", "Java")),
            new User("Ana", 17, "Kaunas", true, List.of("Music", "Java")),
            new User("Bob", 18, "Vilnius", false, List.of("Gaming")),
            new User("Zoe", 40, "Kaunas", true, List.of()),
            new User("Ana", 20, "Vilnius", true, List.of(" java ", "MUSIC", "")),
            new User("Cara", 18, "Vilnius", true, List.of("Hiking", "Java")),
            new User("Dan", 25, "Klaipeda", false, List.of("Cooking")),
            new User("Eve", 26, "Vilnius", true, List.of("JAVA", "Cycling"))
        );
    }
}
