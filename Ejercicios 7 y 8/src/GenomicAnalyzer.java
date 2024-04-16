import java.util.ArrayList;
import java.util.List;

public class GenomicAnalyzer {

    public static void main(String[] args) {
        String dnaSequence = "ATGCATGCTAGCTAGCTAGCTAGCATG";
        int geneCount = countGenes(dnaSequence);
        System.out.println("Número de genes encontrados: " + geneCount);

        String[] nucleotides = {"A", "T", "C", "G"};
        int combinationLength = 3;
        List<String> combinations = calculateCombinations(nucleotides, combinationLength);
        System.out.println("Combinaciones genéticas:");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }

    public static int countGenes(String dna) {
        int count = 0;
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1)
            return 0;
        else {
            int endIndex = dna.indexOf("TAG", startIndex + 3);
            if (endIndex != -1) {
                count = 1 + countGenes(dna.substring(endIndex + 3));
            }
        }
        return count;
    }

    public static List<String> calculateCombinations(String[] nucleotides, int length) {
        // Algoritmo recursivo para calcular combinaciones genéticas
        // Recibe un conjunto de nucleótidos y la longitud deseada de la combinación
        // Retorna una lista de combinaciones genéticas
        List<String> combinations = new ArrayList<>();
        calculateCombinationsHelper(nucleotides, length, "", combinations);
        return combinations;
    }

    private static void calculateCombinationsHelper(String[] nucleotides, int length, String current, List<String> combinations) {
        if (length == 0) {
            combinations.add(current);
            return;
        }
        for (String nucleotide : nucleotides) {
            calculateCombinationsHelper(nucleotides, length - 1, current + nucleotide, combinations);
        }
    }
}
