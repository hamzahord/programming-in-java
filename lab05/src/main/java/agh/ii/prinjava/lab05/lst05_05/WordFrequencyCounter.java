package agh.ii.prinjava.lab05.lst05_05;
import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java WordFrequencyCounter filename");
            System.exit(1);
        }

        String filename = args[0];
        Map<String, Integer> wordCounts = new TreeMap<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                word = word.toLowerCase();
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: file not found");
            System.exit(1);
        }

        for (String word : wordCounts.keySet()) {
            int count = wordCounts.get(word);
            System.out.printf("%-20s %d\n", word, count);
        }
    }
}
