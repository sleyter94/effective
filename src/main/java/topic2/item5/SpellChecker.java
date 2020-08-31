package topic2.item5;

//// Inappropriate use of static utility - inflexible & untestable!
//public class SpellChecker {
//  private static final Lexicon dictionary = ...;
//  private SpellChecker() {} // Noninstantiable
//  public static boolean isValid(String word) { ... }
//  public static List<String> suggestions(String typo) { ... }
//}


import java.util.Collections;
import java.util.List;
import java.util.Objects;

//// Inappropriate use of singleton - inflexible & untestable!
//public class SpellChecker {
//  private final Lexicon dictionary = ...;
//  private SpellChecker(...) {}
//  public static INSTANCE = new SpellChecker(...);
//  public boolean isValid(String word) { ... }
//  public List<String> suggestions(String typo) { ... }
//}

// Dependency injection provides flexibility and testability
public class SpellChecker {

//  private final Lexicon dictionary;
//
//  public SpellChecker(Lexicon dictionary) {
//    this.dictionary = Objects.requireNonNull<Lexicon>(dictionary);
//  }

  public boolean isValid(String word) {
    return false;
  }

  public List<String> suggestions(String typo) {
    return Collections.emptyList();
  }

}