public class Main {

  public static void main(String args[]) {
    Animator animator = new Animator();
    MoveBall ball = new MoveBall(MoveBall.UP, 1);
    animator.addDrawable(ball);
    animator.setVisible(true);
  }

}
