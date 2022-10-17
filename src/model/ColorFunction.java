package model;

import java.awt.Color;

public interface ColorFunction {

  public Color getColor(int x, int y);

  public void setMod(double mod);

  public double getMod();

  public void setIncreasing(boolean isIncreasing);

  public boolean isIncreasing();
}
