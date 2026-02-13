public class Main {
    public static void main(String[] args) {
        // Different aircraft systems trying to access the SAME Black Box
        FlightBlackBox altimeter = FlightBlackBox.getInstance();
        FlightBlackBox engineSensor = FlightBlackBox.getInstance();

        altimeter.recordEvent("Altimeter", "30,000 ft");
        engineSensor.recordEvent("Engine 1", "Normal Temp");

        // Verify they are using the same physical storage
        System.out.println("\nSystem Check: Are both sensors writing to the same box?");
        System.out.println("Identical Hardware ID: " + (altimeter == engineSensor));
        
        // Final recovery simulation
        System.out.println("\n" + altimeter.recoverData());
    }
}