package objects;

/**
 * Created by Admin on 14.07.2016.
 */
public class Snake {
    public int direction = 3;
    public int length = 2;

    public int snakeX[] = new int[100];
    public int snakeY[] = new int[100];

    public Snake(int x0,int y0,int x1,int y1)
    {
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;
    }


    public void move(){

        for(int d = length; d > 0; d--)
        {
            snakeX[d] = snakeX[d-1];
            snakeY[d] = snakeY[d-1];
        }
        if (direction == 0) snakeX[0]++;
        if (direction == 1) snakeY[0]++;
        if (direction == 2) snakeX[0]--;
        if (direction == 3) snakeY[0]--;

        for(int d = length-1; d > 0; d--){
            if((snakeX[0] == snakeX[d]) & (snakeY[0]== snakeY[d])) length = d-2;
        }

        if (length < 2) length = 2;

    }


}
