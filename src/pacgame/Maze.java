package pacgame;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Arc2D;
import java.util.Arrays;
// java file io
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
//from www  .j  a va  2 s .c om
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.List;

public class Maze {
    public static final int nCols = 28;         // number of columns
    public static final int nRows = 36;         // number of rows
    public static final int sqSize = 25;        // grid square size
    public static final int dotd = sqSize/4;    // dot diameter
    public static final int WT = 3;             // wall thickness
    // array for what is in each square, row,col
    static Square[][] grid;
    // maze file info
    Path wiki_path = Paths.get("../data", "maze.txt");
    Charset charset = Charset.forName("ISO-8859-1");
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
        // bottom end left
        Square BELsq = new Square();
        BELsq.wall = WallType.BEL;
        // bottom end right
        Square BERsq = new Square();
        BERsq.wall = WallType.BER;
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
        try {
          // read the maze file
          List<String> mazedef = Files.readAllLines(wiki_path, charset);
          // for each line
          int mRow = 0;
          for (String line : mazedef) {
            // split the line
            String[] mCodes = line.split(" ");
            // for each column
            for (int mCol = 0; mCol < nCols; mCol++){
                // assign square type to maze grid array
                switch (mCodes[mCol]) {
                  case "EMPTYsq":
                    grid[mRow][mCol] = EMPTYsq;
                    break;
                  case "TLCDsq":
                    grid[mRow][mCol] = TLCDsq;
                    break;
                  case "Tsq":
                    grid[mRow][mCol] = Tsq;
                    break;
                  case "TTLsq":
                    grid[mRow][mCol] = TTLsq;
                    break;
                  case "TTRsq":
                    grid[mRow][mCol] = TTRsq;
                    break;
                  case "TRCDsq":
                    grid[mRow][mCol] = TRCDsq;
                    break;
                  case "Lsq":
                    grid[mRow][mCol] = Lsq;
                    break;
                  case "DOTsq":
                    grid[mRow][mCol] = DOTsq;
                    break;
                  case "vertsq":
                    grid[mRow][mCol] = vertsq;
                    break;
                  case "Rsq":
                    grid[mRow][mCol] = Rsq;
                    break;
                  case "TLCsq":
                    grid[mRow][mCol] = TLCsq;
                    break;
                  case "horizsq":
                    grid[mRow][mCol] = horizsq;
                    break;
                  case "TRCsq":
                    grid[mRow][mCol] = TRCsq;
                    break;
                  case "POWERUPsq":
                    grid[mRow][mCol] = POWERUPsq;
                    break;
                  case "BLCsq":
                    grid[mRow][mCol] = BLCsq;
                    break;
                  case "BRCsq":
                    grid[mRow][mCol] = BRCsq;
                    break;
                  case "Bsq":
                    grid[mRow][mCol] = Bsq;
                    break;
                  case "LTTsq":
                    grid[mRow][mCol] = LTTsq;
                    break;
                  case "LTBsq":
                    grid[mRow][mCol] = LTBsq;
                    break;
                  case "RTTsq":
                    grid[mRow][mCol] = RTTsq;
                    break;
                  case "RTBsq":
                    grid[mRow][mCol] = RTBsq;
                    break;
                  case "TRCUsq":
                    grid[mRow][mCol] = TRCUsq;
                    break;
                  case "TLCUsq":
                    grid[mRow][mCol] = TLCUsq;
                    break;
                  case "BRCUsq":
                    grid[mRow][mCol] = BRCUsq;
                    break;
                  case "BRCDsq":
                    grid[mRow][mCol] = BRCDsq;
                    break;
                  case "BLCUsq":
                    grid[mRow][mCol] = BLCUsq;
                    break;
                  case "BLCDsq":
                    grid[mRow][mCol] = BLCDsq;
                    break;
                  case "DOORsq":
                    grid[mRow][mCol] = DOORsq;
                    break;
                  case "ITLCsq":
                    grid[mRow][mCol] = ITLCsq;
                    break;
                  case "ITRCsq":
                    grid[mRow][mCol] = ITRCsq;
                    break;
                  case "IBLCsq":
                    grid[mRow][mCol] = IBLCsq;
                    break;
                  case "IBRCsq":
                    grid[mRow][mCol] = IBRCsq;
                    break;
                  case "BELsq":
                    grid[mRow][mCol] = BELsq;
                    break;
                  case "BERsq":
                    grid[mRow][mCol] = BERsq;
                    break;
                  default:
                    break;
                }
            }
            mRow = mRow+1;
          }
        } catch (IOException e) {
          System.out.println(e);
        }
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
        DOOR, ITLC, ITRC, IBLC, IBRC, BEL, BER
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
            g2.setStroke(new BasicStroke(WT));
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
                            g.fillRect(dotx, doty, dotd, dotd);
                            continue;
                        } else if (grid[row][col].powerup) {
                            // draw a powerup
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
                        case TRCD:
                            g2.draw(new Arc2D.Float(centX-sqSize, centY, sqSize, sqSize, 0, 90, Arc2D.OPEN));
                            g2.draw(new Arc2D.Float(centX-3*sqSize/2+WT, centY-sqSize/2+WT, 2*sqSize-2*WT, 2*sqSize-2*WT, 0, 90, Arc2D.OPEN));
                            break;
                        case TRCU: // DONE RIGHT!
                            g2.draw(new Arc2D.Float(centX-sqSize, centY-sqSize, sqSize, sqSize, 270, 90, Arc2D.OPEN));
                            g2.draw(new Arc2D.Float(centX-sqSize/2-WT, centY-sqSize/2-WT, 2*WT, 2*WT, 270, 90, Arc2D.OPEN));
                            break;
                        case TLCU: // DONE RIGHT!
                            g2.draw(new Arc2D.Float(centX, centY-sqSize, sqSize, sqSize, 180, 90, Arc2D.OPEN));
                            g2.draw(new Arc2D.Float(centX+sqSize/2-WT, centY-sqSize/2-WT, 2*WT, 2*WT, 180, 90, Arc2D.OPEN));
                            break;
                        case BLCU: // seems right
                            g2.draw(new Arc2D.Float(centX, centY-sqSize, sqSize, sqSize, 180, 90, Arc2D.OPEN));
                            g2.draw(new Arc2D.Float(centX-sqSize/2+WT, centY-3*sqSize/2+WT, 2*sqSize-2*WT, 2*sqSize-2*WT, 180, 90, Arc2D.OPEN));
                            break;
                        case BRCU:
                            g2.draw(new Arc2D.Float(centX-sqSize, centY-sqSize, sqSize, sqSize, 270, 90, Arc2D.OPEN));
                            g2.draw(new Arc2D.Float(centX-3*sqSize/2+WT, centY-3*sqSize/2+WT, 2*sqSize-2*WT, 2*sqSize-2*WT, 270, 90, Arc2D.OPEN));
                            break;
                        case BRCD: // DONE RIGHT!
                            g2.draw(new Arc2D.Float(centX-sqSize, centY, sqSize, sqSize, 0, 90, Arc2D.OPEN));
                            g2.draw(new Arc2D.Float(centX-sqSize/2-WT, centY+sqSize/2-WT, 2*WT, 2*WT, 0, 90, Arc2D.OPEN));
                            break;
                        case BLCD: // DONE RIGHT!
                            g2.draw(new Arc2D.Float(centX, centY, sqSize, sqSize, 90, 90, Arc2D.OPEN));
                            g2.draw(new Arc2D.Float(centX+sqSize/2-WT, centY+sqSize/2-WT, 2*WT, 2*WT, 90, 90, Arc2D.OPEN));
                            // g2.draw(new Line2D.Float(centX+sqSize/2, centY+sqSize/2-WT, centX+sqSize/2-WT/2, centY+sqSize/2-WT));
                            break;
                        case TTL:
                            g2.draw(new Arc2D.Float(centX-sqSize, centY, sqSize, sqSize, 0, 90, Arc2D.OPEN));
                            g2.draw(new Line2D.Float(centX-sqSize/2, centY-sqSize/2+WT, centX+sqSize/2, centY-sqSize/2+WT));
                            break;
                        case TTR:
                            g2.draw(new Arc2D.Float(centX, centY, sqSize, sqSize, 90, 90, Arc2D.OPEN));
                            g2.draw(new Line2D.Float(centX-sqSize/2, centY-sqSize/2+WT, centX+sqSize/2, centY-sqSize/2+WT));
                            break;
                        case LTT:
                            g2.draw(new Arc2D.Float(centX, centY-sqSize, sqSize, sqSize, 180, 90, Arc2D.OPEN));
                            g2.draw(new Line2D.Float(centX-sqSize/2+WT, centY-sqSize/2, centX-sqSize/2+WT, centY+sqSize/2));
                            break;
                        case LTB:
                            g2.draw(new Arc2D.Float(centX, centY, sqSize, sqSize, 90, 90, Arc2D.OPEN));
                            g2.draw(new Line2D.Float(centX-sqSize/2+WT, centY-sqSize/2, centX-sqSize/2+WT, centY+sqSize/2));
                            break;
                        case RTT:
                            g2.draw(new Arc2D.Float(centX-sqSize, centY-sqSize, sqSize, sqSize, 270, 90, Arc2D.OPEN));
                            g2.draw(new Line2D.Float(centX+sqSize/2-WT, centY-sqSize/2, centX+sqSize/2-WT, centY+sqSize/2));
                            break;
                        case RTB:
                            g2.draw(new Arc2D.Float(centX-sqSize, centY, sqSize, sqSize, 0, 90, Arc2D.OPEN));
                            g2.draw(new Line2D.Float(centX+sqSize/2-WT, centY-sqSize/2, centX+sqSize/2-WT, centY+sqSize/2));
                            break;
                        case ITLC:
                            g2.draw(new Line2D.Float(centX, centY, centX+sqSize/2, centY));
                            g2.draw(new Line2D.Float(centX, centY, centX, centY+sqSize/2));
                            g2.draw(new Line2D.Float(centX+sqSize/2-WT, centY+sqSize/2-WT, centX+sqSize/2, centY+sqSize/2-WT));
                            g2.draw(new Line2D.Float(centX+sqSize/2-WT, centY+sqSize/2-WT, centX+sqSize/2-WT, centY+sqSize/2));
                            break;
                        case ITRC:
                            g2.draw(new Line2D.Float(centX, centY, centX-sqSize/2, centY));
                            g2.draw(new Line2D.Float(centX, centY, centX, centY+sqSize/2));
                            g2.draw(new Line2D.Float(centX-sqSize/2+WT, centY+sqSize/2-WT, centX-sqSize/2, centY+sqSize/2-WT));
                            g2.draw(new Line2D.Float(centX-sqSize/2+WT, centY+sqSize/2-WT, centX-sqSize/2+WT, centY+sqSize/2));
                            break;
                        case IBLC:
                            g2.draw(new Line2D.Float(centX, centY, centX+sqSize/2, centY));
                            g2.draw(new Line2D.Float(centX, centY, centX, centY-sqSize/2));
                            g2.draw(new Line2D.Float(centX+sqSize/2-WT, centY-sqSize/2+WT, centX+sqSize/2, centY-sqSize/2+WT));
                            g2.draw(new Line2D.Float(centX+sqSize/2-WT, centY-sqSize/2+WT, centX+sqSize/2-WT, centY-sqSize/2));
                            break;
                        case IBRC:
                            g2.draw(new Line2D.Float(centX, centY, centX-sqSize/2, centY));
                            g2.draw(new Line2D.Float(centX, centY, centX, centY-sqSize/2));
                            g2.draw(new Line2D.Float(centX-sqSize/2+WT, centY-sqSize/2+WT, centX-sqSize/2, centY-sqSize/2+WT));
                            g2.draw(new Line2D.Float(centX-sqSize/2+WT, centY-sqSize/2+WT, centX-sqSize/2+WT, centY-sqSize/2));
                            break;
                        case DOOR:
                            g.setColor(Color.PINK);
                            g.fillRect(centX-sqSize/2, centY+2*WT/3, sqSize, sqSize/2-2*WT);
                            break;
                        case BER:
                            g2.draw(new Line2D.Float(centX-sqSize/2, centY+sqSize/2-WT, centX+sqSize/2, centY+sqSize/2-WT));
                            g2.draw(new Line2D.Float(centX-sqSize/2, centY, centX+sqSize/2, centY));
                            g2.draw(new Line2D.Float(centX+sqSize/2, centY, centX+sqSize/2, centY+sqSize/2-WT));
                            break;
                        case BEL:
                            g2.draw(new Line2D.Float(centX-sqSize/2, centY+sqSize/2-WT, centX+sqSize/2, centY+sqSize/2-WT));
                            g2.draw(new Line2D.Float(centX-sqSize/2, centY, centX+sqSize/2, centY));
                            g2.draw(new Line2D.Float(centX-sqSize/2, centY, centX-sqSize/2, centY+sqSize/2-WT));
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
