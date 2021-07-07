package Marathon.participants;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Competitor> team = new ArrayList<>();

    {
        team.add(new Human("Боб"));
        team.add(new Cat("Барсик"));
        team.add(new Dog("Бобик"));
    }

    public List<Competitor> getTeam() {
        return team;
    }

    public void printMarathonResult() {
        team.forEach(Competitor::info);
    }
}
