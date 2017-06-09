import java.util.HashSet;

/**
 * Created by ioana-chirca on 09-Jun-17.
 */
public class Dictionary {
    private HashSet<String> words;
    private HashSet<String> prefixes;

    public Dictionary() {
        words = new HashSet<>();
        prefixes = new HashSet<>();
        prefixes.add("");
    }

    public Dictionary(String[] words) {
        this();
        for (String word : words) {
            addWord(new StringBuilder(word));
        }
    }

    public void addWord(StringBuilder word) {
        for (int i = 0; i < word.length(); i++) {
            prefixes.add(word.substring(0, i+1));
        }
        words.add(word.toString());
    }

    public boolean isWord(String word) {
        return words.contains(word);
    }

    public boolean isPrefix(String prefix) {
        return prefixes.contains(prefix);
    }
}
