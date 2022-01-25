//Clarisse Ilibagiza Umulisa
// Program to perform a bounded priority queue using binary heap
import java.util.ArrayList;

public class BoundedPQ<Key extends Comparable<Key>> {
  
  MaxPQ<Key> max = null;
  MinPQ<Key> min = null;
  int a;
  int n = 0;
  
  public BoundedPQ(int bound) { // Construct a BoundedPQ with size bound.
    a = bound;
    max = new MaxPQ<Key>(a);
    min = new MinPQ<Key>(a);
  }
  
  public BoundedPQ(Key[] keys) { // Construct a BoundedPQ from Keys[] keys, keys.length is the bound
    a = keys.length;
    n = a;
    max = new MaxPQ<Key>(keys);
    min = new MinPQ<Key>(keys);
  }
  
  public void insert(Key x) { // Insert a new key. Remove lowest priority key if size bound is exceeded
    max.insert(x);
    min.insert(x);
    if (n < a) {
      this.n++;
    }
    else if (n == a) {
       if (max == null)
        System.out.println("null");
    this.n--;
     max.delItem(min.delMin());
      this.n++;
    }
    else
    return;
  }
  
  public Key delMax() { // Remove the key with highest priority
    if (max == null)
      return null;
    n--;
    return min.delItem(max.delMax());
  }
    
  
  public Key Max() {
    return max.max();
  }
  
  public void merge(BoundedPQ<Key> bpq) { // Merge BoundedPQ<Key> bpq with this
    this.a = this.a + bpq.a;
    int bound = bpq.a;
    ArrayList<Key> k = new ArrayList<Key>();
    for (int i=1; i<=bpq.a; i++) {
      if (bound > 1) {
        k.add(bpq.delMax());
        this.insert(k.get(i-1));
      }
      else if (bound == 1) {
        this.insert(bpq.Max());
      }
      else
        System.out.println(" ");
      bound--;
    }
    while (k.size() > 0) {
      bpq.insert(k.remove(0));
    }
    return;
  }
  
  public String toString() {
    return max.toString(a).substring(7, max.toString(a).length());
  }
}