package demo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
//  ww w.j ava  2s .com
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScaleTest extends JPanel {
    public void paint(Graphics g) {
        g.fillRect(0, 0, 20, 20);

        Graphics2D g2 = (Graphics2D) g;

        var line = new Rectangle2D.Double(30.125, 30.0, 1, 1);

        g2.draw(line);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new ScaleTest());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(20, 20, 500, 500);
        frame.setVisible(true);
    }
}