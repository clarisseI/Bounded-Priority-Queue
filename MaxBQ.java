import java.util.ArrayList;

public class MaxBQ<Key extends Comparable<Key>> {
  
  private class Power2Heap {
    Key val; // value of root
    ArrayList<Power2Heap> children; // children Power2Heaps, stored in increasing order by size.
    
    public Power2Heap(Key val) {
      this.val = val;
      children = new ArrayList<Power2Heap>();
    }
    
    public String toString() {
      String s = "(" + val + "";
      for(Power2Heap h : children)
        s += " " + h;
      return s + ")";
    }
    
    public Power2Heap merge(Power2Heap a) {
      if(val.compareTo(a.val) >= 0) {
        children.add(a);
        return this;
      }
      else {
        a.children.add(this);
        return a;
      }
    }
  }
  
  private ArrayList<Power2Heap> heaps;
  
  public MaxBQ() {
    heaps = new ArrayList<Power2Heap>();
  }
  
  public MaxBQ(Key val) {
    this();
    heaps.add(new Power2Heap(val));
  }
  
  public MaxBQ(Key[] keys) {
    this();
    for(Key k : keys)
      insert(k);
  }
  
  public MaxBQ(ArrayList<Power2Heap> heaps) {
    this.heaps = heaps;
  }
  
  public String toString() { return heaps.toString(); }
  
  public boolean isEmpty() { return heaps.isEmpty(); }
  
  public void insert(Key val) {
    MaxBQ<Key> bq2 = new MaxBQ<Key>(val);
    heaps = merge(heaps, bq2.heaps);
  }
  
  public Key max() {
    // Assume this not empty.
    int max = 0; // Find heap with max value.
    for(int i=1; i<heaps.size(); i++)
      if(heaps.get(max) == null || (heaps.get(i) != null && heaps.get(i).val.compareTo(heaps.get(max).val) > 0))
      max = i;
    Key val = heaps.get(max).val;
    return val;
  }
  
  public Key delMax() {
    // Assume this not empty.
    int max = 0; // Find heap with max value.
    for(int i=1; i<heaps.size(); i++)
      if(heaps.get(max) == null || (heaps.get(i) != null && heaps.get(i).val.compareTo(heaps.get(max).val) > 0))
      max = i;
    Key val = heaps.get(max).val;
    ArrayList<Power2Heap> heaps2 = heaps.get(max).children;
    heaps.remove(max);
    heaps = merge(heaps, heaps2);
    return val;
  }
  
  public Key delItem(Key x) {
    // Assume this not empty.
    int place = 0; // Find heap with max value.
    for(int i=1; i<heaps.size(); i++)
      if(heaps.get(place) == null || (heaps.get(i) != null && heaps.get(i).val.compareTo(x) == 0))
      place = i;
    Key val = heaps.get(place).val;
    ArrayList<Power2Heap> heaps2 = heaps.get(place).children;
    heaps.remove(place);
    heaps = merge(heaps, heaps2);
    return val;
  }
  
  public MaxBQ<Key> merge(MaxBQ<Key> a) {
    return new MaxBQ<Key>(merge(heaps, a.heaps));
  }
  
  public ArrayList<Power2Heap> merge(ArrayList<Power2Heap> a, ArrayList<Power2Heap> b) {
    ArrayList<Power2Heap> c = new ArrayList<Power2Heap>();
    Power2Heap carry = null;
    int i;
    for(i=0; i<a.size() && i<b.size(); i++)
      if(carry == null) {
      if(a.get(i) != null && b.get(i) != null) {
        carry = a.get(i).merge(b.get(i));
        c.add(null);
      }
      else if(a.get(i) != null || b.get(i) != null)
        c.add(a.get(i) != null ? a.get(i) : b.get(i));
      else
        c.add(null);
    }
    else { // carry != null
      if(a.get(i) != null && b.get(i) != null) {
        c.add(carry);
        carry = a.get(i).merge(b.get(i));
      }
      else if(a.get(i) != null || b.get(i) != null) {
        carry = carry.merge(a.get(i) != null ? a.get(i) : b.get(i));
        c.add(null);
      }
      else {
        c.add(carry);
        carry = null;
      }
    }
    for(; i<a.size(); i++)
      if(carry == null)
      c.add(a.get(i));
    else if(a.get(i) != null) {
      carry = carry.merge(a.get(i));
      c.add(null);
    }
    else {
      c.add(carry);
      carry = null;
    }
    for(; i<b.size(); i++)
      if(carry == null)
      c.add(b.get(i));
    else if(b.get(i) != null) {
      carry = carry.merge(b.get(i));
      c.add(null);
    }
    else {
      c.add(carry);
      carry = null;
    }
    if(carry != null)
      c.add(carry);
    return c;
  }
}