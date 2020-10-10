package topic4.item15;

import topic3.item10.PhoneNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Classes and Interfaces only can be Package-Private or Public
 */
public class Accesability {

  /**
   * Fields, methods, nested classes, and nested interfaces can be private, package, protected, public
   */

  private String privateField; // Only in the top-level class where it's declared

  String defaultField; // Any class in the package where it's declared
  // In interfaces the default is public

  protected String protectedField;//Any class in the package where it's declared and subclasses of the class

  public String publicField; //Anywhere

  @Override
  /**
   * It cannot be more restrictive the super class access level
   */
  public int hashCode() {
    return super.hashCode();
  }

  //Potential security hole!
  //Arrays is always mutable
  public static final Object[] VALUES = {};

  //Fix
  private static final PhoneNumber[] PRIVATE_VALUES = {};
  public static final List<PhoneNumber> PUBLIC_VALUES =
          Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
  public static final Object[] values() {
    return PRIVATE_VALUES.clone();
  }
}
