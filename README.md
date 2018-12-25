# Data Structure (Java)

## 1. Integral Image & Maximum Value Stack 

#### Integral Image
Images will be stored in 2D arrays. We will follow the convention that the first index of the array indicates the row number (vertical position and the second index indicates the column number (horizontal position). Vertical position is indexed from the top down, and horizontal position is indexed from left to right. Thus image[0][0] is the top left pixel of the image.

#### Maximum Value Stack

A new class MaxStack that specializes the java.util.Stack class to Comparable objects and provides a new method max() that will return the maximum value on the stack in O(1) time. In order to provide this functionality you will have to define some new private instance variables, provide a constructor for MaxStack (with no parameters), override methods push(e) and pop(), and implement the method max().

## 2. Pair Sum & Emergency Ward Triage

#### Pair Sum

The class SortedIntegerArray contains a sorted representation of an array of integers. You are to implement a method kPairSum, that uses a recursive algorithm to determine whether the array contains two elements that sum to a given integer k, returning true if it does, false if it does not. The method should run in O(n) time, where n is the number of integers in the array.

#### Emergency Ward Triage

The implementation of a system to triage patients in a hospital emergency ward. Patients are triaged according to both medical priority and wait time. Priorities are positive integers; the highest priority is 1. Normally patients are seen in priority order. However, if there are patients who have waited longer than a specified time (maxWait), they are seen first, in order of their arrival.

## 3. BST & Double Hashing

#### Range in BST

Extend theTreeMap class of the net.datastructures package to allow all entries within a range of key values [k1...k2] to be found and returned as an iterable list. It is trivial to do this in O(n) time using the entries() method of the BinarySearchTree class, which returns an iterable collection of all the entries in the tree. However, this implementation run in O(h + m) time, where h is the height of the tree and m is the number of entries in the tree with keys in the specified range.
- `findLowestCommonAncestor`, which returns the lowest position in a subtree that is a common
ancestor to all positions with keys between k1 and k2.
- `findAllAbove`, which finds all entries with keys greater than or equal to a specified key k, in
increasing order
- `findAllBelow`, which finds all entries with keys less than or equal to a specified key k, in
increasing order

#### Double Hashing

Extend ProbeHashMap() in the book *"Data Structures and Algorithms in Java"* to use double hashing with three methods: 
- `resize(newCap)`, which resizes and rehashes the map
- `findSlot(h1, k)`, which finds the location of the entry with key k or, if such an entry does not exist, returns the location where a new entry with key k should be stored
- `secondaryHashValue(k)`, which computes the secondary hash value for key k

## 4. Sorting & Depth-First Search

#### Sorting

In total, this implements three methods for sorting an array in non-decreasing order:
- `heapSort(a)` sorts the Integer array a, returning the result in a.
- `mergeSort(a,p,q)` sorts the Integer subarray a[p…q], returning the result.
- `merge(a,b)` merges the two input Integer arrays a and b and returns the result.

#### Depth-First Search

A natural choice is a directed graph.
- Each vertex represents a course.
- Each directed edge represents a prerequisite
- A directed edge from Course U to Course V means that Course U must be taken before Course V.

This method will use a depth-first-search algorithm (also provided) that can be used to prevent the addition of prerequisites that introduce cycles.