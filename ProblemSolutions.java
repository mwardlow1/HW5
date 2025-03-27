/******************************************************************
 *
 *   Michael Wardlow / 001
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

        // Add the elements of list1 to a HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int num : list1) {
            set.add(num);
        }


        // Check if all elements of list2 are in the HasSet
        for (int num : list2) {
            if (!set.contains(num)) {
                return false;       // if any elements aren't found, B is not a subset
            }
        }

        return true;        // True since all elements of B are found in A
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

        // Creating a min-Heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Adding elements to the heap
        for (int num : array) {
            minHeap.offer(num);


            // Removing the smallest element once size exceeds k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Return the root, as it is the kth largest element
        return minHeap.peek();
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


        // Create a new array to hold all the elements
        int[] mergedArray = new int[array1.length + array2.length];

        // Copy both arrays A and B into the mergedArray
        System.arraycopy(array1, 0, mergedArray, 0, array1.length);
        System.arraycopy(array2, 0, mergedArray, array1.length, array2.length);

        // Sort the merged array
        Arrays.sort(mergedArray);

        return mergedArray;     // Returns the sorted array with all elements in A and B
    }

}
