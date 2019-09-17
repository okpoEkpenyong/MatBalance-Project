/*
 * @MbalRegressionCoeffBean.java  Version 1.0 07/07/2016
 *
 * Copyright (c) 2016 VESoft Ltd
 * 1 Chima Close,Rumuodara Port-Harcourt, Rivers State Nigeria.
 * All Rights Reserved.
 */
package model;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;


/**
 *
 * @author Okpo Ekpenyong
 */
public class TankDataModel {

    private ArrayList list;
    protected final SimpleIntegerProperty rID;
    protected final SimpleStringProperty fieldDate;
    protected final SimpleDoubleProperty fieldPressure;
    protected final SimpleDoubleProperty fieldWp;
    protected final SimpleDoubleProperty cumOil;
    protected final SimpleDoubleProperty cumGas;
    protected final SimpleDoubleProperty ratio;
    
    private final SimpleStringProperty fieldMonth;
    private final SimpleDoubleProperty fieldBo;
    protected final SimpleDoubleProperty fieldBg;
    private final SimpleDoubleProperty fieldBw;
    protected final SimpleDoubleProperty fieldBt;
    private final SimpleDoubleProperty fieldCo;
    protected final SimpleDoubleProperty fieldCf;
    private final SimpleDoubleProperty fieldCw;
    private final SimpleDoubleProperty fieldGOR;
    
    private final SimpleDoubleProperty field_m = new SimpleDoubleProperty(0);
    private final SimpleDoubleProperty field_N = new SimpleDoubleProperty(10000000);
    private final SimpleDoubleProperty field_rsi = new SimpleDoubleProperty(1040);
    private final SimpleDoubleProperty field_Pi = new SimpleDoubleProperty(3000);
    private final SimpleDoubleProperty field_Bti = new SimpleDoubleProperty(1.58);
    private final SimpleDoubleProperty field_Boi = new SimpleDoubleProperty(1.58);
    private final SimpleDoubleProperty field_Bgi = new SimpleDoubleProperty(0.0008);
    private final SimpleDoubleProperty field_We = new SimpleDoubleProperty(0.0);
    

    private DecimalFormat df;

    private SimpleIntegerProperty iTime;
    /**
     * Np (stb)
     */
    private SimpleDoubleProperty dNp;
    /**
     * Wp(stb)
     */
    private SimpleDoubleProperty dWp;
    /**
     * P(psi)
     */
    private SimpleDoubleProperty dP;
    /**
     * Bo = Boi*Ceff*delP (rb/stb)
     */
    private SimpleDoubleProperty dBo;
    /**
     * Fluid Expansion E = Boi*Ceff*delP (rb/stb)
     */
    private SimpleDoubleProperty dE;
    /**
     * Vol withdrawn F = Np*Bo+ Wp*Bw (rb/stb)
     */
    private SimpleDoubleProperty dF;
    /**
     * F/E (MMstb)
     */
    private SimpleDoubleProperty result;
    /**
     * tD
     */
    private SimpleDoubleProperty dTd;
    /**
     * P(tD)
     */
    private SimpleDoubleProperty dPtD;
    /**
     * P'(tD)
     */
    private SimpleDoubleProperty dP1tD;
    /**
     * td(time step -1)
     */
    private SimpleDoubleProperty dTdPrevious;
    /**
     * P(dTdPrevious)
     */
    private SimpleDoubleProperty dPtDPrevious;
    /**
     * delP psi
     */
    private SimpleDoubleProperty delP;
    /**
     * Cum water influx (rb)
     */
    private SimpleDoubleProperty dWe;
    /**
     * We(td -1)
     */
    private SimpleDoubleProperty dWePrevious;
    /**
     * We/E (MMstb)
     */
    private SimpleDoubleProperty water;
    /**
     * N (MMstb)
     */
    private SimpleDoubleProperty dN;

    private final String sColTTVals[] = {"Property", "Value", "Units"};
    private final int defaultVal = 0;
    private final StringProperty angleTexts = new SimpleStringProperty("Encroachment angle");
    private MaterialBalInputModel pInputStruct = new MaterialBalInputModel();
    private final DoubleProperty amount = new SimpleDoubleProperty();

