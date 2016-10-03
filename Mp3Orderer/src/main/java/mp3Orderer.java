import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.Mp3File;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Admin on 27.09.2016.
 */

public class mp3Orderer
{
        public static void main(String[] args) throws IOException
        {
            Scanner scanner = new Scanner(System.in);
            String tempPath = "";

            while (true)
            {
                // get path
                System.out.println("-------> Enter file path (including .mp3) to continue, or 'exit' to close program");
                String input = scanner.next();

                // EXIT
                if (input.toUpperCase().equals("EXIT"))
                {
                    System.out.println("Program is closed by user. Goodbye!");
                    return;
                }

                String path = tempPath+input;

                try
                {
                    Mp3File mp3file = new Mp3File(path);
                    if (mp3file.hasId3v1Tag())
                    {
                        // get info
                        ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                        String artist = id3v1Tag.getArtist();
                        String title = id3v1Tag.getTitle();

                        // create new name
                        String replacedArtist = artist.replace(" ", "_");
                        String replacedTitle = title.replace(" ", "_");
                        String newName = replacedArtist + "-" + replacedTitle;

                        // rename
                        File file = new File(path);
                        File newFile = new File("D:\\" + newName + ".mp3");
                        if (file.renameTo(newFile))
                        {
                            System.out.println("Renamed successfully to: " + newName);
                            return;
                        }
                    }

                    else
                    {
                        System.out.println("Can't extract necessary data from file!");
                        return;
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                Lister lister = new Lister(path);
                lister.print();

                // add this path to previous, for example: D:// + /user + /music + /mySong.mp3
                tempPath += path;
            }
        }

    static class Lister
    {
        public File path;
        public File[] files;

        public Lister(String pathname) throws IOException
        {
            path = new File(pathname);
            if (!path.exists()) {
                throw new IOException("Cannot access " + pathname + ": No such file or directory");
            }
            if (path.isFile()) {
                files = new File[]{path};
            } else {
                files = path.listFiles();
                Arrays.sort(files, new FilesComparator());
            }
        }

        public  void print()
        {
            for (File f: files)
            {
                System.out.println(f.getName() + ((f.isDirectory()) ? File.separator : ""));
            }
        }

        public class FilesComparator implements Comparator<File>
        {
            public int compare(File f1, File f2) {
                if (f1.isDirectory() && f2.isFile()) {
                    return -1;
                }
                if (f1.isFile() && f2.isDirectory()) {
                    return 1;
                }
                return f1.compareTo(f2);
            }
        }
    }
}