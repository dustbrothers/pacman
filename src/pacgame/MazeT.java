package pacman;
import javax.swing.*;
import java.awt.*;

public class Maze {
    // Sometimes, you want to have constants, which are values that are always
    // the same.  This allows you to avoid "magic numbers", which are any
    // numbers written in code.  Ideally, you want everything to be in a
    // variable, especially if it's used more than once.  This way, if you
    // ever need to change them, you do it in one place and it takes effect
    // everywhere.  Two relevant constants are dimensions of the grid/maze,
    // which you will have to update.
    // Here, we say "final" after "public static" to essentially tell the
    // compiler that these values can't/won't be changed.
    // Style note: when a constant or variable is the number of something,
    // it is common to put the letter n at the front to denote "number".  You
    // may also see "num", as in numCols.  If you like one better than the
    // other, go ahead and use it.
    public static final int nCols = 200;
    public static final int nRows = 100;

    // The maze should have some concept of what is in each square, so store
    // that in here.  It will be a 2D array, or an array of arrays.  When
    // indexing, the number in the first (left) set of brackets will be the
    // row and the number in the second (right) will be the column.  Note that
    // this is backwards from what you'd nomally see in algebra.  Thus, the
    // point (1, 5) would be at x=1 (column 1) and y=5 (row 5) and indexed
    // as array2D[5][1].
    static Square[][] grid;

    // You need a constructor that creates the grid for you.  You'll have to
    // put correct values in for number of rows and columns.
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
        // To do this, you'll have to iterate over grid (an example exists
        // later in this file).  Here is an example for reference of how to
        // set values in the array and Square class.
        Square example = new Square();
        example.dot = false;
        example.wall = WallType.HORIZONTAL;
        grid[0][0] = example;

        // OR //
        grid[0][1].dot = true;
        grid[0][1].wall = WallType.NONE;
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
        NONE, HORIZONTAL, VERTICAL
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
            for (int row = 0; row < nRows; row++) {
                for (int col = 0; col < nCols; col++) {
                    // It may be nice to quickly compute the pixel
                    // coordinates of the center of this square right
                    // here for reference later in the loop.  It will likely
                    // require some simple math to figure out.
                    int pixelX;
                    int pixelY;

                    // Here is where you can take care of each possible
                    // value of a grid
                    if (grid[row][col].dot) {
                        // Draw a dot and continue.  Continue basically
                        // says you're done on this iteration of the loop
                        // so go to the next one
                        continue;
                    }
                    // If there's no dot, then there might be a wall.  We
                    // can use a switch statement to address each possible
                    // value.
                    switch (grid[row][col].wall) {
                        case NONE:
                            break;
                        case HORIZONTAL:
                            break;
                        case VERTICAL:
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

        frame.setVisible(true);
        frame.setResizable(false);
        // NOTE: These are magic numbers.  They should be constants set at the
        // top.  Alternatively, you can "setSize" based on how many rows and
        // columns you've drawn.
        frame.setSize(300, 300);
        frame.setLocation(375, 55);
    }
}
