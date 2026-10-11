package lt.techin.oop;

public class Menu {

    private java.util.List<String> meals = new java.util.ArrayList<>();


    public Menu() {
        // TODO: implement the contract in README.md / README.lt.md.
    }

    public void addMeal(String meal) {
        // TODO: implement the contract in README.md / README.lt.md.
        if (!meals.contains(meal)) {
            meals.add(meal);
        }
    }

    public void printMeals() {
        // TODO: implement the contract in README.md / README.lt.md.
        for (String meal : meals) {
            System.out.println(meal);
        }
    }

    public void clearMenu() {
        // TODO: implement the contract in README.md / README.lt.md.
        meals.clear();
    }
}