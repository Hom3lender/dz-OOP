package persons.abstracts;

import java.util.List;

public abstract class Wizards extends Person{

    protected int currentMana, maxMana, recoveryMana;
    protected boolean flagRevival = false;

    public Wizards(String name, boolean isMovable, boolean isMelee, boolean isMilitary, int maxHealth,
            int currentHealth, int[] damage, int x, int y, int initiative){
        super(name, isMovable, isMelee, isMilitary, maxHealth, currentHealth, damage, x, y, initiative);
    }

    public void treatment(Person person){
        int health = Person.random.nextInt(this.damage[1] - this.damage[0] + 1) + this.damage[0];
        if (person.currentHealth > 0 && person.currentHealth < person.maxHealth) {
            person.currentHealth = person.currentHealth + health;
            currentMana = currentMana - health;
            if (person.currentHealth > person.maxHealth) person.currentHealth = person.maxHealth;
            if(currentMana < 0) currentMana = 0;
        }
    }

    public void revival(List<Person> enemyTeam, List<Person> alliedTeam){

        if(alliedTeam.stream().allMatch(n-> !n.getType().equals("Пихотинец") && n.currentHealth < 1)){
            flagRevival = true;
            if(currentMana < maxMana) return;
            for(Person h: alliedTeam){
                if(h.getType().equals("Пихотинец")){
                    for(Person enemy: enemyTeam){
                        if(h.personPosition.getDistance(enemy.personPosition) == 0){
                            return;
                        }
                    }
                    for(Person aiiied: alliedTeam){
                        if(h.personPosition.getDistance(aiiied.personPosition) == 0){
                            return;
                        }
                    }
                    h.currentHealth = h.maxHealth;
                    currentMana -= maxMana/2;
                    flagRevival = false;
                    return;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "имя " + name + " (здоровье: " + currentHealth + " манна: " + currentMana +")";
    }

    @Override
    public void step(List<Person> enemyTeam, List<Person> alliedTeam) {
        if(this.currentHealth == 0) return;
        revival(enemyTeam, alliedTeam);
        if(!flagRevival){
            treatment(getPersonWithMinAmountLife(alliedTeam));
        }
        currentMana += recoveryMana;
        if(currentMana > maxMana) currentMana = maxMana;
    }

    @Override
    public String getType() {
        return "Волшебник";
    }
}
