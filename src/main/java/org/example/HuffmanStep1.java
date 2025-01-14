package org.example;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HuffmanStep1 {
    public static void main(String[] args) {
        String filePath = "test.txt";
        Map<Character, Integer> frequencyMap = calculateFrequency(filePath);

        if (frequencyMap != null) {
            System.out.println("Frequenze dei caratteri:");
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    // Metodo per calcolare la frequenza dei caratteri in un file
    public static Map<Character, Integer> calculateFrequency(String filePath) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                char character = (char) ch;
                frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file: " + e.getMessage());
            return null;
        }

        return frequencyMap;
    }
}
