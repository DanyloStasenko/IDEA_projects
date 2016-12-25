package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    private int arraySize = 0;

    @FXML
    private ListView idList;

    @FXML
    private ListView dataList;

    @FXML
    private TextField textFieldAdd;

    @FXML
    private TextField textFieldDeleteById;

    @FXML
    private Text textWarning;

    @FXML
    private Text textTotal;

    public void addValue(ActionEvent event) {
        if (!textFieldAdd.getText().isEmpty()) {
            arraySize++;

            dataList.getItems().add(Integer.parseInt(textFieldAdd.getText()));
            idList.getItems().add(arraySize - 1);

            textTotal.setText("Total: " + arraySize + " Elements");
        }
    }

    public void Delete (ActionEvent event) {
        if (Integer.parseInt(textFieldDeleteById.getText()) < arraySize){
            arraySize--;

            dataList.getItems().remove(Integer.parseInt(textFieldDeleteById.getText()));
            idList.getItems().remove(Integer.parseInt(textFieldDeleteById.getText()));

            idList.getItems().clear();
            for (int i = 0; i < arraySize; i++) {
                idList.getItems().add(i);
            }

            textWarning.setVisible(false);
            textTotal.setText("Total: " + arraySize + " Elements");
        }
        else{
            textWarning.setVisible(true);
        }
    }

    // Function for: HyperlinkClicked - open my Github profile using default browser
    public void hyperlinkClicked(ActionEvent event)
    {
        Main m = new Main();
        m.openBrowser();
    }
}
