/*
 * @MbalRegressionCoeffBean.java  Version 1.0 07/07/2016
 *
 * Copyright (c) 2016 VESoft Ltd
 * 1 Chima Close,Rumuodara Port-Harcourt, Rivers State Nigeria.
 * All Rights Reserved.
 */


package model;

//import matBal.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MaterialBalInputModel {

 // Fluid Properties

  private double dPi = 3000 ;   
  private double dBoi = 1.58 ; 
  private double dBw = 1 ;  
  private double dCo = 0.00000751 ; 
  private double dCw = 0.0000015;  

  // Aquifer Properties

  private double Wei = 0;
  private double J = 0;
  private double Wi = 0;
  private double ratio = 0;
  private double dEncroachmentAngle = 140; 
  private double dF = dEncroachmentAngle/360;   
  private double dPhi = 0.19; 
  private double dH = 150; 
  private double dCf = 0.000001;  
  private double dC = dCf + dCw ; 
  private double dK = 15; 
  private double dMu = 0.4; 
  private double dRe = 800.0;
  

  private double dRo = 100.0; 
  private double dSwc = 0.2; 
  private double dCeff = 0; 
  private double m = 0.25; 
  private double N = 10E+06; 
  private double We = 0;
  
  //Aquifer constant

  private double dU=1.119*dF*dPhi*dH*dC*(dRo*dRo); // units -- b/psi

  private double dUfinal = 1800; 

  // Time steps

  private double dTd = 0.0;
  private double dTdFinal = 0.00325;

  // regression coefficient index
  private int iRegressionCoeffIndex = 8;

  // list of listeners

  private ArrayList listListeners=new ArrayList();
    private final DecimalFormat formatter;

  public MaterialBalInputModel()
  {

      formatter = new DecimalFormat("0.###E0");
  }


  public double getDBoi() {
      this.dBoi = Double.parseDouble(formatter.format(dBoi));
      return this.dBoi;
  }
  public void setDBoi(double dBoi) {
    this.dBoi = dBoi;
   
  }

  public double getDBw() {
      this.dBw = Double.parseDouble(formatter.format(dBw));
      return this.dBw;
  }
  public void setDBw(double dBw) {
    this.dBw = dBw;
   
  }
  public double getDC() {
    this.dC = Double.parseDouble(formatter.format(dC));
    return this.dC;
  }
  public double getDCeff() {
    this.dCeff = Double.parseDouble(formatter.format(dCeff));  
    return this.dCeff;
  }
  public double getDCf() {
    this.dCf = Double.parseDouble(formatter.format(dCf));
    return this.dCf;
  }
  public void setDCf(double dCf) {
    this.dCf = dCf;
  
  }
  public double getDCo() {
    this.dCo = Double.parseDouble(formatter.format(dCo));
    return this.dCo;
  }
  public void setDCo(double dCo) {
    this.dCo = dCo;
    
  }
  public double getDCw() {
    this.dCw = Double.parseDouble(formatter.format(dCw));
    return this.dCw;
  }
  public void setDCw(double dCw) {
    this.dCw = dCw;
   
  }
  public double getDEncroachmentAngle() {
    return dEncroachmentAngle;
  }
  public void setDEncroachmentAngle(double dEncroachmentAngle) {
    this.dEncroachmentAngle = dEncroachmentAngle;
    //this.modelDataChanged();
  }
  public double getDF() {
          DecimalFormat f = new DecimalFormat("#0.00");

      this.dF = Double.parseDouble(formatter.format(dF));
    return this.dF;
  }
  public double getGasGapRatio() {   
    return m;
  }
  public double getOilInPlace() {   
    return N;
  }
  public double getAcquiferInflux() {   
    return We;
  }
  public double getDH() {   
    return dH;
  }
  public void setDH(double dH) {
    this.dH = dH;
 
  }
  public double getDUfinal() {
    this.dUfinal = Double.parseDouble(formatter.format(dUfinal));
    return this.dUfinal;
  }
  public void setDUfinal(double dUfinal) {
    this.dUfinal = dUfinal;
   
  }
  public double getDU() {
    this.dF = Double.parseDouble(formatter.format(dU));
    return this.dU;
  }
  public double getDK() {
    return dK;
  }
  public void setDK(double dK) {
    this.dK = dK;
 
  }
  public double getDMu() {
    this.dMu = Double.parseDouble(formatter.format(dMu));
    return this.dMu;
  }
  public void setDMu(double dMu) {
    this.dMu = dMu;
 
  }
  public double getDPhi() {
    return dPhi;
  }
  public void setDPhi(double dPhi) {
    this.dPhi = dPhi;
 
  }
  public double getDPi() {
    return dPi;
  }
  public void setDPi(double dPi) {
    this.dPi = dPi;
   
  }
  public double getDRo() {
    return dRo;
  }
  public void setDRo(double dRo) {
    this.dRo = dRo;
   
  }
  public double getDRe() {
    return dRe;
  }
  public void setDRe(double dRe) {
    this.dRe = dRe;
  
  }
  public double getDSwc() {
    this.dSwc = Double.parseDouble(formatter.format(dSwc));
    return this.dSwc;
  }
  public void setDSwc(double dSwc) {
    this.dSwc = dSwc;

  }

  private void setDC()
  {
    this.dC=this.dCf+this.dCw;
  }

  private void setDCeff()
  {
    this.dCeff = ( (this.dCo*(1-this.dSwc)) +
                   (this.dCw*this.dSwc) +
                   (this.dCf)
                 )/(1-this.dSwc);
  }

   public double calcDCeff()
  {
    this.dCeff = ( (this.dCo*(1-this.dSwc)) +
                   (this.dCw*this.dSwc) +
                   (this.dCf)
                 )/(1-this.dSwc);
    this.dCeff = Double.parseDouble(formatter.format(dCeff));
    
    return this.dCeff;
  }

  
  private void setDf()
  {
    this.dF= this.dEncroachmentAngle/360;
  }

  private void setDU()
  {
    this.dU = 1.119 * this.dF * this.dPhi * this.dC *
                      this.dRo * this.dRo *this.dH;
   ;
  }

  private void setDTd()
  {
    this.dTd = 0.00634 * this.dK;
    this.dTd = this.dTd /(this.dPhi* this.dMu * this.dC * this.dRo * this.dRo);

  }

  public double calcDU()
  {
    this.dU = 1.119 * this.dF * this.dPhi * this.dC *
                      this.dRo * this.dRo *this.dH;
    //this.dUfinal = this.dU ;
    this.dU = Double.parseDouble(formatter.format(dU));
    return this.dU;
  }
  



  public double calcDJ()
  {
    this.J = 0.0078 * this.dK * this.dH * this.dPhi/(360*this.dMu*(Math.log(dRe/dRo))) ;
    this.J = Double.parseDouble(formatter.format(J));
    return this.J;
  }

  public double calcDWei()
  {
    this.Wi = 3.14*((dRe * dRe) - (dRo * dRo)) * dH * dPhi /5.615;
    this.Wei = dCf * this.Wi * this.dPi * this.dPhi/360 ;
    this.Wei = Double.parseDouble(formatter.format(Wei));
    return this.Wei;
  }

  public double calcRatio()
  {
    this.ratio = dRe/dRo;
    this.ratio = Double.parseDouble(formatter.format(ratio));
    return this.ratio;
  }

  public double calcDTd()
  {
    this.dTd = 0.00634 * this.dK;
    this.dTd = this.dTd /(this.dPhi* this.dMu * this.dC * this.dRo * this.dRo);
    this.dTd = Double.parseDouble(formatter.format(dTd));
    return this.dTd;
  }


  
  public double getDTdFinal()
  {
    this.dTdFinal = Double.parseDouble(formatter.format(dTdFinal));
    return (this.dTdFinal);
  }

  public void setDTdFinal(double dVal)
  {
    this.dTdFinal = dVal;
  }

  public int getRCIndex()
  {
    return (this.iRegressionCoeffIndex);
  }

  public void setRCIndex(int iVal)
  {
    this.iRegressionCoeffIndex = iVal;
  
  }





  public double getDTd() {
    this.dTd = Double.parseDouble(formatter.format(dTd));
    return dTd;
  }

}