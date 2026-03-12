import java.util.*;

public class UsernameSystem {
    private final HashSet<String> takenUsernames = new HashSet<>(); //
    private final HashMap<String, Integer> attemptCounts = new HashMap<>(); //

    public UsernameSystem() {
        takenUsernames.addAll(Arrays.asList("john_doe", "jane_smith", "admin")); //
    }

    public boolean checkAvailability(String username) {
        attemptCounts.put(username, attemptCounts.getOrDefault(username, 0) + 1); //
        return !takenUsernames.contains(username); //
    }

    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();
        int i = 1;
        while (suggestions.size() < 3) {
            String candidate = username + i;
            if (!takenUsernames.contains(candidate)) suggestions.add(candidate); //
            i++;
        }
        return suggestions;
    }

    static void main() {
        UsernameSystem sys = new UsernameSystem();
        System.out.println("john_doe available: " + sys.checkAvailability("john_doe")); //
        System.out.println("Suggestions: " + sys.suggestAlternatives("john_doe")); //
    }
}