import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Клас для виконання обчислень над матрицями цілих чисел.
 * Містить методи для аналізу стовпців та їх сум.
 * * @author Пилипенко
 */
public class MatrixProcessor {

    /**
     * Метод шукає стовпець з найбільшою сумою елементів.
     * На вхід потрібна матриця.
     * Повертає індекс знайденого стовпця.
     */
    public static int findMaxSumColumnIndex(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Матриця не може бути порожньою.");
        }

        int columnCount = matrix[0].length;

        // Обчислюємо суми для кожного стовпця без явних циклів
        long[] columnSums = IntStream.range(0, columnCount)
                .mapToLong(colIndex -> Arrays.stream(matrix)
                        .mapToLong(row -> row[colIndex])
                        .sum())
                .toArray();

        // Знаходимо індекс максимального значення в отриманому масиві сум
        return IntStream.range(0, columnSums.length)
                .reduce((i, j) -> columnSums[i] >= columnSums[j] ? i : j)
                .orElse(0);
    }

    /**
     * Допоміжний метод для отримання суми конкретного стовпця.
     */
    public static long getColumnSum(int[][] matrix, int colIndex) {
        return Arrays.stream(matrix)
                .mapToLong(row -> row[colIndex])
                .sum();
    }
}
