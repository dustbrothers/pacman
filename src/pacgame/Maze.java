package pacgame;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Arc2D;
import java.util.Arrays;

public class Maze {
    public static final int nCols = 14;         // number of columns
    public static final int nRows = 13;         // number of rows
    public static final int sqSize = 40;        // grid square size
    public static final int dotd = sqSize/4;    // dot diameter
    public static final int WT = 3;             // wall thickness
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
        // single horizontal line
        Square horizsq = new Square();
        horizsq.wall = WallType.HORIZ;
        // single vertical line
        Square vertsq = new Square();
        vertsq.wall = WallType.VERT;
        // single top left corner
        Square TLCsq = new Square();
        TLCsq.wall = WallType.TLC;
        // single top right corner
        Square TRCsq = new Square();
        TRCsq.wall = WallType.TRC;
        // single bottom left corner
        Square BLCsq = new Square();
        BLCsq.wall = WallType.BLC;
        // single bottom right corner
        Square BRCsq = new Square();
        BRCsq.wall = WallType.BRC;
        // double top aligned
        Square Tsq = new Square();
        Tsq.wall = WallType.T;
        // dbl bottom aligned
        Square Bsq = new Square();
        Bsq.wall = WallType.B;
        // dbl left aligned
        Square Lsq = new Square();
        Lsq.wall = WallType.L;
        // dbl right aligned
        Square Rsq = new Square();
        Rsq.wall = WallType.R;
        // dbl top aligned T intersect left
        Square TTLsq = new Square();
        TTLsq.wall = WallType.TTL;
        // dbl top aligned T intersect right
        Square TTRsq = new Square();
        TTRsq.wall = WallType.TTR;
        // dbl left aligned T intersect top
        Square LTTsq = new Square();
        LTTsq.wall = WallType.LTT;
        // dbl left aligned T intersect bottom
        Square LTBsq = new Square();
        LTBsq.wall = WallType.LTB;
        // dbl right aligned T intersect top
        Square RTTsq = new Square();
        RTTsq.wall = WallType.RTT;
        // dbl right aligned T intersect bottom
        Square RTBsq = new Square();
        RTBsq.wall = WallType.RTB;
        // dbl top aligned right corner down
        Square TRCDsq = new Square();
        TRCDsq.wall = WallType.TRCD;
        // dbl top aligned right corner up
        Square TRCUsq = new Square();
        TRCUsq.wall = WallType.TRCU;
        // dbl top aligned left corner down
        Square TLCDsq = new Square();
        TLCDsq.wall = WallType.TLCD;
        // dbl top aligned left corner up
        Square TLCUsq = new Square();
        TLCUsq.wall = WallType.TLCU;
        // dbl bottom aligned right corner up
        Square BRCUsq = new Square();
        BRCUsq.wall = WallType.BRCU;
        // dbl bottom aligned right corner down
        Square BRCDsq = new Square();
        BRCDsq.wall = WallType.BRCD;
        // dbl bottom aligned left corner up
        Square BLCUsq = new Square();
        BLCUsq.wall = WallType.BLCU;
        // dbl bottom aligned left corner down
        Square BLCDsq = new Square();
        BLCDsq.wall = WallType.BLCD;
        // door
        Square DOORsq = new Square();
        DOORsq.wall = WallType.DOOR;
        // inner top left corner
        Square ITLCsq = new Square();
        ITLCsq.wall = WallType.ITLC;
        // inner top right corner
        Square ITRCsq = new Square();
        ITRCsq.wall = WallType.ITRC;
        // inner bottom left corner
        Square IBLCsq = new Square();
        IBLCsq.wall = WallType.IBLC;
        // inner bottom right corner
        Square IBRCsq = new Square();
        IBRCsq.wall = WallType.IBRC;
        // powerup
        Square POWERUPsq = new Square();
        POWERUPsq.powerup = true;
        POWERUPsq.wall = WallType.NONE;
        // dot
        Square DOTsq = new Square();
        DOTsq.dot = true;
        DOTsq.wall = WallType.NONE;
        // empty
        Square EMPTYsq = new Square();
        EMPTYsq.wall = WallType.NONE;
        // create the maze
        // row 0
        Arrays.fill(grid[0], EMPTYsq);
        // row 1
        Arrays.fill(grid[1], EMPTYsq);
        // row 2
        Arrays.fill(grid[2], EMPTYsq);
        // row 3
        grid[3][0] = TLCDsq;
        for (int i = 1; i < 13; i++){
            grid[3][i] = Tsq;
        }
        grid[3][13] = TTLsq;
        // grid[3][14] = TTRsq;
        // for (int i = 15; i < 27; i++){
        //     grid[3][i] = Tsq;
        // }
        // grid[3][27] = TRCDsq;
        // row 4
        grid[4][0] = Lsq;
        for (int i = 1; i < 13; i++){
            grid[4][i] = DOTsq;
        }
        grid[4][13] = vertsq;
        // row 5
        grid[5][0] = Lsq;
        grid[5][1] = DOTsq;
        grid[5][2] = TLCsq;
        grid[5][3] = horizsq;
        grid[5][4] = horizsq;
        grid[5][5] = TRCsq;
        grid[5][6] = DOTsq;
        grid[5][7] = TLCsq;
        grid[5][8] = horizsq;
        grid[5][9] = horizsq;
        grid[5][10] = horizsq;
        grid[5][11] = TRCsq;
        grid[5][12] = DOTsq;
        grid[5][13] = vertsq;
        // row 6
        grid[6][0] = Lsq;
        grid[6][1] = POWERUPsq;
        grid[6][2] = vertsq;
        grid[6][3] = EMPTYsq;
        grid[6][4] = EMPTYsq;
        grid[6][5] = vertsq;
        grid[6][6] = DOTsq;
        grid[6][7] = vertsq;
        grid[6][8] = EMPTYsq;
        grid[6][9] = EMPTYsq;
        grid[6][10] = EMPTYsq;
        grid[6][11] = vertsq;
        grid[6][12] = DOTsq;
        grid[6][13] = vertsq;
        // row 7
        grid[7][0] = Lsq;
        grid[7][1] = DOTsq;
        grid[7][2] = BLCsq;
        grid[7][3] = horizsq;
        grid[7][4] = horizsq;
        grid[7][5] = BRCsq;
        grid[7][6] = DOTsq;
        grid[7][7] = BLCsq;
        grid[7][8] = horizsq;
        grid[7][9] = horizsq;
        grid[7][10] = horizsq;
        grid[7][11] = BRCsq;
        grid[7][12] = DOTsq;
        grid[7][13] = BLCsq;
        // row 8
        grid[8][0] = Lsq;
        for (int i = 1; i < 14; i++){
            grid[8][i] = DOTsq;
        }
        // row 9
        grid[9][0] = Lsq;
        grid[9][1] = DOTsq;
        grid[9][2] = TLCsq;
        grid[9][3] = horizsq;
        grid[9][4] = horizsq;
        grid[9][5] = TRCsq;
        grid[9][6] = DOTsq;
        grid[9][7] = TLCsq;
        grid[9][8] = TRCsq;
        grid[9][9] = DOTsq;
        grid[9][10] = TLCsq;
        grid[9][11] = horizsq;
        grid[9][12] = horizsq;
        grid[9][13] = horizsq;
        // row 10
        grid[10][0] = Lsq;
        grid[10][1] = DOTsq;
        grid[10][2] = BLCsq;
        grid[10][3] = horizsq;
        grid[10][4] = horizsq;
        grid[10][5] = BRCsq;
        grid[10][6] = DOTsq;
        grid[10][7] = vertsq;
        grid[10][8] = vertsq;
        grid[10][9] = DOTsq;
        grid[10][10] = BLCsq;
        grid[10][11] = horizsq;
        grid[10][12] = horizsq;
        grid[10][13] = TRCsq;
        // row 11
        grid[11][0] = Lsq;
        grid[11][1] = DOTsq;
        grid[11][2] = DOTsq;
        grid[11][3] = DOTsq;
        grid[11][4] = DOTsq;
        grid[11][5] = DOTsq;
        grid[11][6] = DOTsq;
        grid[11][7] = vertsq;
        grid[11][8] = vertsq;
        grid[11][9] = DOTsq;
        grid[11][10] = DOTsq;
        grid[11][11] = DOTsq;
        grid[11][12] = DOTsq;
        grid[11][13] = vertsq;
        // row 12
        grid[12][0] = BLCUsq;
        grid[12][1] = Bsq;
        grid[12][2] = Bsq;
        grid[12][3] = Bsq;
        grid[12][4] = Bsq;
        grid[12][5] = BRCDsq;
        grid[12][6] = DOTsq;
        grid[12][7] = vertsq;
        grid[12][8] = BLCsq;
        grid[12][9] = horizsq;
        grid[12][10] = horizsq;
        grid[12][11] = TRCsq;
        grid[12][12] = EMPTYsq;
        grid[12][13] = vertsq;
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
        // small b boolean defaults to false
        boolean dot;
        boolean powerup;
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
        NONE, HORIZ, VERT, TLC, TRC, BLC, BRC,
        T, TTL, TTR, L, LTT, LTB, R, RTT, RTB, B,
        TRCD, TRCU, TLCD, TLCU, BRCU, BRCD, BLCU, BLCD,
        DOOR, ITLC, ITRC, IBLC, IBRC
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
                    if (grid[row][col].dot || grid[row][col].powerup) {
                        g.setColor(Color.PINK);
                        if (grid[row][col].dot) {
                            // Draw a dot and continue.  Continue basically
                            // says you're done on this iteration of the loop
                            // so go to the next one
                            dotx = grid[row][col].pixelX-dotd/2;
                            doty = grid[row][col].pixelY-dotd/2;
                            g.fillOval(dotx, doty, dotd, dotd);
                            continue;
                        } else if (grid[row][col].powerup) {
                            dotx = grid[row][col].pixelX-sqSize/2;
                            doty = grid[row][col].pixelY-sqSize/2;
                            g.fillOval(dotx, doty, sqSize, sqSize);
                            continue;
                        }
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
                        case HORIZ:
                            g2.draw(new Line2D.Float(centX-sqSize/2, centY, centX+sqSize/2, centY));
                            break;
                        case VERT:
                            g2.draw(new Line2D.Float(centX, centY-sqSize/2, centX, centY+sqSize/2));
                            break;
                        case T:
                            g2.draw(new Line2D.Float(centX-sqSize/2, centY-sqSize/2+WT, centX+sqSize/2, centY-sqSize/2+WT));
                            g2.draw(new Line2D.Float(centX-sqSize/2, centY, centX+sqSize/2, centY));
                            break;
                        case B:
                            g2.draw(new Line2D.Float(centX-sqSize/2, centY+sqSize/2-WT, centX+sqSize/2, centY+sqSize/2-WT));
                            g2.draw(new Line2D.Float(centX-sqSize/2, centY, centX+sqSize/2, centY));
                            break;
                        case L:
                            g2.draw(new Line2D.Float(centX-sqSize/2+WT, centY-sqSize/2, centX-sqSize/2+WT, centY+sqSize/2));
                            g2.draw(new Line2D.Float(centX, centY-sqSize/2, centX, centY+sqSize/2));
                            break;
                        case R:
                            g2.draw(new Line2D.Float(centX+sqSize/2-WT, centY-sqSize/2, centX+sqSize/2-WT, centY+sqSize/2));
                            g2.draw(new Line2D.Float(centX, centY-sqSize/2, centX, centY+sqSize/2));
                            break;
                        case TLC:
                            g2.draw(new Arc2D.Float(centX, centY, sqSize, sqSize, 90, 90, Arc2D.OPEN));
                            break;
                        case TRC:
                            g2.draw(new Arc2D.Float(centX-sqSize, centY, sqSize, sqSize, 0, 90, Arc2D.OPEN));
                            break;
                        case BLC:
                            g2.draw(new Arc2D.Float(centX, centY-sqSize, sqSize, sqSize, 180, 90, Arc2D.OPEN));
                            break;
                        case BRC:
                            g2.draw(new Arc2D.Float(centX-sqSize, centY-sqSize, sqSize, sqSize, 270, 90, Arc2D.OPEN));
                            break;
                        case TLCD:
                            g2.draw(new Arc2D.Float(centX, centY, sqSize, sqSize, 90, 90, Arc2D.OPEN));
                            g2.draw(new Arc2D.Float(centX-sqSize/2+WT, centY-sqSize/2+WT, 2*sqSize-2*WT, 2*sqSize-2*WT, 90, 90, Arc2D.OPEN));
                            break;
                        // case TRCD:
                        //     g2.draw(new Arc2D.Float(centX-sqSize, centY, sqSize, sqSize, 0, 90, Arc2D.OPEN));
                        //     g2.draw(new Arc2D.Float(centX-sqSize+WT, centY-sqSize/2+WT, 2*sqSize-2*WT, 2*sqSize-2*WT, 0, 90, Arc2D.OPEN));
                        //     break;
                        case BLCU:
                            g2.draw(new Arc2D.Float(centX, centY-sqSize, sqSize, sqSize, 180, 90, Arc2D.OPEN));
                            g2.draw(new Arc2D.Float(centX-sqSize/2+WT, centY-3*sqSize/2+WT, 2*sqSize-2*WT, 2*sqSize-2*WT, 180, 90, Arc2D.OPEN));
                            break;
                        case TTL:
                            g2.draw(new Arc2D.Float(centX-sqSize, centY, sqSize, sqSize, 0, 90, Arc2D.OPEN));
                            g2.draw(new Line2D.Float(centX-sqSize/2, centY-sqSize/2+WT, centX+sqSize/2, centY-sqSize/2+WT));
                            break;
                        // case TTR:
                        //     g2.draw(new Arc2D.Float(centX, centY, sqSize, sqSize, 90, 90, Arc2D.OPEN));
                        //     g2.draw(new Line2D.Float(centX-sqSize/2, centY-sqSize/2+WT, centX+sqSize/2, centY-sqSize/2+WT));
                        //     break;
                        case BRCD:
                            g2.draw(new Arc2D.Float(centX-sqSize, centY, sqSize, sqSize, 0, 90, Arc2D.OPEN));
                            break;
                        default: break;
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
        frame.setSize(sqSize*nCols, sqSize*nRows+sqSize/2+WT);
        frame.setLocation(0, 0);
    }
}
