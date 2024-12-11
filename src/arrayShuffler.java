import java.util.Random;

public class arrayShuffler {

    private static Random rand = new Random();

    // Método para mezclar un arreglo
    public static void shuffle(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

}
