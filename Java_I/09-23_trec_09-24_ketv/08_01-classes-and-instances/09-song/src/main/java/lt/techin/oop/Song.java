package lt.techin.oop;

public class Song {
    // TODO: declare name and length fields.
    private String name;
    private int length;
    public Song(String name, int length) {
        // TODO: store both arguments.
        this.name = name;
        this.length = length;
    }
    public String getName() {
        // TODO: return the name.
        return name;
    }
    public int getLength() {
        // TODO: return the length in seconds.
        return length;
    }
}
