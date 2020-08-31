package topic2.item8;

import java.lang.ref.Cleaner;

/**
 * In summary, don’t use cleaners, or in releases prior to Java 9, finalizers,
 * except as a safety net or to terminate noncritical native resources. Even then,
 * beware the indeterminacy and performance consequences.
 */
// An autocloseable class using a cleaner as a safety net
public class Room implements AutoCloseable {
  private static final Cleaner cleaner = Cleaner.create();

  // Resource that requires cleaning. Must not refer to Room!
  private static class State implements Runnable
  {
    int numJunkPiles;
    State(int numJunkPiles){
      this.numJunkPiles = numJunkPiles;
    }


    @Override
    public void run() {
      System.out.println("Cleaning Room");
      numJunkPiles = 0;
    }
  }

  // The state of this room, shared with our cleanable
  private final State state;
  // Our cleanable. Cleans the room when it’s eligible for gc
  private final Cleaner.Cleanable cleanable;
  public Room(int numJunkPiles) {
    state = new State(numJunkPiles);
    cleanable = cleaner.register(this, state);
  }
  @Override public void close() {
    cleanable.clean();
  }

}
