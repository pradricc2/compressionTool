package org.example;


import org.example.calculator.FrequencyCalculator;
import org.example.calculator.FrequencyCalculatorImpl;
import org.example.huffman.HuffmanNode;
import org.example.huffman.HuffmanTreeBuilder;
import org.example.reader.FileReaderService;
import org.example.reader.FileReaderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class HuffmanApp {

    private static final Logger logger = LoggerFactory.getLogger(HuffmanApp.class);

    public static void main(String[] args) {
        String filePath = "test.txt";

        FileReaderService fileReader = new FileReaderServiceImpl();
        FrequencyCalculator frequencyCalculator = new FrequencyCalculatorImpl();
        HuffmanTreeBuilder huffmanTreeBuilder = new HuffmanTreeBuilder();

        try {
            List<Character> characters = fileReader.readFile(filePath);
            Map<Character, Integer> frequencyMap = frequencyCalculator.calculateFrequency(characters);

            logger.info("Frequenze dei caratteri:");
            frequencyMap.forEach((key, value) -> logger.info("Carattere '{}' -> {} occorrenze", key, value));

            HuffmanNode root = huffmanTreeBuilder.buildTree(frequencyMap);

            logger.info("Codici di Huffman:");
            printCodes(root, "");


        } catch (IOException e) {
            logger.error("Errore: {} ", e.getMessage());
        }
    }

    // Metodo per stampare i codici
    public static void printCodes(HuffmanNode root, String code) {
        if (root == null) {
            return;
        }

        // Nodo foglia
        if (root.getLeft() == null && root.getRight() == null) {
            logger.info("'{}': {}",root.getCh(), code);
        }

        // Ricorsione per i figli
        printCodes(root.getLeft(), code + "0");
        printCodes(root.getRight(), code + "1");
    }
}
