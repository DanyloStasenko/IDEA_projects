import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 27.09.2016.
 */
public class Orderer
{

    public static void main(String[] args) throws IOException
    {
        // file path
        Mp3File mp3file = new Mp3File("D:\\DOWNLOADS\\VKmusic/Metallica - Shoot Me Again.mp3");

        System.out.println("Artist: " + id3v1Tag.getArtist());
        System.out.println("Title: " + id3v1Tag.getTitle());

        /*String sinput = reader.readLine();
        byte[] binput = sinput.getBytes(Charset.forName("UTF-8"));


        byte[] title = Arrays.copyOfRange(binput, 0, 128);
        byte[] author = Arrays.copyOfRange(binput, 30, 60);

        String string = new String( title, "UTF-8");
        String string2 = new String( author, "UTF-8");

        //System.out.println(Arrays.toString(binput));

        System.out.println(string);
        System.out.println(string2);*/



        // FileInputStream input = new FileInputStream(file);



    }
}
