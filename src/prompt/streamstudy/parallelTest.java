package prompt.streamstudy;

import java.util.function.LongConsumer;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 使用并行流进行处理
 * 对集合对象调用parallelStream方法或者对顺序流调用parallel方法来生成并行流
 * 使用流 应该注意以下几点
 *  留意拆装箱成本；
 *  流中依赖于元素顺序的操作，在并行流上执行的代价非常大；
 *  考虑流的流水线操作总成本，对于较小的数据量，并不适合使用并行流；
 *  考虑流背后的数据结构是否易于分解，不易分解的数据结构不适合使用并行流。
 */
public class parallelTest {

  public static void main(String[] args) {
    // parallelTest.test((n) -> LongStream.rangeClosed(1L, n).reduce(0L, Long::sum), 1000000000L);
    // parallelTest.test((n) -> LongStream.rangeClosed(1L, n).parallel().reduce(0L, Long::sum), 1000000000L);

    parallelTest.test((n) -> Stream.iterate(1L, a -> a + 1L).limit(n).reduce(0L, Long::sum), 1000000000L);
    parallelTest.test((n) -> LongStream.rangeClosed(1L, n).parallel().reduce(0L, Long::sum), 1000000000L);

  }

  static void test(LongConsumer c, Long n) {
    long start = System.currentTimeMillis();
    c.accept(n);
    long end = System.currentTimeMillis();
    System.out.println("处理时间：" + (end - start) + "msc");
  }
}
