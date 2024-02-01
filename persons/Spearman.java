package persons;

import persons.abstracts.*;

public class Spearman extends Infantrymen{

    public Spearman(String name, int x, int y){
        super(name,
        true,
        true,
        true,
        100,
        100,
        new int[]{4, 6},
        x,
        y,
        1);

        this.currentArmor = 10;
    }

    @Override
    public String toString() {
        return "Копейщик: " + super.toString();
    }

    @Override
    public String getInfo() {
        String result = "Копейщик";
        return result;
    }
}
