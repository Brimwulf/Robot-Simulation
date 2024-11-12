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
        s = new Scanner(System.in); // set up scanner for user input

        myArena = setupArena();	// Allow user to create the arena
        int rNum = 0;

        char ch = ' ';
        do {
            System.out.print("Enter (A)dd Robot, get (I)nformation, (D)isplay canvas, (M)ove all robots once," +
                    " (R)un animation, (S)ave arena or e(X)it > ");
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
                case 'S' :
                case 's' :
                    myArena.saveArena();
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

    public RobotArena setupArena() {
        char choice = ' ';
        do {
            System.out.println("Do you want to (C)reate a new arena or (L)oad from a file? " +
                    "Enter X to create a default arena > ");
            choice = s.next().charAt(0);
            s.nextLine();
            switch (choice) {
                case 'C':
                case 'c':
                    // Prompt user for arena dimensions
                    System.out.println("Enter arena width > ");
                    int width = s.nextInt();
                    System.out.println("Enter arena height > ");
                    int height = s.nextInt();
                    return myArena = new RobotArena(width, height);
                case 'L':
                case 'l':
                    myArena = RobotArena.loadArena();
                    if(myArena != null){
                        return myArena;
                    } else {
                        System.out.println("Please retry...\n");
                    }
                    break;
                case 'x' : choice = 'X';
                    break;
            }
        } while(choice != 'X');
        return new RobotArena(20,6); // creates a default arena
    }

    public static void main(String[] args) {
        RobotInterface r = new RobotInterface();	// just call the interface
    }

}