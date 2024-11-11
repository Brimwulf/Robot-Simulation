package RobotSimulation;

import java.io.Console;

public class Robot {
    private int x;
    private int y;
    private int num;

    public Robot(int mum, int x, int y) {
        this.x = x;
        this.y = y;
        this.num = mum;
    }

    public int getNum() {
        return num;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "Robot " + num + " is at " + x + ", " + y;
    }

    /**
     * display the robot on canvas
     * @param c the canvas used.
     */
    public void displayRobot(ConsoleCanvas c) {
        c.showIt(x,y,'R');
    }

    public static void main(String[] args) {
        Robot d = new Robot(0,5, 3);
        System.out.println(d.toString());
    }
}