    //Tank Data
    public TankDataModel(Integer sID, String fDate, double fPr, double cumOil, double cumGas, double fWp) {
        this.rID = new SimpleIntegerProperty(sID);
        this.fieldDate = new SimpleStringProperty(fDate);
        this.fieldWp = new SimpleDoubleProperty(fWp);
        this.fieldPressure = new SimpleDoubleProperty(fPr);
        this.cumOil = new SimpleDoubleProperty(cumOil);
        this.cumGas = new SimpleDoubleProperty(cumGas);

        this.fieldMonth = new SimpleStringProperty();
        this.fieldBo = new SimpleDoubleProperty();
        this.fieldBg = new SimpleDoubleProperty();
        this.fieldBw = new SimpleDoubleProperty();
        this.fieldBt = new SimpleDoubleProperty();

        this.fieldCo = new SimpleDoubleProperty();
        this.fieldCf = new SimpleDoubleProperty();
        this.fieldCw = new SimpleDoubleProperty();
        this.fieldGOR = new SimpleDoubleProperty();
        
        
        this.ratio = new SimpleDoubleProperty();
        this.delP = new SimpleDoubleProperty();
        this.dBo = new SimpleDoubleProperty();
        this.dE = new SimpleDoubleProperty();
        this.dF = new SimpleDoubleProperty();
        this.result = new SimpleDoubleProperty();
        this.dWe = new SimpleDoubleProperty();
        this.dTd = new SimpleDoubleProperty();
        this.dPtD = new SimpleDoubleProperty();
        this.dP1tD = new SimpleDoubleProperty();
        this.water = new SimpleDoubleProperty();
        this.dTdPrevious = new SimpleDoubleProperty(0);
        this.dPtDPrevious = new SimpleDoubleProperty(0);
        this.dWePrevious = new SimpleDoubleProperty(0);

        df = new DecimalFormat("0.##E0");

    }

    
    //PVT data
    public TankDataModel(Integer sID, String fMonth,  double fPr, double fBo,double fBg,
        double fBw,double fBt, double fCo, double fCf, double fCw, double fGOR) {
        
        this.rID = new SimpleIntegerProperty(sID);
        this.fieldMonth = new SimpleStringProperty(fMonth);
        this.fieldBo = new SimpleDoubleProperty(fBo);
        this.fieldBg = new SimpleDoubleProperty(fBg);
        this.fieldBw = new SimpleDoubleProperty(fBw);
        this.fieldBt = new SimpleDoubleProperty(fBt);
        this.fieldCo = new SimpleDoubleProperty(fCo);
        this.fieldCf = new SimpleDoubleProperty(fCf);
        this.fieldCw = new SimpleDoubleProperty(fCw);
        this.fieldGOR = new SimpleDoubleProperty(fGOR);
        this.fieldPressure = new SimpleDoubleProperty(fPr);
        this.fieldDate = new SimpleStringProperty();
        this.fieldWp = new SimpleDoubleProperty();
        this.cumOil = new SimpleDoubleProperty();
        this.cumGas = new SimpleDoubleProperty();
        this.ratio = new SimpleDoubleProperty();
    }


    public DoubleBinding getRpVal() {
        return Bindings.createDoubleBinding(()
                -> (cumGas.get() * 1000 / cumOil.get()),
                this.cumGas, this.cumOil);
    }

    public DoubleBinding getdelPVal() {
       // getDelP();
        //   System.out.println( "Pi:"+pInputStruct.getDPi()+";"+"dP:"+getFieldValuePr()+"\n");
        return Bindings.createDoubleBinding(()
                -> pInputStruct.getDPi() - getFieldValuePr(),
                this.fieldPressure);
    }

    public DoubleBinding getBoVal() {
        //Bo = Boi*Ceff*delP
        return Bindings.createDoubleBinding(()
                -> (pInputStruct.getDBoi() * (1 + (pInputStruct.getDCo()) * (getDelP()))),
                this.fieldPressure
        );

    }

    public DoubleBinding getEVal() {
        //E = Boi*Ceff*delP
        return Bindings.createDoubleBinding(()
                -> (pInputStruct.getDBoi() * ((pInputStruct.calcDCeff()) * (getDelP()))));

    }

