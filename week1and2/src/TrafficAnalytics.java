import java.util.*;

public class TrafficAnalytics {
    private final HashMap<String, Integer> pageViews = new HashMap<>(); // [cite: 134]
    private final HashMap<String, Set<String>> uniqueUsers = new HashMap<>(); // [cite: 135]

    public void processEvent(String url, String userId) {
        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1); // [cite: 125]
        uniqueUsers.computeIfAbsent(url, k -> new HashSet<>()).add(userId); // [cite: 126]
    }

    public static void main(String[] args) {
        TrafficAnalytics ta = new TrafficAnalytics();
        ta.processEvent("/breaking-news", "user123"); // [cite: 143]
        System.out.println("Views for /breaking-news: " + ta.pageViews.get("/breaking-news")); // [cite: 146]
    }
}