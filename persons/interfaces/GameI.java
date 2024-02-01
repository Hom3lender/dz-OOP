package persons.interfaces;

import java.util.List;

import persons.abstracts.*;

public interface GameI {

    void step(List<Person> enemyTeam, List<Person> alliedTeam);

}
