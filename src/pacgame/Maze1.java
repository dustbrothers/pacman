package pacgame;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Maze {
    public static final int nCols = 10;
    public static final int nRows = 10;
    public static final int sqSize = 50;
    public static final int dotd = sqSize/3;
    // array for what is in each square, row,col
    static Square[][] grid;
    // a constructor that creates the grid for you.
    public Maze() {
        grid = new Square[nRows][nCols];
    }
    // You should have some sort of function that initializes your Maze to
    // the correct values (wall, dots, etc.).  A function that initializes
    // everything is commonly called init.  This can also be done in your
    // constructor if it is called every time you create a new Maze.  Make
    // sure if you have an init function that needs to run, that you call it
    // from somewhere.
    public void init() {
        // shorthand square types
        Square horizsq = new Square();
        horizsq.dot = false;
        horizsq.wall = WallType.HORIZONTAL;
        Square vertsq = new Square();
        vertsq.dot = false;
        vertsq.wall = WallType.VERTICAL;
        Square TLCsq = new Square();
        TLCsq.dot = false;
        TLCsq.wall = WallType.TLC;
        Square TRCsq = new Square();
        TRCsq.dot = false;
        TRCsq.wall = WallType.TRC;
        Square BLCsq = new Square();
        BLCsq.dot = false;
        BLCsq.wall = WallType.BLC;
        Square BRCsq = new Square();
        BRCsq.dot = false;
        BRCsq.wall = WallType.BRC;
        Square VETsq = new Square();
        VETsq.dot = false;
        VETsq.wall = WallType.VET;
        Square VEBsq = new Square();
        VEBsq.dot = false;
        VEBsq.wall = WallType.VEB;
        Square HELsq = new Square();
        HELsq.dot = false;
        HELsq.wall = WallType.HEL;
        Square HERsq = new Square();
        HERsq.dot = false;
        HERsq.wall = WallType.HER;
        Square dotsq = new Square();
        dotsq.dot = true;
        dotsq.wall = WallType.NONE;
        Square empsq = new Square();
        empsq.dot = false;
        empsq.wall = WallType.NONE;
        // create the maze
        // row 0
        grid[0][0] = TLCsq;
        grid[0][1] = horizsq;
        grid[0][2] = horizsq;
        grid[0][3] = horizsq;
        grid[0][4] = horizsq;
        grid[0][5] = horizsq;
        grid[0][6] = horizsq;
        grid[0][7] = horizsq;
        grid[0][8] = horizsq;
        grid[0][9] = TRCsq;
        // row 1
        grid[1][0] = vertsq;
        grid[1][1] = dotsq;
        grid[1][2] = dotsq;
        grid[1][3] = dotsq;
        grid[1][4] = dotsq;
        grid[1][5] = dotsq;
        grid[1][6] = dotsq;
        grid[1][7] = dotsq;
        grid[1][8] = dotsq;
        grid[1][9] = vertsq;
        // row 2
        grid[2][0] = vertsq;
        grid[2][1] = dotsq;
        grid[2][2] = TLCsq;
        grid[2][3] = HERsq;
        grid[2][4] = dotsq;
        grid[2][5] = HELsq;
        grid[2][6] = horizsq;
        grid[2][7] = TRCsq;
        grid[2][8] = dotsq;
        grid[2][9] = vertsq;
        // row 3
        grid[3][0] = VEBsq;
        grid[3][1] = dotsq;
        grid[3][2] = VEBsq;
        grid[3][3] = dotsq;
        grid[3][4] = dotsq;
        grid[3][5] = dotsq;
        grid[3][6] = dotsq;
        grid[3][7] = VEBsq;
        grid[3][8] = dotsq;
        grid[3][9] = VEBsq;
        // row 4
        grid[4][0] = empsq;
        grid[4][1] = dotsq;
        grid[4][2] = dotsq;
        grid[4][3] = dotsq;
        grid[4][4] = TLCsq;
        grid[4][5] = TRCsq;
        grid[4][6] = dotsq;
        grid[4][7] = dotsq;
        grid[4][8] = dotsq;
        grid[4][9] = empsq;
        // row 5
        grid[5][0] = TLCsq;
        grid[5][1] = horizsq;
        grid[5][2] = HERsq;
        grid[5][3] = dotsq;
        grid[5][4] = BLCsq;
        grid[5][5] = BRCsq;
        grid[5][6] = dotsq;
        grid[5][7] = HELsq;
        grid[5][8] = horizsq;
        grid[5][9] = TRCsq;
        // row 6
        grid[6][0] = vertsq;
        grid[6][1] = dotsq;
        grid[6][2] = dotsq;
        grid[6][3] = dotsq;
        grid[6][4] = dotsq;
        grid[6][5] = dotsq;
        grid[6][6] = dotsq;
        grid[6][7] = dotsq;
        grid[6][8] = dotsq;
        grid[6][9] = vertsq;
        // row 7
        grid[7][0] = vertsq;
        grid[7][1] = dotsq;
        grid[7][2] = HELsq;
        grid[7][3] = horizsq;
        grid[7][4] = HERsq;
        grid[7][5] = dotsq;
        grid[7][6] = HELsq;
        grid[7][7] = HERsq;
        grid[7][8] = dotsq;
        grid[7][9] = vertsq;
        // row 8
        grid[8][0] = vertsq;
        grid[8][1] = dotsq;
        grid[8][2] = dotsq;
        grid[8][3] = dotsq;
        grid[8][4] = dotsq;
        grid[8][5] = dotsq;
        grid[8][6] = dotsq;
        grid[8][7] = dotsq;
        grid[8][8] = dotsq;
        grid[8][9] = vertsq;
        // row 9
        grid[9][0] = BLCsq;
        grid[9][1] = horizsq;
        grid[9][2] = horizsq;
        grid[9][3] = horizsq;
        grid[9][4] = horizsq;
        grid[9][5] = horizsq;
        grid[9][6] = horizsq;
        grid[9][7] = horizsq;
        grid[9][8] = horizsq;
        grid[9][9] = BRCsq;
    }
    // We need to define the Square class.  It's important that it's public
    // because we will probably need other classes to use it.
    public class Square {
        // Keep in here some concept of each square.  As we talked about, this
        // will likely have a boolean for wall/not wall and a boolean for
        // dot/not dot.  If you choose to implement this by referring to the
        // Square to draw a wall, then it'll also be useful to have something
        // that knows what kind of wall.  For this, we will use an enum, which
        // just allows us to refer to things by specific names.
        Boolean dot;
        WallType wall;
        int pixelX;
        int pixelY;
    }
    // Define the WallType enum to contain all the possible values of wall.
    // The way I have it started, you will have to have no wall as one.
    // Then, when drawing, you can just check what type of wall it is,
    // and act accordingly.  Enum is short for "enumerate", so what you're
    // essentially seeing
    // For more info on enum, refer to:
    //      https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
    public enum WallType {
        // Add more values by separating by commas, as I did here.  It is
        // common that enum values are in all caps.
        NONE, HORIZONTAL, VERTICAL, TLC, TRC, BLC, BRC, VET, VEB, HEL, HER
    }
    // This is the DrawPanel analog we're using for this maze.  As you draw
    // things, you may find that you need more constants.  One such constant
    // will be box width.  Define these at the top where nRows and nCols are
    // defined.
    static class MazePanel extends JPanel {
        public void paintComponent(Graphics g) {
            // Iterate over everything in your grid and draw each box
            // accordingly.  We nest two for loops because we are iterating
            // in two dimensions of our 2D grid array.
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3));
            int dotx;
            int doty;
            int centX;
            int centY;
            for (int row = 0; row < nRows; row++) {
                for (int col = 0; col < nCols; col++) {
                    grid[row][col].pixelX = col*sqSize + sqSize/2;
                    grid[row][col].pixelY = row*sqSize + sqSize/2;
                    if (grid[row][col].dot) {
                        // Draw a dot and continue.  Continue basically
                        // says you're done on this iteration of the loop
                        // so go to the next one
                        dotx = grid[row][col].pixelX-dotd/2;
                        doty = grid[row][col].pixelY-dotd/2;
                        g.setColor(Color.YELLOW);
                        g.fillOval(dotx, doty, dotd, dotd);
                        continue;
                    }
                    // If there's no dot, then there might be a wall.  We
                    // can use a switch statement to address each possible
                    // value.
                    centX = grid[row][col].pixelX;
                    centY = grid[row][col].pixelY;
                    g.setColor(Color.BLUE);
                    switch (grid[row][col].wall) {
                        case NONE:
                            break;
                        case HORIZONTAL:
                            g2.draw(new Line2D.Float(centX-sqSize/2, centY, centX+sqSize/2, centY));
                            break;
                        case HEL:
                            g2.draw(new Line2D.Float(centX, centY, centX+sqSize/2, centY));
                            break;
                        case HER:
                            g2.draw(new Line2D.Float(centX-sqSize/2, centY, centX, centY));
                            break;
                        case VERTICAL:
                            g2.draw(new Line2D.Float(centX, centY-sqSize/2, centX, centY+sqSize/2));
                            break;
                        case VET:
                            g2.draw(new Line2D.Float(centX, centY, centX, centY+sqSize/2));
                            break;
                        case VEB:
                            g2.draw(new Line2D.Float(centX, centY-sqSize/2, centX, centY));
                            break;
                        case TLC:
                            g2.draw(new Line2D.Float(centX, centY, centX+sqSize/2, centY));
                            g2.draw(new Line2D.Float(centX, centY, centX, centY+sqSize/2));
                            break;
                        case TRC:
                            g2.draw(new Line2D.Float(centX, centY, centX-sqSize/2, centY));
                            g2.draw(new Line2D.Float(centX, centY, centX, centY+sqSize/2));
                            break;
                        case BLC:
                            g2.draw(new Line2D.Float(centX, centY, centX+sqSize/2, centY));
                            g2.draw(new Line2D.Float(centX, centY, centX, centY-sqSize/2));
                            break;
                        case BRC:
                            g2.draw(new Line2D.Float(centX, centY, centX-sqSize/2, centY));
                            g2.draw(new Line2D.Float(centX, centY, centX, centY-sqSize/2));
                            break;
                    }
                }
            }
        }
    }
    // Define a function to draw your maze.  This function will have something
    // that extends JPanel
    public static void draw() {
        // Code adapted from
        // http://codereview.stackexchange.com/questions/29630/simple-java-animation-with-swing
        JFrame frame = new JFrame("Pacman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MazePanel mazePanel = new MazePanel();
        frame.getContentPane().add(BorderLayout.CENTER, mazePanel);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);
        frame.setResizable(false);
        // DONT KNOW WHY I HAD TO ADD TO HEIGHT????
        frame.setSize(sqSize*nCols, sqSize*nRows+sqSize/2);
        frame.setLocation(0, 0);
    }
}
