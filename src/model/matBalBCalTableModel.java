/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

///import model.MaterialBalInputModel;

/**
 *
 * @author Owner
 */
public class matBalBCalTableModel {
    
  private MaterialBalInputModel pModelBean=null;
  //////////////////////////////// Acquifer   ///////////////////////////////////////////////////////////
  private final String sAqToolTips[]={"Encroachment angle (deg)","f= Encroachment Angle/360 (deg)","Porosity (fraction)",
                                     "Height (ft)","Total Aq.Comp (1/psi)","Permeability (mD)","Water Viscosity (cp)",
                                     "Aquifer constant U = 1.119*f*phi*h*c*ro^2 (b/psi)","U final (b/psi)",
                                     "Dimensionless Time tD = 0.00634Kt/(phi*Mu*c*ro^2)(t)","tD final (t)","Radius,re (ft)",
                                     "PI,(bpd/psi)","Max Aq, (MMstb)","Aquifer_Reservoir Radius ratio"};

  
 private final String sAqPrompts[] = {"angle(deg)","f(deg)","poro(fraction)","ht(ft)","Aq_Ceff = Cf+Cw, (1/psi)","K(mD)","Uw(cp)",
                                      "U(b/psi)","U final(b/psi)","tD(t)","tD final(t)","re (ft)","J (bpd/psi)","Wei (MMstb)","ratio"};
  
 private final String sAqInitVals [] = {"140", "","0.19", "150","","15","0.4","", "1800","", "0.00325","800"};
 
 //////////////////////////////// Reservoir////////////////////////////////////////////////////////////// 
 private final String sResToolTips[] = {"Radius,ro (ft)", "Water Saturation,Swc (PV)",
                                      "Effective Compressibility Ceff = (co*So+cw*Swc+cf)/(1-Swc)",
                                      "regression coefficients, ao","regression coefficients, a1",
                                      "regression coefficients a2","regression coefficients a3"};
  
  // private TextField rad, Swc,Ceff,ao,a1,a2,a3;
 private final String sResPrompts[] = {"re (ft)","Swc (PV) ","Ceff (1/psi)",
                                       "ao","a1",
                                       "a2","a3"};
  
 private final String sResInitVals[] = {"100.0","0.2","","0.82092","-0.000368","0.28908","0.002882"};
 ///////////////////////////////// PVT ////////////////////////////////////////////////////////////////
 private final String sPVTToolTips[] = { "Initial reservoir pressure (psia)",
                                       "Oil formation volume factor at Pi (rb/stb)",
                                       "Water formation volume factor (rb/stb)",
                                       "Oil Compressibility (1/psi)",
                                       "Pore Compressibility (1/psi)",
                                       "Water Compressibility (i/psi)",
                                        "Date (dd/mm/yy)",""
         + "                            Gas Solubility (scf/stb)",
                                        "Initial Gas Solubility (scf/stb)",
                                        "Pressure (psi)",
                                        "Bubble Point Pressure (psi)",
                                        "Gas formation volume factor (scf/stb)",
                                        "2-phase formation volume factor (scf/stb)"};
 
 private final String sPVTPrompts[] =  {"Pi (psi)","Boi (rb/stb)","Bw (rb/stb)","Co (1/psi)","Cf (1/psi)","Cw (1/psi)",
                                        "Date (dd/mm/yy)"," Rs (scf/stb)","Rsi (scf/stb)","P (psi)","Pb (psi)","Bg (scf/stb)","Bt (scf/stb)"};
 
 private final String sPVTInitVals[] = {"4217.0","1.18","1.0","0.0000075","0.000005","0.000003",
                                        "12/5/2018","1225.0","1040","3200","3100","0.00015","2.0145"};
 
 
 
 
 
//   private final String sProps[]={"Pi","Boi","Bw","Co","Cf","Cw"};
//  private final String sPropsDesc[]= { "Initial reservoir pressure",
//                                       "Oil formation volume factor at Pi",
//                                       "Water formation volume factor",
//                                       "Oil Compressibility",
//                                       "Pore Compressibility",
//                                       "Water Compressibility"
//                                      };
//  private final String sUnits[]={"psia","rb/stb","rb/stb",
//                                 "1/psi","1/psi","1/psi"};
// 
// 

  /** Method getColumnCount()
   *  <p> returns the number of columns in the table.
   *  @return number of columns in the table
   */

  public int getColumnCount()
  {
    return sAqToolTips.length;
  }

