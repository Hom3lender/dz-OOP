package persons.abstracts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import persons.coordinates.PersonPosition;
import persons.interfaces.*;

/*
    * name             - имя
    * isMovable        - подвижен
    * isMelee          - предназначен для ближнего боя
    * ismilitary       - является военным
    * maxHealth        - максимальное здоровье
    * currentHealth    - текущее здоровье
    * damage            -повреждение
    * personPosition    -позиция персонажа
    * initiative        -очередность хода
 */
public abstract class Person implements GameI{

    protected static Random random;

    protected String name;
    protected boolean isMovable;
    protected boolean isMelee;
    protected boolean isMilitary;
    protected int maxHealth;
    protected int currentHealth;
    protected int[] damage;
    protected PersonPosition personPosition;
    protected int initiative;

    static {
        Person.random = new Random();
    }

    public Person(String name, boolean isMovable,
            boolean isMelee, boolean isMilitary, int maxHealth,
            int currentHealth, int[] damage, int x, int y, int initiative) {
        this.name = name;
        this.isMovable = isMovable;
        this.isMelee = isMelee;
        this.isMilitary = isMilitary;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.damage = damage;
        this.personPosition = new PersonPosition(x, y);
        this.initiative = initiative;
    }

    public int getInitiative(){
        return initiative;
    }

    public void getDamage(int damage) {
        this.currentHealth -= damage;
        if(this.currentHealth < 0){
            this.currentHealth = 0;
        }
    }

    public PersonPosition getPersonPosition(){
        return new PersonPosition(personPosition.getX(), personPosition.getY());
    }

    public void healedHealth(int health){
        if(this.currentHealth + health > this.maxHealth){
            this.currentHealth = this.maxHealth;
        }
        else{
            this.currentHealth = this.currentHealth + health;
        }
    }

    public void outputDistanceToEnemy(List<Person> persons){
        for(Person person: persons){
            System.out.print(person.personPosition.getDistance(personPosition) + ", ");
        }
        //persons.forEach(n->System.out.print(this.positionPerson.distance(n.positionPerson) + ", "));
        System.out.println();
    }

    public Person getNearestLivingEnemy(List<Person> persons){
        Person nearestEnemy = persons.get(0);
        float minDistanc = persons.get(0).personPosition.getDistance(personPosition);
        for(int i = 1; i < persons.size(); i ++){
            float distance = persons.get(i).personPosition.getDistance(personPosition);
            if(distance < minDistanc && persons.get(i).currentHealth > 0){
                minDistanc = distance;
                nearestEnemy = persons.get(i);
            }
        }
        return nearestEnemy;
    }

    public Person getPersonWithMinAmountLife(List<Person> persons){
        Person minLifePerson = persons.get(0);
        int minHealth = persons.get(0).currentHealth;
        for(int i = 1; i < persons.size(); i ++){
            int health = persons.get(i).currentHealth;
            if(health < minHealth && persons.get(i).currentHealth > 0){
                minHealth = health;
                minLifePerson = persons.get(i);
            }
        }
        return minLifePerson;
    }

    public int[] getCoords(){
        return new int[]{personPosition.getX(), personPosition.getY()};
    }

    public int getHp(){
        return this.currentHealth;
    }

    public abstract String getInfo();

    public abstract String getType();

    @Override
    public void step(List<Person> enemyTeam, List<Person> alliedTeam) {
        System.out.println("Не инициализировано");
    }
}
