/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Owner
 */
public class PVTDataModel {

    private final SimpleIntegerProperty rID;
    private final SimpleStringProperty fieldMonth;
    private final SimpleDoubleProperty fieldPressure;
    private final SimpleDoubleProperty fieldBo;
    private final SimpleDoubleProperty fieldBg;
    private final SimpleDoubleProperty fieldBw;
    private final SimpleDoubleProperty fieldBt;
    private final SimpleDoubleProperty fieldCo;
    private final SimpleDoubleProperty fieldCf;
    private final SimpleDoubleProperty fieldCw;
    private final SimpleDoubleProperty fieldGOR;
    
//    private SimpleStringProperty a,b,c,d,e,f,g,h;
   
    

    public PVTDataModel(Integer sID, String fMonth,  double fPr, double fBo,double fBg,
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
    }


    public String getFieldMonth() {
        return fieldMonth.get();
    }
    
        public Integer getRID() {
        return rID.get();
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
    
    
      public double getFieldValueGOR() {
        return fieldGOR.get();
    }
    
      public double getFieldValuePr() {
        return fieldPressure.get();
    }
    
    

    public void setFieldMonth(String fMonth) {
        fieldMonth.set(fMonth);
    }

    public void setFieldValueBo(double fValueBo) {
        fieldBo.set(fValueBo);
    }

    public void setFieldValueBg(double fValueBg) {
        fieldBo.set(fValueBg);
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
        fieldCf.set(fValueCw);
    }

    public void setFieldValueGOR(double fValueGOR) {
        fieldGOR.set(fValueGOR);
    }

    public void setFieldValuePr(double fValuePr) {
        fieldPressure.set(fValuePr);
    }

    public void setRID(Integer fSerial) {
        rID.set(fSerial);
    }


}
