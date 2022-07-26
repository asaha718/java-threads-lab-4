public class Counter {

  long count = 0;

  public synchronized void inc() {
      count++;
  }

  public long getCount() {
      return count;
  }
}