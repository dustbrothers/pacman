package pacgame;
// adapted from http://codereview.stackexchange.com/questions/29630/simple-java-animation-with-swing
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Maze {
    public void go() {

        System.out.println("this is Maze.go");

        class DrawPanel extends JPanel {
            public void paintComponent(Graphics g) {
                // red banner
                g.setColor(Color.RED);
                g.fillRect(0, 0, this.getWidth(), this.getHeight()/8);
                // rectangle x,y,w,h
                int rectx = this.getWidth()/6;
                int recty = this.getHeight()/3;
                int rectw = this.getWidth()/16;
                int recth = this.getHeight()/3+this.getHeight()/10;
                // blue rectangle
                g.setColor(Color.BLUE);
                g.fillRect(rectx, recty, rectw, recth);
                // square x,y,width
                int squarex = this.getWidth()/2;
                int squarey = this.getHeight()/3+this.getHeight()/10;
                int squarew = this.getWidth()/4;
                // orange square outline
                Color orange = Color.decode("#FC9E45");
                g.setColor(orange);
                g.fillRect(squarex, squarey, squarew, squarew);
                // white square
                g.setColor(Color.WHITE);
                g.fillRect(squarex+3, squarey+3, squarew-6, squarew-6);
                // circle x,y,radius
                int circler = squarew/3;
                int circlex = squarex+squarew-circler;
                int circley = squarey-circler;
                // green circle outline
                Color green = Color.decode("#029C0A");
                g.setColor(green);
                g.fillOval(circlex, circley, 2*circler, 2*circler);
                // yellow circle
                g.setColor(Color.YELLOW);
                g.fillOval(circlex+3, circley+3, 2*circler-6, 2*circler-6);
                // purple line
                Color purple = Color.decode("#920292");
                g.setColor(purple);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g2.draw(new Line2D.Float(0, 0, this.getWidth(), this.getHeight()));
                // g.setColor(Color.MAGENTA);
                // g.drawLine(0, 0, this.getWidth(), this.getHeight());
            }
        }

        JFrame frame = new JFrame("Pacman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawPanel drawPanel = new DrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        Color bgblue = Color.decode("#59D1FC");
        frame.setBackground(bgblue);

        frame.setVisible(true);
        frame.setResizable(false);
        // frame.setSize(224, 288);
        frame.setSize(300, 300);
        frame.setLocation(0, 0);
        // moveIt();

    }
}
