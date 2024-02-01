package persons;

import java.util.List;

import persons.abstracts.*;

public class Sniper extends Shooter{

    public Sniper(String name, int x, int y){
        super(name,
        false,
        false,
        true,
        100,
        100,
        new int[]{10, 13},
        x,
        y,
        3);

        this.maxArrows = this.currentArrows = 10;
    }

    @Override
    public String toString() {
        return "Снайпер: " + super.toString();
    }

    @Override
    public String getInfo() {
        String result = "Снайпер";
        return result;
    }
}
