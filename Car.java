class Car { //outer class

    class Engine {   //inner class 
        public void start() {
            System.out.println("Engine has started");
        }
        public void stop() {
            System.out.println("Engine has stopped");
        }
    }
    public void drive() { //method to create Engine instance and call start and stop
        Engine engine = new Engine();
        engine.start();
        engine.stop();
    }
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.drive();
    }
}
