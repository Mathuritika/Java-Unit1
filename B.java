package Q;
import P.A; // Importing from package P

public class B {
    public static void main(String[] args) {
        A obj = new A();
        obj.publicMethod(); // this is accessible everywhere
        
        // obj.protectedMethod(); - is not accessible outside package without inheritance
        // obj.defaultMethod();   - is not accessible outside package
        // obj.privateMethod();   - is not accessible outside class A

        /*error: protectedMethod() has protected access in A
           error: defaultMethod() is not public in A; cannot be accessed from outside package
            error: privateMethod() has private access in A
 */
    }
}
