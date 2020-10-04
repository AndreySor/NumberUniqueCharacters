package com.foxminded.character_count;

import java.util.*;

public class UniqueCharactersCounter {
    private Map<String, String> cache = new HashMap<>();

    public String countUniqueCharacters(String stringInput) {

        if (stringInput == null || stringInput.equals("")) {
            throw new IllegalArgumentException("string can't empty");
        }
        
        Map<String, Integer> uniqueCharacters = new LinkedHashMap<>();
        if (cache.containsKey(stringInput) == false) {
            uniqueCharacters = countUniqueValues(stringInput);
            cache.put(stringInput, modifyResultToView(uniqueCharacters));
        }

        return cache.get(stringInput);
    }

    private String modifyResultToView(Map<String, Integer> uniqueCharacters) {
        StringBuilder resultBody = new StringBuilder();
        for (Map.Entry<String, Integer> index : uniqueCharacters.entrySet()) {
            resultBody
                    .append(String.format('"' + index.getKey().toString() + '"' + " - " + 
            index.getValue().toString())).append("\n");
        }
        return resultBody.toString();
    }

    private Map<String, Integer> countUniqueValues(String stringInput) {
        Map<String, Integer> uniqueValues = new LinkedHashMap<>();
        List<String> testString = Arrays.asList(stringInput.split(""));
        for (String checkCharacter : testString) {
            uniqueValues.put(checkCharacter, Collections.frequency(testString, checkCharacter));
        }
        return uniqueValues;
    }
}
