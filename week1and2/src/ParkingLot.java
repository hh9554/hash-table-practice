public class ParkingLot {
    private final String[] spots = new String[500]; // [cite: 210]

    public int park(String plate) {
        int idx = Math.abs(plate.hashCode()) % 500; // [cite: 224]
        while (spots[idx] != null) {
            idx = (idx + 1) % 500; // [cite: 225]
        }
        spots[idx] = plate;
        return idx;
    }

    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot();
        System.out.println("Vehicle parked at spot: " + pl.park("ABC-1234")); // [cite: 232]
    }
}