import java.util.ArrayList;
import java.util.List;

public class FuncionesRecursivas {

    public static void main(String[] args) {
        System.out.println("Suma de los primeros 5 números naturales: " + calcularSumaNaturales(5));

        System.out.println("Listado de números en el rango de 1 a 10:");
        List<Integer> numeros = listarNumerosEnRango(1, 10);
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Potencia de 2 elevado a 5: " + calcularPotencia(2, 5));

        int[] datos = {10, 5, 8, 15, 3};
        System.out.println("Máximo en el conjunto de datos: " + encontrarMaximo(datos));
    }

    // Función recursiva para calcular la suma de los primeros n números naturales
    public static int calcularSumaNaturales(int n) {
        if (n == 0)
            return 0;
        else
            return n + calcularSumaNaturales(n - 1);
    }
    public static List<Integer> listarNumerosEnRango(int inicio, int fin) {
        List<Integer> numeros = new ArrayList<>();
        listarNumerosEnRangoHelper(inicio, fin, numeros);
        return numeros;
    }

    private static void listarNumerosEnRangoHelper(int inicio, int fin, List<Integer> numeros) {
        if (inicio <= fin) {
            numeros.add(inicio);
            listarNumerosEnRangoHelper(inicio + 1, fin, numeros);
        }
    }

    // Función recursiva para calcular la potencia de un número mediante multiplicaciones sucesivas
    public static int calcularPotencia(int base, int exponente) {
        if (exponente == 0)
            return 1;
        else
            return base * calcularPotencia(base, exponente - 1);
    }
    public static int encontrarMaximo(int[] datos) {
        return encontrarMaximoHelper(datos, datos.length - 1);
    }

    private static int encontrarMaximoHelper(int[] datos, int indice) {
        if (indice == 0)
            return datos[0];
        else
            return Math.max(datos[indice], encontrarMaximoHelper(datos, indice - 1));
    }
}
