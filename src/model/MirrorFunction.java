package model;

import java.awt.Color;

public class MirrorFunction extends BasicFunction {
  boolean mirrorX;
  boolean mirrorY;
  int maxVal;

  public MirrorFunction(double powerMod, boolean mirrorX, boolean mirrorY, int maxVal) {
    super(powerMod);
    this.mirrorX = mirrorX;
    this.mirrorY = mirrorY;
    this.maxVal = maxVal;
  }
  public MirrorFunction(double powerMod) {
    this(powerMod,true,false,255);
  }

  public MirrorFunction() {
    this(1);
  }

  @Override
  public Color getColor(int x, int y) {

    if (mirrorX) {
      x = maxVal - x;
    }
    if (mirrorY) {
      y = maxVal - y;
    }

    return new Color(dontGoOver((Math.pow(x,powerMod) * Math.pow(y,powerMod))),
        dontGoOver((Math.pow(x,powerMod) * Math.pow(y ,powerMod)) + 40),
        dontGoOver((Math.pow(x,powerMod) * Math.pow(y,powerMod)) + 180));

  }
}
