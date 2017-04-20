import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int arraySize = 40;

        // Creating and filling array
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = arraySize - i;
        }

        System.out.println("Input values:");
        System.out.println(Arrays.toString(array));
        System.out.println();

        quickSort(array, 0, array.length - 1);

        System.out.println();
        System.out.println("Output values:");
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (arr == null || arr.length == 0){
            return;
        }
        if (leftIndex >= rightIndex){
            return;
        }

        // pick the pivot
        int middle = leftIndex + (rightIndex - leftIndex) / 2;
        int pivot = arr[middle];

        System.out.println("sorting (leftIndex = " + leftIndex + " rightIndex = " + rightIndex + " pivot = " + pivot + ")");

        // make startIndex < pivot and endIndex > pivot
        int startIndex = leftIndex, endIndex = rightIndex;

        while (startIndex <= endIndex) {
            while (arr[startIndex] < pivot) {
                startIndex++;
            }
            while (arr[endIndex] > pivot) {
                endIndex--;
            }
            if (startIndex <= endIndex) {
                int temp = arr[startIndex];
                arr[startIndex] = arr[endIndex];
                arr[endIndex] = temp;
                startIndex++;
                endIndex--;
            }
        }

        // recursively sort two sub parts
        if (leftIndex < endIndex){
            quickSort(arr, leftIndex, endIndex);
        }
        if (rightIndex > startIndex){
            quickSort(arr, startIndex, rightIndex);
        }
    }
}
