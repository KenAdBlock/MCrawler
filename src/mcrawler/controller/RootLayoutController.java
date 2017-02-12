package mcrawler.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import mcrawler.MainApp;

/**
 * Created by jonathan on 08/02/17.
 */
public class RootLayoutController {

    private MainApp mainApp;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private Pane panel;


    private HamburgerBasicCloseTransition burgerTask2;


    /* LINKS */

    @FXML
    private JFXButton linkPages;

    @FXML
    private JFXButton linkNewPage;



    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;


        // Init burger menu
        //BackArrow
        burgerTask2 = new HamburgerBasicCloseTransition(hamburger);
        burgerTask2.setRate(-1);


        // hide panel on launch
        panel.setMaxWidth(0);
    }



    public void hidePanel() {
        panel.setMaxWidth(0);
    }



    @FXML
    public void hamburgerClick() {
        //System.out.println("hamburger click");

        burgerTask2.setRate(burgerTask2.getRate() * -1);
        burgerTask2.play();

        // show/hide panel
        if(burgerTask2.getRate() < 0) {
            hidePanel();
        } else {
            panel.setMaxWidth(200);
        }

    }


    @FXML
    public void linkPagesClick() {
        System.out.println("Pages click");
        hamburgerClick();
        mainApp.showPages();
    }

    @FXML
    public void linkNewPageClick() {
        System.out.println("New page click");
        hamburgerClick();
        mainApp.showNewPage();
    }


    @FXML
    private void handleExit() {
        System.exit(0);
    }



}