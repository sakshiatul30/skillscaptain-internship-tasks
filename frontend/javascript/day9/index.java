import java.util.ArrayList;

// 1. Interface
interface MusicPlayer {
    void play();
    void pause();
    void stop();
    void addSong(String song);
    void removeSong(String song);
}

// 2. Implementing class
class MyMusicPlayer implements MusicPlayer {

    private ArrayList<String> playlist = new ArrayList<>();
    private String currentSong = null;
    private boolean isPlaying = false;

    @Override
    public void addSong(String song) {
        playlist.add(song);
        System.out.println("Song added: " + song);
    }

    @Override
    public void removeSong(String song) {
        if (playlist.remove(song)) {
            System.out.println("Song removed: " + song);
        } else {
            System.out.println("Song not found: " + song);
        }
    }

    @Override
    public void play() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty. Add songs first.");
            return;
        }
        currentSong = playlist.get(0);
        isPlaying = true;
        System.out.println("Playing song: " + currentSong);
    }

    @Override
    public void pause() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Song paused: " + currentSong);
        } else {
            System.out.println("No song is currently playing.");
        }
    }

    @Override
    public void stop() {
        if (currentSong != null) {
            isPlaying = false;
            System.out.println("Song stopped: " + currentSong);
            currentSong = null;
        } else {
            System.out.println("No song to stop.");
        }
    }

    // Optional feature
    public void displayPlaylist() {
        System.out.println("\nCurrent Playlist:");
        for (String song : playlist) {
            System.out.println("- " + song);
        }
    }
}

// 3. Main class
public class Main {
    public static void main(String[] args) {

        MyMusicPlayer player = new MyMusicPlayer();

        // Add songs
        player.addSong("Shape of You");
        player.addSong("Perfect");
        player.addSong("Believer");
        player.addSong("Closer");
        player.addSong("Faded");

        // Display playlist
        player.displayPlaylist();

        // Play song
        player.play();

        // Pause song
        player.pause();

        // Remove a song
        player.removeSong("Closer");

        // Stop song
        player.stop();
    }
}
