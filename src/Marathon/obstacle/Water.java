package Marathon.obstacle;

import Marathon.participants.Competitor;

public class Water extends Obstacle {

    Water(int obstacleSize) {
        super(obstacleSize);
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(obstacleSize);
    }
}