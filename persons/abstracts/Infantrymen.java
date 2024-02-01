package persons.abstracts;

import java.util.List;

import persons.coordinates.PersonPosition;

public abstract class Infantrymen extends Person{

    protected int currentArmor;

    public Infantrymen(String name, boolean isMovable, boolean isMelee, boolean isMilitary, int maxHealth,
            int currentHealth, int[] damage, int x, int y, int initiative){
        super(name, isMovable, isMelee, isMilitary, maxHealth, currentHealth, damage, x, y, initiative);
    }

    public void attack(Person person) {
        int damage = Person.random.nextInt(this.damage[1] - this.damage[0] + 1) + this.damage[0];
        person.getDamage(damage);
    }

    public PersonPosition moving(Person nearestEnemy){
        PersonPosition deltaPosition = personPosition.deltaCoordinatesToPerson(nearestEnemy.personPosition);
        PersonPosition wantToGetPosition = new PersonPosition(this.personPosition.getX(), this.personPosition.getY());
        if(deltaPosition.getX() > 0){
            wantToGetPosition.setX(personPosition.getX() - 1);
            return wantToGetPosition;
        }

        if(deltaPosition.getX() < 0){
            wantToGetPosition.setX(personPosition.getX() + 1);
            return wantToGetPosition;
        }

        if(deltaPosition.getY() > 0){
            wantToGetPosition.setY(personPosition.getY() - 1);
            return wantToGetPosition;
        }

        if(deltaPosition.getY() < 0){
            wantToGetPosition.setY(personPosition.getY() + 1);
            return wantToGetPosition;
        }
        return wantToGetPosition;
    }

    @Override
    public void getDamage(int damage) {
        if (this.currentArmor - damage > 0) {
            this.currentArmor -= damage;
        }
        else if((this.currentHealth + this.currentArmor) - damage > 0){
            this.currentHealth = (this.currentHealth + this.currentArmor) - damage;
        }
        else{
            this.currentHealth = 0;
        }
    }

    @Override
    public String toString() {
        return "имя " + name + " (здоровье: " + currentHealth + ")";
    }

    @Override
    public void step(List<Person> enemyTeam, List<Person> alliedTeam) {
        if(this.currentHealth == 0) return;
        Person nearestEnemy = getNearestLivingEnemy(enemyTeam);
        if(this.personPosition.getDistance(nearestEnemy.personPosition) < 2){
            attack(nearestEnemy);
        }
        else{
            PersonPosition getToPosition = moving(nearestEnemy);
            boolean step = true;
            for(Person person: alliedTeam){
                if(getToPosition.equals(person.personPosition)) step = false;
            }
            if(step) personPosition = getToPosition;
        }
    }

    @Override
    public String getType() {
        return "Пихотинец";
    }
}