    public DoubleBinding getFVal() {
        //F = Np*Bo+ Wp*Bw
        return Bindings.createDoubleBinding(()
                -> ((getDBo() * cumOil.get() + (pInputStruct.getDBw() * getFieldValueWp()))),
                this.cumOil, this.fieldWp);

    }

    public DoubleBinding getFbyEVal() {
        //F/E (MMstb)
        //  System.out.println(getDF() + "\t"+ getDE());
        return Bindings.createDoubleBinding(()
                -> (((getDF() / getDE()) / 1000000)),
                this.cumOil, this.fieldWp);
    }

    public DoubleBinding getTdVal() {
        //tD (t)
        //this.dTd = pInputStruct.getDTdFinal()*this.iTime
        //     System.out.println("F/E:"+getFbyE()+";dTDFinal:"+pInputStruct.getDTdFinal()+";iTime:"+getFieldDate()+"\n"); 
        return Bindings.createDoubleBinding(()
                -> pInputStruct.getDTdFinal() * Double.parseDouble(getFieldDate()),
                this.fieldDate);
    }

    public DoubleBinding getPtDVal() {
        //PtD (t)
        int iRCIndex = pInputStruct.getRCIndex();
        double dA0 = MbalRegressionCoeffBean.dA0[iRCIndex];
        double dA1 = MbalRegressionCoeffBean.dA1[iRCIndex];
        double dA2 = MbalRegressionCoeffBean.dA2[iRCIndex];
        double dA3 = MbalRegressionCoeffBean.dA3[iRCIndex];
        double dLNtD = Math.log(getDTd()) / Math.log(Math.E);
//    //dPtD.set(dA0 + (dA1*dTd.get()) + (dA2*dLNtD) + (dA3*dLNtD*dLNtD));

        // System.out.println("dTd: "+getDTd()+";dA0:"+dA0+";dA1:"+dA1+";dA2:"+dA2+";dA3:"+dA3+";dLNtD:"+dLNtD);
        return Bindings.createDoubleBinding(()
                -> dA0 + (dA1 * dTd.get()) + (dA2 * dLNtD) + (dA3 * dLNtD * dLNtD),
                this.fieldDate);
    }

    public DoubleBinding getP1tDVal() {
        //tD (t)

     //   System.out.println("P(tD): "+getDPtD()+";dPtDPrevious:"+ 0 +
        //           ";dTd:"+getDTd()+";dPTdPrevious:"+getdTdPrevious(dTdPrevious)+"\n");
        return Bindings.createDoubleBinding(()
                -> (getDPtD() - 0) / (getDTd() - getdTdPrevious(dTdPrevious)),
                this.fieldDate);

    }

    public DoubleBinding getPrevious(SimpleDoubleProperty dTdPrevious,
            SimpleDoubleProperty dPtDPrevious,
            SimpleDoubleProperty dWePrevious) {
        //tD (t)
        // this.dP1tD = (this.dPtD - this.dPtDPrevious)/(this.dTd - this.dTdPrevious);
        this.dTdPrevious = dTdPrevious;
        this.dPtDPrevious = dPtDPrevious;
        this.dWePrevious = dWePrevious;

        int iSize = this.list.size();

        System.out.println("P(tD): " + getDPtD() + ";dPtDPrevious:" + getdPtDPrevious()
                + ";dTd:" + getDTd() + ";dPTdPrevious:" + getdTdPrevious(dTdPrevious) + "\n");
        return Bindings.createDoubleBinding(()
                -> (getDPtD() - getdPtDPrevious()) / (getDTd() - getdTdPrevious(dTdPrevious)),
                this.fieldDate);

    }

    public DoubleBinding getWeVal() {

        double dNum = (getDTd() - getdTdPrevious(dTdPrevious))
                * (pInputStruct.getDUfinal() * getDelP()) - (getdWePrevious(dWePrevious) * getP1tD());
        double dDen = (getDPtD() - (getdTdPrevious(dTdPrevious) * getP1tD()));

        return Bindings.createDoubleBinding(()
                -> getdWePrevious(dWePrevious) + (dNum / dDen),
                this.fieldDate);
    }

    public DoubleBinding getWebyEVal() {
        return Bindings.createDoubleBinding(()
                -> (getDWe() / getDE()) / 1000000,
                this.fieldDate);
    }

