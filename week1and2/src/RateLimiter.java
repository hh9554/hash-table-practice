import java.util.HashMap;

public class RateLimiter {
    static class TokenBucket {
        int tokens = 1000; // [cite: 152]
    }
    private final HashMap<String, TokenBucket> clients = new HashMap<>(); // [cite: 167]

    public boolean check(String id) {
        TokenBucket b = clients.computeIfAbsent(id, k -> new TokenBucket());
        if (b.tokens > 0) {
            b.tokens--; // [cite: 154]
            return true;
        }
        return false; // [cite: 176]
    }

    public static void main(String[] args) {
        RateLimiter rl = new RateLimiter();
        System.out.println("Request allowed: " + rl.check("abc123")); // [cite: 176]
    }
}