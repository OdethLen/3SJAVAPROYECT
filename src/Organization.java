import java.util.Random;
import java.util.function.Consumer;

public class Organization {
     private Consumer<int[]> onSwap;
    private boolean swapped;

    public Organization(Consumer<int[]> onSwap) {
        this.onSwap = onSwap;
    }

    public void bubbleSort(int[] array) {
        int size = array.length;

        for (int quantity = 0; quantity < size - 1; quantity++) {
            swapped = false;
            for (int current = 0; current < size - quantity - 1; current++) {
                if (array[current] > array[current + 1]) {
                    int temporal = array[current];
                    array[current] = array[current + 1];
                    array[current + 1] = temporal;
                    swapped = true;
                    if (onSwap != null) {
                        onSwap.accept(array);
                    }
                }
            }
            if (!swapped) {
                break;
            }
        }
    }


    public void cocktailSort(int[] array) {
        int end = array.length - 1;
        swapped = true;

        for (int start = 0; start < end && swapped; start++, end--) {
            swapped = false;

            for (int current = start; current < end; current++) {
                if (array[current] > array[current + 1]) {
                    int temporal = array[current];
                    array[current] = array[current + 1];
                    array[current + 1] = temporal;
                    swapped = true;
                    if (onSwap != null) {
                        onSwap.accept(array);
                    }
                }
            }

            if (!swapped) break;

            swapped = false;

            for (int i = end - 1; i >= start; i--) {
                if (array[i] > array[i + 1]) {
                    int temporal = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temporal;
                    swapped = true;
                    if (onSwap != null) {
                        onSwap.accept(array);
                    }
                }
            }
        }
    }

     public void insertionSort(int[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            int elemento = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > elemento) {
                array[j + 1] = array[j];
                j--;
                if (onSwap != null) {
                    onSwap.accept(array);
                }
            }
            array[j + 1] = elemento;
            if (onSwap != null) {
                onSwap.accept(array);
            }
        }
    }

    public int[] desordenarArreglo(int[] array) {
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            int j = random.nextInt(array.length - i) + i;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        return array;
    }

}
