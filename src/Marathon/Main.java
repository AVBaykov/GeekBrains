package Marathon;

import Marathon.obstacle.Course;
import Marathon.participants.Team;

public class Main {
    public static void main(String[] args) {
        Course course = new Course();
        Team team = new Team();

        course.start(team);
        team.printMarathonResult();
    }
}
