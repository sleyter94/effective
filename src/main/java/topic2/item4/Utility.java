package topic2.item4;

/**
 * Such utility classes were not designed to be instantiated: an instance would be
 * nonsensical. In the absence of explicit constructors, however, the compiler provides
 * a public, parameter less default constructor.
 */
//Noninstatiable utility class
public class Utility {

  private Utility(){
    throw new AssertionError();
  }
}
