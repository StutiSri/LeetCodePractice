public class MergeTwoUnsortedArray {
    public int[] mergeArrays(int[] L, int[] R) {
        int[] ints = new int[L.length + R.length];
        mergeInto(ints, L, L.length, R, R.length, 0);
        mergeSort(ints, 0, ints.length - 1);
        return ints;
    }

    private void mergeSort(int[] ints, int l, int r) {
        if (r <= l) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(ints, l, mid);
        mergeSort(ints, mid + 1, r);
        merge(ints, l, mid, r);
    }

    private void merge(int[] ints, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = ints[l + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = ints[mid + 1 + i];
        }

        mergeInto(ints, L, n1, R, n2, l);
    }

    private void    mergeInto(int[] ints, int[] l, int lengthL, int[] r, int lengthR, int k) {
        int i = 0;
        int j = 0;
        while (i < lengthL && j < lengthR) {
            if (l[i] <= r[j]) {
                ints[k] = l[i];
                i++;
            } else {
                ints[k] = r[j];
                j++;
            }
            k++;
        }
        while (i < lengthL) {
            ints[k] = l[i];
            i++;
            k++;
        }
        while (j < lengthR) {
            ints[k] = r[j];
            j++;
            k++;
        }
    }
}
