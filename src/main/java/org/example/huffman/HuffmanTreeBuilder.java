package org.example.huffman;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTreeBuilder {

    private static final Logger logger = LoggerFactory.getLogger(HuffmanTreeBuilder.class);

    public HuffmanNode buildTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new HuffmanComparator());

        // Crea nodi foglia
        frequencyMap.forEach((character, frequency) -> {
            HuffmanNode node = new HuffmanNode();
            node.setCh(character);
            node.setFreq(frequency);
            pq.add(node);
        });

        pq.forEach(e -> logger.info("'{}' : {}",String.valueOf(e.getCh()), e.getFreq()));

        // Costruzione dell'albero
        while (pq.size() > 1) {
            HuffmanNode x = pq.poll();
            HuffmanNode y = pq.poll();

            HuffmanNode newNode = new HuffmanNode();
            newNode.setFreq(x.getFreq() + y.getFreq());
            newNode.setCh('-');
            newNode.setLeft(x);
            newNode.setRight(y);

            pq.add(newNode);
        }

        return pq.poll(); // Radice dell'albero
    }
}

