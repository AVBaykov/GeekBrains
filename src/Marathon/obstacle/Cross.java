package Marathon.obstacle;

import Marathon.participants.Competitor;

public class Cross extends Obstacle {

    Cross(int obstacleSize) {
        super(obstacleSize);
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(obstacleSize);
    }
}