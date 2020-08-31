package topic2.item1;

public class StaticFactory {

  /**
   * A class can provide a public static factory method, which is
   * simply a static method that returns an instance of the class. Here’s a simple
   * example from
   * One advantage of static factory methods is that, unlike constructors, they
   * have names.
   * A second advantage of static factory methods is that, unlike constructors,
   * they are not required to create a new object each time they’re invoked.
   * A third advantage of static factory methods is that, unlike constructors,
   * they can return an object of any subtype of their return type.
   * A fourth advantage of static factories is that the class of the returned
   * object can vary from call to call as a function of the input parameters.
   * The main limitation of providing only static factory methods is that
   * classes without public or protected constructors cannot be subclassed.
   * A second shortcoming of static factory methods is that they are hard for
   * programmers to find.
   * Boolean
   * @param b
   * @return Boolean
   */
  public static Boolean valueOf(boolean b) {
    return b ? Boolean.TRUE: Boolean.FALSE;
  }
}
