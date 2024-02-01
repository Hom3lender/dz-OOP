package persons;

import java.util.List;

import persons.abstracts.*;

public class Villager extends Person{

    private boolean isReady;

    public Villager(String name, int x, int y){
        super(name,
        false,
        false,
        false,
        100,
        100,
        new int[]{0, 0},
        x,
        y,
        0);

        isReady = true;
    }

    public boolean getIsReady(){
        return isReady;
    }

    public void setIsReady(boolean r){
        isReady = r;
    }

    @Override
    public String toString() {
        return "Крестьянин: имя " + name + " (здоровье: " + currentHealth + ")";
    }

    @Override
    public String getInfo() {
        String result = "Крестьянин";
        return result;
    }

    @Override
    public void step(List<Person> enemyTeam, List<Person> alliedTeam) {
        if(this.currentHealth == 0) return;
        isReady = true;
    }

    @Override
    public String getType() {
        return "Крестьянин";
    }
}
