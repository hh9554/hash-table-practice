import java.util.*;

public class AutocompleteSystem {
    private final HashMap<String, Integer> queryFreq = new HashMap<>(); // [cite: 192]

    public void update(String query) {
        queryFreq.put(query, queryFreq.getOrDefault(query, 0) + 1); // [cite: 184]
    }

    public static void main(String[] args) {
        AutocompleteSystem as = new AutocompleteSystem();
        as.update("java tutorial"); // [cite: 202]
        System.out.println("Frequencies: " + as.queryFreq);
    }
}