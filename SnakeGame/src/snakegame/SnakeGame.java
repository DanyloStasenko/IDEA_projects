package snakegame;
import objects.Apple;
import objects.Snake;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Admin on 14.07.2016.
 */

public class SnakeGame extends JPanel implements ActionListener {

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int SPEED = 5;

    Apple a = new Apple((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
    Snake s = new Snake(10, 10, 9, 10);
    Timer t = new Timer(1000/SPEED, this);

    public SnakeGame(){
        t.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
    }

    public void paint(Graphics g){
        g.setColor(color(15, 50, 10));
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        g.setColor(color(255, 10, 16));

        for(int xx = 0; xx <= WIDTH*SCALE; xx+=SCALE)
        {
            g.drawLine(xx, 0, xx, HEIGHT*SCALE);
        }

        for(int yy = 0; yy <= HEIGHT*SCALE; yy+=SCALE)
        {
            g.drawLine(0, yy, HEIGHT*SCALE, yy);
        }

        for(int d = 0; d < s.length; d++)
        {
            g.setColor(color(200, 150, 0));
            g.fillRect(s.snakeX[d]*SCALE+1, s.snakeY[d]*SCALE+1, SCALE+1, SCALE+1);
        }

        g.setColor(color(255, 0, 0));
        g.fillRect(a.posX*SCALE+1, a.posY*SCALE+1, SCALE-1, SCALE-1);
    }


    public Color color(int red, int green, int blue)
    {
        return new Color(red, green, blue);
    }


    public static void main(String[] args) {

        JFrame f = new JFrame();

        // памятати про порядок виклику функцій
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(WIDTH * SCALE+7, HEIGHT * SCALE+30);
        f.setLocationRelativeTo(null);
        f.add(new SnakeGame());
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent arg0){
        s.move();
        if((s.snakeX[0] == a.posX)&(s.snakeY[0] == a.posY))
        {
            a.setRandomPosition();
            s.length++;
        }

        for (int k = 1; k < s.length ; k++) {

            if((s.snakeX[k] == a.posX)&(s.snakeY[k] == a.posY))
            {
                a.setRandomPosition();
                s.length++;
            }
        }

        repaint();
    }

    private class Keyboard extends KeyAdapter{
        public void keyPressed(KeyEvent kvt){
            int key = kvt.getKeyCode();

            if((key == KeyEvent.VK_RIGHT) & s.direction != 2) s.direction = 0;
            if((key == KeyEvent.VK_DOWN) & s.direction != 3)s.direction = 1;
            if((key == KeyEvent.VK_LEFT) & s.direction != 0)s.direction = 2;
            if((key == KeyEvent.VK_UP) & s.direction != 1)s.direction = 3;
        }
    }
}
