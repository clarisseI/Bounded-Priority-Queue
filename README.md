## Bounded-Priority-Queue

#### Uses: Priority Queue, Binary Heap, Binomial Queue, BST

A bounded priority queue is one which has a maximum number of elements, say n. If the priority already has n elements, and a new element is added, then the element with lowest priority is removed from the queue to maintain the limit of n elements. If the priority queue has fewer than n elements, then adding a element is done in the same way as for a regular priority queue. Ties for the lowest priority element are broken arbitrarily. Removing the element with highest priority is the same as for a regular priority queue. 
For this assignment, you are to efficiently implement a bounded priority queue in two different ways, that is, use two different data structures for the bounded priority queue. In addition, the merge operation should be implemented. The obvious choices are to use a binary heap, a binomial queue, or a binary search tree. The class should be generic and should contain the following constructors and methods. 
