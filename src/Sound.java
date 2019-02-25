/**
 * Sound.java
 * Collaboration between partners; Jayda Medina and Serena Flint
 * This class sets up music and sounds of the game.
 */
import java.io.File;
import javax.sound.sampled.*;

public enum Sound{
		
	CLICK("click.wav"),
	BACKGROUND("background.wav");

	public Clip clip;
	
	Sound(String fileName) {
		try {
			clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile());
			clip.open(inputStream);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	//Preloads sounds so there isn't a delay on first use
	public static void preload() {
		values();
	}
	
	//Plays the selected sound from the beginning
	public void play() {
		clip.setFramePosition(0);
		clip.start();
	}
	
	//Continuously loops the sound
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	//Stops the selected sound
	public void stop() {
		clip.stop();
	}

	//Unused
	public void onButton() {
		try {
			clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("click.wav").getAbsoluteFile());
			clip.open(inputStream);
			clip.start();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	//Unused
	public void background() {
		try {
			clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("background.wav").getAbsoluteFile());
			clip.open(inputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
}
