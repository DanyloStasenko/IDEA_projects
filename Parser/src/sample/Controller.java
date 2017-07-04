package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Controller
{
    @FXML
    private WebView webView;


    WebEngine engine = webView.getEngine();


    @FXML
    private Button btnGo;

    void btnGoClicked(ActionEvent e)
    {
        System.out.println("Go!");
        webView.getEngine();
    }

}
