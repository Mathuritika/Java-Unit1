interface Plays {
    void play();
    void pause();
    void stop();
}

class MusicPlayer implements Plays {
    public void play() {
        System.out.println("Music is being played");
    }
    public void pause() {
        System.out.println("Music has been paused");
    }
    public void stop() {
        System.out.println("Music has been stopped playing");
    }
}

public class TestPlayer {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.play();
        player.pause();
        player.stop();
    }
}
