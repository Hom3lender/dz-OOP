package persons;

import persons.abstracts.*;

public class Sorcerer extends Wizards{

    public Sorcerer(String name, int x, int y){
        super(name,
        false,
        false,
        true,
        100,
        100,
        new int[]{5, 15},
        x,
        y,
        2);

        currentMana = maxMana = 20;
        recoveryMana = 3;
    }

    @Override
    public String toString() {
        return "Колдун: " + super.toString();
    }

    @Override
    public String getInfo() {
        String result = "Колдун";
        return result;
    }
}
