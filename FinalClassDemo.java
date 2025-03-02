// Final class cannot be extended
final class Logger {
    // Method to print a message
    public void logMessage(String message) {
        System.out.println("Log: " + message);
    }
}

// Trying to extend Logger will cause an error
// class ExtendedLogger extends Logger {
// }

// Main class to test Logger
public class FinalClassDemo {
    public static void main(String[] args) {
        // Creating an object of Logger
        Logger logger = new Logger();
        
        // Calling the method to print a message
        logger.logMessage("This is a log message.");
    }
}
