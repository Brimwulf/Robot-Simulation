package RobotSimulation;

import java.io.Console;

public class Robot {
    private int x;
    private int y;
    private int num;
    Direction direction;

    public Robot(int mum, int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.num = mum;
        this.direction = direction;
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
        return "Robot " + num + " is at " + x + ", " + y + " facing " + direction;
    }

    public int[] calculateNewPosition() {
        int newX = this.x;
        int newY = this.y;

        switch (this.direction) {
            case North :
                newX -= 1;
                break;
            case South :
                newX += 1;
                break;
            case West :
                newY -= 1;
                break;
            case East :
                newY += 1;
                break;
        }
        return new int[]{newX, newY}; // This creates an array with the new x,y coords that have been calculated.
    }

    public void tryToMove() {
        int[] newPosition = calculateNewPosition();
        this.x = newPosition[0];
        this.y = newPosition[1];

    }

    /**
     * display the robot on canvas
     * @param c the canvas used.
     */
    public void displayRobot(ConsoleCanvas c) {
        c.showIt(x,y,'R');
    }

    public static void main(String[] args) {
        Robot d = new Robot(0,5, 3, Direction.getRandomDirection());
        System.out.println(d.toString());
    }
}
