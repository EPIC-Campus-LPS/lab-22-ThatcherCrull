import java.util.Arrays;

class RadixSort {
    // Method to get the maximum length of strings in the array
    public static int getMaxLength(String[] arr, int n) {
        int max = arr[0].length();
        for (int i = 1; i < n; i++) {
            if (arr[i].length() > max) {
                max = arr[i].length();
            }
        }
        return max;
    }

    // Counting sort for a specific character position (case-insensitive)
    public static void countSort(String[] arr, int n, int pos) {
        String[] output = new String[n];
        int[] count = new int[256]; // Assuming ASCII characters; adjust if needed for Unicode
        Arrays.fill(count, 0);

        // Count occurrences of each character at position 'pos' (using lower case for case-insensitivity)
        for (int i = 0; i < n; i++) {
            char c = (pos < arr[i].length()) ? Character.toLowerCase(arr[i].charAt(pos)) : '\0'; // '\0' for shorter strings
            count[c]++;
        }

        // Compute cumulative counts
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            char c = (pos < arr[i].length()) ? Character.toLowerCase(arr[i].charAt(pos)) : '\0';
            output[count[c] - 1] = arr[i];
            count[c]--;
        }

        // Copy output back to arr
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // LSD Radix Sort for strings (case-insensitive alphabetical order)
    public static void radixSort(String[] arr, int n) {
        if (n == 0) return;
        int maxLen = getMaxLength(arr, n);

        // Sort from least significant digit (rightmost character) to most
        for (int pos = maxLen - 1; pos >= 0; pos--) {
            countSort(arr, n, pos);
        }
    }
}