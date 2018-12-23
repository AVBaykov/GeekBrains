package Marathon.obstacle;

import Marathon.participants.Competitor;

import java.util.Collection;

public abstract class Obstacle {
    int obstacleSize;

    Obstacle(int obstacleSize) {
        this.obstacleSize = obstacleSize;
    }

    public abstract void doIt(Competitor competitor);

    void doIt(Collection<Competitor> competitors) {
        competitors.forEach(this::doIt);
    }
}