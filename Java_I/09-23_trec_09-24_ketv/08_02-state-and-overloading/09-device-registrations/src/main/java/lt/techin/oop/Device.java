package lt.techin.oop;

public class Device {

    public static final String DEFAULT_NAME = "Unnamed";
    private static int count;

    private final int id;
    private String name;


    public Device(int id) {
        // TODO: implement the contract in README.md / README.lt.md.
        this(id, DEFAULT_NAME);
    }

    public Device(int id,String name) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.id = id;
        this.name = name;
        count = count + 1;
    }

    public int getId() {
        // TODO: implement the contract in README.md / README.lt.md.
        return id;
    }

    public String getName() {
        // TODO: implement the contract in README.md / README.lt.md.
        return name;
    }

    public void setName(String name) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.name = name;
    }

    public static int getCount() {
        // TODO: implement the contract in README.md / README.lt.md.
        return count;
    }
}