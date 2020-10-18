package topic4.item19;

/**
 * Sequence is
 * Constructor Super Class calls first, then sub class constructor
 */
public class Super {
  
  public Super() {
    //Broken - constructor invokes an overridable method
    System.out.println("call 1");
    overrideMe();
  }

  public void overrideMe() {
  }


}
