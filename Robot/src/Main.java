import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class Main {
    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int xPos = 0;
        int yPos = 0;

        if(Desktop.isDesktopSupported()){
            Desktop.getDesktop().browse(new URI("http://www.google.com"));
            Thread.sleep(10000);
        }

        boolean exit = false;
        while (!exit){
            String input = reader.readLine();
            if (!input.isEmpty()){
                if (input.contains("click") || input.contains("c") || input.contains("C")){
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    continue;
                }
                if (input.contains("exit")){
                    exit = true;
                    continue;
                }
                if (input.contains("U") || input.contains("u")){
                    if (yPos > 0){
                        yPos -= 10;
                    }
                }
                if (input.contains("D") || input.contains("d")){
                    yPos += 10;
                }
                if (input.contains("R") || input.contains("r")){
                    xPos += 10;
                }
                if (input.contains("L") || input.contains("l")){
                    if (xPos > 0){
                        xPos -= 10;
                    }
                }
                robot.mouseMove(xPos, yPos);

            }
        }
    }
}