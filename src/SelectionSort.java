import java.util.Arrays;
import java.util.function.Consumer;

public class SelectionSort {


    private Consumer<int[]> updateCallback;

    public SelectionSort(Consumer<int[]> updateCallback) {
        this.updateCallback = updateCallback;
    }

    public void selectionSort(int[] array) throws InterruptedException {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            // Encuentra el índice del elemento mínimo en el subarreglo no ordenado
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Intercambia el elemento mínimo con el primer elemento no ordenado
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

            // Pausa para visualizar el cambio y actualizar el ListBox
            Thread.sleep(500);
            updateListBox(array);
        }
    }

    private void updateListBox(int[] array) {
        if (updateCallback != null) {
            updateCallback.accept(Arrays.copyOf(array, array.length));
        }
    }

}
