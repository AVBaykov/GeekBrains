package Marathon.obstacle;

import Marathon.participants.Competitor;

public class Wall extends Obstacle {

    public Wall(int obstacleSize) {
        super(obstacleSize);
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(obstacleSize);
    }
}
