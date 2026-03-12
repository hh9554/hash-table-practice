import java.util.*;

public class DNSCache {
    static class DNSEntry {
        String ip;
        long expiryTime;
        DNSEntry(String ip, int ttl) {
            this.ip = ip;
            this.expiryTime = System.currentTimeMillis() + (ttl * 1000L); // [cite: 75]
        }
    }

    private final HashMap<String, DNSEntry> cache = new HashMap<>(); // [cite: 76]

    public String resolve(String domain) {
        DNSEntry entry = cache.get(domain);
        if (entry == null || System.currentTimeMillis() > entry.expiryTime) { // [cite: 63, 64]
            return "Cache MISS -> Querying Upstream"; // [cite: 84]
        }
        return "Cache HIT: " + entry.ip; // [cite: 84]
    }

    public static void main(String[] args) {
        DNSCache dns = new DNSCache();
        dns.cache.put("google.com", new DNSEntry("172.217.14.206", 2)); // [cite: 84]
        System.out.println(dns.resolve("google.com"));
    }
}