package weblab.divide_and_conquer;

public class MergeSort {

    /**
     * Takes an array and sorts it in an ascending order. Note that the method is void, so it should
     * sort the input, rather than return a sorted copy.
     *
     * @param arr - the array that needs to be sorted.
     */
    public void sort(int[] arr) {
        mergeSortUtil(arr, 0, arr.length);
    }

    // Recursive function to split the array
    // into two subarrays and sort them
    public static void mergeSortUtil(int[] arr, int left, int right) {

        //base case
        //If size of the array is equal to 1, simply return out of the function.
        if (right - left <= 1) {
            return;
        }

        //otherwise, find middle index
        int mid = left + (right - left) / 2;

        //recursively sort left subarray
        mergeSortUtil(arr, left, mid);

        //recursively sort right subarray
        mergeSortUtil(arr, mid, right);

        //merge the two sorted arrays
        merge(arr, left, mid, right);
    }

    // Function to merge two sorted subarrays
    public static void merge(int[] arr, int left, int mid, int right) {
        //create temp array to store the merged subarray
        int[] temp = new int[right - left];

        //initialize indices for left and right subarray
        int i = left;
        int j = mid;
        int k = 0;

        //merge the two subarrays
        while (i < mid && j < right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        //copy reining elements from left subarray
        while (i < mid) {
            temp[k++] = arr[i++];
        }

        //copy reining elements from left subarray
        while (j < right) {
            temp[k++] = arr[j++];
        }

        //copy the merged subarray back to the original array
        for (i = left, k = 0; i < right; i++, k++) {
            arr[i] = temp[k];
        }
    }
}


/*
     //@param elements Array of integers to be sorted.
     //@return New array of sorted integers.

    public static int[] mergeSort(int[] arr) {
        int n = arr.length;

        //base case, if size is less than 2 then array is sorted
        if (n < 2) return arr;

        int mid = n / 2;

        //split into 2 arrays
        int[] left = Arrays.copyOfRange(arr, 0, mid); //first half
        int[] right = Arrays.copyOfRange(arr, mid, n); // second half

        left = mergeSort(left);
        right = mergeSort(right);


        int[] result = new int[n];
        int i = 0; //pointer for left subarray
        int j = 0; //pointer for right subarray
        int r = 0; //index of final result array

        //sorting by comparision and merging arrays
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[r] = left[i];
                r++;
                i++;
            } else {
                result[r] = right[j];
                r++;
                j++;
            }
        }

        //add remaining elements from both arrays
        while (i < left.length) {
            result[r] = left[i];
            r++;
            i++;
        }
        while (j < right.length) {
            result[r] = right[j];
            r++;
            j++;
        }

        return result;
    }
*/
