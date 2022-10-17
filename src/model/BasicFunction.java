package model;

import java.awt.Color;

public class BasicFunction implements ColorFunction{

  double powerMod;
  boolean isIncreasing;

  public BasicFunction(double powerMod) {
    this.powerMod = powerMod;
    this.isIncreasing = true;
  }

  public BasicFunction() {
    this(1);
  }


  @Override
  public Color getColor(int x, int y) {


    return new Color(dontGoOver((Math.pow(x,powerMod) * Math.pow(y,powerMod))),
        dontGoOver((Math.pow(x,powerMod) * Math.pow(y,powerMod))),
        dontGoOver((Math.pow(x,powerMod) * Math.pow(y,powerMod))));

  }

  @Override
  public void setMod(double mod) {
    this.powerMod = mod;
  }

  @Override
  public double getMod() {
    return this.powerMod;
  }

  @Override
  public void setIncreasing(boolean isIncreasing) {
    this.isIncreasing = isIncreasing;
  }

  @Override
  public boolean isIncreasing() {
    return isIncreasing;
  }

  int dontGoOver(double val) {
    int newVal = (int) (val % 255);
    if (newVal < 0) {
      newVal = -newVal;
    }
    return newVal;
  }
}
