import java.util.Arrays;
import java.util.function.BiConsumer;

public class Algorithms {
      public static void mergeSort(int[] array, int left, int right, BiConsumer<int[], String> displayCallback) {
        if (left < right) {
            int middle = (left + right) / 2;
            displayCallback.accept(Arrays.copyOfRange(array, left, right + 1), "División: " + left + " - " + right);

            mergeSort(array, left, middle, displayCallback);
            mergeSort(array, middle + 1, right, displayCallback);
            merge(array, left, middle, right, displayCallback);
        }
    }

    private static void merge(int[] array, int left, int middle, int right, BiConsumer<int[], String> displayCallback) {
        int[] leftArray = Arrays.copyOfRange(array, left, middle + 1);
        int[] rightArray = Arrays.copyOfRange(array, middle + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < leftArray.length && j < rightArray.length) {
            array[k++] = leftArray[i] <= rightArray[j] ? leftArray[i++] : rightArray[j++];
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }

        displayCallback.accept(array, "Merge paso completado");
    }

    public static void directMerge(int[] array, BiConsumer<int[], String> displayCallback) {
        int n = array.length;
        int[] temp = new int[n];

        for (int width = 1; width < n; width *= 2) {
            displayCallback.accept(array.clone(), "División con width = " + width);

            for (int i = 0; i < n; i += 2 * width) {
                int left = i;
                int middle = Math.min(i + width, n);
                int right = Math.min(i + 2 * width, n);

                int l = left, r = middle, k = left;

                while (l < middle && r < right) {
                    temp[k++] = array[l] <= array[r] ? array[l++] : array[r++];
                }

                while (l < middle) {
                    temp[k++] = array[l++];
                }

                while (r < right) {
                    temp[k++] = array[r++];
                }
            }

            System.arraycopy(temp, 0, array, 0, n);
            displayCallback.accept(array.clone(), "Mezcla después de width = " + width);
        }
    }

    public static void naturalMerge(int[] array, BiConsumer<int[], String> displayCallback) {
        boolean ordenado = false;
        int[] temp = new int[array.length];

        while (!ordenado) {
            ordenado = true;
            int i = 0;

            displayCallback.accept(array.clone(), "División en sub-secuencias");

            while (i < array.length) {
                int start = i;

                while (i < array.length - 1 && array[i] <= array[i + 1]) {
                    i++;
                }
                i++;

                int j = i;

                while (i < array.length - 1 && array[i] <= array[i + 1]) {
                    i++;
                }
                i++;

                if (j < array.length) {
                    mergeNatural(array, start, j, Math.min(i, array.length), temp);
                    ordenado = false;
                }
            }

            System.arraycopy(temp, 0, array, 0, array.length);
            displayCallback.accept(array.clone(), "Mezcla completa");
        }
    }

    private static void mergeNatural(int[] array, int left, int middle, int right, int[] temp) {
        int i = left, j = middle, k = left;

        while (i < middle && j < right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        while (i < middle) {
            temp[k++] = array[i++];
        }

        while (j < right) {
            temp[k++] = array[j++];
        }
    }

}
