package view;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import model.ColorNode;

public class ColoredRenderer extends JFrame {
  private NodePanel nodePanel;

  public ColoredRenderer(List<ColorNode> nodes, int sizeMod) {
    this.setTitle("Colored Screen");
    this.setSize((int)Math.sqrt(nodes.size()) * sizeMod + 17 ,
        (int)Math.sqrt(nodes.size()) * sizeMod + 39);
    nodePanel = new NodePanel(nodes,sizeMod);
    this.add(nodePanel);

  }

  public void animate() {
    this.setVisible(true);
    this.repaint();
//    Container c = getContentPane();
//    BufferedImage im = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB);
//    c.paint(im.getGraphics());
//    try {
//      ImageIO.write(im, "PNG", new File("oneeightPower.png"));
//    } catch (IOException e) {
//      System.out.println("save failed");
//    }
  }
}
