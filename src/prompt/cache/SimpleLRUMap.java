package prompt.cache;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * LRU：最近最少使用算法
 * 缓存用SimpleLRUMap
 */
public class SimpleLRUMap extends LinkedHashMap {

  private final int max;
  private Object lock;

  public SimpleLRUMap(int max, Object lock) {
    // 无需扩容
    super((int) (max * 1.4), 0.75f, true);
    this.max = max;
    this.lock = lock;
  }


  /**
   * 重写LinkedHashMap的removeEldestEntry方法即可
   *
   * 在Put的时候判断，如果为true，就会删除最老的
   */
  @Override
  protected boolean removeEldestEntry(Entry eldest) {
    return size() > max;
  }

  public Object getValue(Object key) {
    synchronized (lock) {
      return get(key);
    }
  }

  public void setValue(Object key, Object value) {
    synchronized (lock) {
      put(key, value);
    }
  }

  public boolean removeValue(Object key) {
    synchronized (lock) {
      return remove(key) != null;
    }
  }

  public boolean removeAll() {
    clear();
    return true;
  }
}
