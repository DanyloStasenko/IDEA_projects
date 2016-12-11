import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main
{

    public static void main(String[] args)
    {
        //String url = "https://sb-ssl.google.com/safebrowsing/api/lookup?client=DS&key=AIzaSyBe5JVoM-jSx3bFGLTpF1Uy5mhjhNHhmq4&appver=1.5.2&pver=3.1&url=http://www.google.com/search?q=mkyong";

        try
        {
            sendGet("google.com");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // HTTP GET request
    private static void sendGet(String title) throws Exception {

        String url;
        if (title.contains("http://"))
        {
            url = title;
            System.out.println("url corrected");
        }
        else
        {
           url = ("http://"+title);
        }

        //String url = "http://www.google.com";
        String status = "";
        try
        {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            status = con.getResponseMessage();
            System.out.println("rm = "+status);
        }
        catch (Exception e)
        {
            //e.printStackTrace();
        }
        //this.domainStatus = defaultStatus;
        System.out.println(status);

    }
}
