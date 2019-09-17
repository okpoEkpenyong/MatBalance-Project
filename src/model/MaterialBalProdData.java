/*
 * @MbalRegressionCoeffBean.java  Version 1.0 07/07/2016
 *
 * Copyright (c) 2016 VESoft Ltd
 * 1 Chima Close,Rumuodara Port-Harcourt, Rivers State Nigeria.
 * All Rights Reserved.
 */
package model;

/**
 * <p >Class MaterialBalProdData</p>
 * Performs production/pressure data and Carter-Tracy water influx calculations
 * <p>
 * Holds the regression coefficients for the Carter-Tracy aquifer Model
 *
 * @version 1.0 07/07/2016
 * @author Okpo Ekpenyong
 * </p>
 */

import javax.swing.event.*;
import java.util.ArrayList;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import model.MaterialBalInputModel;
import model.MbalRegressionCoeffBean;

 
public class MaterialBalProdData {

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
    private SimpleDoubleProperty dFbyE;
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
    private SimpleDoubleProperty dWeByE;
    /**
     * N (MMstb)
     */
    private SimpleDoubleProperty dN;

    /**
     * flag to enable/disable debug statements
     */
    private boolean blnDebug = false;

    /**
     * Input properties data
     */
    private MaterialBalInputModel pInputStruct;

    private boolean blnFirstTimeStep = true;

    // private final SimpleDoubleProperty oilfactor;
    /**
     * <p>
     * Initializes the input properties data // * @param pInputStruct - input
     * properties data
     */
    //tbl_result.getColumns().addAll(Bo,Pr,dP,E,F,FbyE);
    
    public MaterialBalProdData(MaterialBalInputModel pInputStruct, double dBo, double dP, double dE, double dF, double dFbyE) {
        this.pInputStruct = pInputStruct;
        this.dBo = new SimpleDoubleProperty(dBo);
        this.dP = new SimpleDoubleProperty(dP);
        this.dE = new SimpleDoubleProperty(dE);
        this.dF = new SimpleDoubleProperty(dF);
        this.dFbyE = new SimpleDoubleProperty(dFbyE);
        this.dBo = new SimpleDoubleProperty(dBo);
        this.delP = new SimpleDoubleProperty();

        this.delPProperty().bind(getdelPVal());

    }
 
    public DoubleBinding getdelPVal() {
        return Bindings.createDoubleBinding(()
                -> (pInputStruct.getDPi() + 20 - getDP()),
                this.dP);
    }

    public SimpleDoubleProperty delPProperty() {
        return delP;
    }

    public SimpleDoubleProperty getDFbyE() {
        return dFbyE;
    }

    public SimpleDoubleProperty getDN() {
        return dN;
    }

    public SimpleDoubleProperty getDWeByE() {
        return dWeByE;
    }

    public SimpleIntegerProperty getITime() {
        return iTime;
    }


    public void setITime(int time) {
        //this.iTime = iTime;
        iTime.set(time);
        
      
    }

    public double getDNp() {
        return dNp.get();
    }

    public void setDNp(double dNp) {
        this.dNp.set(dNp);
       
      
    }

    public double getDWp() {
        return dWp.get();
    }

    public double getDP() {
        return dP.get();
    }

    public double getDBo() {
        return dBo.get();
    }

    public double getDE() {
        return dE.get();
    }

    public double getDelP() {
        return delP.get();
    }

    public double getDF() {
        return dF.get();
    }

    public double getDPtD() {
        return dPtD.get();
    }

    public double getDTd() {
        return dTd.get();
    }

    public double getDWe() {
        return dWe.get();
    }

    public void setDWp(double dWp) {
        this.dWp.set(dWp);
       
       
    }

    public void setDP(double dP) {
        this.dP.set(dP);
        
        
    }

    public void setDelP() {
        delP.set(pInputStruct.getDPi() - dP.get());
       
    }

    public void setBo() {
        setDelP();
        dBo.set(pInputStruct.getDBoi() * (1 + (pInputStruct.getDCo() * delP.get())));
       
    }

    public void setE() {
        setDelP();
        dE.set(pInputStruct.getDBoi() * pInputStruct.getDCeff() * delP.get());
       
    }

    public void setF() {
        setBo();
        dF.set((dBo.get() * dNp.get()) + (pInputStruct.getDBw() * dWp.get()));
       
    }

    public void setFbyE() {
        this.setF();
        this.setE();
        dFbyE.set((dF.get() / dE.get()) / 1000000);
      
    }

    public void setTd() {
        dTd.set(pInputStruct.getDTdFinal() * iTime.get());
        
    }

    public void setPtD() {
        this.setTd();
        int iRCIndex = pInputStruct.getRCIndex();
        double dA0 = MbalRegressionCoeffBean.dA0[iRCIndex];
        double dA1 = MbalRegressionCoeffBean.dA1[iRCIndex];
        double dA2 = MbalRegressionCoeffBean.dA2[iRCIndex];
        double dA3 = MbalRegressionCoeffBean.dA3[iRCIndex];
        double dLNtD = Math.log(dTd.get()) / Math.log(Math.E);
        dPtD.set(dA0 + (dA1 * dTd.get()) + (dA2 * dLNtD) + (dA3 * dLNtD * dLNtD));

    }

    public void setP1tD() {
        this.setPtD();
        dP1tD.set((dPtD.get() - dPtDPrevious.get()) / (dTd.get() - dTdPrevious.get()));
       
    }

    public double getP1tD() {
        return (dP1tD.get());
    }

    public void setPreviousValues(SimpleDoubleProperty dTdPrevious,
            SimpleDoubleProperty dPtDPrevious,
            SimpleDoubleProperty dWePrevious) {

        this.dTdPrevious = dTdPrevious;
        // this.dTdPrevious = new SimpleDoubleProperty();
        this.dPtDPrevious = dPtDPrevious;
        this.dWePrevious = dWePrevious;
        
    }

    public void setWe() {
        this.setP1tD();

        double dNum = (pInputStruct.getDUfinal() * delP.get())
                - (dWePrevious.get() * dP1tD.get());
        dNum = (this.dTd.get() - dTdPrevious.get()) * dNum;
        double dDen = (this.dPtD.get() - (this.dTdPrevious.get() * this.dP1tD.get()));
        this.dWe.set(this.dWePrevious.get() + (dNum / dDen));
       
    }

    public void setWeByE() {
        this.setWe();
        this.dWeByE.set((this.dWe.get() / this.dE.get()) / 1000000);
       
    }

    public void setN() {
        this.setFbyE();
        this.setWeByE();
        this.dN.set(this.dFbyE.get() - this.dWeByE.get());
    
    }



 

}
