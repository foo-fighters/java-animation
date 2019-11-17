import path.Path;
import path.StraightLinePath;

import java.awt.*;

public class MoveBall implements Drawable {

  static final int UP = 1;
  static final int DOWN = 0;
  private int direction = DOWN;

  private Path path;
  private Point position;
  private int number;

  public MoveBall(int direction, int number) {
    this.direction = direction;
    this.number = number;
  }

  /**
   * called each time in the animator loop to draw the object.
   * path is used to calculate the position, and the position is used to draw.
   */
  @Override
  public void draw(Graphics g) {
    if (path != null && path.hasMoreSteps()) {
      position = path.nextPosition();
    } else {
      if (direction == DOWN) {
        // numbers given arbitrarily
        path = new StraightLinePath(410, 410, 10, 10, 20);
        position = path.nextPosition();
        direction = UP;
      } else {
        path = new StraightLinePath(10, 10, 410, 410, 20);
        position = path.nextPosition();
        direction = DOWN;
      }
    }

    g.setColor(Color.red);
    g.fillOval((int) position.getX(), (int) position.getY(), 15, 15);
    g.setColor(Color.black);
    g.drawString("" + number, (int) position.getX() + 3, (int) position.getY() + 12);
  }

}
