package topic3.item14;

/**
 * Use of the relational operators
 * < and > in compareTo methods is
 * verbose and error-prone and no longer recommended.
 */
public class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {

  String s;

  @Override
  public int compareTo(CaseInsensitiveString o) {
    return String.CASE_INSENSITIVE_ORDER.compare(s, o.s);
  }
}
