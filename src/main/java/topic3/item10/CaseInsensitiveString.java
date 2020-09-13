package topic3.item10;

import java.util.Objects;

// Broken - violates symmetry

/**
 * Override Equals, it comply symmetric, transitive and consistent
 * Write unit test to validate
 */
public class CaseInsensitiveString {
  private final String s;
  public CaseInsensitiveString(String s) {
    this.s = Objects.requireNonNull(s);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof CaseInsensitiveString && ((CaseInsensitiveString) obj).s.equalsIgnoreCase(s);
  }

  public static void main(String[] args) {
    CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
    String s = "polish";
    //Violate symmetry
    System.out.println(cis.equals(s));
    System.out.println(s.equals(cis));
  }


}
