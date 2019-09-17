/*
 * @MbalRegressionCoeffBean.java  Version 1.0 07/07/2016
 *
 * Copyright (c) 2016 VESoft Ltd
 * 1 Chima Close,Rumuodara Port-Harcourt, Rivers State Nigeria.
 * All Rights Reserved.
 */

package model;

/** MbalRegressionCoeffBean
 *  <p> Holds the regression coefficients for the
 *      Carter-Tracy aquifer Model
 *
 *  @version 1.0 07/07/2016
 *  @author  Okpo Ekpenyong
 * </p>
 */

public interface MbalRegressionCoeffBean
{
  public final static double dInfinity =
          Double.POSITIVE_INFINITY;
  public final static double[] dReD =
                          {1.5,2.0,3.0,4.0,5.0,6.0,8.0,10.0,dInfinity};
  public final static double[] dA0  =
                          {0.10371,0.30210,0.51243,0.63656,0.65106,
                           0.63367,0.40132,0.14386,0.82092};
  public final static double[] dA1  =
                          {1.66657,0.68178,0.29317,0.16101,0.10414,
                           0.06940,0.04104,0.02649,-3.68E-4};
  public final static double[] dA2  =
                          {-0.04579,-0.01599,0.01534,0.15812,0.30953,
                           0.41750,0.69592,0.89646,0.28908};
  public final static double[] dA3  =
                          {-0.01023,-0.01356,-0.06732,-0.09104,-0.11258,
                           -0.11137,-0.14350,-0.15502,0.02882};

}