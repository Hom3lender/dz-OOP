package persons;

import persons.abstracts.*;

public class Robber extends Infantrymen{

    public Robber(String name, int x, int y){
        super(name,
        true,
        true,
        true,
        100,
        100,
        new int[]{10, 13},
        x,
        y,
        1);

        this.currentArmor = 10;
    }

    @Override
    public String toString() {
        return "Грабитель: " + super.toString();
    }

    @Override
    public String getInfo() {
        String result = "Грабитель";
        return result;
    }
}
