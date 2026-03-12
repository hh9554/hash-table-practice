import java.util.*;

public class PlagiarismDetector {
    private final HashMap<String, Set<String>> ngramMap = new HashMap<>(); // [cite: 105]

    public void analyze(String docId, String text) {
        String[] words = text.split(" ");
        int n = 5; // [cite: 106]
        for (int i = 0; i <= words.length - n; i++) {
            String ngram = String.join(" ", Arrays.copyOfRange(words, i, i + n)); // [cite: 107]
            ngramMap.computeIfAbsent(ngram, k -> new HashSet<>()).add(docId);
        }
        System.out.println("Analyzed " + docId); // [cite: 113]
    }

    public static void main(String[] args) {
        PlagiarismDetector pd = new PlagiarismDetector();
        pd.analyze("essay_123.txt", "This is a sample essay for testing"); // [cite: 113]
    }
}