    public String getColTTip(int col) {
        return sColTTVals[col];
    }

    public String getEncrPrompts() {
        return angleTexts.get();
    }

    public String getFieldDate() {
        return fieldDate.get();
    }

    public SimpleStringProperty nameProperty() {
        return fieldDate;
    }

    public int getRID() {
        return rID.get();
    }

    public double getFieldValueWp() {
        return fieldWp.get();
    }


    public double getFieldValuePr() {
        return fieldPressure.get();
    }

    public void setFieldDate(String fDate) {
        fieldDate.set(fDate);
    }

    public void setFieldValueWp(double fValueWp) {
        fieldWp.set(fValueWp);
    }
    public void setFieldValuePr(double fValuePr) {
        fieldPressure.set(fValuePr);
    }

    public void setRID(Integer fSerial) {
        rID.set(fSerial);

    }

    /////////////////////////////////////////////////
    public SimpleDoubleProperty BtProperty() {
        return fieldBt;
    }
    public SimpleDoubleProperty BgProperty() {
        return fieldBg;
    }
    public SimpleDoubleProperty cumOilProperty() {
        return cumOil;
    }

    public SimpleDoubleProperty cumGasProperty() {
        return cumGas;
    }

    public SimpleDoubleProperty ratioProperty() {
        return ratio;
    }

    public SimpleDoubleProperty BoProperty() {
        return dBo;
    }

    public SimpleDoubleProperty delPProperty() {
        return delP;
    }

    public SimpleDoubleProperty EProperty() {
        return dE;
    }

    public SimpleDoubleProperty FProperty() {
        return dF;
    }

    public SimpleDoubleProperty resultProperty() {
        return result;
    }

    public SimpleDoubleProperty TdProperty() {
        return dTd;
    }

    public SimpleDoubleProperty PtDProperty() {
        return dPtD;
    }

    public SimpleDoubleProperty P1tDProperty() {
        return dP1tD;
    }

    public SimpleDoubleProperty WeProperty() {
        return dWe;
    }

    public SimpleDoubleProperty waterProperty() {
        return water;
    }

    public double getdTdPrevious(SimpleDoubleProperty dTdPrevious) {
        this.dTdPrevious = dTdPrevious;
        return this.dTdPrevious.get();
    }

    public double getdPtDPrevious() {
       // TankDataModel previousData = new TankDataModel();
        return getDPtD();
    }

    public void getD() {
        TankDataModel pData = null;
        int index = list.size() - 1;
        if (index < 0) {
            return;
        }
        TankDataModel previousData = (TankDataModel) list.get(index);
       // pData = new TankDataModel();
        pData.setPreviousValues(previousData.TdProperty());
//                            previousData.getDPtD(),
//                            previousData.getDWe());
        this.list.add(pData);
        System.out.println("List:" + list);
    }

    public double getdWePrevious(SimpleDoubleProperty dWePrevious) {
        this.dWePrevious = dWePrevious;
        return this.dWePrevious.get();
    }

    public double getCumOil() {
        return cumOil.get();
    }

    public double getCumGas() {
        double val = (String.valueOf(cumGas.get()) != null) ? cumGas.get() : 0d;
        return val;
    }

    public void setCumOil(double cumOil) {
        double val = (String.valueOf(cumOil) != null) ? cumOil : 0d;
        this.cumOil.set(val);
    }

    public void setCumGas(double cumGas) {
        this.cumGas.set(cumGas);
    }

    public void setCumRatio(double cumRatio) {
        this.ratio.set(cumRatio);
    }

    ////////////////////////////////////////////////

    public double getDWp() {
        return dWp.get();
    }
//  public double getDP() {
//    return dP.get();
//  }

    public double getCumRatio() {
        double Rp = 0;
        if (cumOil.get() > 0) {
            Rp = (cumGas.get() / cumOil.get());
        }
        return Rp;
       //  return (String.valueOf(Rp) != null) ? Rp:0d;
    }
    
