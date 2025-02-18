class Player {
    String name;
    int age;
    String position;
    Player(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;  
        /* using 'this' here to refer to the current instance of the class 
        and to differentiate instance variables from the constructor parameters*/ 
    }
    void play() {
        System.out.println(name + " is playing.");
    }
    void train() {
        System.out.println(name + " is training.");
    }
}
class Cricket_Player extends Player {
    Cricket_Player(String name, int age, String position) {  // function: 
        super(name, age, position);
        // to pass values to the parent constructor
    }
}

class Football_Player extends Player {
    Football_Player(String name, int age, String position) {
        super(name, age, position);
    }
}

class Hockey_Player extends Player {
    Hockey_Player(String name, int age, String position) {
        super(name, age, position);
    }   
}

public class SportsExpFive {
    public static void main(String[] args) {
        Cricket_Player cricketPlayer = new Cricket_Player("Virat", 34, "Batsman");
        Football_Player footballPlayer = new Football_Player("Ronaldo", 40, "Forward");
        Hockey_Player hockeyPlayer = new Hockey_Player("Ritika", 20, "Midfielder");
        System.out.println("------------------------------------------------------------------");
        cricketPlayer.play();
        footballPlayer.train();
        hockeyPlayer.play();
        System.out.println("------------------------------------------------------------------");

    }
}
