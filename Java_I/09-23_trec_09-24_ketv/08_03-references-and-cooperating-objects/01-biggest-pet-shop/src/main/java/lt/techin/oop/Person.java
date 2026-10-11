package lt.techin.oop;

public class Person {
    private String name;
    private Pet pet;

    public Person(String name, Pet pet) { this.name = name; this.pet = pet; }
    public Person(String name) { this(name, new Pet("Toothless", "dragon")); }
    public Person() { this("Lilo", new Pet("Stitch", "blue alien")); }

    @Override public String toString() {
        // TODO: include this person's name and the stored pet's name and breed.
        return name + ", has a friend called " + pet.getName() + " (" + pet.getBreed() + ")";
    }
}
