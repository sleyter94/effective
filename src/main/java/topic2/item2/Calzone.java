package topic2.item2;

import lombok.ToString;

@ToString
public class Calzone extends Pizza {
  private boolean sauceInside;

  public static class Builder extends Pizza.Builder<Builder> {
    private boolean sauceInside = false; //Default
    public Builder sauceInside(){
      sauceInside = true;
      return this;
    }

    @Override
    Calzone build() {
      return new Calzone(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }


  Calzone(Builder builder) {
    super(builder);
    sauceInside = builder.sauceInside;
  }

  public static void main(String[] args) {
    Calzone calzone = new Calzone.Builder().addTopping(Topping.HAM).sauceInside().build();
    NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Topping.SAUSAGE).addTopping(Topping.ONION).build();
    System.out.println(calzone);
    System.out.println(pizza);
  }
}
