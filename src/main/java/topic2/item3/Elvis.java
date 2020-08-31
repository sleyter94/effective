package topic2.item3;

// Singleton with public final field
//public class Elvis {
//  public static final Elvis INSTANCE = new Elvis();
//
//  /**
//   * a privileged client can invoke the private constructor reflectively
//   * (Item 65) with the aid of the
//   * AccessibleObject.setAccessible method. If you
//   * need to defend against this attack, modify the constructor to make it throw an
//   * exception if it’s asked to create a second instance.
//   */
//  private Elvis() { }
//  public void leaveTheBuilding() { }
//}


// Singleton with static factory
//public class Elvis {
//  private static final Elvis INSTANCE = new Elvis();
//  private Elvis() {  }
//  public static Elvis getInstance() { return INSTANCE; }
//  public void leaveTheBuilding() {  }
//
//  /**
//   * To maintain the singleton guarantee, declare all instance fields
//   * transient and provide a readResolve method (Item 89). Otherwise, each time a
//   * serialized instance is deserialized, a new instance will be created, leading, in the
//   * case of our example, to spurious
//   * Elvis sightings.
//   * @return
//   */
//  private Object readResolve() {
//    return INSTANCE;
//  }
//}
//Enum Singleton - the preferred approach

/**
 * This approach is similar to the public field approach, but it is more concise,
 * provides the serialization machinery for free, and provides an ironclad guarantee
 * against multiple instantiation, even in the face of sophisticated serialization or
 * reflection attacks. This approach may feel a bit unnatural, but a single-element
 * enum type is often the best way to implement a singleton. Note that you can’t
 * use this approach if your singleton must extend a superclass other than
 * Enum
 * (though you can declare an enum to implement interfaces).
 */
public enum Elvis {
  INSTANCE;
  public void leaveTheBuilding() {

  }
}