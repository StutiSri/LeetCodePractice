public class MergeSortedArrays {
    /**
     *
     * @param arr1 - The first of the sorted arrays
     * @param arr2 - The first of the sorted arrays
     * @return - Returns the sorted array which is the output of merging the first and the second array
     */
    public int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] mergedArr = new int[n + m]; //The length of the merged array would be equal to the sum of the lengths of the two arrays

        /*
         * Using the merge mechanism used in merge sort to merge two sorted arrays for merging the two arrays
         */
        int i = 0;
        int j = 0;
        int k = 0;
        //Iterate till we reach the end in either of the arrays
        while (i < n && j < m) {
            /*
             * If the element in first array at position i is less than the element at j position in second array, in order to maintain the natural order
             * the smaller element should be placed first in the merged array. The index for the element which is greater would be kept the same
             * till a number greater than itself is found in the other array, enabling it to have a place in the merged array.
             */
            if (arr1[i] < arr2[j]) {
                mergedArr[k] = arr1[i];
                i++;
            } else {
                mergedArr[k] = arr2[j];
                j++;
                ;
            }
            k++;
        }
        /*
         * Once we have reached the end in either of the arrays, we now need to append the remaining elements from the array that did not reach its limit yet
         * to the merged array. As these elements are already sorted and since they were not yet inserted into the
         * merged array they are definitely grater than the last insertion in the merged array and hence can be inserted directly without requiring any further
         * processing
         */
        while (i < n) {
            mergedArr[k++] = arr1[i++];
        }

        while (j < m) {
            mergedArr[k++] = arr2[j++];
        }

        return mergedArr;
    }

    public static void main(String[] args) {
        mergeArrays(new int[]{1, 2, 3}, new int[]{1, 2, 3});

        mergeArrays(new int[]{1, 2, 3}, new int[]{2, 4, 6});

        mergeArrays(new int[]{1, 2, 3, 4}, new int[]{2, 4, 6});

        mergeArrays(new int[]{}, new int[]{});

        mergeArrays(new int[]{1, 2, 3, 5, 6}, new int[]{4});

        mergeArrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{10});

        mergeArrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{10, 12, 13, 14, 15, 16});

        mergeArrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6});
    }

    private static void mergeArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new MergeSortedArrays().merge(arr1, arr2);
        for (int value : mergedArray) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}



