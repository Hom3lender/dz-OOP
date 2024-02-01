package persons;

import java.util.List;

import persons.abstracts.*;

public class Archer extends Shooter {

    public Archer(String name, int x, int y) {
        super(name,
        false,
        false,
        true,
        100,
        100,
        new int[]{5, 10},
        x,
        y,
        3);

        this.maxArrows = this.currentArrows = 10;
    }

    @Override
    public String toString() {
        return "Лучник: " + super.toString();
    }

    @Override
    public String getInfo() {
        String result = "Лучник";
        return result;
    }
}
