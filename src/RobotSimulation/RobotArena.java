package RobotSimulation;
import java.util.Random;

public class RobotArena {
    private int x_size;
    private int y_size;
    private Robot[] robot;
    private int numRobots;
    // This line is needed to store any robots that are created in the arena.

    public int getNumRobots() {
        return numRobots;
    }

    public RobotArena(int x_size, int y_size, int numRobots) {
        this.x_size = x_size;
        this.y_size = y_size;
        this.numRobots = numRobots;
        robot = new Robot[numRobots];
    }

    /**
     * Is the robot at this x, y position?
     * @param sx    x position.
     * @param sy    y position.
     * @param rNum  the robot being tested.
     * @return      true if robot at xy is found, false otherwise.
     */
    public boolean isHere(int rNum, int sx, int sy) {
        if(robot[rNum].getX() == sx && robot[rNum].getY() == sy) return true;
        return false;
    }

    public void addRobot(int index, int num) {
        Random randomGenerator;
        randomGenerator = new Random();
        int rX = randomGenerator.nextInt(x_size);
        int rY = randomGenerator.nextInt(y_size);
        do {
            robot[index] = new Robot(num, randomGenerator.nextInt(x_size), randomGenerator.nextInt(y_size));
            numRobots++;
        }
        while (isHere(index, rX, rY));
    }

    public String toString(int numRobots) {
        System.out.println("Arena of size " + x_size + " by " + y_size + " with "
                + numRobots + " robot(s)");
        String returnstr = "";
        for (int i = 0; i < numRobots; i++) {
            returnstr += robot[i] + "\n";
        }
        return returnstr;
    }

    public static void main(String[] args) {
        RobotArena a = new RobotArena(20,20,3);
        a.addRobot(0,1);
        a.addRobot(1,2);
        a.addRobot(2,3);
        System.out.println(a.toString(a.numRobots));
    }
}
