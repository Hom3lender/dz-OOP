import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import persons.*;
import persons.abstracts.*;
public class Main {

    public static List<Person> teamA = new ArrayList<>();
    public static List<Person> teamB = new ArrayList<>();
    public static List<Person> personsOrder = new ArrayList<>();
    public static void main(String[] args) {
        //создание и расстановка команд
        teamA = createTeam(0, 1);
        teamB = createTeam(3, 10);

        personsOrder.addAll(teamA);
        personsOrder.addAll(teamB);

        personsOrder.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getInitiative() - o1.getInitiative();
            }
        });

        Scanner entScanner = new Scanner(System.in);
        boolean flag;

        while (true) {
            View.view();

            if (gameOverTeamA()){
                flag = true;
                break;
            }
            if (gameOverTeamB()){
                flag = false;
                break;
            }

            for(Person team: personsOrder){
                if(teamA.contains(team)){
                    team.step(teamB, teamA);
                }
                else{
                    team.step(teamA, teamB);
                }
            }

            String s = entScanner.nextLine();
        }

        if (flag){
            System.out.println("Победила команда В");
        } else {
            System.out.println("Победила команда А");
        }

    }

    static List<Person> createTeam(int personNumber, int y){
        List<Person> gameTeam = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i < 11; i++) {
            int createPerson = random.nextInt(5 - 1) + 1 + personNumber;
            switch (createPerson) {
                case 1:
                    gameTeam.add(new Archer(getName(), i, y));
                    break;
                case 2:
                    gameTeam.add(new Monk(getName(), i, y));
                    break;
                case 7:
                    gameTeam.add(new Robber(getName(), i, y));
                    break;
                case 5:
                    gameTeam.add(new Sniper(getName(),  i, y));
                    break;
                case 6:
                    gameTeam.add(new Sorcerer(getName(),  i, y));
                    break;
                case 4:
                    gameTeam.add(new Villager(getName(),  i, y));
                    break;
                case 3:
                    gameTeam.add(new Spearman(getName(),  i, y));
                    break;
            }
        }

        return gameTeam;
    }

    static String getName() {
        return Names.values()[new Random().nextInt(Names.values().length - 1)].toString();
    }

    public static boolean gameOverTeamA(){
        for (Person person : teamA) {
            if (person.getHp() > 0) return false;
        }
        return true;
    }
    public static boolean gameOverTeamB(){
            for (Person person : teamB) {
                if (person.getHp() > 0) return false;
            }
            return true;
    }
}