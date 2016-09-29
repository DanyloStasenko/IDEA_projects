package sample;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.Mp3File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.List;

public class Controller
{
/*
    @FXML
    private Button btn1;
*/

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private ListView listView;
    private List<File> pathes;

    /*

    public void Button1Action (ActionEvent event)
    {
        FileChooser fc = new FileChooser();
       fc.getExtensionFilters().addAll(
       new FileChooser.ExtensionFilter("MP3 files", "*.mp3"));
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null)
        {
            listView.getItems().add(selectedFile.getName());

        }
        else
        {
            System.out.println("File not valid");
        }

    }

    */

    public void Button2Action (ActionEvent event)
    {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("MP3 files", "*.mp3"));
        List<File> selectedFiles = fc.showOpenMultipleDialog(null);
        pathes = selectedFiles.subList(0, selectedFiles.size());

        if (selectedFiles != null)
        {
            for (int i = 0; i < selectedFiles.size() ; i++)
            {
                listView.getItems().add(selectedFiles.get(i).getName());
            }
        }

        else
        {
            System.out.println("File not valid");
        }
    }

    public void Button3Action (ActionEvent event)
    {
        for (int i = 0; i < pathes.size() ; i++)
        {
            try
            {
                Mp3File mp3file = new Mp3File(pathes.get(i));
                if (mp3file.hasId3v1Tag())
                {
                    ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                    String artist = id3v1Tag.getArtist();
                    String title = id3v1Tag.getTitle();

                    String replacedArtist = artist.replace(" ","_");
                    String replacedTitle = title.replace(" ","_");
                    String newName = replacedArtist+"-"+replacedTitle;

                   //System.out.println(newName);
                   // System.out.println( pathes.get(i).getAbsolutePath());
                   // System.out.println( pathes.get(i).getPath());
                   // System.out.println( pathes.get(i).getParent()+"\\"+newName+".mp3");

                    File oldFile = new File(pathes.get(i).getAbsolutePath());
                    File newFile = new File(pathes.get(i).getParent()+"\\"+newName+".mp3");
                    boolean success = oldFile.renameTo(newFile);
                    System.out.println(success);
                    System.out.println(newName);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        pathes.clear();

    }
}
