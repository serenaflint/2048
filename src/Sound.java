
import java.io.File;
import java.net.URL;

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
	
	public void preload() {
		values();
	}
	
	public void play() {
		clip.setFramePosition(0);
		clip.start();
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
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
