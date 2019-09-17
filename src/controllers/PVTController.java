/*
 * @MbalRegressionCoeffBean.java  Version 1.0 07/07/2016
 *
 * Copyright (c) 2016 VESoft Ltd
 * 1 Chima Close,Rumuodara Port-Harcourt, Rivers State Nigeria.
 * All Rights Reserved.
 */


package controllers;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import model.PVTDataModel;
import model.matBalBCalTableModel;
import model.MaterialBalInputModel;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class PVTController implements Initializable {

    /**
     * Initializes the controller class.
     */
     
   @FXML private TextField mnth_input, pr_input, bo_input, bg_input, bw_input, bt_input, gor_input, cf_input, co_input, cw_input;
   @FXML public TextField rsi_input, pb_input, pi_input, boi_input, bgi_input, bti_input;      
   @FXML private TextField txt_re, res_note;
   @FXML private RadioButton radiobtnUD, radiobtnCalc;
   @FXML private TextField angle, f, poro, ht, Total_Compr, perm, Wvisc, U, Ufinal, tD, tDfinal;
   @FXML TextField resRad, aqRad, Swc, Ceff, ao, a1, a2, a3, J, Wei, ratio, N_txt, m_txt, We_txt, netWe_txt;
    
  
   @FXML private TableView<PVTDataModel> tbl_pvt = new TableView<PVTDataModel>();
   PVTList myList = new PVTList();
   private int iNumber = 1;
   matBalBCalTableModel bParams = new matBalBCalTableModel();
   MaterialBalInputModel input = new MaterialBalInputModel();
   private DecimalFormat df;
   
   
    TableColumn iSn = new TableColumn("#");
    TableColumn iMnth = new TableColumn("Date");
    TableColumn iPr = new TableColumn("Pressure (psia)");
    TableColumn iBw = new TableColumn("Bw (rb/stb");
    TableColumn iBo = new TableColumn("Bo (rb/stb)");
    TableColumn iBg = new TableColumn("Bg (rb/stb)");
    TableColumn iBt = new TableColumn("Bt (rb/stb)");
    TableColumn iCo = new TableColumn("Co (1/psi");
    TableColumn iCf = new TableColumn("Cf (1/psi)");
    TableColumn iCw = new TableColumn("Cw (1/psi)");
    TableColumn iRs = new TableColumn("Rs (scf/rb)");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dummyInitFTable(); //table should be initialize here once
    }  
    
    public void addtoFTable(ActionEvent event) {
//        add data and update the Ttable    
        myList.add(new PVTDataModel(iNumber++ - 1,
                mnth_input.getText(),
                Double.parseDouble(pr_input.getText()),
                Double.parseDouble(bo_input.getText()),
                Double.parseDouble(bg_input.getText()),
                Double.parseDouble(bw_input.getText()),
                Double.parseDouble(bt_input.getText()),
                Double.parseDouble(co_input.getText()),
                Double.parseDouble(cf_input.getText()),
                Double.parseDouble(cw_input.getText()),
                Double.parseDouble(gor_input.getText())));

        //Record(Integer sID, String fMonth,  double fPr, double fBo, double fBw, double fCo, double fCf, double fGOR)
        clearTextFields();
    }
    private void clearTextFields() {
        mnth_input.clear();
        pr_input.clear();
        bo_input.clear();
        bg_input.clear();
        bt_input.clear();
        bw_input.clear();
        cf_input.clear();
        co_input.clear();
        gor_input.clear();
    }
    public void initializeFuidTable() {
        tbl_pvt.getItems().clear();
        for (int i = iNumber; i < 2; i++) {
            tbl_pvt.setEditable(true);
        }

    }
    
    private void setFluidTblProps() {

        // textfields, combobox and labels...
        pi_input.setPromptText(bParams.getPVTPrompts(0));
        pi_input.setMaxWidth(100);
        pi_input.setText(bParams.getPVTInitVals(0));
        pi_input.setTooltip(new Tooltip(bParams.getPVTToolTips(0)));
        pi_input.textProperty().addListener(for_Pi);

        bo_input.setPromptText(bParams.getPVTPrompts(1));
        bo_input.setMaxWidth(100);
        bo_input.setText(bParams.getPVTInitVals(1));
        bo_input.setTooltip(new Tooltip(bParams.getPVTToolTips(1)));

        bg_input.setPromptText(bParams.getPVTPrompts(11));
        bg_input.setMaxWidth(100);
        bg_input.setText(bParams.getPVTInitVals(11));
        bg_input.setTooltip(new Tooltip(bParams.getPVTToolTips(11)));

        bt_input.setPromptText(bParams.getPVTPrompts(12));
        bt_input.setMaxWidth(100);
        bt_input.setText(bParams.getPVTInitVals(12));
        bt_input.setTooltip(new Tooltip(bParams.getPVTToolTips(12)));

        bw_input.setPromptText(bParams.getPVTPrompts(2));
        bw_input.setMaxWidth(100);
        bw_input.setText(bParams.getPVTInitVals(2));
        bw_input.setTooltip(new Tooltip(bParams.getPVTToolTips(2)));

        co_input.setPromptText(bParams.getPVTPrompts(3));
        co_input.setMaxWidth(100);
        co_input.setText(bParams.getPVTInitVals(3));
        co_input.setTooltip(new Tooltip(bParams.getPVTToolTips(3)));
        co_input.textProperty().addListener(for_Co);

        cf_input.setPromptText(bParams.getPVTPrompts(4));
        cf_input.setMaxWidth(100);
        cf_input.setText(bParams.getPVTInitVals(4));
        cf_input.setTooltip(new Tooltip(bParams.getPVTToolTips(4)));
        cf_input.textProperty().addListener(for_Cf);

        cw_input.setPromptText(bParams.getPVTPrompts(5));
        cw_input.setMaxWidth(100);
        cw_input.setText(bParams.getPVTInitVals(5));
        cw_input.setTooltip(new Tooltip(bParams.getPVTToolTips(5)));
        cw_input.textProperty().addListener(for_Cw);

//        comboMetric.getSelectionModel().select(0);
        mnth_input.setPromptText(bParams.getPVTPrompts(6));
        mnth_input.setMaxWidth(100);
        mnth_input.setText(bParams.getPVTInitVals(6));
        mnth_input.setTooltip(new Tooltip(bParams.getPVTToolTips(6)));

        gor_input.setPromptText(bParams.getPVTPrompts(7));
        gor_input.setMaxWidth(100);
        gor_input.setText(bParams.getPVTInitVals(7));
        gor_input.setTooltip(new Tooltip(bParams.getPVTToolTips(7)));

        rsi_input.setPromptText(bParams.getPVTPrompts(8));
        rsi_input.setMaxWidth(100);
        rsi_input.setText(bParams.getPVTInitVals(8));
        rsi_input.setTooltip(new Tooltip(bParams.getPVTToolTips(8)));

        pr_input.setPromptText(bParams.getPVTPrompts(9));
        pr_input.setMaxWidth(100);
        pr_input.setText(bParams.getPVTInitVals(9));
        pr_input.setTooltip(new Tooltip(bParams.getPVTToolTips(9)));

        pb_input.setPromptText(bParams.getPVTPrompts(10));
        pb_input.setMaxWidth(100);
        pb_input.setText(bParams.getPVTInitVals(10));
        pb_input.setTooltip(new Tooltip(bParams.getPVTToolTips(10)));

        // boi_input.setVisible(true);
        boi_input.setPromptText("Boi (rb/stb)");
        boi_input.setText("1.58");
        boi_input.setTooltip(new Tooltip("initial oil formation volume factor, Boi"));

        bgi_input.setPromptText("Bgi scf/stb)");
        bgi_input.setText("0.00080");
        bgi_input.setTooltip(new Tooltip("initial gas formation volume factor, Bgi"));

        bti_input.setPromptText("Boi (rb/stb)");
        bti_input.setText("1.58");
        bti_input.setTooltip(new Tooltip("initial 2-phase formation volume factor, Bti"));

       // pi_lbl.setText("Pi (psia)");
        // pb_lbl.setText("Pb (psia)");
       // rsi_lbl.setText("Rsi (scf/stbo)");
       // comboItems.setPromptText("Help");
        // btn_clearTbl.setText("Clear");
    }
    
        private ChangeListener for_pi = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (newValue != null && !pi_input.toString().isEmpty()) {
                try {
                    double input_val = Double.parseDouble(newValue);
                    double pb_val = Double.parseDouble(pb_input.getText());

                    if (input_val == pb_val) {
                        res_note.setText("Saturated Reservoir");
                        System.out.println("Saturated Reservoir");
                    } else if (input_val > pb_val) {
                        res_note.setText("Undersaturated Reservoir");
                        System.out.println("Undersaturated Reservoir");
                    }
                    // ratio.setText(String.valueOf(df.format(re_ratio_val)));
                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }
        }
    };
    private ChangeListener for_pb = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (newValue != null && !pb_input.toString().isEmpty()) {
                try {
                    double old_val = Double.parseDouble(oldValue);
                    double new_val = Double.parseDouble(newValue);
                    double pi_val = Double.parseDouble(pi_input.getText());

                    if (new_val == pi_val) {
                        res_note.setText("Saturated Reservoir");
                        //res_note.setBorder(Border.);
                        System.out.println("Saturated Reservoir");

                    } else if (new_val < pi_val) {
                        res_note.setText("Undersaturated Reservoir");
                        System.out.println("Undersaturated Reservoir");
                    }
                    // ratio.setText(String.valueOf(df.format(re_ratio_val)));
                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }
        }
    };
    //Ceff
    private ChangeListener for_Co = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue observable, String oldValue, String newValue) {

            if (newValue != null && !co_input.toString().isEmpty()) {
                try {
                    double input_val = Double.parseDouble(newValue);
                    double Swc_val = Double.parseDouble(Swc.getText());
                    double Cw_val = Double.parseDouble(cw_input.getText());
                    double Cf_val = Double.parseDouble(cf_input.getText());

                    double Co_val = ((input_val * (1 - Swc_val)) + (Cw_val * Swc_val) + (Cf_val)) / (1 - Swc_val);

                    System.out.println(newValue + "\t" + Co_val);

                    Ceff.setText(String.valueOf(df.format(Co_val)));
                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }
        }

    };

    private ChangeListener for_Cf = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue observable, String oldValue, String newValue) {

            if (newValue != null && !cf_input.toString().isEmpty()) {
                try {
                    double input_val = Double.parseDouble(newValue);

                    double Swc_val = Double.parseDouble(Swc.getText());
                    double Cw_val = Double.parseDouble(cw_input.getText());
                    double Co_val = Double.parseDouble(co_input.getText());

                    double newCf_val = ((Co_val * (1 - Swc_val)) + (Cw_val * Swc_val) + (input_val)) / (1 - Swc_val);
                    double newCf_val2 = input_val + Cw_val;
                    System.out.println(newValue + "\t" + newCf_val + "\t" + newCf_val2);

                    Ceff.setText(String.valueOf(df.format(newCf_val)));
                    Total_Compr.setText(String.valueOf(df.format(newCf_val2)));
                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }

        }

    };

    private ChangeListener for_Cw = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue observable, String oldValue, String newValue) {

            if (newValue != null && !cw_input.toString().isEmpty()) {
                try {
                    double input_val = Double.parseDouble(newValue);
                    double Swc_val = Double.parseDouble(Swc.getText());
                    double Cf_val = Double.parseDouble(cf_input.getText());
                    double Co_val = Double.parseDouble(co_input.getText());

                    double newCw_val = ((Co_val * (1 - Swc_val)) + (input_val * Swc_val) + (Cf_val)) / (1 - Swc_val);
                    double newCw_val2 = Cf_val + input_val;

                    System.out.println(newValue + "\t" + newCw_val + "\t" + newCw_val2);

                    Ceff.setText(String.valueOf(df.format(newCw_val)));
                    Total_Compr.setText(String.valueOf(df.format(newCw_val2)));
                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }

            //  this.dCeff = ( (this.dCo*(1-this.dSwc))+(this.dCw*this.dSwc)+(this.dCf))/(1-this.dSwc);
        }
    };
    private ChangeListener for_Swc = new ChangeListener<String>() {

        @Override
        public void changed(ObservableValue observable, String oldValue, String newValue) {

            if (newValue != null && !Swc.toString().isEmpty()) {
                try {
                    double input_val = Double.parseDouble(newValue);

                    double Swc_val = Double.parseDouble(Swc.getText());
                    double Cw_val = Double.parseDouble(cw_input.getText());
                    double Cf_val = Double.parseDouble(cf_input.getText());
                    double Co_val = Double.parseDouble(co_input.getText());

                    double Sw_val = ((Co_val * (1 - Swc_val)) + (Cw_val * Swc_val) + (Cf_val)) / (1 - Swc_val);

//                    double Sw_val = ((input.getDCo()*(1 - input_val))+
//                                                  (input.getDCw()*input_val)+
//                                            (input.getDCf()))/(1 - input_val);
                    System.out.println(newValue + "\t" + Sw_val);

                    Ceff.setText(String.valueOf(df.format(Sw_val)));
                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }

        }

    };
    private ChangeListener for_K = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue observable, String oldValue, String newValue) {

            if (newValue != null && !perm.toString().isEmpty()) {
                try {
                    double input_val = Double.parseDouble(newValue);
                    double Re_val = Double.parseDouble(aqRad.getText());
                    double Ro_val = Double.parseDouble(resRad.getText());
                    double H_val = Double.parseDouble(ht.getText());
                    double angle_val = Double.parseDouble(angle.getText());
                    double Wvisc_val = Double.parseDouble(Wvisc.getText());

                    double K_val = (0.00708 * input_val * H_val * (angle_val / 360)) / (Wvisc_val * ((Math.log(Re_val / Ro_val)) - 0.75));

                    System.out.println(input_val + "\t" + angle_val + "\t" + Re_val + "\t" + Ro_val + "\t" + K_val + "\t" + H_val + "\t" + Wvisc_val);

                    J.setText(String.valueOf(df.format(K_val)));
                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }

//J = 0.0078 * this.dK * this.dH * this.dPhi/(360*this.dMu*(Math.log(dRe/dRo))) ;
        }

    };
    private ChangeListener for_H = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue observable, String oldValue, String newValue) {

            if (newValue != null && !ht.toString().isEmpty()) {
                try {
                    double input_val = Double.parseDouble(newValue);
                    double Re_val = Double.parseDouble(aqRad.getText());
                    double Ro_val = Double.parseDouble(resRad.getText());
                    double K_val = Double.parseDouble(perm.getText());
                    double angle_val = Double.parseDouble(angle.getText());
                    double Wvisc_val = Double.parseDouble(Wvisc.getText());
                    double poro_val = Double.parseDouble(poro.getText());
                    double pi_val = Double.parseDouble(pi_input.getText());
                    double Ct_val = Double.parseDouble(Total_Compr.getText());

                    double J_val = (0.00708 * K_val * input_val * (angle_val / 360)) / (Wvisc_val * ((Math.log(Re_val / Ro_val)) - 0.75));
                    double Wei_val = (Ct_val * Math.PI * ((Re_val * Re_val) - (Ro_val * Ro_val)) * input_val * poro_val * pi_val * (angle_val / 360)) / 5.615;

                    System.out.println(input_val + "\t" + J_val + "\t" + Wei_val + "\t" + Re_val + "\t" + Ct_val
                            + "\t" + Ro_val + "\t" + K_val + "\t" + "\t" + Wvisc_val + "\t" + poro_val + "\t" + pi_val);
                    System.out.println("==================");
//                     System.out.println(Math.log(Re_val/Ro_val)+"\t" + Re_val + "\t" + Ro_val +"\t" + "\t" + (0.00708 * K_val * input_val * (angle_val/360))+
//                           "\t" +  Wvisc_val*(Math.log(Re_val/Ro_val)-0.75) +"\t" + (Wvisc_val*((Math.log(Re_val/Ro_val))-0.75)));

                    J.setText(String.valueOf(df.format(J_val)));
                    Wei.setText(String.valueOf(df.format(Wei_val)));
                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }

//J = 0.0078 * this.dK * this.dH * this.dPhi/(360*this.dMu*(Math.log(dRe/dRo))) ;
        }

    };
    private ChangeListener for_angle = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue observable, String oldValue, String newValue) {

            if (newValue != null && !angle.toString().isEmpty()) {
                try {
                    double Re_val = Double.parseDouble(aqRad.getText());
                    double Ro_val = Double.parseDouble(resRad.getText());
                    double K_val = Double.parseDouble(perm.getText());
                    double H_val = Double.parseDouble(ht.getText());
                    double Wvisc_val = Double.parseDouble(Wvisc.getText());
                    double poro_val = Double.parseDouble(poro.getText());
                    double pi_val = Double.parseDouble(pi_input.getText());
                    double Ct_val = Double.parseDouble(Total_Compr.getText());

                    double input_val = Double.parseDouble(newValue);
                    double J_val = (0.00708 * K_val * H_val * (input_val / 360)) / (Wvisc_val * ((Math.log(Re_val / Ro_val)) - 0.75));
                    double Wei_val = (Ct_val * Math.PI * ((Re_val * Re_val) - (Ro_val * Ro_val)) * H_val * poro_val * pi_val * (input_val / 360)) / 5.615;

                    System.out.println(input_val + "\t" + J_val + "\t" + Wei_val + "\t" + Re_val + "\t" + Ct_val
                            + "\t" + Ro_val + "\t" + K_val + "\t" + H_val + "\t" + Wvisc_val + "\t" + poro_val + "\t" + pi_val);

                    J.setText(String.valueOf(df.format(J_val)));
                    Wei.setText(String.valueOf(df.format(Wei_val)));
                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }
//             this.Wi = 3.14 * ((dRe * dRe) - (dRo * dRo)) * dH * dPhi / 5.615;
//             this.Wei = dCf * this.Wi * this.dPi * this.dPhi / 360;
//             this.Wei = Double.parseDouble(formatter.format(Wei));
//J = 0.0078 * this.dK * this.dH * this.dPhi/(360*this.dMu*(Math.log(dRe/dRo))) ;
// J = 0.0078 * input.getDK() * input.getDH() * input.getDPhi()/(360*input.getDMu()*(Math.log(input.getDRe()/input.getDRo())));

        }

    };
    private ChangeListener for_WVisc = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue observable, String oldValue, String newValue) {

            if (newValue != null && !Wvisc.toString().isEmpty()) {
                try {
                    double Re_val = Double.parseDouble(aqRad.getText());
                    double Ro_val = Double.parseDouble(resRad.getText());
                    double K_val = Double.parseDouble(perm.getText());
                    double H_val = Double.parseDouble(ht.getText());
                    double angle_val = Double.parseDouble(angle.getText());

                    double input_val = Double.parseDouble(newValue);
                    double Wvisc_val = (0.00708 * K_val * H_val * (angle_val / 360)) / (input_val * ((Math.log(Re_val / Ro_val)) - 0.75));

                    System.out.println(input_val + "\t" + angle_val + "\t" + Re_val + "\t" + Ro_val + "\t" + K_val + "\t" + H_val + "\t" + Wvisc_val);

                    J.setText(String.valueOf(df.format(Wvisc_val)));
                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }

//J = 0.0078 * this.dK * this.dH * this.dPhi/(360*this.dMu*(Math.log(dRe/dRo))) ;
// J = 0.0078 * input.getDK() * input.getDH() * input.getDPhi()/(360*input.getDMu()*(Math.log(input.getDRe()/input.getDRo())));
        }

    };
    private ChangeListener for_Re = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue observable, String oldValue, String newValue) {

            if (newValue != null && !aqRad.toString().isEmpty()) {
                try {
                    double Ro_val = Double.parseDouble(resRad.getText());
                    double Re_val = Double.parseDouble(aqRad.getText());
                    double K_val = Double.parseDouble(perm.getText());
                    double H_val = Double.parseDouble(ht.getText());
                    double angle_val = Double.parseDouble(angle.getText());
                    double Wvisc_val = Double.parseDouble(Wvisc.getText());
                    double poro_val = Double.parseDouble(poro.getText());
                    double pi_val = Double.parseDouble(pi_input.getText());
                    double Ct_val = Double.parseDouble(Total_Compr.getText());

                    double input_val = Double.parseDouble(newValue);
                    double J_val = (0.00708 * K_val * H_val * (angle_val / 360)) / (Wvisc_val * ((Math.log(input_val / Ro_val)) - 0.75));
                    double re_ratio_val = input_val / Ro_val;
                    double Wei_val = (Ct_val * Math.PI * ((input_val * input_val) - (Ro_val * Ro_val)) * H_val * poro_val * pi_val * (angle_val / 360)) / 5.615;

                    System.out.println(input_val + "\t" + J_val + "\t" + Wei_val + "\t" + Re_val + "\t" + Ct_val
                            + "\t" + Ro_val + "\t" + K_val + "\t" + H_val + "\t" + Wvisc_val + "\t" + poro_val + "\t" + pi_val);

                    J.setText(String.valueOf(df.format(J_val)));
                    Wei.setText(String.valueOf(df.format(Wei_val)));
                    ratio.setText(String.valueOf(df.format(re_ratio_val)));
                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }

        }

    };
    private ChangeListener for_Ro = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue observable, String oldValue, String newValue) {

            if (newValue != null && !resRad.toString().isEmpty()) {
                try {
                    double input_val = Double.parseDouble(newValue);
                    double Ro_val = Double.parseDouble(resRad.getText());
                    double Re_val = Double.parseDouble(aqRad.getText());
                    double K_val = Double.parseDouble(perm.getText());
                    double H_val = Double.parseDouble(ht.getText());
                    double angle_val = Double.parseDouble(angle.getText());
                    double Wvisc_val = Double.parseDouble(Wvisc.getText());
                    double poro_val = Double.parseDouble(poro.getText());
                    double pi_val = Double.parseDouble(pi_input.getText());
                    double Ct_val = Double.parseDouble(Total_Compr.getText());

                    double J_val = (0.00708 * K_val * H_val * (angle_val / 360)) / (Wvisc_val * ((Math.log(Re_val / input_val)) - 0.75));
                    double ro_ratio_val = Re_val / input_val;

                    double Wei_val = (Ct_val * Math.PI * ((Re_val * Re_val) - (input_val * input_val)) * H_val * poro_val * pi_val * (angle_val / 360)) / 5.615;

                    System.out.println(input_val + "\t" + J_val + "\t" + Wei_val + "\t" + Re_val + "\t" + Ct_val
                            + "\t" + Ro_val + "\t" + K_val + "\t" + H_val + "\t" + Wvisc_val + "\t" + poro_val + "\t" + pi_val);

                    J.setText(String.valueOf(df.format(J_val)));
                    Wei.setText(String.valueOf(df.format(Wei_val)));
                    ratio.setText(String.valueOf(df.format(ro_ratio_val)));

                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }
        }

    };
    private ChangeListener for_Pi = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue observable, String oldValue, String newValue) {

            if (newValue != null && !pi_input.toString().isEmpty()) {
                try {
                    double input_val = Double.parseDouble(newValue);
                    double Ro_val = Double.parseDouble(resRad.getText());
                    double Re_val = Double.parseDouble(aqRad.getText());
                    double K_val = Double.parseDouble(perm.getText());
                    double H_val = Double.parseDouble(ht.getText());
                    double angle_val = Double.parseDouble(angle.getText());
                    double Wvisc_val = Double.parseDouble(Wvisc.getText());
                    double poro_val = Double.parseDouble(poro.getText());
                    double pi_val = Double.parseDouble(pi_input.getText());
                    double Ct_val = Double.parseDouble(Total_Compr.getText());

                    double Wei_val = (Ct_val * Math.PI * ((Re_val * Re_val) - (Ro_val * Ro_val)) * H_val * poro_val * input_val * (angle_val / 360)) / 5.615;

                    System.out.println(input_val + "\t" + "\t" + Wei_val + "\t" + Re_val + "\t" + Ct_val
                            + "\t" + Ro_val + "\t" + K_val + "\t" + H_val + "\t" + Wvisc_val + "\t" + poro_val + "\t" + pi_val);

                    Wei.setText(String.valueOf(df.format(Wei_val)));

                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }
        }

    };
    private ChangeListener for_poro = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue observable, String oldValue, String newValue) {

            if (newValue != null && !poro.toString().isEmpty()) {
                try {
                    double input_val = Double.parseDouble(newValue);
                    double Ro_val = Double.parseDouble(resRad.getText());
                    double Re_val = Double.parseDouble(aqRad.getText());
                    double K_val = Double.parseDouble(perm.getText());
                    double H_val = Double.parseDouble(ht.getText());
                    double angle_val = Double.parseDouble(angle.getText());
                    double Wvisc_val = Double.parseDouble(Wvisc.getText());
                    double poro_val = Double.parseDouble(poro.getText());
                    double pi_val = Double.parseDouble(pi_input.getText());
                    double Ct_val = Double.parseDouble(Total_Compr.getText());

                    double Wei_val = (Ct_val * Math.PI * ((Re_val * Re_val) - (Ro_val * Ro_val)) * H_val * input_val * pi_val * (angle_val / 360)) / 5.615;

                    System.out.println(input_val + "\t" + "\t" + Wei_val + "\t" + Re_val + "\t" + Ct_val
                            + "\t" + Ro_val + "\t" + K_val + "\t" + H_val + "\t" + Wvisc_val + "\t" + poro_val + "\t" + pi_val);

                    Wei.setText(String.valueOf(df.format(Wei_val)));

                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }
        }

    };
    private ChangeListener for_Ct = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue observable, String oldValue, String newValue) {

            if (newValue != null && !Total_Compr.toString().isEmpty()) {
                try {
                    double input_val = Double.parseDouble(newValue);
                    double Ro_val = Double.parseDouble(resRad.getText());
                    double Re_val = Double.parseDouble(aqRad.getText());
                    double K_val = Double.parseDouble(perm.getText());
                    double H_val = Double.parseDouble(ht.getText());
                    double angle_val = Double.parseDouble(angle.getText());
                    double Wvisc_val = Double.parseDouble(Wvisc.getText());
                    double poro_val = Double.parseDouble(poro.getText());
                    double pi_val = Double.parseDouble(pi_input.getText());
                    double Ct_val = Double.parseDouble(Total_Compr.getText());

                    double Wei_val = (input_val * Math.PI * ((Re_val * Re_val) - (Ro_val * Ro_val)) * H_val * poro_val * pi_val * (angle_val / 360)) / 5.615;

                    System.out.println(input_val + "\t" + "\t" + Wei_val + "\t" + Re_val + "\t" + Ct_val
                            + "\t" + Ro_val + "\t" + K_val + "\t" + H_val + "\t" + Wvisc_val + "\t" + poro_val + "\t" + pi_val);

                    Wei.setText(String.valueOf(df.format(Wei_val)));

                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }
        }

    };
    private ChangeListener for_Ro_Ratio = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (newValue != null && !resRad.toString().isEmpty()) {
                try {
                    double input_val = Double.parseDouble(newValue);
                    double ro_ratio_val = input.getDRe() / input_val;

                    System.out.println(newValue + "\t" + ro_ratio_val);

                    ratio.setText(String.valueOf(df.format(ro_ratio_val)));
                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }
        }
    };
    private ChangeListener for_Re_Ratio = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (newValue != null && !aqRad.toString().isEmpty()) {
                try {
                    double input_val = Double.parseDouble(newValue);
                    double re_ratio_val = input_val / input.getDRo();

                    System.out.println(newValue + "\t" + re_ratio_val);

                    ratio.setText(String.valueOf(df.format(re_ratio_val)));
                } catch (NumberFormatException nfe) {
                    System.out.println("empty value");
                }

            }
        }
    };
    
    public void dummyInitFTable() {
        
        myList.add(new PVTDataModel(0, "12/5/2018", 3000.0, 1.58, 0.00080, 1.0, 1.580, 0.0, 0.000001, 0.0000015, 1040));
        myList.add(new PVTDataModel(1, "02/6/2018", 2800.0, 1.48, 0.00092, 1.0, 1.655, 0.0, 0.000001, 0.0000015, 850));

        tbl_pvt.setEditable(true);
        tbl_pvt.setItems(myList.dataList);
        tbl_pvt.getColumns().addAll(iSn, iMnth, iPr, iBo, iBg, iBw, iBt, iCo, iCf, iCw, iRs);
        tbl_pvt.getSelectionModel().setCellSelectionEnabled(true);
        tbl_pvt.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
       // System.out.println("dummInitFTable method called");
   
}


}

class PVTList {

    ObservableList<PVTDataModel> dataList;
    ObservableList<XYChart.Data> xyList1;
    ObservableList<XYChart.Data> xyList2;

    PVTList() {
        dataList = FXCollections.observableArrayList();
        xyList1 = FXCollections.observableArrayList();
        xyList2 = FXCollections.observableArrayList();
    }

    public void add(PVTDataModel r) {
        dataList.add(r);

        xyList1.add(new XYChart.Data(r.getFieldMonth(), r.getFieldValueBo()));
        xyList2.add(new XYChart.Data(r.getFieldMonth(), r.getFieldValueBo()));

    }

    public void update1(int pos, Number val) {
        // xyList1.clear();
        // xyList1.setAll(new XYChart.Data(xyList1.get(pos).getXValue(), val));
        xyList1.set(pos, new XYChart.Data(xyList1.get(pos).getXValue(), val));
        System.out.println("val:" + val);
    }

    public void update2(int pos, Number val) {
        //xyList2.clear();
        // xyList2.setAll(new XYChart.Data(xyList1.get(pos).getXValue(), val));
        xyList2.set(pos, new XYChart.Data(xyList2.get(pos).getXValue(), val));
    }
}

