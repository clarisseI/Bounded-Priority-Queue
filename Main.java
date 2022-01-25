//Clarisse Ilibagiza Umulisa
//main program to test boundedBQ and PQ 

public class Main {
  public static void main(String[] args) {
    
    System.out.println("\nBOUNDED BQ:");    
    BoundedBQ<Integer> try1 = new BoundedBQ<Integer>(4);
    try1.insert(6);
    System.out.println(" 6 is inserted = " + try1);
    try1.insert(10);
    System.out.println("10 is inserted = " + try1);
    try1.insert(3);
    System.out.println(" 3 is inserted= " + try1);
    try1.insert(5);
    System.out.println(" 5 is inserted = " + try1);
    try1.insert(9);
    System.out.println(" 9 is inserted = " + try1);
    try1.delMax();
    System.out.println(" max is deleted= " + try1);
    try1.insert(7);
    System.out.println(" 7 is inserted = " + try1);
    
    Integer[] x = {4, 1, 6, 2, 8, 0};
    BoundedBQ<Integer> try2 = new BoundedBQ<Integer>(x);
    System.out.println("try2 = " + try2);
    try1.merge(try2);
    System.out.println(" merging try1 and try2 = " + try1);
    System.out.println("merging try2 into try 1= " + try2);
    
    System.out.println("BOUNDED PQ:");   
    BoundedPQ<Integer> try3 = new BoundedPQ<Integer>(3);
    try3.insert(5);
    System.out.println(" 5 is inserted= " + try3);
    try3.insert(1);
    System.out.println("1 is inserted= " + try3);
    try3.insert(10);
    System.out.println(" 10 is inserted= " + try3);
    try3.insert(3);
    System.out.println(" 3 is inserted = " + try3);
    try3.delMax();
    System.out.println(" max is deleted =" + try3);
    try3.insert(6);
    System.out.println(" 6 is inserted =" + try3);
    
    Integer[] y = {1, 5, 2, 3, 8, 10};
    BoundedPQ<Integer> try4 = new BoundedPQ<Integer>(y);
    System.out.println("try4 = " + try4);
    
    try3.merge(try4);
    System.out.println("merging try3 into try4 = " + try3);
    System.out.println(" merging try4 into try3 =" + try4);
  
    
   
  }
}