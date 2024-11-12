package RobotSimulation;
import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Simple program to show arena with multiple robots
 * @author shsmchlr
 *
 */
public class RobotInterface {

    private Scanner s;								// scanner used for input from user
    private RobotArena myArena;				// arena in which Robots are shown
    /**
     * constructor for RobotInterface
     * sets up scanner used for input and the arena
     * then has main loop allowing user to enter commands
     */
    public RobotInterface() {
        s = new Scanner(System.in);			// set up scanner for user input
        myArena = new RobotArena(20, 6, 0);	// create arena of size 20*6
        int rNum = 0;

        char ch = ' ';
        do {
            System.out.print("Enter (A)dd Robot, get (I)nformation, (D)isplay canvas, (M)ove all robots once," +
                    " (R)un animation or e(X)it > ");
            ch = s.next().charAt(0);
            s.nextLine();
            switch (ch) {
                case 'A' :
                case 'a' :
                    myArena.addRobot(rNum+1);	// add a new Robot to arena
                    rNum++;
                    break;
                case 'I' :
                case 'i' :
                    System.out.print(myArena.toString(myArena.getNumRobots()));
                    //This needs to be the number of items in ArrayList
                    break;
                case 'D' :
                case 'd' :
                    doDisplay();
                    break;
                case 'M' :
                case 'm' :
                    myArena.moveAll(myArena);
                    doDisplay();
                    break;
                case 'R' :
                case 'r' :
                    animateCanvas();
                    break;
                case 'x' : 	ch = 'X';				// when X detected program ends
                    break;
            }
        } while (ch != 'X');						// test if end

        s.close();									// close scanner
    }

    public void doDisplay() {
        int x_size = myArena.getX_size();
        int y_size = myArena.getY_size();
        ConsoleCanvas canvas = new ConsoleCanvas(y_size, x_size, "32024813");
        myArena.showRobots(canvas);
        canvas.printCanvas();
    }

    public void animateCanvas(){
        for(int i=0; i<10; i++){
            myArena.moveAll(myArena);
            System.out.print(myArena.toString(myArena.getNumRobots()));
            doDisplay();
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted. Stopping...");
                return;      // I could also have this part of the code retry after waiting.
            }
        }
    }

    public static void main(String[] args) {
        RobotInterface r = new RobotInterface();	// just call the interface
    }

}