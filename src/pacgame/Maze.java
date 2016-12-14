package pacgame;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Arc2D;
import java.util.Arrays;

public class Maze {
    public static final int nCols = 28;         // number of columns
    public static final int nRows = 36;         // number of rows
    public static final int sqSize = 25;        // grid square size
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
        grid[3][14] = TTRsq;
        for (int i = 15; i < 27; i++){
            grid[3][i] = Tsq;
        }
        grid[3][27] = TRCDsq;
        // row 4
        grid[4][0] = Lsq;
        for (int i = 1; i < 13; i++){
            grid[4][i] = DOTsq;
        }
        grid[4][13] = vertsq;
        grid[4][14] = vertsq;
        for (int i = 15; i < 27; i++){
            grid[4][i] = DOTsq;
        }
        grid[4][27] = Rsq;
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
        grid[5][14] = vertsq;
        grid[5][15] = DOTsq;
        grid[5][16] = TLCsq;
        grid[5][17] = horizsq;
        grid[5][18] = horizsq;
        grid[5][19] = horizsq;
        grid[5][20] = TRCsq;
        grid[5][21] = DOTsq;
        grid[5][22] = TLCsq;
        grid[5][23] = horizsq;
        grid[5][24] = horizsq;
        grid[5][25] = TRCsq;
        grid[5][26] = DOTsq;
        grid[5][27] = Rsq;
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
        grid[6][14] = vertsq;
        grid[6][15] = DOTsq;
        grid[6][16] = vertsq;
        grid[6][17] = EMPTYsq;
        grid[6][18] = EMPTYsq;
        grid[6][19] = EMPTYsq;
        grid[6][20] = vertsq;
        grid[6][21] = DOTsq;
        grid[6][22] = vertsq;
        grid[6][23] = EMPTYsq;
        grid[6][24] = EMPTYsq;
        grid[6][25] = vertsq;
        grid[6][26] = POWERUPsq;
        grid[6][27] = Rsq;
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
        grid[7][14] = BRCsq;
        grid[7][15] = DOTsq;
        grid[7][16] = BLCsq;
        grid[7][17] = horizsq;
        grid[7][18] = horizsq;
        grid[7][19] = horizsq;
        grid[7][20] = BRCsq;
        grid[7][21] = DOTsq;
        grid[7][22] = BLCsq;
        grid[7][23] = horizsq;
        grid[7][24] = horizsq;
        grid[7][25] = BRCsq;
        grid[7][26] = DOTsq;
        grid[7][27] = Rsq;
        // row 8
        grid[8][0] = Lsq;
        for (int i = 1; i < 27; i++){
            grid[8][i] = DOTsq;
        }
        grid[8][27] = Rsq;
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
        for (int i = 11; i < 17; i++){
            grid[9][i] = horizsq;
        }
        grid[9][17] = TRCsq;
        grid[9][18] = DOTsq;
        grid[9][19] = TLCsq;
        grid[9][20] = TRCsq;
        grid[9][21] = DOTsq;
        grid[9][22] = TLCsq;
        grid[9][23] = horizsq;
        grid[9][24] = horizsq;
        grid[9][25] = TRCsq;
        grid[9][26] = DOTsq;
        grid[9][27] = Rsq;
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
        grid[10][14] = TLCsq;
        grid[10][15] = horizsq;
        grid[10][16] = horizsq;
        grid[10][17] = BRCsq;
        grid[10][18] = DOTsq;
        grid[10][19] = vertsq;
        grid[10][20] = vertsq;
        grid[10][21] = DOTsq;
        grid[10][22] = BLCsq;
        grid[10][23] = horizsq;
        grid[10][24] = horizsq;
        grid[10][25] = BRCsq;
        grid[10][26] = DOTsq;
        grid[10][27] = Rsq;
        // row 11
        grid[11][0] = Lsq;
        for (int i = 1; i < 7; i++){
            grid[11][i] = DOTsq;
        }
        grid[11][7] = vertsq;
        grid[11][8] = vertsq;
        for (int i = 9; i < 13; i++){
            grid[11][i] = DOTsq;
        }
        grid[11][13] = vertsq;
        grid[11][14] = vertsq;
        for (int i = 15; i < 19; i++){
            grid[11][i] = DOTsq;
        }
        grid[11][19] = vertsq;
        grid[11][20] = vertsq;
        for (int i = 21; i < 27; i++){
            grid[11][i] = DOTsq;
        }
        grid[11][27] = Rsq;
        // row 12
        grid[12][0] = BLCUsq;
        for (int i = 1; i < 5; i++){
            grid[12][i] = Bsq;
        }
        grid[12][5] = BRCDsq;
        grid[12][6] = DOTsq;
        grid[12][7] = vertsq;
        grid[12][8] = BLCsq;
        grid[12][9] = horizsq;
        grid[12][10] = horizsq;
        grid[12][11] = TRCsq;
        grid[12][12] = EMPTYsq;
        grid[12][13] = vertsq;
        grid[12][14] = vertsq;
        grid[12][15] = EMPTYsq;
        grid[12][16] = TLCsq;
        grid[12][17] = horizsq;
        grid[12][18] = horizsq;
        grid[12][19] = BRCsq;
        grid[12][20] = vertsq;
        grid[12][21] = DOTsq;
        grid[12][22] = BLCDsq;
        for (int i = 23; i < 27; i++){
            grid[12][i] = Bsq;
        }
        grid[12][27] = BRCUsq;
        // row 13
        for (int i = 0; i < 5; i++){
            grid[13][i] = EMPTYsq;
        }
        grid[13][5] = Lsq;
        grid[13][6] = DOTsq;
        grid[13][7] = vertsq;
        grid[13][8] = TLCsq;
        grid[13][9] = horizsq;
        grid[13][10] = horizsq;
        grid[13][11] = BRCsq;
        grid[13][12] = EMPTYsq;
        grid[13][13] = BLCsq;
        grid[13][14] = BRCsq;
        grid[13][15] = EMPTYsq;
        grid[13][16] = BLCsq;
        grid[13][17] = horizsq;
        grid[13][18] = horizsq;
        grid[13][19] = TRCsq;
        grid[13][20] = vertsq;
        grid[13][21] = DOTsq;
        grid[13][22] = Rsq;
        for (int i = 23; i < 28; i++){
            grid[13][i] = EMPTYsq;
        }
        // row 14
        for (int i = 0; i < 5; i++){
            grid[14][i] = EMPTYsq;
        }
        grid[14][5] = Lsq;
        grid[14][6] = DOTsq;
        grid[14][7] = vertsq;
        grid[14][8] = vertsq;
        for (int i = 9; i < 19; i++){
            grid[14][i] = EMPTYsq;
        }
        grid[14][19] = vertsq;
        grid[14][20] = vertsq;
        grid[14][21] = DOTsq;
        grid[14][22] = Rsq;
        for (int i = 23; i < 28; i++){
            grid[14][i] = EMPTYsq;
        }
        // row 15
        for (int i = 0; i < 5; i++){
            grid[15][i] = EMPTYsq;
        }
        grid[15][5] = Lsq;
        grid[15][6] = DOTsq;
        grid[15][7] = vertsq;
        grid[15][8] = vertsq;
        grid[15][9] = EMPTYsq;
        grid[15][10] = ITLCsq;
        grid[15][11] = Bsq;
        grid[15][12] = BERsq;
        grid[15][13] = DOORsq;
        grid[15][14] = DOORsq;
        grid[15][15] = BELsq;
        grid[15][16] = Bsq;
        grid[15][17] = ITRCsq;
        grid[15][18] = EMPTYsq;
        grid[15][19] = vertsq;
        grid[15][20] = vertsq;
        grid[15][21] = DOTsq;
        grid[15][22] = Rsq;
        for (int i = 23; i < 28; i++){
            grid[15][i] = EMPTYsq;
        }
        // row 16
        for (int i = 0; i < 5; i++){
            grid[16][i] = Tsq;
        }
        grid[16][5] = TRCUsq;
        grid[16][6] = DOTsq;
        grid[16][7] = BLCsq;
        grid[16][8] = BRCsq;
        grid[16][9] = EMPTYsq;
        grid[16][10] = Rsq;
        for (int i = 11; i < 17; i++){
            grid[16][i] = EMPTYsq;
        }
        grid[16][17] = Lsq;
        grid[16][18] = EMPTYsq;
        grid[16][19] = BLCsq;
        grid[16][20] = BRCsq;
        grid[16][21] = DOTsq;
        grid[16][22] = TLCUsq;
        for (int i = 23; i < 28; i++){
            grid[16][i] = Tsq;
        }
        // row 17
        for (int i = 0; i < 6; i++){
            grid[17][i] = EMPTYsq;
        }
        grid[17][6] = DOTsq;
        grid[17][7] = EMPTYsq;
        grid[17][8] = EMPTYsq;
        grid[17][9] = EMPTYsq;
        grid[17][10] = Rsq;
        for (int i = 11; i < 17; i++){
            grid[17][i] = EMPTYsq;
        }
        grid[17][17] = Lsq;
        grid[17][18] = EMPTYsq;
        grid[17][19] = EMPTYsq;
        grid[17][20] = EMPTYsq;
        grid[17][21] = DOTsq;
        for (int i = 22; i < 28; i++){
            grid[17][i] = EMPTYsq;
        }
        // row 18
        for (int i = 0; i < 5; i++){
            grid[18][i] = Bsq;
        }
        grid[18][5] = BRCDsq;
        grid[18][6] = DOTsq;
        grid[18][7] = TLCsq;
        grid[18][8] = TRCsq;
        grid[18][9] = EMPTYsq;
        grid[18][10] = Rsq;
        for (int i = 11; i < 17; i++){
            grid[18][i] = EMPTYsq;
        }
        grid[18][17] = Lsq;
        grid[18][18] = EMPTYsq;
        grid[18][19] = TLCsq;
        grid[18][20] = TRCsq;
        grid[18][21] = DOTsq;
        grid[18][22] = BLCDsq;
        for (int i = 23; i < 28; i++){
            grid[18][i] = Bsq;
        }
        // row 19
        for (int i = 0; i < 5; i++){
            grid[19][i] = EMPTYsq;
        }
        grid[19][5] = Lsq;
        grid[19][6] = DOTsq;
        grid[19][7] = vertsq;
        grid[19][8] = vertsq;
        grid[19][9] = EMPTYsq;
        grid[19][10] = IBLCsq;
        for (int i = 11; i < 17; i++){
            grid[19][i] = Tsq;
        }
        grid[19][17] = IBRCsq;
        grid[19][18] = EMPTYsq;
        grid[19][19] = vertsq;
        grid[19][20] = vertsq;
        grid[19][21] = DOTsq;
        grid[19][22] = Rsq;
        for (int i = 23; i < 28; i++){
            grid[19][i] = EMPTYsq;
        }
        // row 20
        for (int i = 0; i < 5; i++){
            grid[20][i] = EMPTYsq;
        }
        grid[20][5] = Lsq;
        grid[20][6] = DOTsq;
        grid[20][7] = vertsq;
        grid[20][8] = vertsq;
        for (int i = 9; i < 19; i++){
            grid[20][i] = EMPTYsq;
        }
        grid[20][19] = vertsq;
        grid[20][20] = vertsq;
        grid[20][21] = DOTsq;
        grid[20][22] = Rsq;
        for (int i = 23; i < 28; i++){
            grid[20][i] = EMPTYsq;
        }
        // row 21
        for (int i = 0; i < 5; i++){
            grid[21][i] = EMPTYsq;
        }
        grid[21][5] = Lsq;
        grid[21][6] = DOTsq;
        grid[21][7] = vertsq;
        grid[21][8] = vertsq;
        grid[21][9] = EMPTYsq;
        grid[21][10] = TLCsq;
        for (int i = 11; i < 17; i++){
            grid[21][i] = horizsq;
        }
        grid[21][17] = TRCsq;
        grid[21][18] = EMPTYsq;
        grid[21][19] = vertsq;
        grid[21][20] = vertsq;
        grid[21][21] = DOTsq;
        grid[21][22] = Rsq;
        for (int i = 23; i < 28; i++){
            grid[21][i] = EMPTYsq;
        }
        // row 22
        grid[22][0] = TLCDsq;
        for (int i = 1; i < 5; i++){
            grid[22][i] = Tsq;
        }
        grid[22][5] = TRCUsq;
        grid[22][6] = DOTsq;
        grid[22][7] = BLCsq;
        grid[22][8] = BRCsq;
        grid[22][9] = EMPTYsq;
        grid[22][10] = BLCsq;
        grid[22][11] = horizsq;
        grid[22][12] = horizsq;
        grid[22][13] = TRCsq;
        grid[22][14] = TLCsq;
        grid[22][15] = horizsq;
        grid[22][16] = horizsq;
        grid[22][17] = BRCsq;
        grid[22][18] = EMPTYsq;
        grid[22][19] = BLCsq;
        grid[22][20] = BRCsq;
        grid[22][21] = DOTsq;
        grid[22][22] = TLCUsq;
        for (int i = 23; i < 27; i++){
            grid[22][i] = Tsq;
        }
        grid[22][27] = TRCDsq;
        // row 23
        grid[23][0] = Lsq;
        for (int i = 1; i < 13; i++){
            grid[23][i] = DOTsq;
        }
        grid[23][13] = vertsq;
        grid[23][14] = vertsq;
        for (int i = 15; i < 27; i++){
            grid[23][i] = DOTsq;
        }
        grid[23][27] = Rsq;
        // row 24
        grid[24][0] = Lsq;
        grid[24][1] = DOTsq;
        grid[24][2] = TLCsq;
        grid[24][3] = horizsq;
        grid[24][4] = horizsq;
        grid[24][5] = TRCsq;
        grid[24][6] = DOTsq;
        grid[24][7] = TLCsq;
        grid[24][8] = horizsq;
        grid[24][9] = horizsq;
        grid[24][10] = horizsq;
        grid[24][11] = TRCsq;
        grid[24][12] = DOTsq;
        grid[24][13] = vertsq;
        grid[24][14] = vertsq;
        grid[24][15] = DOTsq;
        grid[24][16] = TLCsq;
        grid[24][17] = horizsq;
        grid[24][18] = horizsq;
        grid[24][19] = horizsq;
        grid[24][20] = TRCsq;
        grid[24][21] = DOTsq;
        grid[24][22] = TLCsq;
        grid[24][23] = horizsq;
        grid[24][24] = horizsq;
        grid[24][25] = TRCsq;
        grid[24][26] = DOTsq;
        grid[24][27] = Rsq;
        // row 25
        grid[25][0] = Lsq;
        grid[25][1] = DOTsq;
        grid[25][2] = BLCsq;
        grid[25][3] = horizsq;
        grid[25][4] = TRCsq;
        grid[25][5] = vertsq;
        grid[25][6] = DOTsq;
        grid[25][7] = BLCsq;
        grid[25][8] = horizsq;
        grid[25][9] = horizsq;
        grid[25][10] = horizsq;
        grid[25][11] = BRCsq;
        grid[25][12] = DOTsq;
        grid[25][13] = BLCsq;
        grid[25][14] = BRCsq;
        grid[25][15] = DOTsq;
        grid[25][16] = BLCsq;
        grid[25][17] = horizsq;
        grid[25][18] = horizsq;
        grid[25][19] = horizsq;
        grid[25][20] = BRCsq;
        grid[25][21] = DOTsq;
        grid[25][22] = vertsq;
        grid[25][23] = TLCsq;
        grid[25][24] = horizsq;
        grid[25][25] = BRCsq;
        grid[25][26] = DOTsq;
        grid[25][27] = Rsq;
        // row 26
        grid[26][0] = Lsq;
        grid[26][1] = POWERUPsq;
        grid[26][2] = DOTsq;
        grid[26][3] = DOTsq;
        grid[26][4] = vertsq;
        grid[26][5] = vertsq;
        for (int i = 6; i < 13; i++){
            grid[26][i] = DOTsq;
        }
        grid[26][13] = EMPTYsq;
        grid[26][14] = EMPTYsq;
        for (int i = 15; i < 22; i++){
            grid[26][i] = DOTsq;
        }
        grid[26][22] = vertsq;
        grid[26][23] = vertsq;
        grid[26][24] = DOTsq;
        grid[26][25] = DOTsq;
        grid[26][26] = POWERUPsq;
        grid[26][27] = Rsq;
        // row 27
        grid[27][0] = LTTsq;
        grid[27][1] = horizsq;
        grid[27][2] = TRCsq;
        grid[27][3] = DOTsq;
        grid[27][4] = vertsq;
        grid[27][5] = vertsq;
        grid[27][6] = DOTsq;
        grid[27][7] = TLCsq;
        grid[27][8] = TRCsq;
        grid[27][9] = DOTsq;
        grid[27][10] = TLCsq;
        for (int i = 11; i < 17; i++){
            grid[27][i] = horizsq;
        }
        grid[27][17] = TRCsq;
        grid[27][18] = DOTsq;
        grid[27][19] = TLCsq;
        grid[27][20] = TRCsq;
        grid[27][21] = DOTsq;
        grid[27][22] = vertsq;
        grid[27][23] = vertsq;
        grid[27][24] = DOTsq;
        grid[27][25] = TLCsq;
        grid[27][26] = horizsq;
        grid[27][27] = RTTsq;
        // row 28
        grid[28][0] = LTBsq;
        grid[28][1] = horizsq;
        grid[28][2] = BRCsq;
        grid[28][3] = DOTsq;
        grid[28][4] = BLCsq;
        grid[28][5] = BRCsq;
        grid[28][6] = DOTsq;
        grid[28][7] = vertsq;
        grid[28][8] = vertsq;
        grid[28][9] = DOTsq;
        grid[28][10] = BLCsq;
        grid[28][11] = horizsq;
        grid[28][12] = horizsq;
        grid[28][13] = TRCsq;
        grid[28][14] = TLCsq;
        grid[28][15] = horizsq;
        grid[28][16] = horizsq;
        grid[28][17] = BRCsq;
        grid[28][18] = DOTsq;
        grid[28][19] = vertsq;
        grid[28][20] = vertsq;
        grid[28][21] = DOTsq;
        grid[28][22] = BLCsq;
        grid[28][23] = BRCsq;
        grid[28][24] = DOTsq;
        grid[28][25] = BLCsq;
        grid[28][26] = horizsq;
        grid[28][27] = RTBsq;
        // row 29
        grid[29][0] = Lsq;
        for (int i = 1; i < 7; i++){
            grid[29][i] = DOTsq;
        }
        grid[29][7] = vertsq;
        grid[29][8] = vertsq;
        for (int i = 9; i < 13; i++){
            grid[29][i] = DOTsq;
        }
        grid[29][13] = vertsq;
        grid[29][14] = vertsq;
        for (int i = 15; i < 19; i++){
            grid[29][i] = DOTsq;
        }
        grid[29][19] = vertsq;
        grid[29][20] = vertsq;
        for (int i = 21; i < 27; i++){
            grid[29][i] = DOTsq;
        }
        grid[29][27] = Rsq;
        // row 30
        grid[30][0] = Lsq;
        grid[30][1] = DOTsq;
        grid[30][2] = TLCsq;
        for (int i = 3; i < 7; i++){
            grid[30][i] = horizsq;
        }
        grid[30][7] = BRCsq;
        grid[30][8] = BLCsq;
        grid[30][9] = horizsq;
        grid[30][10] = horizsq;
        grid[30][11] = TRCsq;
        grid[30][12] = DOTsq;
        grid[30][13] = vertsq;
        grid[30][14] = vertsq;
        grid[30][15] = DOTsq;
        grid[30][16] = TLCsq;
        grid[30][17] = horizsq;
        grid[30][18] = horizsq;
        grid[30][19] = BRCsq;
        grid[30][20] = BLCsq;
        for (int i = 21; i < 25; i++){
            grid[30][i] = horizsq;
        }
        grid[30][25] = TRCsq;
        grid[30][26] = DOTsq;
        grid[30][27] = Rsq;
        // row 31
        grid[31][0] = Lsq;
        grid[31][1] = DOTsq;
        grid[31][2] = BLCsq;
        for (int i = 3; i < 11; i++){
            grid[31][i] = horizsq;
        }
        grid[31][11] = BRCsq;
        grid[31][12] = DOTsq;
        grid[31][13] = BLCsq;
        grid[31][14] = BRCsq;
        grid[31][15] = DOTsq;
        grid[31][16] = BLCsq;
        for (int i = 17; i < 25; i++){
            grid[31][i] = horizsq;
        }
        grid[31][25] = BRCsq;
        grid[31][26] = DOTsq;
        grid[31][27] = Rsq;
        // row 32
        grid[32][0] = Lsq;
        for (int i = 1; i < 27; i++){
            grid[32][i] = DOTsq;
        }
        grid[32][27] = Rsq;
        // row 33
        grid[33][0] = BLCUsq;
        for (int i = 1; i < 27; i++){
            grid[33][i] = Bsq;
        }
        grid[33][27] = BRCUsq;
        // row 34
        Arrays.fill(grid[34], EMPTYsq);
        // row 35
        Arrays.fill(grid[35], EMPTYsq);
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
