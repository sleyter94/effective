package topic3.item10;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@AllArgsConstructor
@Slf4j
@Setter
public class PhoneNumber {

  private short areaCode, prefix, lineNum;

  private static final short rangeCheck(int val, int max, String arg) {
    if( val < 0 || val > max) throw new IllegalArgumentException(arg + ": " + val);
    return (short) val;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof PhoneNumber)) return false;
    PhoneNumber pn = (PhoneNumber) obj;
    return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
  }

  // Typical hashCode method
  @Override public int hashCode() {
    int result = Short.hashCode(areaCode);
    result = 31 * result + Short.hashCode(prefix);
    result = 31 * result + Short.hashCode(lineNum);
    return result;
  }

  // One-line hashCode method - mediocre performance
  /*
  @Override public int hashCode() {
    return Objects.hash(lineNum, prefix, areaCode);
  }
  */

  /**
   * If a class is immutable and the cost of computing the hash code is significant,
   * you might consider caching the hash code in the object rather than recalculating it
   * each time it is requested. If you believe that most objects of this type will be used
   * as hash keys, then you should calculate the hash code when the instance is created.
   */
  // hashCode method with lazily initialized cached hash code
  /*
  private int hashCode; // Automatically initialized to 0
  @Override public int hashCode() {
    int result = hashCode;
    if (result == 0) {
    }
    result = Short.hashCode(areaCode);
    result = 31 * result + Short.hashCode(prefix);
    result = 31 * result + Short.hashCode(lineNum);
    hashCode = result;
    return result;
  }
   */

  @Override public String toString() {

    return String.format("%03d-%03d-%04d",
            areaCode, prefix, lineNum);
  }

  public static void main(String[] args) {
    PhoneNumber pn1 = new PhoneNumber((short)1,(short)1,(short)957);
    PhoneNumber pn2 = new PhoneNumber((short)1,(short)1,(short)956);
    log.debug("pn1 compare with pn2 {}",pn1.equals(pn2));
    log.debug("pn1 hashcode {} pn2 hashcode {}",pn1.hashCode(), pn2.hashCode());
    log.debug("pn1 string {} pn2 string {}", pn1.toString(), pn2.toString());
    pn2.setLineNum((short)957);
    log.debug("pn1 compare with pn2 after change {}",pn1.equals(pn2));
    log.debug("pn1 hashcode {} pn2 hashcode {}",Integer.toHexString(pn1.hashCode()), Integer.toHexString(pn2.hashCode()));
    log.debug("pn1 string {} pn2 string {}", pn1.toString(), pn2.toString());

  }
}
