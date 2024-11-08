package RobotSimulation;

public class ConsoleCanvas {
    private int height;
    private int width;
    private String studentNo;
    private char[][] canvas;

    //This method is the constructor and sets height and width to be the values passed in.
    public ConsoleCanvas(int height, int width, String studentNo) {
        this.height = height;
        this.width = width;
        System.out.println("Initializing canvas with height = " + height + ", width = " + width);
        canvas = new char[height][width];
        this.studentNo = studentNo;
        createCanvas();
    }

    private void createCanvas() {
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                canvas[i][j] = ' ';
            }
        }
        drawBorder();
        placeStudentNumber();
    }

    private void drawBorder(){
        if(canvas.length < height || canvas[0].length < width){
            throw new IllegalArgumentException("Canvas dimensions are too small");
        }
        for(int i = 0; i<height; i++){
            canvas[i][0] = '#';         //leftmost column
            canvas[i][width-1] = '#';   //rightmost column
        }
        for(int j = 0; j<width; j++){
            canvas[0][j] = '#';         //Top row
            canvas[height-1][j] = '#';   //Bottom row
        }
    }

    private void placeStudentNumber() {
        int studentNoLength = studentNo.length();
        //This part throws an exception if student number is longer than width to prevent placing out of bounds.
        if(studentNoLength > width){
            throw new IllegalArgumentException(studentNoLength + " is too long.");
        }
        int centreSpace=(width-studentNoLength)/2;
        for(int i=0; i<studentNoLength; i++){
            canvas[0][centreSpace+i]=studentNo.charAt(i);
        }
    }

    public void showIt(int x, int y, char identifier) {
        if(x>=width || y>=height || x<0 || y<0){
            throw new IllegalArgumentException("Bot is out of bounds.");
        }
        canvas[x][y] = identifier;
    }

    public void printCanvas() {
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        ConsoleCanvas c = new ConsoleCanvas(20, 20, "32024813");
        c.showIt(4, 3, 'R');
        c.printCanvas();
    }
}
