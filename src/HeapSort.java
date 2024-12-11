import java.util.function.Consumer;

public class HeapSort {

     private Consumer<int[]> updateCallback;

        public HeapSort(Consumer<int[]> updateCallback) {
            this.updateCallback = updateCallback;
        }

        public void heapSort(int[] array) throws InterruptedException {
            int n = array.length;

            // Construir el max-heap
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(array, n, i);
            }

            // Extraer elementos del heap uno por uno
            for (int i = n - 1; i >= 0; i--) {
                // Mueve la raíz (el máximo) al final
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;

                // Actualiza el callback
                if (updateCallback != null) {
                    updateCallback.accept(array);
                }
                Thread.sleep(500);

                // Llama a Heapify en el heap reducido
                heapify(array, i, 0);
            }
        }

        private void heapify(int[] array, int n, int i) throws InterruptedException {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // Si el hijo izquierdo es mayor que la raíz
            if (left < n && array[left] > array[largest]) {
                largest = left;
            }

            // Si el hijo derecho es mayor que el mayor hasta ahora
            if (right < n && array[right] > array[largest]) {
                largest = right;
            }

            // Si el mayor no es la raíz
            if (largest != i) {
                int swap = array[i];
                array[i] = array[largest];
                array[largest] = swap;

                // Actualiza el callback
                if (updateCallback != null) {
                    updateCallback.accept(array);
                }
                Thread.sleep(500);

                // Recursivamente heapify el subárbol afectado
                heapify(array, n, largest);
            }
        }
    }



