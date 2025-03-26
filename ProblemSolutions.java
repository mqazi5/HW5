/******************************************************************
 *
 *   YOUR NAME / SECTION NUMBER
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE

        HashSet <Integer> subset = new HashSet<>(); //hash table to store the subset

        //for loop that iterates through list1 array and adds each element to the subset hashtable 
        for(int i = 0; i < list1.length; i++) {
            subset.add(list1[i]);
        }

        // for loop that checks if the elemts of the second araya re present in the first array 
        // returns false if they are not and if all elemetns are present then return true
        for (int i = 0; i < list2.length; i++) {
            if (!subset.contains(list2[i])) {
                return false;
            }
        }



        return true;

    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //minHeap prioroty queue to store the elements in the arary

        //for lop that iterates through the array and adds the i-th element to the minheap priority queue
        for (int i = 0; i < array.length; i++) {
            minHeap.add(array[i]);
            
            //if statement that checks if the size of the minHeao has excceded k 
            //if it has then it takes out the smallest element from the heap leaving only the 4 largest elements in the array 
            //inside the heap
            if(minHeap.size() > k) {
                minHeap.poll();
            }

        }

        return minHeap.peek(); // returns the root of the minHeap which is the kth largest element in the array

    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOU CODE HERE

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // minHeap that holds all the elemetns in array1 and 2

        //for loop adding all the elements in array1 into the minheap
        for(int i = 0; i < array1.length; i++) {
            minHeap.add(array1[i]);
        }

        //for loop adding all the elements in array 2 to the minheap
        for(int i = 0; i < array2.length; i++) {
            minHeap.add(array2[i]);
        }

        int[] sorted = new int[array1.length + array2.length]; //array to hold the sorted array

        //for loop that inserts the elements if the minheap one by one taking the smallest number off the top and adding
        //it into the array
        for( int i = 0; i < sorted.length; i++) {
            sorted[i] = minHeap.poll();
        }

        return sorted;
    }

}
