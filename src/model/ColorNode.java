package model;

import java.awt.Color;

public class ColorNode {
  private int x;
  private int y;
  private ColorFunction function;


  public ColorNode(int x, int y, ColorFunction function) {
    this.x = x;
    this.y = y;
    this.function = function;
  }

  public Color getColor() {
    return this.function.getColor(this.x, this.y);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
