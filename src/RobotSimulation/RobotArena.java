package RobotSimulation;
import java.io.Console;
import java.util.Random;
import java.util.ArrayList;

public class RobotArena {
    private int x_size;
    private int y_size;
    private ArrayList<Robot> robot;

    public int getNumRobots() {
        return robot.size();
    }

    public int getX_size() {
        return x_size;
    }

    public int getY_size() {
        return y_size;
    }

    public RobotArena(int x_size, int y_size, int numRobots) {
        this.x_size = x_size;
        this.y_size = y_size;
        //this.numRobots = numRobots;
        robot = new ArrayList<>();
    }

    /**
     * Is the robot at this x, y position?
     * @param sx    x position.
     * @param sy    y position.
     * @param rNum  the robot being tested.
     * @return      true if robot at xy is found, false otherwise.
     */
    public boolean isHere(int rNum, int sx, int sy) {
        //Need to change the robots here to work with array list.
//        if(robot[rNum].getX() == sx && robot[rNum].getY() == sy) return true;
//        return false;
        if(rNum < robot.size()) {
            Robot r = robot.get(rNum);
            return r.getX() == sx && r.getY() == sy;
        }
        return false;
    }

    public void addRobot(int num) {
        Random randomGenerator = new Random();
        int rX, rY;
        Robot newRobot;
        do {
            rX = randomGenerator.nextInt(x_size);
            rY = randomGenerator.nextInt(y_size);
            newRobot = new Robot(num, rX, rY);
        }
        while (isHere(num -1, rX, rY));

        robot.add(newRobot);
    }

    public String toString(int numRobots) {
        System.out.println("Arena of size " + x_size + " by " + y_size + " with "
                + numRobots + " robot(s)");
        String returnstr = "";
        for (int i = 0; i < numRobots; i++) {
            returnstr += robot.get(i) + "\n";
        }
        return returnstr;
    }

    public void showRobots(ConsoleCanvas c) {
        for (Robot value : robot) {
            //Accessing robot number i in robot and accessing the displayRobot method.
            value.displayRobot(c);
        }
    }

    public static void main(String[] args) {
        RobotArena a = new RobotArena(20,20,3);
        a.addRobot(1);
        a.addRobot(2);
        a.addRobot(3);
        System.out.println(a.toString(3));
    }
}
