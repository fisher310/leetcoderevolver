package others;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedRect extends Frame {
  public RedRect() {
    super("RedRect");
    addWindowListener(
            new WindowAdapter() {
              @Override
              public void windowClosing(WindowEvent e) {
                System.exit(0);
              }
            });
    setSize(200, 100);
    add("Center", new CvRedRect());
    pack();
    setVisible(true);
  }

  public static void main(String[] args) {
    new RedRect();
  }
}

class CvRedRect extends Canvas {
  @Override
  public void paint(Graphics g) {
    Dimension d = getSize();
    int maxX = d.width - 1;
    int maxY = d.height - 1;
    g.drawString("d.width=" + d.width, 10, 30);
    g.drawString("d.height=" + d.height, 10, 60);
    g.setColor(Color.RED);
    g.drawRect(0, 0, maxX, maxY);
  }
}
