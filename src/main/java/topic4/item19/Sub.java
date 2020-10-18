package topic4.item19;

import java.time.Instant;

public class Sub extends Super {

  private final Instant instant;

  Sub() {
    System.out.println("call 2");
    instant = Instant.now();
  }

  @Override
  public void overrideMe() {
    System.out.println(instant);
  }

  public static void main(String[] args) {
    Sub sub = new Sub();
    sub.overrideMe();
  }
}
