import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ioana-chirca on 16-May-17.
 */
public class StringPermutation {
    public boolean isPermutation(String first, String second) {
        boolean isValid = validateInput(first, second);
        if (!isValid) return false;

        // in order for two strings to be permutations, they have to have the same characters
        HashMap<Character, Integer> frequencies = new HashMap<>();
        for (Character c : first.toCharArray()) {
            if (!frequencies.containsKey(c)) {
                frequencies.put(c, 1);
            } else {
                frequencies.put(c, frequencies.get(c) + 1);
            }
        }
        for (Character c : second.toCharArray()) {
            if (!frequencies.containsKey(c)) {
                frequencies.put(c, -1);
            } else {
                frequencies.put(c, frequencies.get(c) - 1);
            }
        }

        boolean ok = true;
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() != 0) {
                ok = false;
                break;
            }
        }

        return ok;
    }

    private boolean validateInput(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        if (first.length() != second.length()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StringPermutation permutation = new StringPermutation();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String first = null;
        String second = null;

        try {
            first = input.readLine();
            second = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(permutation.isPermutation(first, second));
    }

}
