import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import model.BasicFunction;
import model.BasicFunctionColored;
import model.BasicQuad;
import model.ColorFunction;
import model.ColorNode;
import model.MirrorFunction;
import view.ColoredRenderer;

public class GeoGraphic {

  public static void main(String[] args) {
    int sizeUsing = 2;
    boolean animated = false;
    double startingMod = 2;

    for (int i = 0; i < args.length; i++) {

      switch (args[i]) {
        case "-size":
          try {
            sizeUsing = Integer.parseInt(args[i + 1]);
          } catch (Exception e) {
            System.out.println("Invalid size argument");
          }
          break;
        case "-animated":
          animated = true;
          break;
        case "-startingMod":
          try {
            startingMod = Double.parseDouble(args[i + 1]);
          } catch (Exception e) {
            System.out.println("Invalid mod argument");

          }
          break;

      }
    }


    List<ColorNode> nodes = new ArrayList<>();
    ColorFunction function = new BasicQuad(startingMod);
    Timer timer = new Timer();




    int size = 255;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        nodes.add(new ColorNode(i,j,function));
      }
    }
    ColoredRenderer renderer = new ColoredRenderer(nodes,sizeUsing);
    renderer.animate();
    if (animated) {
      timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
          boolean increasing = function.isIncreasing();
          if (increasing) {
            if (function.getMod() <= 1.5) {
              function.setMod(function.getMod() + .005);
            } else if (function.getMod() > 1.5) {
              function.setMod(function.getMod() - .005);
              function.setIncreasing(false);
            }
          } else {
            if (function.getMod() >= 1) {
              function.setMod(function.getMod() - .005);
            } else if (function.getMod() < 1) {
              function.setMod(function.getMod() + .005);
              function.setIncreasing(true);
            }
          }


          renderer.repaint();
        }
      }, 100, 100);
    }

  }

}
