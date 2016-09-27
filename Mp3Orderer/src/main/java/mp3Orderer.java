import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.IOException;

/**
 * Created by Admin on 27.09.2016.
 */
public class mp3Orderer
{

        public static void main(String[] args) throws IOException
        {
            // file path
            try
            {
                Mp3File mp3file = new Mp3File("D:\\DOWNLOADS\\VKmusic/Metallica - Shoot Me Again.mp3");

                if (mp3file.hasId3v1Tag())
                {
                    ID3v1 id3v1Tag = mp3file.getId3v1Tag();

                    System.out.println("Artist: " + id3v1Tag.getArtist());
                    System.out.println("Title: " + id3v1Tag.getTitle());

                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
}
