import java.util.ArrayList;

public class MaxPQ<Key extends Comparable<Key>> {
  
  private ArrayList<Key> pq;
  
  private int N = 0;
  
  public MaxPQ(int cap) {
    pq = new ArrayList<Key>(cap + 1);
    pq.add(null);
  }
  
  public MaxPQ() { this(1); }
  
  public MaxPQ(Key[] keys) {
    this(keys.length);
    N = keys.length;
    for (int i = 0; i < N; i++)
      pq.add(keys[i]);
    for (int k = N/2; k >= 1; k--)
      sink(k);
  }
  
  private void swap(ArrayList<Key> pq, int i, int j) {
    Key t = pq.get(i);
    pq.set(i,pq.get(j));
    pq.set(j,t);
  }
  
  private void swim(int k) {
    Key x = pq.get(k);
    while (k > 1 && pq.get(k/2).compareTo(x) < 0) {
      pq.set(k, pq.get(k/2));
      k = k/2;
    }
    pq.set(k, x);
  }
  
  private void sink(int k) {
    Key x = pq.get(k);
    while (2*k <= N) {
      int j = 2*k;
      if (j<N && pq.get(j).compareTo(pq.get(j+1))<0)
        j++;
      if (x.compareTo(pq.get(j)) >= 0) break;
      pq.set(k, pq.get(j));
      k = j;
    }
    pq.set(k, x);
  }
  
  public boolean isEmpty() { return N == 0; }
  
  public int size() { return N; }
  
  public Key max() { return pq.get(1);}
  
  public void insert(Key x) {
    N++;
    pq.add(x);
    swim(N);
  }
  
  public Key delItem(Key k) {
    for (int i=1; i<pq.size(); i++) {
      if (k == pq.get(i)) {
        pq.remove(i);
        if (i == 1) {
          sink(1);
        }
        N--;
        return k;
      }
    }
    return null;
  }
  
  public Key delMax() {
    Key max = pq.get(1);
    swap(pq, 1, N--);
    sink(1);
    pq.remove(N+1);
    return max;
  }
  
  public String toString(int s) { //turn the first s items into a String
    return pq.toString();
  }
}