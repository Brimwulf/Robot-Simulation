package RobotSimulation;

import java.util.Random;

public enum Direction {
    North,
    South,
    East,
    West;

    /**
     * Title: How do I pick a random value from an enum?
     * Author: Wayan
     * Date: June 6th 2023
     * Available at: https://kodejava.org/how-do-i-pick-a-random-value-from-an-enum/
     */
    public static Direction getRandomDirection() {
        Random rand = new Random();
        return values()[rand.nextInt(values().length)];

    }
}
