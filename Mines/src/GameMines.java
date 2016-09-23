import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * Created by Admin on 23.09.2016.
 */

// JFrame - windows on the desktop
public class GameMines extends JFrame
{
    final String TITLE_OF_PROGRAMM = "Game Mines";
    final String SIGN_OF_FLAG = "f";
    final int BLOCK_SIZE = 30; // px
    final int FIELD_SIZE = 9; // blocks
    final int FIELD_DX = 6;
    final int FIELD_DY = 28;
    final int START_LOCATION = 200;
    final int MOUSE_BUTTON_LEFT = 1;
    final int MOUSE_BUTTON_RIGHT = 3;
    final int NUMBER_OF_MINES = 10;
    final int[] COLOR_OF_NUMBERS = {0x0000FF, 0x008000, 0xFF0000, 0x800000, 0x0};

    Cell[][] field = new Cell[FIELD_SIZE][FIELD_SIZE];
    Random random = new Random();
    int countOpenedCells;
    boolean youWon, bangMine;
    int bangX, bangY;

    public static void main(String[] args)
    {
        // start of the game
        new GameMines();
    }




    GameMines()
    {
        setTitle(TITLE_OF_PROGRAMM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, FIELD_SIZE*BLOCK_SIZE + FIELD_DX, FIELD_SIZE*BLOCK_SIZE + FIELD_DY);
        setResizable(false);
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.white);
        canvas.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseReleased(MouseEvent e)
            {
                super.mouseReleased(e);
                int x = e.getX()/BLOCK_SIZE;
                int y = e.getY()/BLOCK_SIZE;
                if (!bangMine && !youWon) {
                    if (e.getButton() == MOUSE_BUTTON_LEFT) // left button mouse
                        if (field[y][x].isNotOpen()) {
                            openCells(x, y);
                            youWon = countOpenedCells == FIELD_SIZE*FIELD_SIZE - NUMBER_OF_MINES; // winning check
                            if (bangMine) {
                                bangX = x;
                                bangY = y;
                            }
                        }
                    if (e.getButton() == MOUSE_BUTTON_RIGHT) field[y][x].inverseFlag(); // right button mouse
                    if (bangMine || youWon) timeLabel.stopTimer(); // game over
                    canvas.repaint();
                }
            }
        });

        add(BorderLayout.CENTER, canvas);
        // add(BorderLayout.SOUTH, timeLable);

        setVisible(true);
        initField();


    }




    void initField()
    {

    }

    class Cell
    {
        void open()
        {

        }

        boolean isNotOpen()
        {
            return false;
        }

        void inverseFlag()
        {

        }

    }

    class  Canvas extends JPanel
    {
        @Override
        public void paint(Graphics g)
        {
            super.paint(g);
            for (int x = 0; x < FIELD_SIZE; x++)
            {
                for (int y = 0; y < FIELD_SIZE; y++)
                {
                    field[y][x].paint(g, x, y);
                }
            }
        }

        // 0:56:19

    }
}
