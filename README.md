# Threads Lab 4

## Instructions

You are given the following `Counter` class:

```java
class Counter {

    long count = 0;

    public void inc() {
        count++;
    }

    public long getCount() {
        return count;
    }
}
```

We are running this code in our `main` method:

```java
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> IntStream.range(0, 10_000_000).forEach((i) -> counter.inc()));
        Thread t2 = new Thread(() -> IntStream.range(0, 30_000_000).forEach((i) -> counter.inc()));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getCount());
    }
}
```

We are using two threads, `t1` and `t2`, to increment the `count` value of the
same `Counter` instance. If you run this code, it will give the wrong answer
most of the time.

Fix the `Counter` class code to make sure the `main` method always print
`40000000`.
