package topic2.item6;


import java.util.regex.Pattern;

// Reusing expensive object for improved performance
public class RomanNumerals {

  private static final Pattern ROMAN = Pattern.compile(
          "^(?=.)M*(C[MD]|D?C{0,3})"
                  + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

  //It takes 0.17 µs
  static boolean isRomanNumeral(String s) {
    return ROMAN.matcher(s).matches();
  }

  /**
   * While String.matches is the easiest way to check if a string matches
   * a regular expression, it’s not suitable for repeated use in performance-critical
   * situations.
   * @param s
   * @return
   */
  // Performance can be greatly improved!
  //It takes 1.1 µs
  static boolean isRomanNumeralLow(String s) {
    return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
  }

  /**
   * Autoboxing blurs but does not erase the distinction
   * between primitive and boxed primitive types.
   * Lesson: prefer primitives to
   * boxed primitives, and watch out for unintentional autoboxing.
   */
  // Hideously slow! Can you spot the object creation?

  private static long sum() {
    Long sum = 0L;
    for (long i = 0; i <= Integer.MAX_VALUE; i++)
      sum += i;
    return sum;
  }
}
