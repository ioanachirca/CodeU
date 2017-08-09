import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by ioana-chirca on 03-Jul-17.
 */
public class UnknownLanguage {
    public static ArrayList<Character> getAlphabet(String[] inputDictionary) {
        int alphabetSize = 256;  // we consider the whole ASCII table
        Graph graph = new Graph(alphabetSize);
        if (inputDictionary == null) return null;
        if (inputDictionary.length == 1) {
            // if there is only one word, any ordering of the letters is ok
            ArrayList<Character> alphabet = new ArrayList<>();
            Set<Character> charSet = new LinkedHashSet<>();
            for (int i = 0; i < inputDictionary[0].length(); i++) {
                charSet.add(inputDictionary[0].charAt(i));
            }
            for (Character character : charSet) {
                alphabet.add(character);
            }
            return alphabet;
        }
        for (int i = 1; i < inputDictionary.length; i++) {
            String previous = inputDictionary[i-1];
            String current = inputDictionary[i];
            int j = 0;
            int k = 0;
            while (j < previous.length() && k < current.length() && previous.charAt(j) == current.charAt(k)) {
                j++;
                k++;
            }
            if (j < previous.length() && k == current.length()) {
                // a case like "balk bal" is invalid
                return null;
            }
            if (j < previous.length() && k < current.length()) {
                graph.addEdge((int)previous.charAt(j), (int)current.charAt(k));

                while (j < previous.length()) {
                    graph.addNode((int) previous.charAt(j));
                    j++;
                }

                while (k < current.length()) {
                    graph.addNode((int) previous.charAt(k));
                    k++;
                }
            }
        }

        ArrayList<Integer> integerAlphabet =  graph.topologicalSort();
        if (integerAlphabet == null) {
            return null;
        }
        ArrayList<Character> characterAlphabet = new ArrayList<>();
        for (Integer integer : integerAlphabet) {
            characterAlphabet.add((char)(int)integer);
        }

        return characterAlphabet;
    }

    public static void main(String[] args) {
        String[] inputDictionary = {"ART", "RAT", "CAT", "CAR"};
        ArrayList<Character> alphabet = getAlphabet(inputDictionary);
        if (alphabet == null) System.out.println("null");
        else {
            for (Character character : alphabet) {
                System.out.println(character + " ");
            }
        }

    }
}
