interface EventHandler {
    void handleEvent();
}
class EventManager {
    public void registerEvent() {//local inner class implementing event handler
        class LocalEventHandler implements EventHandler {
            public void handleEvent() {
                System.out.println("Event handled by local inner class");
            }
        }
        EventHandler local = new LocalEventHandler(); //creating an instance of the local inner class
        local.handleEvent();
    }
    public static void main(String[] args) {
        EventManager manager = new EventManager();
        manager.registerEvent(); //using the local inner class

        EventHandler anonymous = new EventHandler() {
            public void handleEvent() {
                System.out.println("Event handled by anonymous inner class");
            }
        };
        anonymous.handleEvent(); //calling the method from the anonymous class
    }
}
