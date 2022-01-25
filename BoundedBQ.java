//Clarisse Ilibagiza Umulisa
// Program to perform a bounded priority queue using binomial queue
import java.util.ArrayList;

public class BoundedBQ<Key extends Comparable<Key>> {
  MaxBQ<Key> max = null;
  MinBQ<Key> min = null;
  int a;
  int n = 0;
  
  public BoundedBQ(int bound) { // Construct a BoundedBQ with size bound.
    a = bound;
    max = new MaxBQ<Key>();
    min = new MinBQ<Key>();
  }
  public BoundedBQ(Key[] keys) { // Construct a BoundedBQ from Keys[] keys, keys.length is the bound
    a = keys.length;
    max = new MaxBQ<Key>(keys);
    min = new MinBQ<Key>(keys);
  } 
  public void insert(Key x) { // Insert a new key. Remove lowest priority key if size bound is exceeded
    n++;
    if (n <= a) { 
      max.insert(x);
      min.insert(x);
    }
    else {
      n--;
     max.delItem(min.delMin());
      max.insert(x);
      min.insert(x);
    }
    return;
  }
  public Key delMax() { // Remove the key with highest priority
    n--;
    return min.delItem(max.delMax());
  }
  public Key Max() { 
    return max.max();
  }
  
  public void merge(BoundedBQ<Key> bbq) { // Merge BoundedBQ<Key> bbq with this
    this.a += bbq.a;
    int bound = bbq.a;
    ArrayList<Key> k = new ArrayList<Key>();
    for (int i=1; i<=bbq.a; i++) {
      if (bound > 1) {
        k.add(bbq.delMax());
        this.insert(k.get(i-1));
      }
      else if (bound == 1) {
        this.insert(bbq.Max());
      }
      else
      bound--;
    }
    while (k.size() > 0) {
      bbq.insert(k.remove(0));
    }
    return;
  }
  
  public String toString() {
    return max.toString();
  }
}