    public double getVolWe(){
        double VolWe = 0.0;
     return VolWe;   
    }
     public double getDDI(){
         double ddi = 0.0,w1 = 0.0,Np = 0.0;
//        Np = tbl_tank.getItems().get(i).getCumOil();
//        P = tbl_tank.getItems().get(i).getFieldValuePr();
//        date = Double.parseDouble(tbl_tank.getItems().get(i).getFieldDate());
//
//        w1 = Np
//                * (tbl_pvt.getItems().get(i).getFieldValueBt()
//                + ((tbl_tank.getItems().get(i).getCumRatio()
//                - Double.parseDouble(rsi_input.getText()))
//                * tbl_pvt.getItems().get(i).getFieldValueBg()));
//
//        //double ddi = N*(Bt-Bti)/w1;
//        ddi = (Double.parseDouble(N_txt.getText())
//                * (tbl_pvt.getItems().get(i).getFieldValueBt()
//                - Double.parseDouble(bti_input.getText()))) / w1;
         
        
      return 0.0;  
    }

    public double getDelP() {
        // System.out.println("delP:"+delP.get());
        double deltaP = pInputStruct.getDPi() - fieldPressure.get();
        return deltaP;

    }

    public double getDBo() {
        double Bo = (pInputStruct.getDBoi() * (1 + (pInputStruct.getDCo()) * (getDelP())));
        return Bo;
    }

    public double getDE() {
        double E = (pInputStruct.getDBoi() * ((pInputStruct.calcDCeff()) * (getDelP())));
// return dE.get();
        return E;
    }

    public double getDF() {
        double F = ((getDBo() * cumOil.get() + (pInputStruct.getDBw() * getFieldValueWp())));
        return F;
    }

    public double getFbyE() {
        double FbyE = 0;
        if (getDE() > 0) {
            FbyE = (((getDF() / getDE()) / 1000000));
        }
        return Double.parseDouble(df.format(FbyE));
    }

    public double getDTd() {
        double Td = pInputStruct.getDTdFinal() * Double.parseDouble(getFieldDate());
        //  return pInputStruct.getDTdFinal()*Double.parseDouble(getFieldDate());
        return Td;
    }

    public double getDPtD() {
        int iRCIndex = pInputStruct.getRCIndex();
        double dA0 = MbalRegressionCoeffBean.dA0[iRCIndex];
        double dA1 = MbalRegressionCoeffBean.dA1[iRCIndex];
        double dA2 = MbalRegressionCoeffBean.dA2[iRCIndex];
        double dA3 = MbalRegressionCoeffBean.dA3[iRCIndex];
        double dLNtD = Math.log(getDTd()) / Math.log(Math.E);
        double PtD = 0;

        if (getDTd() > 0) {
            PtD = (dA0 + (dA1 * getDTd()) + (dA2 * dLNtD) + (dA3 * dLNtD * dLNtD));
        }
        return PtD;
        //return dPtD.get();
    }

    public double getP1tD() {
      //this.dP1tD = (this.dPtD - this.dPtDPrevious)/(this.dTd - this.dTdPrevious);
        // return (getDPtD() - getdPtDPrevious(dPtDPrevious))/(getDTd() - getdTdPrevious(dTdPrevious));
        return dP1tD.get();
    }

    public double getDWe() {
        double We = 0;
        double dNum = (getDTd() - getdTdPrevious(dTdPrevious))
                * (pInputStruct.getDUfinal() * getDelP()) - (getdWePrevious(dWePrevious) * getP1tD());

        double dDen = (getDPtD() - (getdTdPrevious(dTdPrevious) * getP1tD()));
        //return dWe.get();
        //  if(dDen > 0&&fieldPressure.get()>0){
        if (dDen > 0) {
            We = getdWePrevious(dWePrevious) + (dNum / dDen);
        }
//                      System.out.println("P'(tD): "+getP1tD()+";dWePrevious:"+getdWePrevious(dWePrevious)+";dTd:"+dTd.get()+
//                      ";dPTdPrevious:"+getdTdPrevious(dTdPrevious) +";P'(tD):"+getP1tD()+";dPtD:"+getDPtD()+
//                      ";delP:"+getDelP()+";dUfinal:"+pInputStruct.getDUfinal()+"\n");

        return We;

    }

    public double getFetKovich() {
        double fWe = 0;

        return fWe;
    }

    public double getWebyE() {
        double WebyE = 0;
        if (getDE() > 0) {
            WebyE = (((getDWe() / getDE()) / 1000000));
        }
        return Double.parseDouble(df.format(WebyE));
    }

