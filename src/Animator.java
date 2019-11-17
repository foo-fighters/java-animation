import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.Vector;

public class Animator extends JPanel implements Runnable {

  Vector elementsToDraw = new Vector();
  int sleepTime = 100;
  boolean animatorStopped = true;
  boolean firstTime = true;
  JFrame animFrame;

  public Animator() {
    animFrame = new JFrame("Generic Animator");
    Container animContainer = animFrame.getContentPane();
    animContainer.add(this);
    animFrame.setSize(700, 450);
    animFrame.setLocation(0, 100);
  }

  /** TODO: implement for display = false.
   * the control thread should be suspended.
   * If display = true, the control thread should be started only the first time.
  */
  public void setVisible(boolean display) {
    if (display) {
      if (firstTime) {
        firstTime = false;
        animFrame.setVisible(true);

        // the animator is on another thread so that the calling object can continue.
        (new Thread(this)).start();
      }
    }
  }

  @Override
  public void run() {
    while(true) {
      try {
        Thread.sleep(sleepTime);
      } catch (InterruptedException e) {
        System.out.println("Program interrupted.");
        System.exit(0);
      }
      repaint();
    }
  }

  /**
   * redraws all objects registered with this animator.
   * the graphics object g is passed onto each object so that they can draw themselves.
   */
  public void paint(Graphics g) {
    super.paint(g);
    Enumeration e = elementsToDraw.elements();
    while (e.hasMoreElements()) {
      ((Drawable) e.nextElement()).draw(g);
    }
  }

  public void addDrawable(Drawable d) {
    elementsToDraw.add(d);
  }

  public void removeDrawable(Drawable d) {
    elementsToDraw.removeElement(d);
  }

}














