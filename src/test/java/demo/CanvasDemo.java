package demo;

import javax.swing.*;
import java.awt.*;

public class CanvasDemo extends JFrame {
    private MyCanvas canvas = new MyCanvas();

    public static void main(String[] args) {
        CanvasDemo fr = new CanvasDemo();
    }

    private CanvasDemo() {
        setLayout(new BorderLayout());
        setSize(500, 375);
        setTitle("canvas demo");
        add(canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {

            var g2d = (Graphics2D) g;

            g2d.drawString("hello canvas", 0, 10);
            g2d.drawOval(50, 50, 100, 25);
            g2d.drawRect(50, 62, 100, 50);
            g2d.drawOval(50, 100, 100, 25);

            g2d.setColor(Color.BLUE);
            g2d.fillOval(200, 100, 70, 70);
            g2d.fillRect(190, 170, 90, 90);

            g2d.setColor(Color.yellow);
            g2d.setFont(new Font("", Font.BOLD, 20));
            g2d.drawString("end", 50, 200);

            g2d.drawLine(250, 200, 200, 250);

g2d.scale(10,10);
            g2d.dispose();
        }

    }
}




