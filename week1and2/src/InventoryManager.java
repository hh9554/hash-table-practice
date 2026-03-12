import java.util.concurrent.*;
import java.util.*;

public class InventoryManager {
    private final ConcurrentHashMap<String, Integer> stock = new ConcurrentHashMap<>(); // [cite: 43]
    private final ConcurrentLinkedQueue<Integer> waitingList = new ConcurrentLinkedQueue<>(); // [cite: 45]

    public synchronized String purchaseItem(String productId, int userId) {
        int currentStock = stock.getOrDefault(productId, 0);
        if (currentStock > 0) {
            stock.put(productId, currentStock - 1); // [cite: 44]
            return "Success, " + (currentStock - 1) + " units remaining"; // [cite: 53]
        } else {
            waitingList.add(userId);
            return "Added to waiting list, position #" + waitingList.size(); // [cite: 54]
        }
    }

    public static void main(String[] args) {
        InventoryManager im = new InventoryManager();
        im.stock.put("IPHONE15", 1); // [cite: 52]
        System.out.println(im.purchaseItem("IPHONE15", 12345)); // [cite: 53]
        System.out.println(im.purchaseItem("IPHONE15", 67890)); // [cite: 54]
    }
}