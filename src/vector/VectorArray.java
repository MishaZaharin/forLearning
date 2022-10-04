package vector;

public class VectorArray {
    // теперь не три координаты, а массив координат
    private double values[];

    public VectorArray(double[] values) {
        this.values = values;
    }

    // Длина вектора. Корень из суммы квадратов
    public double length() {
        double sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i] * values[i];
        }
        return Math.sqrt(sum);
    }

    // метод, вычисляющий скалярное произведение
    public double scalarProduct(VectorArray vectorArray) {
        double res = 0;
        for (int i = 0; i < values.length; i++) {
            res += values[i] * vectorArray.values[i];
        }
        return res;
    }

    // для многомерных не определено
    //    public double crossProduct(VectorArray vector) {
    //
    //    }

    // Косинус между двумя векторами
    public double cos(VectorArray vectorArray) {
        return scalarProduct(vectorArray) / (length() * vectorArray.length());
    }

    public VectorArray add(VectorArray vectorArray) {
        double[] another = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            another[i] = values[i] + vectorArray.values[i];
        }
        return new VectorArray(another);
    }

    public VectorArray subtract(VectorArray vectorArray) {
        double[] another = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            another[i] = values[i] - vectorArray.values[i];
        }
        return new VectorArray(another);
    }

    // Вспомогательный метод
    private static double[] generateRandomArray(int length) {
        double[] array = new double[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
        return array;
    }

    public static VectorArray[] generate(int n, int dimension) {
        VectorArray[] vectorArrays = new VectorArray[n];
        for (int i = 0; i < n; i++) {
            vectorArrays[i] = new VectorArray(generateRandomArray(dimension));
        }
        return vectorArrays;
    }
}