  /** Method getRowCount()
   *  <p> returns the number of rows in the table.
   *  @return number of rows in the table
   */

//  public int getRowCount()
//  {
//    return (this.iNumOfRows);
//  }

  /** Method getAqToolTips(int)
   *  <p> returns the name of the column at specified column number
   *  @param col - column number
   *  @return name of the specified column
   */

    public String getAqToolTips(int col) {
        return sAqToolTips[col];
    }

    public String getAqPrompts(int col) {
        return sAqPrompts[col];
    }

    public String getAqInitVals(int col) {
        return sAqInitVals[col];
    }
/////////////////////////////////////////////
    public String getResToolTips(int col) {
        return sResToolTips[col];
    }
    
        public String getResPrompts(int col) {
        return sResPrompts[col];
    }

    public String getResInitVals(int col) {
        return sResInitVals[col];
    }
/////////////////////////////////////////////

      public String getPVTToolTips(int col) {
        return sPVTToolTips[col];
    }
    
        public String getPVTPrompts(int col) {
        return sPVTPrompts[col];
    }

    public String getPVTInitVals(int col) {
        return sPVTInitVals[col];
    }


  /** Method getPropsDesc()
   *  @return description of the basic cal properties
   */

//  public String[] getPropsDesc()
//  {
//    return (this.sPropsDesc);
//  }

  /** Method getValueAt(int,int)
   *  <p> returns the value at the specified row,column
   *  @param col - column number
   *  @param row - row number
   *  @return value at the specified row,column
   */

//  public Object getValueAt(int row, int col)
//  {
//    switch (col)
//    {
//      case 0:
//        return this.sProps[row];
//      case 1:
//        return getRowValueAt(row);
//      case 2:
//        return this.sUnits[row];
//      default:
//        return new Integer(-1);
//    }
//  }

  /** Method getRowValueAt(int)
   *  <p> returns the value at the specified row for column no:1
   *  @param row - row number
   *  @return value at the specified row for column no: 1
   */

  public Object getRowValueAt(int row)
  {
    switch (row)
    {
      case 0:
        return new String(""+this.pModelBean.getDU());
      case 1:
        return new String(""+this.pModelBean.getDUfinal());
      case 2:
        return new String(""+this.pModelBean.getDTd());
      case 3:
        return new String(""+this.pModelBean.getDTdFinal());
      default:
        return new Integer(-1);
    }
  }

  /** Method getColumnClass(int)
   *  <p> Returns the 'class' type of the specified column
   * @param c - column number
   * @return 'class' type of the specified column
   */

//  public Class getColumnClass(int c)
//  {
//    return getValueAt(0, c).getClass();
//  }

  /**
   *
   * @param row - row number
   * @param col - column number
   * @return true if the specified cell is editable
   */

  public boolean isCellEditable(int row, int col)
  {
    switch(col)
    {
      case 0:
        return false;
      case 1:
        if(row==0 || row==2)
          return false;
        else
          return true;
      case 2:
        return false;
      default:
        return false;
    }
  }

  /**
   * <p> Sets the value at the specified row,column to the specified value
   *
   * @param value - Value of the cell
   * @param row   - row number
   * @param col   - column number
   */

  public void setValueAt(Object value, int row, int col)
  {
    switch (row)
    {
      case 0:
        break;
      case 1:
        this.pModelBean.setDUfinal(setDoubleValue(value));
        break;
      case 2:
        break;
      case 3:
        this.pModelBean.setDTdFinal(setDoubleValue(value));
        break;
      default:
    }

//    fireTableCellUpdated(row, col);
 }

  /**
   * <p> Converts the specified object to a 'double' value
   * @param objDouble -  value
   * @return double value for the specified object
   */

  private double setDoubleValue(Object objDouble)
  {
    double dVal=0.0;
    try
    {
      dVal= (new Double((String)objDouble)).doubleValue();
    }
    catch(Exception e)
    {
      dVal=0.0;
    }
    return (dVal);
  }

  /** Method updateInputData
   *  <p> Updates the table model with the specified input model
   *  @param pModelBean  - input properties data
   */

//  public void updateInputData(MaterialBalInputModel pModelBean)
//  {
//    this.pModelBean=pModelBean;
////    fireTableDataChanged();
//  }

  /**
   * <p> Listens to changes in the input properties data
   */
//  class modelListener implements matBalModelListener{
//    public void modelChanged(Object argsObject)
//    {
//      fireTableDataChanged();
//    }
//  }

}
