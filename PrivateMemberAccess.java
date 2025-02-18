class SuperclassError {
    private int privateNumber = 10;
    // protected int privateNumber = 10; - does not give error since protected can be accessed
}

class Subclass extends SuperclassError {
    void display() {
        // accessing private member directly from superclass
        System.out.println(privateNumber); 
        // since privateNumber has private access in Superclass, an error comes in compilation
    }
}

public class PrivateMemberAccess {
    public static void main(String[] args) {
        new Subclass().display();
    }
}