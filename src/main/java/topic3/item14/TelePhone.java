package topic3.item14;

import topic3.item10.PhoneNumber;

import java.util.Comparator;

public class TelePhone extends PhoneNumber implements Comparable<PhoneNumber> {

  // Comparable with comparator construction methods
  private static final Comparator<PhoneNumber> COMPARATOR = Comparator.comparing((PhoneNumber pn) -> pn.getAreaCode())
          .thenComparingInt(pn -> pn.getPrefix()).thenComparingInt(pn -> pn.getLineNum());

  public TelePhone(short areaCode, short prefix, short lineNum) {
    super(areaCode, prefix, lineNum);
  }

  @Override
  // Multiple-field Comparable with primitive fields
  public int compareTo(PhoneNumber pn) {
    int result = Short.compare(this.getAreaCode(), pn.getAreaCode());
    if (result == 0)  {
      result = Short.compare(this.getPrefix(), pn.getPrefix());
      if (result == 0)
        result = Short.compare(this.getLineNum(), pn.getLineNum());
    }
    return result;

    //return COMPARATOR.compare(this, pn);
  }

  //BROKEN difference-based comparator - violates transitivity!
  //It can be overflowed
  static Comparator<Object> hashCodeOrder = new Comparator<Object>() {
    @Override
    public int compare(Object o1, Object o2) {
      return o1.hashCode() - o2.hashCode();
    }
  };

  static Comparator<Object> hashCodeOrderWell = new Comparator<Object>() {
    @Override
    public int compare(Object o1, Object o2) {
      return Integer.compare(o1.hashCode(), o2.hashCode());
    }
  };

  static Comparator<Object> hashCodeOrderConstruction = Comparator.comparingInt(Object::hashCode);


}
