package Main;

/*
 * @MbalRegressionCoeffBean.java  Version 1.0 07/07/2016
 *
 * Copyright (c) 2016 VESoft Ltd
 * 1 Chima Close,Rumuodara Port-Harcourt, Rivers State Nigeria.
 * All Rights Reserved.
 */


import controllers.ResponsiveController;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author Okpo Ekpenyong
 */
public class MainApp extends Application {
    
    private Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new StackPane());
      //  Parent root = FXMLLoader.load(getClass().getResource("/view/view1.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/rootView.fxml"));
        scene.setRoot(loader.load());
       
        //openLogin();
        //create an instance of the ResponsiveController and use it to call the Tab methods
        ResponsiveController controller = loader.getController();
        controller.PVTMenuBtnHandler();
        
       // Scene scene = new Scene(root);
       // scene.getStylesheets().addAll(this.getClass().getResource("/Resources/style.css").toExternalForm());
        stage.setTitle("LaserMBAL ");
        stage.setMinHeight(450);
        stage.setMinWidth(350);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(MainApp.class, (String[]) null);
    }
    

    
}