    public void setDelP() {
        // delP.set(pInputStruct.getDPi() - dP.get());
        // this.printValue("delP:  "+delP);
    }

    private void setPreviousValues(SimpleDoubleProperty dTd) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.dTd = dTd;
    }

    protected Object getPrevValueAt(TableView<?> table, int col, int row) {
        // return table.getColumns().get(column).getCellObservableValue(row).getValue();
        Object value = 0;
        if (row > 0) {
            value = table.getColumns().get(col).getCellObservableValue(row - 1).getValue();
        } else {
            System.err.println("negative row or col");
        }
        return value;

    }

    protected double getPrevNp(TableView<TankDataModel> table, int row) {

        double prevNp = 0;
        if (row > 0) {
            prevNp = table.getItems().get(row - 1).getCumOil();
        } else {
            System.err.println("negative row");
        }

        return prevNp;
    }
    //Bt = tbl_pvt.getItems().get(i).getFieldValueBt();
    //Bti = Double.parseDouble(bti_input.getText());
    //    double w1 = Np * (Bt + ((Rp - Rsi) * Bg));
//    double ddi = N * (Bt - Bti) / w1;
//    double sdi = (N * m * Bti * (Bg - Bgi)) / (Bgi * w1);
//    double wdi = (We - (Wp * Bw)) / w1;
//    double edi = (N * Bt * (1 + m) * ((Cw * Swi) + Cf) * (P1 - P2) / (1 - Swi)) / w1;

    public double getFprod() {
        //double Bt = tbl_pvt.getItems().get(i).getFieldValueBt();
        double Fprod = 0;
        if (cumOil.get() > 0) {
            Fprod = (cumOil.get() / cumOil.get());
        }
        return Fprod;
        // return (String.valueOf(Rp) != null) ? Rp:0d;
    }

    //return 0 to prevent nfe
    public double getAmount() {
        return (amount.getValue() != null) ? amount.doubleValue() : 0d;
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }

    public DoubleProperty amountProperty() {
        return amount;
    }
    //////////////////////////////////////////
    
    public String getFieldMonth() {
        return fieldMonth.get();
    }

    public double getFieldValueBo() {
        return fieldBo.get();
    }

    public double getFieldValueBg() {
        return fieldBg.get();
    }

    public double getFieldValueBw() {
        return fieldBw.get();
    }
    public double getFieldValueBt() {
        return fieldBt.get();
    }
    
    
     public double getFieldValueCo() {
        return fieldCo.get();
    }

    public double getFieldValueCf() {
        return fieldCf.get();
    }

    public double getFieldValueCw() {
    return fieldCw.get();
    }
    
    public double getFieldValueM() {
      return field_m.get();
    }
    public double getFieldValueN() {
      return field_N.get();
    }
    public double getFieldValueWe() {
      return field_We.get();
    }
    public double getFieldValueBti() {
      return field_Bti.get();
    }
    public double getFieldValueBgi() {
      return field_Bgi.get();
    }
    public double getFieldValueBoi() {
      return field_Boi.get();
    }
    public double getFieldValueRsi() {
      return field_rsi.get();
    }
    public double getFieldValuePi() {
      return field_Pi.get();
    }
     
    
    public void setFieldMonth(String fMonth) {
        fieldMonth.set(fMonth);
    }

    public void setFieldValueBo(double fValueBo) {
        fieldBo.set(fValueBo);
    }

    public void setFieldValueBg(double fValueBg) {
        fieldBg.set(fValueBg);
    }

    public void setFieldValueBw(double fValueBw) {
        fieldBw.set(fValueBw);
    }
    public void setFieldValueBt(double fValueBt) {
        fieldBw.set(fValueBt);
    }
    
    public void setFieldValueCo(double fValueCo) {
        fieldCo.set(fValueCo);
    }

    public void setFieldValueCf(double fValueCf) {
        fieldCf.set(fValueCf);
    }
    
    public void setFieldValueCw(double fValueCw) {
        fieldCw.set(fValueCw);
    }

    public void setFieldValueGOR(double fValueGOR) {
        fieldGOR.set(fValueGOR);
    }
    
    public void setFieldValueRsi(double fValueRsi) {
        field_rsi.set(fValueRsi);
    }
    
    


}
