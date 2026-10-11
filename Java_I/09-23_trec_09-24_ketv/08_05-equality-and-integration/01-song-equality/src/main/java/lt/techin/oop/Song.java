package lt.techin.oop;

public class Song {

    private String artist;
    private String name;
    private int durationInSeconds;


    public Song(String artist,String name,int durationInSeconds) {
        this.artist=artist;this.name=name;this.durationInSeconds=durationInSeconds;
    }

    @Override public String toString() {
        return artist+": "+name+" ("+durationInSeconds+" s)";
    }

    @Override public boolean equals(Object other) {
        // TODO: implement the contract in README.md / README.lt.md.
        if (this == other) {
            return true;
        }
        if (!(other instanceof Song)) {
            return false;
        }
        Song song = (Song) other;
        return durationInSeconds == song.durationInSeconds
                && java.util.Objects.equals(artist, song.artist)
                && java.util.Objects.equals(name, song.name);
    }

    @Override public int hashCode() {
        // TODO: implement the contract in README.md / README.lt.md.
        return java.util.Objects.hash(artist, name, durationInSeconds);
    }
}
