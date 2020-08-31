package topic2.item2;

import lombok.ToString;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * The Builder pattern is well suited to class hierarchies.
 * the Builder pattern is a good choice when designing classes
 * whose constructors or static factories would have more than a handful of
 * parameters especially if many of the parameters are optional or of identical type.
 * Client code is much easier to read and write with builders than with telescoping
 * constructors, and builders are much safer than JavaBeans.
 */
// Builder pattern for class hierarchies
@ToString
public abstract class Pizza {
  public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
  final Set<Topping> toppings;

  abstract static class Builder<T extends Builder<T>> {
    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
    public T addTopping(Topping topping){
      toppings.add(Objects.requireNonNull(topping));
      return self();
    }

    abstract Pizza build();
    // Subclasses must override this method to return "this"
    protected abstract T self();
  }

  Pizza(Builder<?> builder) {
    toppings = builder.toppings.clone();
  }
}
