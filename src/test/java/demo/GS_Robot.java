package demo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static java.lang.System.currentTimeMillis;

public class GS_Robot extends JFrame {
    private Random rd = new Random(currentTimeMillis());
    RobotCanvas canvas = new RobotCanvas();

    public static void main(String[] args) {
        GS_Robot fr = new GS_Robot();
        fr.saveImg();
    }

    private GS_Robot() {
        setLayout(new BorderLayout());
        setSize(800, 500);
        setTitle("canvas demo");
        add(canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void saveImg() {
        BufferedImage images = canvas.getBFI();
        try {
            ImageIO.write(images, "PNG", new File("target"+File.separator+"test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class RobotCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            //500*500
            int r = 100;
            int rPlus = 120;
            int oX = 250, oY = 150;

            //background
            var image=new ImageIcon("C:\\Users\\wsgpz\\IdeaProjects\\canvas\\src\\run\\resources\\img\\16pic_613483_b.png").getImage();
            g.drawImage(image, 1, 1, this);


            g.setColor(Color.BLACK);
            //头
            g.drawOval(150, 50, r * 2, r * 2);

            //爆炸头
            for (double i = 0; i < 90; i++) {
                double sin = Math.sin(i);
                double cos = Math.cos(i);
                changeColor(g);
                g.drawLine((int) (oX + r * cos), (int) (oY + r * sin), (int) (oX + rPlus * cos), (int) (oY + (rPlus) * sin));
            }


            //眼睛
            g.drawOval(180, 85, 40, 30);
            g.drawOval(280, 85, 40, 30);
            //瞳孔
            g.fillOval(190, 92, 20, 15);
            g.fillOval(290, 92, 20, 15);

            //light
            int temp_x = 150;
            for (int i = 0; i < 5; i++) {
                changeColor(g);
                g.fillRect(temp_x, 50 + 100, 40, 20);
                temp_x = temp_x + 40;
            }

            //body
            changeColor(g);
            g.fillRect(150, 170, 200, 200);
            changeColor(g);
            g.setFont(new Font("", Font.BOLD, 20));
            g.drawString("GS_ROBOT", 200, 220);

            //leg
            int temp_y = 370;
            for (int i = 0; i < 5; i++) {
                changeColor(g);
                g.fillRect(190, temp_y, 20, 10);
                g.fillRect(290, temp_y, 20, 10);
                temp_y += 10;
            }
            g.copyArea(0, 0, 400, 500, 400, 0);
            g.dispose();
        }

        BufferedImage getBFI() {
            BufferedImage bi = new BufferedImage(800, 500, BufferedImage.TYPE_INT_ARGB);
            Graphics g2d = bi.createGraphics();
            paint(g2d);
            g2d.dispose();//销毁资源
            return bi;
        }

        int colorValue() {
            return Math.abs(rd.nextInt()) % 255;
        }

        void changeColor(Graphics g) {
            g.setColor(new Color(colorValue(), colorValue(), colorValue()));
        }
    }
}




