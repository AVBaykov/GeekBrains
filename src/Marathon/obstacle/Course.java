package Marathon.obstacle;

import Marathon.participants.Team;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private List<Obstacle> course;

    public Course() {
        course = new ArrayList<>();
        course.add(new Cross(80));
        course.add(new Wall(2));
        course.add(new Water(20));
        course.add(new Cross(120));
    }

    public void start(Team team) {
        course.forEach(obstacle -> obstacle.doIt(team.getTeam()));
    }
}
