package model;

import java.awt.Color;

public class BasicFunctionColored extends BasicFunction{

  public BasicFunctionColored(double powerMod) {
    super(powerMod);
  }

  public BasicFunctionColored() {
    super();
  }

  @Override
  public Color getColor(int x, int y) {


    return new Color(dontGoOver((Math.pow(x,powerMod) * Math.pow(y,powerMod))),
        dontGoOver((Math.pow(x * 2,powerMod) * Math.pow(y * 2,powerMod))),
        dontGoOver((Math.pow(x * 1.5,powerMod) * Math.pow(y * 1.5,powerMod))));

  }

}
