import java.util.*;

public class MultiLevelCache {
    private final LinkedHashMap<String, String> l1 = new LinkedHashMap<>(10, 0.75f, true); // [cite: 282]
    private final HashMap<String, String> l2 = new HashMap<>(); // [cite: 283]

    public String get(String id) {
        if (l1.containsKey(id)) return "L1 HIT: " + l1.get(id); // [cite: 293]
        if (l2.containsKey(id)) {
            l1.put(id, l2.get(id)); // [cite: 294]
            return "L2 HIT";
        }
        return "L3 HIT"; // [cite: 274]
    }

    public static void main(String[] args) {
        MultiLevelCache mlc = new MultiLevelCache();
        mlc.l2.put("video_123", "Video Data");
        System.out.println(mlc.get("video_123")); // [cite: 292]
    }
}