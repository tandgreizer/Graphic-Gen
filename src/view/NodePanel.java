package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import javax.swing.JPanel;
import model.ColorNode;

public class NodePanel extends JPanel {
  private int sizeMod;
  private List<ColorNode> nodes;

  NodePanel(List<ColorNode> nodes, int sizeMod) {
    super();
    this.setBackground(Color.BLACK);
    this.nodes = nodes;
    this.sizeMod = sizeMod;

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    for (ColorNode node : nodes) {
      g2d.setColor(node.getColor());

      g2d.fill(new Rectangle2D.Double(node.getX() * sizeMod, node.getY() * sizeMod,sizeMod,sizeMod));


    }

  }
}
