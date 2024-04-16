import java.io.*;
import java.util.*;

public class OrganizadorDocumentos {

    public static void ordenarArchivo(String nombreArchivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            List<String> lineas = new ArrayList<>();
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
            reader.close();
            Collections.sort(lineas);

            // Escribir las líneas ordenadas en un nuevo archivo
            BufferedWriter writer = new BufferedWriter(new FileWriter("documento_ordenado.txt"));
            for (String l : lineas) {
                writer.write(l);
                writer.newLine();
            }
            writer.close();
            System.out.println("El archivo ha sido ordenado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al leer/escribir el archivo: " + e.getMessage());
        }
    }

    // Método para buscar una palabra en un archivo de texto de manera lineal
    public static boolean buscarPalabraLineal(String palabra, String nombreArchivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.contains(palabra)) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }

    // Método para buscar una palabra en un archivo de texto utilizando búsqueda binaria
    public static boolean buscarPalabraBinaria(String palabra, String nombreArchivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            List<String> lineas = new ArrayList<>();
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
            reader.close();

            // Ordenar las líneas alfabéticamente para la búsqueda binaria
            Collections.sort(lineas);

            // Realizar búsqueda binaria
            int inicio = 0;
            int fin = lineas.size() - 1;
            while (inicio <= fin) {
                int medio = inicio + (fin - inicio) / 2;
                String lineaMedio = lineas.get(medio);
                if (lineaMedio.contains(palabra)) {
                    return true;
                } else if (lineaMedio.compareTo(palabra) < 0) {
                    inicio = medio + 1;
                } else {
                    fin = medio - 1;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }

    // Método principal
    public static void main(String[] args) {
        // Ejemplo de uso de los métodos
        ordenarArchivo("documento.txt");

        if (buscarPalabraLineal("palabra", "documento.txt")) {
            System.out.println("La palabra se encontró en el archivo (búsqueda lineal).");
        } else {
            System.out.println("La palabra no se encontró en el archivo (búsqueda lineal).");
        }

        if (buscarPalabraBinaria("palabra", "documento.txt")) {
            System.out.println("La palabra se encontró en el archivo (búsqueda binaria).");
        } else {
            System.out.println("La palabra no se encontró en el archivo (búsqueda binaria).");
        }
    }
}
