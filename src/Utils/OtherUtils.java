package Utils;

public class OtherUtils {

    public static void sleep(int time)
    {
        // Заморозка потока на time миллисекунд.
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void print1DArray(int[] array) {
        // Вывод одномерного целочисленного массива в консоль.
        for (int element : array)
            System.out.printf("%4d ", element);
        System.out.println();
    }
}
