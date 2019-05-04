package com.dolnikova;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String first = "this apple is sweet";
        String second = "this apple is sour";

        System.out.println(first);
        System.out.println(second);

        String[] firstWords = first.split("\\s+");
        String[] secondWords = second.split("\\s+");

        Map<String, Integer> mapOfFirstSentence = new HashMap<>();
        Map<String, Integer> mapOfSecondSentence = new HashMap<>();

        for (String s : firstWords) {
            if (mapOfFirstSentence.containsKey(s)) {
                mapOfFirstSentence.put(s, mapOfFirstSentence.get(s) + 1);
            } else {
                mapOfFirstSentence.put(s, 1);
            }
        }

        for (String s : secondWords) {
            if (mapOfSecondSentence.containsKey(s)) {
                mapOfSecondSentence.put(s, mapOfSecondSentence.get(s) + 1);
            } else {
                mapOfSecondSentence.put(s, 1);
            }
        }

        List<String> uncommonWords = new ArrayList<>();

        searchUncommonWords(firstWords, mapOfFirstSentence, mapOfSecondSentence, uncommonWords);
        searchUncommonWords(secondWords, mapOfSecondSentence, mapOfFirstSentence, uncommonWords);

        System.out.println("uncommon words: " + uncommonWords);
    }

    public static void searchUncommonWords(String[] arr, Map<String, Integer> firstMap,
                                           Map<String, Integer> secondMap, List<String> uncommon) {

        for (String s : arr) {
            if ((firstMap.get(s) == 1 && !secondMap.containsKey(s)) ||
                    (!firstMap.containsKey(s) && secondMap.containsKey(s) && secondMap.get(s) == 1)) {
                uncommon.add(s);
            }
        }
    }

}
