import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.Mp3File;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 27.09.2016.
 */
public class mp3Orderer
{

/* public static ArrayList<File> listFilesWithSubFolders(File dir) {
        ArrayList<File> files = new ArrayList<File>();
        for (File file : dir.listFiles()) {
            if (file.isDirectory())
                files.addAll(listFilesWithSubFolders(file));
            else
                files.add(file);
        }
        return files;
    }

    public static void renameSoundtracks(ArrayList<File> songs)
    {
        Iterator<File> files = songs.iterator();
        while(files.hasNext())
        {

        }


    }
        for (File file : ArrayList.get()) {
            if (file.isDirectory())
                files.addAll(listFilesWithSubFolders(file));
            else
                files.add(file);


    }*/
        public static void main(String[] args) throws IOException
        {
            String path = "D:\\DOWNLOADS\\VKmusic\\Dublicate\\1\\Metallica - Shoot Me Again.mp3";
            File file = new File(path);

            System.out.println((file));
            try
            {

                Mp3File mp3file = new Mp3File("D:\\DOWNLOADS\\VKmusic\\Dublicate\\1\\Metallica - Shoot Me Again.mp3");

                if (mp3file.hasId3v1Tag())
                {
                    // get tag
                    ID3v1 id3v1Tag = mp3file.getId3v1Tag();

                    // get info
                    String artist = id3v1Tag.getArtist();
                    String title = id3v1Tag.getTitle();

                    // change info
                    String replacedArtist = artist.replace(" ","_");
                    String replacedTitle = title.replace(" ","_");

                    //create new name
                    String newName = replacedArtist+"-"+replacedTitle;
                    System.out.println(newName);

                    File file1 = new File("D:\\DOWNLOADS\\VKmusic\\Dublicate\\1\\Metallica - Shoot Me Again.mp3");
                    File fileWithNewName = new File("D:\\DOWNLOADS\\VKmusic\\Dublicate\\1\\"+newName+".mp3");
                    if (file1.renameTo(fileWithNewName)) {
                        System.out.println("Переименование прошло успешло");
                    } else {
                        System.out.println("Переименовать файл не удалось");
                    }


                    file.renameTo(new java.io.File("newName"+".mp3"));
                    System.out.println(newName);


                }
            }
            catch (Exception e){ e.printStackTrace();}
        }
}
