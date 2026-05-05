import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] testMatrix = {
            {10, 2, 3, 5},
            {1, 20, 3, 4},
            {5, 6, 70, 8}
        };

        System.out.println("Тестова матриця:");
        Arrays.stream(testMatrix).forEach(row -> System.out.println(Arrays.toString(row)));

        try {
            int maxColIndex = MatrixProcessor.findMaxSumColumnIndex(testMatrix);
            long maxSum = MatrixProcessor.getColumnSum(testMatrix, maxColIndex);

            System.out.println("\nРезультат перевірки:");
            System.out.println("Стовпець з максимальною сумою має індекс: " + maxColIndex);
            System.out.println("Значення максимальної суми: " + maxSum);

            int[][] smallMatrix = {{1, 10}, {5, 2}};
            System.out.println("\nДруга перевірка (2x2): " + 
                (MatrixProcessor.findMaxSumColumnIndex(smallMatrix) == 1 ? "Пройдено" : "Помилка"));

        } catch (Exception e) {
            System.err.println("Помилка під час виконання: " + e.getMessage());
        }
    }
}
