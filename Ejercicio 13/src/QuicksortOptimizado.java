import java.util.Arrays;

public class QuicksortOptimizado {

    public static void main(String[] args) {
        int[] arr = {12, 4, 5, 6, 7, 3, 1, 15, 10, 9, 8, 2};
        System.out.println("Array original: " + Arrays.toString(arr));
        quicksort(arr, 0, arr.length - 1);
        System.out.println("Array ordenado: " + Arrays.toString(arr));
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            // Optimización: Usar Insertion Sort para pequeñas sub-arrays
            if (high - low + 1 <= 10) {
                insertionSort(arr, low, high);
                return;
            }
            int pivotIndex = partition(arr, low, high);
            quicksort(arr, low, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
