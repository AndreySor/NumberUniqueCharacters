package com.foxminded.character_count;

import static org.junit.Assert.*;

import org.junit.Test;

import com.foxminded.character_count.UniqueCharactersCounter;

public class TestUniqueCharactersCounter {
    UniqueCharactersCounter string = new UniqueCharactersCounter();

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenStringNull() {
        string.countUniqueCharacters(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenStringEmpty() {
        string.countUniqueCharacters("");
    }

    @Test
    public void shouldCountUniqueLetters() {
        String expected = "\"h\" - 1\n" + 
                          "\"e\" - 1\n" + 
                          "\"l\" - 2\n" + 
                          "\"o\" - 1\n";
        String actual = string.countUniqueCharacters("hello");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCountUniqueNumbers() {
        String expected = "\"1\" - 1\n" + 
                          "\"2\" - 2\n" + 
                          "\"5\" - 2\n" + 
                          "\"8\" - 1\n";
        String actual = string.countUniqueCharacters("125285");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCountLetters() {
        String expected = "\"a\" - 10\n";
        String actual = string.countUniqueCharacters("aaaaaaaaaa");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCountWhiteSpacesDigitals() {
        String expected = "\"6\" - 6\n";
        String actual = string.countUniqueCharacters("666666");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCountSymbols() {
        String expected = "\"&\" - 5\n";
        String actual = string.countUniqueCharacters("&&&&&");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCountSymbol() {
        String expected = "\"&\" - 1\n";
        String actual = string.countUniqueCharacters("&");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCountWhiteSpaces() {
        String expected = "\" \" - 11\n";
        String actual = string.countUniqueCharacters("           ");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCountUniqueLettersSeveralWords() {
        String expected = "\"h\" - 1\n" + 
                          "\"e\" - 1\n" + 
                          "\"l\" - 2\n" + 
                          "\"o\" - 2\n" + 
                          "\" \" - 1\n" + 
                          "\"w\" - 1\n" +
                          "\"r\" - 1\n" + 
                          "\"d\" - 1\n";       
        String actual = string.countUniqueCharacters("hello word");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCountUniqueLettersAndDigitalsAndSymbols() {
        String expected = "\"a\" - 1\n" + 
                          "\"s\" - 1\n" + 
                          "\"j\" - 3\n" + 
                          "\"k\" - 3\n" + 
                          "\"g\" - 1\n" + 
                          "\"f\" - 2\n" +
                          "\"d\" - 2\n" + 
                          "\"5\" - 1\n" + 
                          "\"6\" - 1\n" + 
                          "\"7\" - 1\n" + 
                          "\" \" - 1\n" + 
                          "\"h\" - 1\n" +
                          "\"3\" - 1\n" + 
                          "\"4\" - 1\n" + 
                          "\"(\" - 1\n" + 
                          "\"*\" - 1\n" + 
                          "\"l\" - 1\n";
        String actual = string.countUniqueCharacters("asjkgfd567 jkjh34(*lkdf");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCountLowerAndUpperCaseLettersSeparately() {
        String expected = "\"H\" - 1\n" + 
                          "\"h\" - 1\n" + 
                          "\"e\" - 1\n" + 
                          "\"L\" - 2\n" + 
                          "\"l\" - 1\n" + 
                          "\"o\" - 2\n" +
                          "\" \" - 1\n" + 
                          "\"w\" - 1\n" + 
                          "\"r\" - 1\n" + 
                          "\"d\" - 1\n";        
        String actual = string.countUniqueCharacters("HheLlo worLd");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCache() {        
        String expected = string.countUniqueCharacters("hello word");
        String actual = string.countUniqueCharacters("hello word");
        assertSame(expected, actual);
    }
}
