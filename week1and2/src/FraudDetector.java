import java.util.*;

public class FraudDetector {
    public boolean findTwoSum(int[] transactions, int target) {
        HashSet<Integer> seen = new HashSet<>(); // [cite: 244, 248]
        for (int t : transactions) {
            if (seen.contains(target - t)) return true; // [cite: 238]
            seen.add(t);
        }
        return false;
    }

    public static void main(String[] args) {
        FraudDetector fd = new FraudDetector();
        System.out.println("Fraud pair found: " + fd.findTwoSum(new int[]{300, 200}, 500)); // [cite: 262]
    }
}