import java.util.Arrays;
import java.util.function.Consumer;

public class QuickSort {

     private Consumer<int[]> updateCallback;

    public QuickSort(Consumer<int[]> updateCallback) {
        this.updateCallback = updateCallback;
    }

    public void quicksort(int[] arr, int low, int high) throws InterruptedException {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quicksort(arr, low, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) throws InterruptedException {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
                Thread.sleep(500); // Pausa para visualizar el cambio
                updateListBox(arr); // Actualizar ListBox
            }
        }

        swap(arr, i + 1, high);
        Thread.sleep(500); // Pausa para visualizar el cambio
        updateListBox(arr); // Actualizar ListBox
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void updateListBox(int[] array) {
        if (updateCallback != null) {
            updateCallback.accept(Arrays.copyOf(array, array.length));
        }
    }
}
