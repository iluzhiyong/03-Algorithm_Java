import java.util.Arrays;

public class MyQuickSort {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    public static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }

    public static void quickSortSingle(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = partitionSingle(arr, startIndex, endIndex);
        quickSortSingle(arr, startIndex, pivotIndex - 1);
        quickSortSingle(arr, pivotIndex + 1, endIndex);
    }

    public static int partitionSingle(int[] arr,  int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex+1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(" MyQuickSort ");
        int[] arr = new int[] {4,4,6,5,3,2,8,1};
        //quickSort(arr, 0, arr.length-1);
        quickSortSingle(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}