/*
 * @MbalRegressionCoeffBean.java  Version 1.0 07/07/2016
 *
 * Copyright (c) 2016 VESoft Ltd
 * 1 Chima Close,Rumuodara Port-Harcourt, Rivers State Nigeria.
 * All Rights Reserved.
 */

package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import model.PVTDataModel;

/**
 *
 * @author DELL
 */
public class ResponsiveController implements Initializable {


    @FXML
    private Button btn_home, btn_pvt, btn_tank, btn_charts;

    @FXML
    private Pane pn_home, pn_pvt, pn_tank, pn_charts;

    @FXML
    private SplitPane spane_tank;

    @FXML
    private TableView table_tank;

    @FXML
    private AnchorPane anchor1, anchor2;

    @FXML
    private SplitPane sPanelTank, sPanelPVT;

    @FXML
    private TabPane tPanePVT, tPaneTank;
    
        // Inject tab contents for PVT tabs
    @FXML private Tab tabCorrelations; //from rootView.fxml: <Tab fx:id="tabCorrelations">
    @FXML private Tab tabFluidProps; //from rootView.fxml: <Tab fx:id="tabFluidProps">
  
    @FXML private Tab tabAcquiferProps; //from rootView.fxml: <Tab fx:id="tabAcquiferProps">
    @FXML private Tab tabTankProps; //from rootView.fxml: <Tab fx:id="tabTankProps">
    
          // Inject tab controllers
    @FXML private PVTController tab1FluidPropsController;//rootView.fxml_include_fx:id="tab1FluidProps" + "Controller"
    @FXML private PVTController tab2CorrelationsController;//rootView.fxml_include_fx:id="tab2Correlations" + "Controller"
    
    @FXML private TankController tab1TankPropsController;//rootView.fxml_include_fx:id="tab1TankProps" + "Controller"
    @FXML private TankController tab2AcquiferPropsController;//rootView.fxml_include_fx:id="tab2AcquiferProps" + "Controller"

    @FXML
    private TextField mnth_input, pr_input, bo_input, bg_input, bw_input, bt_input, gor_input, cf_input, co_input, cw_input;
    @FXML private TableView<PVTDataModel> tbl_pvt = new TableView<PVTDataModel>();

    
    
    //When Fluid Props Tab is Clicked...
    public void PVTMenuBtnHandler() throws Exception {

        tPanePVT.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) -> {
                    if (newValue == tabFluidProps) {
                        System.out.println("Fluid Properties Tab Selected");
                        //do sth here using the PVTController
                    } else if (newValue == tabCorrelations) {
                        System.out.println("Correlations Tab Selected");
                        //do sth her using the PVTController

                    }
                });

    }
    
    public void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btn_tank) {
            tPanePVT.toBack();
            pn_home.toBack();
            tPaneTank.toFront();
            System.out.println("Tank Selected");
        }
        if (event.getSource() == btn_pvt) {
            tPaneTank.toBack();
            pn_home.toBack();
            tPanePVT.toFront();
            System.out.println("PVT Selected");
        }
        if (event.getSource() == btn_home) {
            pn_home.toFront();
            System.out.println("Home Selected");
            
        }
    }
     @Override
    public void initialize(URL url, ResourceBundle rb) {
       // dummyInitFTable();
    }

}
