import java.util.Scanner;

// Base class for TrunkCall
abstract class TrunkCall {
    protected int duration; // Duration in minutes
    
    // Constructor
    public TrunkCall(int duration) {
        this.duration = duration;
    }
    
    // Abstract method to calculate charges
    abstract double calculateCharge();
}

// Ordinary call with specific rate
class OrdinaryCall extends TrunkCall {
    private static final double RATE = 1.0; 
    // Rate per minute
    
    public OrdinaryCall(int duration) {
        super(duration);
    }
    
    @Override
    double calculateCharge() {
        return duration * RATE;
    }
}

// Urgent call with specific rate
class UrgentCall extends TrunkCall {
    private static final double RATE = 2.0;
    
    public UrgentCall(int duration) {
        super(duration);
    }
    
    @Override
    double calculateCharge() {
        return duration * RATE;
    }
}

// Lightning call with specific rate
class LightningCall extends TrunkCall {
    private static final double RATE = 3.0;
    
    public LightningCall(int duration) {
        super(duration);
    }
    
    @Override
    double calculateCharge() {
        return duration * RATE;
    }
}

public class TrunkCallCharges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking user input
        System.out.println("Enter call duration in minutes:");
        int duration = scanner.nextInt();
        
        System.out.println("Enter call type out of the following - Ordinary/Urgent/Lightning:");
        String callType = scanner.next();
        
        TrunkCall call;
        
        // Determining call type and creating corresponding object
        switch (callType.toLowerCase()) {
            case "ordinary":
                call = new OrdinaryCall(duration);
                break;
            case "urgent":
                call = new UrgentCall(duration);
                break;
            case "lightning":
                call = new LightningCall(duration);
                break;
            default:
                System.out.println("Invalid call type! Please enter Ordinary, Urgent, or Lightning.");
                return;
        }
        
        // Calculating and displaying the charges
        System.out.println("The total charges are: Rs." + call.calculateCharge());
        
        scanner.close();
    }
}
