import org.junit.Assert;

import java.util.ArrayList;

/**
 * Created by ioana-chirca on 06-Jul-17.
 */
public class UnknownLanguageTest {
    @org.junit.Test
    public void testSmall1() {
        String[] inputDictionary = {"ART", "RAT", "CAT", "CAR"};
        char[] expectedResult = {'A', 'T', 'R', 'C'};

        ArrayList<Character> alphabet = UnknownLanguage.getAlphabet(inputDictionary);
        char[] result = new char[alphabet.size()];
        for (int i = 0; i < alphabet.size(); i++) {
            result[i] = alphabet.get(i);
        }

        Assert.assertArrayEquals(expectedResult, result);
    }

    @org.junit.Test
    public void testSmall2() {
        String[] inputDictionary = {"gug", "ahh", "bar", "bars", "bast", "basu"};
        char[] expectedResult = {'g', 'h', 'r', 't', 'a', 's', 'u', 'b'};

        ArrayList<Character> alphabet = UnknownLanguage.getAlphabet(inputDictionary);
        char[] result = new char[alphabet.size()];
        for (int i = 0; i < alphabet.size(); i++) {
            result[i] = alphabet.get(i);
        }

        Assert.assertArrayEquals(expectedResult, result);
    }

    @org.junit.Test
    public void testOneWord() {
        String[] inputDictionary = {"blob"};
        char[] expectedResult = {'b', 'l', 'o'};

        ArrayList<Character> alphabet = UnknownLanguage.getAlphabet(inputDictionary);
        char[] result = new char[alphabet.size()];
        for (int i = 0; i < alphabet.size(); i++) {
            result[i] = alphabet.get(i);
        }

        Assert.assertArrayEquals(expectedResult, result);
    }

    @org.junit.Test
    public void testEmptyInput() {
        String[] inputDictionary = {};
        char[] expectedResult = {};

        ArrayList<Character> alphabet = UnknownLanguage.getAlphabet(inputDictionary);
        char[] result = new char[alphabet.size()];
        for (int i = 0; i < alphabet.size(); i++) {
            result[i] = alphabet.get(i);
        }

        Assert.assertArrayEquals(expectedResult, result);
    }

    @org.junit.Test
    public void testNullInput() {
        String[] inputDictionary = null;

        ArrayList<Character> alphabet = UnknownLanguage.getAlphabet(inputDictionary);

        Assert.assertNull(alphabet);
    }

    @org.junit.Test
    public void testInvalidInputCircularDependencies() {
        String[] inputDictionary = {"ax", "ay", "by", "bz", "cz", "cx"};

        ArrayList<Character> alphabet = UnknownLanguage.getAlphabet(inputDictionary);

        Assert.assertNull(alphabet);
    }

    @org.junit.Test
    public void testInvalidInputLongerWordBeforeShorterWord() {
        String[] inputDictionary = {"hay", "ha"};

        ArrayList<Character> alphabet = UnknownLanguage.getAlphabet(inputDictionary);

        Assert.assertNull(alphabet);
    }


}
