package pacgame;
// adapted from http://codereview.stackexchange.com/questions/29630/simple-java-animation-with-swing
import javax.swing.*;
import java.awt.*;

public class Maze {
    public void go() {

        System.out.println("this is Maze.go");

        class DrawPanel extends JPanel {
            public void paintComponent(Graphics g) {
                g.setColor(Color.BLUE);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                g.setColor(Color.RED);
                g.fillRect(3, 3, this.getWidth()-6, this.getHeight()-6);
                g.setColor(Color.WHITE);
                g.fillRect(6, 6, this.getWidth()-12, this.getHeight()-12);
                g.setColor(Color.BLACK);
                g.fillRect(7, 7, 6, 6);
            }
        }

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawPanel drawPanel = new DrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(224, 288);
        frame.setLocation(100, 100);
        // moveIt();

    }
}
