package sample;
import javafx.fxml.FXML;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.Mp3File;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.List;

/*
Program is not working with cyrillic  files --> FIX THIS BUG
If (oldFileName = newFileName) - don't increment filesRenamed --> FIX THIS BUG
*/

public class Controller
{

    @FXML
    private ListView listView;

    @FXML
    private Text txtSelected; // selected OK

    @FXML
    private Text txtProcessInfo; // process info

    @FXML
    private Text txtProcessed; // processed

    @FXML
    private Text txtSuccessfull; // success

    @FXML
    private Text txtCantRename; // unsuccess

    @FXML
    private Text txtErrors; // current process


    private List<File> pathes;
    private List<File> selectedFiles;
    private int filesProcessedCount = 0;
    private int filesSuccessCount = 0;
    private int filesUnsuccessCount = 0;

    // "Select Files" Button function
    public void SelectFiles (ActionEvent event)
    {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("MP3 files", "*.mp3"));
        selectedFiles = fc.showOpenMultipleDialog(null);
        pathes = selectedFiles.subList(0, selectedFiles.size());

        if (selectedFiles != null)
        {
            for (int i = 0; i < selectedFiles.size() ; i++)
            {
                listView.getItems().add(selectedFiles.get(i).getName());
            }
            txtSelected.setText(pathes.size()+" files selected");
        }

        else
        {
            System.out.println("File not valid");
        }
    }

    // "Rename Selected" Button function
    public void RenameSelected (ActionEvent event)
    {
        if (!selectedFiles.isEmpty())
        {
            for (int i = 0; i < pathes.size() ; i++)
            {
                try
                {
                    Mp3File mp3file = new Mp3File(pathes.get(i));
                    filesProcessedCount++;
                    if (mp3file.hasId3v1Tag())
                    {
                        // get data from mp3 tags
                        ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                        String artist = id3v1Tag.getArtist();
                        String title = id3v1Tag.getTitle();

                        // create new name
                        String replacedArtist = artist.replace(" ", "_");
                        String replacedTitle = title.replace(" ", "_");
                        String newName = replacedArtist + "-" + replacedTitle;

                        // rename
                        File oldFile = new File(pathes.get(i).getAbsolutePath());
                        File newFile = new File(pathes.get(i).getParent() + "\\" + newName + ".mp3");
                        boolean success = oldFile.renameTo(newFile);

                        if (success)
                        {
                            filesSuccessCount++;
                        }

                        else
                        {
                            filesUnsuccessCount++;
                        }
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                txtProcessInfo.setText("Process Info:");
                txtProcessed.setText(filesProcessedCount+" Files Processed");
                txtSuccessfull.setText(filesSuccessCount+" Files Renamed");
                txtCantRename.setText(filesProcessedCount-filesSuccessCount+" Files Not Renamed");
                txtErrors.setText(filesUnsuccessCount+" Errors");
            }
        }
    }
}


