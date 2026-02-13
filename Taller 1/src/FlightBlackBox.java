import java.time.LocalDateTime;

public class FlightBlackBox {
    // The single instance of the physical hardware controller
    private static FlightBlackBox instance;
    private StringBuilder memoryBuffer;

    // Private constructor: Only the plane's main system can initialize the box
    private FlightBlackBox() {
        this.memoryBuffer = new StringBuilder();
        System.out.println("[HARDWARE] Black Box Storage Initialized. Status: PROTECTED.");
    }

    // Synchronized Access: If two sensors fire at once, they must wait
    public static synchronized FlightBlackBox getInstance() {
        if (instance == null) {
            instance = new FlightBlackBox();
        }
        return instance;
    }

    // Method to record critical data
    public void recordEvent(String sensorType, String value) {
        String timestamp = LocalDateTime.now().toString();
        String entry = String.format("[%s] Sensor: %s | Value: %s", timestamp, sensorType, value);
        
        // Simulating writing to a crash-proof physical disk
        memoryBuffer.append(entry).append("\n");
        System.out.println("LOGGED: " + entry);
    }

    public String recoverData() {
        return "--- CRASH RECOVERY DATA ---\n" + memoryBuffer.toString();
    }
}
