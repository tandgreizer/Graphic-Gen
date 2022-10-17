package model;

import java.awt.Color;

public class BasicQuad extends BasicFunction{
  ColorFunction upLeft;
  ColorFunction upRight;
  ColorFunction downLeft;
  ColorFunction downRight;
  int leftRight;
  int upDown;

  public BasicQuad(double powerMod, int leftRight, int upDown, int maxVal) {
    super(powerMod);
    this.upLeft = new MirrorFunction(powerMod, false,false,maxVal);
    this.upRight = new MirrorFunction(powerMod, true, false, maxVal);
    this.downLeft = new MirrorFunction(powerMod, false, true, maxVal);
    this.downRight = new MirrorFunction(powerMod, true, true, maxVal);
    this.leftRight = leftRight;
    this.upDown = upDown;
  }

  public BasicQuad(double powerMod) {
    this(powerMod, 127, 127, 255);
  }

  public BasicQuad() {
    this(1);
  }

  @Override
  public Color getColor(int x, int y) {

    if (x <= leftRight) {
      if (y <= upDown) {
        return upLeft.getColor(x, y);

      } else {
        return downLeft.getColor(x, y);
      }
    } else {
      if (y <= upDown) {
        return upRight.getColor(x, y);

      } else {
        return downRight.getColor(x, y);
      }
    }

  }


  @Override
  public void setMod(double mod) {
    this.powerMod = mod;
    this.upLeft.setMod(mod);
    this.upRight.setMod(mod);
    this.downLeft.setMod(mod);
    this.downRight.setMod(mod);
  }
}
