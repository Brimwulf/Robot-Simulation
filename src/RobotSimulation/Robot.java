package RobotSimulation;

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

    public static void main(String[] args) {
        Robot d = new Robot(0,5, 3);
        System.out.println(d.toString());
    }
}
