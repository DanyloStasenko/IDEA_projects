import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Admin on 12.09.2016.
 */

/*
        task from:
        http://codeforces.com/problemset/problem/712/B

        Мемори гуляет по декартовой плоскости, начиная в точке начала координат. У неё есть последовательность действий s:
        Символ «L» означает шаг на единицу влево.
        Символ «R» означает шаг на единицу вправо.
        Символ «U» означает шаг на единицу вверх.
        Символ «D» означает шаг на единицу вниз.

        Мемори хочет, чтобы, последовательно исполнив все команды, она снова оказалась в точке начала координат.
        У неё есть специальный трезубец, который за одно применение может изменить любой символ в строке s на один из символов «L», «R», «U» или «D».
        Однако пользоваться трезубцем нелегко, поэтому Мемори хочет минимизировать количество его применений или определить, что добиться желаемого невозможно в принципе.

        Входные данные
        В единственной строке входных данных записана строка s (1 ≤ |s| ≤ 100 000) — последовательность инструкций, которая есть у Мемори.


        Выходные данные
        Если невозможно изменить строку так, чтобы Мемори заканчивала путешествие в точке начала координат, то выведите -1 в единственной строке выходных данных.
        В противном случае выведите минимальное требуемое количество изменений.

        Примеры:
        Входные даные   :   Результат
             RRU             (-1)
             UDUR             (1)
             RUUR             (2)

        */


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // userInput
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();

        // counts
        int upCount=0;
        int downCount = 0;
        int rightCount = 0;
        int leftCount = 0;

        // difference
        int upDownDifference = 0;
        int leftRightDifference = 0;
        int differenceSum = 0;

        // calculate how many times used 'UP', 'DOWN', 'LEFT', 'RIGHT'
        for (char element : userInput.toCharArray()){
            if (element == 'U') upCount++;
            if (element == 'D') downCount++;
            if (element == 'L') leftCount++;
            if (element == 'R') rightCount++;
        }

        // calculate UpDownDifference
        upDownDifference = upCount-downCount;
        if (upDownDifference < 0)
        {
            upDownDifference = upDownDifference * (-1);
        }

        // calculate LeftRightDifference
        leftRightDifference = leftCount-rightCount;
        if (leftRightDifference < 0)
        {
            leftRightDifference = leftRightDifference * (-1);
        }


        differenceSum = upDownDifference + leftRightDifference;

        if (differenceSum %2 != 0)
        {
            System.out.println("No result!");
        }

        else System.out.println(differenceSum/2);
    }
}
