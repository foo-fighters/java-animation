package path;

import java.awt.*;

public class StraightLinePath implements Path {

  int startX, startY, endX, endY, steps;
  int currentStep = -1;
  double deltaX, deltaY;

  public StraightLinePath(int startX, int startY, int endX, int endY, int steps) {
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
    this.steps = steps;
    deltaX = ((double) endX - startX) / steps;
    deltaY = ((double) endY - startY) / steps;
  }

  @Override
  public boolean hasMoreSteps() {
    return currentStep <= steps;
  }

  @Override
  public Point nextPosition() {
    currentStep++;
    if (!hasMoreSteps()) {
      return new Point(endX, endY);
    } else {
      int newX = (int) (startX + (deltaX * currentStep));
      int newY = (int) (startY + (deltaY * currentStep));
      return new Point(newX, newY);
    }
  }

}
